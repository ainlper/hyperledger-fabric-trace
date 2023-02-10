package com.xinyu.traceserver.fabric;

import com.xinyu.traceserver.fabric.FabricClient;
import com.xinyu.traceserver.fabric.UserContext;
import com.xinyu.traceserver.fabric.UserUtils;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.CryptoException;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 创建channel
 */
//public class SdkMain {
//
//    private static final String keyFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\keystore";
//    private static final String keyFileName = "dedac4ec716f71d3b2516a0ac0defb745e197932f55a03eebe025300e8c22a40_sk";
//    private static final String certFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\signcerts";
//    private static final String certFileName = "Admin@org1.example.com-cert.pem";
//
//    //    Orderer节点的tls证书
//    private static final String orderTlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\ordererOrganizations\\example.com\\tlsca\\tlsca.example.com-cert.pem";
//    //    peer1.org1的tls证书
//    private static final String peerTlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\peers\\peer1.org1.example.com\\msp\\tlscacerts\\tlsca.org1.example.com-cert.pem";
//
//    private static final String txfilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\test.tx";
//
//    //    创建channel
//    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, TransactionException, ProposalException {
//        UserContext userContext = new UserContext();
////        设置组织机构
//        userContext.setAffiliation("Org1");
////        设置组织机构的MspId
//        userContext.setMspId("Org1MSP");   //组织一的MSPID
//        userContext.setAccount("dalin");
//        userContext.setName("admin");
//        Enrollment enrollment = UserUtils.getEnrollment(keyFolderPath, keyFileName, certFolderPath, certFileName);
//        userContext.setEnrollment(enrollment);
//        FabricClient fabricClient = new FabricClient(userContext);
////        Channel channel = fabricClient.getChannel("test");
////        // 将channel关联orderer和peer，并初始化
////        channel.addOrderer(fabricClient.getOrderer("orderer.example.com", "grpcs://orderer.example.com:7050", orderTlsFilePath));
////        channel.joinPeer(fabricClient.getPeer("peer0.org1.example.com", "grpcs://peer0.org1.example.com:7051", peerTlsFilePath));
////        channel.initialize();
//        //创建channel
//        Channel channel = fabricClient.createChannel("test", fabricClient.getOrderer("orderer.example.com", "grpcs://orderer.example.com:7050", orderTlsFilePath), txfilePath);
//        channel.joinPeer(fabricClient.getPeer("peer0.org1.example.com", "grpcs://peer0.org1.example.com:7051", peerTlsFilePath));
//    }
//}

public class SdkMain {
    ////  private static final String keyFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org2.example.com\\users\\Admin@org2.example.com\\msp\\keystore";
////  private static final String keyFileName = "c1727d1dbe1d80da3163300de85ab3c50821e0cfbd86fa8bdd17692de64dabe1_sk";
////  private static final String certFoldePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org2.example.com\\users\\Admin@org2.example.com\\msp\\signcerts";
////  private static final String certFileName = "Admin@org2.example.com-cert.pem";
    private static final String keyFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\keystore";
    private static final String keyFileName = "e047a9f357d7bbbd491f1b5b8ea8a359dca39073e0d80d9dce997470231d5860_sk";
    private static final String certFoldePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\signcerts";
    private static final String certFileName = "Admin@org1.example.com-cert.pem";
    private static final String txfilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\test.tx";
    //order节点的tls证书
    private static final String ordertlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\ordererOrganizations\\example.com\\tlsca\\tlsca.example.com-cert.pem";
    //peer1.org1的tls证书
    private static final String peer1tlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\peers\\peer1.org1.example.com\\msp\\tlscacerts\\tlsca.org1.example.com-cert.pem";
    //peer0.org1的tls证书
    private static final String peer0tlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\peers\\peer0.org1.example.com\\msp\\tlscacerts\\tlsca.org1.example.com-cert.pem";
    //peer0.org2的tls证书
    private static final String peerorg2tlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org2.example.com\\tlsca\\tlsca.org2.example.com-cert.pem";


//    // 安装合约
//    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, TransactionException, ProposalException {
//        UserContext userContext = new UserContext();
//        userContext.setAffiliation("Org1");
//        userContext.setMspId("Org1MSP");
//        userContext.setAccount("dalin");
//        userContext.setName("admin");
//        Enrollment enrollment = UserUtils.getEnrollment(keyFolderPath, keyFileName, certFoldePath, certFileName);
//        userContext.setEnrollment(enrollment);
//        FabricClient fabricClient = new FabricClient(userContext);
//        Peer peer0 = fabricClient.getPeer("peer0.org1.example.com", "grpcs://peer0.org1.example.com:7051", peer0tlsFilePath);
//        Peer peer1 = fabricClient.getPeer("peer1.org1.example.com", "grpcs://peer1.org1.example.com:8051", peer1tlsFilePath);
//        List<Peer> peers = new ArrayList<>();
//        peers.add(peer0);
//        peers.add(peer1);
//
//        fabricClient.installChaincode(TransactionRequest.Type.GO_LANG, "eight", "1.0", "E:\\projectgo\\chaincode", "trace", peers);
//    }

    //实例化合约
//    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException,
//            CryptoException, IOException, IllegalAccessException, InvalidArgumentException,
//            InstantiationException, ClassNotFoundException, NoSuchMethodException,
//            InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, TransactionException, ProposalException {
//        UserContext userContext = new UserContext();
//        //userContext有某个组织的成员变量
//        userContext.setAffiliation("Org1");//设置组织机构
//        userContext.setMspId("Org1MSP");   //组织一的MSPID
//        userContext.setAccount("dalin");
//        userContext.setName("admin");
//        Enrollment enrollment = UserUtils.getEnrollment(keyFolderPath,keyFileName,certFoldePath,certFileName);
//        userContext.setEnrollment(enrollment);
//        FabricClient fabricClient = new FabricClient(userContext);
//        Peer peer = fabricClient.getPeer("peer0.org1.example.com","grpcs://peer0.org1.example.com:7051",peer0tlsFilePath);
//        Orderer order = fabricClient.getOrderer("orderer.example.com","grpcs://orderer.example.com:7050",ordertlsFilePath);
//        String initArgs[] = {""};
//
//        fabricClient.initChaincode("mychannel", TransactionRequest.Type.GO_LANG, "eight","1.0",order,peer,"init",initArgs);
//
//    }


    //invoke合约调用合约函数
//    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, TransactionException, ProposalException {
//        UserContext userContext = new UserContext();
//        //userContext有某个组织的成员变量
//        userContext.setAffiliation("Org1");//设置组织机构
//        userContext.setMspId("Org1MSP");   //组织一的MSPID
//        userContext.setAccount("dalin");
//        userContext.setName("admin");
//        Enrollment enrollment = UserUtils.getEnrollment(keyFolderPath,keyFileName,certFoldePath,certFileName);
//        userContext.setEnrollment(enrollment);
//        FabricClient fabricClient = new FabricClient(userContext);
//        Peer peer0 = fabricClient.getPeer("peer0.org1.example.com","grpcs://peer0.org1.example.com:7051",peer0tlsFilePath);
//        Peer peer1 = fabricClient.getPeer("peer1.org1.example.com","grpcs://peer1.org1.example.com:8051",peer1tlsFilePath);
//        Orderer order = fabricClient.getOrderer("orderer.example.com","grpcs://orderer.example.com:7050",ordertlsFilePath);
//        List<Peer> peers =new ArrayList<>();
//        peers.add(peer0);
//        peers.add(peer1);
//
////        String initArgs[] = {"555","{\"traceability_id\":\"555\",\"name\":\"老八秘制小汉堡\",\"date_of_manufacture\":\"2022/8/5\",\"manufactor\":\"米奇妙妙屋\",\"telephone\":\"12345678910\",\"listing_date\":\"2022/8/11\",\"courier_number\":\"123\",\"term_of_validity\":\"8个月\",\"company\":\"芜湖起飞\",\"tel\":\"12345678910\",\"delivery_date\":\"2022/8/5\" }"};
//
////        String initArgs[] = {"1212","{\"traceability_id\":\"1212\",\"name\":\"老八秘制小汉堡\",\"date_of_manufacture\":\"2022/8/5\",\"manufactor\":\"米奇妙妙屋\",\"telephone\":\"12345678910\"}"};
//        String initArgs[] = {"1213","{\"traceability_id\":\"1213\",\"listing_date\":\"2022/8/11\",\"courier_number\":\"123\",\"term_of_validity\":\"8个月\",\"company\":\"芜湖起飞\",\"tel\":\"12345678910\",\"delivery_date\":\"2022/8/5\" }"};
////        String initArgs[] = {'"'+"Args"+'"'+","+"\"initMarble\",\"marbles9\",\"bule\",\"35\",\"tom\""};
//
//
//
//
//            fabricClient.invoke("mychannel", TransactionRequest.Type.GO_LANG, "eight","1.0",order,peers,"save",initArgs);
//
//    }
    //查询合约
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException,
            CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException,
            ProposalException, TransactionException, JSONException {
        UserContext userContext = new UserContext();
        //userContext有某个组织的成员变量
        userContext.setAffiliation("Org1");//设置组织机构
        userContext.setMspId("Org1MSP");   //组织一的MSPID
        userContext.setAccount("dalin");
        userContext.setName("admin");
        Enrollment enrollment = UserUtils.getEnrollment(keyFolderPath, keyFileName, certFoldePath, certFileName);
        userContext.setEnrollment(enrollment);
        FabricClient fabricClient = new FabricClient(userContext);
        Peer peer0 = fabricClient.getPeer("peer0.org1.example.com", "grpcs://peer0.org1.example.com:7051", peer0tlsFilePath);
        Peer peer1 = fabricClient.getPeer("peer1.org1.example.com", "grpcs://peer1.org1.example.com:8051", peer1tlsFilePath);
        List<Peer> peers = new ArrayList<Peer>();
        String initArgs[] = {"1213"};
        peers.add(peer0);
        peers.add(peer1);

        Map map = fabricClient.queryChaincode(peers, "mychannel", TransactionRequest.Type.GO_LANG, "eight", "queryHistory", initArgs);
        String first = StringUtils.strip(map.values().toString(), "[{}]");
        first = "{" + "\"data\":[{" + first + "}}]}";
        System.out.println(first);
        System.out.println("===============");
        JSONObject jsonObject = JSONObject.fromObject(first);
        System.out.println(jsonObject.getString("data"));

    }

}
