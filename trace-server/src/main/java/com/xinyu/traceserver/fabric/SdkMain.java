package com.xinyu.traceserver.fabric;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.CryptoException;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.TransactionRequest;
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

//public class SdkMain {
//
////    keyFolderPath 私钥的目录
//    private static final String keyFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\keystore";
////    keyFileName   私钥的文件名
//    private static final String keyFileName = "dedac4ec716f71d3b2516a0ac0defb745e197932f55a03eebe025300e8c22a40_sk";
////    certFileName   证书的文件名
//    private static final String certFoldePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\signcerts";
////    certFolderPath 证书的目录
//    private static final String certFileName = "Admin@org1.example.com-cert.pem";
////    tx文件目录
//    private static final String txfilePath = "E:\\projectgo\\模拟\\src\\main\\resources\\test.tx";
////    //order节点的tls证书
//    private static final String ordertlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\ordererOrganizations\\example.com\\tlsca\\tlsca.example.com-cert.pem";
////    //peer1.org1的tls证书
//    private static final String peertlsFilePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\peers\\peer1.org1.example.com\\msp\\tlscacerts\\tlsca.org1.example.com-cert.pem";
////
//    //test创建channel
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
//        Channel test = fabricClient.getChannel("test");
//        //得到orderer加入peer1org1节点并初始化channel
//        test.addOrderer(fabricClient.getOrderer("orderer.example.com","grpcs://orderer.example.com:7050",ordertlsFilePath));
//        test.joinPeer(fabricClient.getPeer("peer1.org1.example.com","grpcs://peer1.org1.example.com:8051",peertlsFilePath));
//        test.initialize();
//        //创建channel
//        fabricClient.createChannel("test",fabricClient.getOrderer("orderer.example.com","grpcs://orderer.example.com:7050",ordertlsFilePath),txfilePath);
//    }
//}

public class SdkMain {
    ////  private static final String keyFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org2.example.com\\users\\Admin@org2.example.com\\msp\\keystore";
////  private static final String keyFileName = "c1727d1dbe1d80da3163300de85ab3c50821e0cfbd86fa8bdd17692de64dabe1_sk";
////  private static final String certFoldePath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org2.example.com\\users\\Admin@org2.example.com\\msp\\signcerts";
////  private static final String certFileName = "Admin@org2.example.com-cert.pem";
    private static final String keyFolderPath = "G:\\hyperledger-fabric-trace\\trace-server\\src\\main\\resources\\crypto-config\\peerOrganizations\\org1.example.com\\users\\Admin@org1.example.com\\msp\\keystore";
    private static final String keyFileName = "d8e904429030eaf41c2a9eb24c67b9a3b65839cdb8201b61e86f858c8e7e22a7_sk";
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


    //测试安装合约
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
//        List<Peer> peers = new ArrayList<Peer>();
//        peers.add(peer0);
//        peers.add(peer1);

//        fabricClient.installChaincode(TransactionRequest.Type.GO_LANG,"eight","1.0","E:\\projectgo\\chaincode","eight",peers);
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

    //        fabricClient.invoke("mychannel", TransactionRequest.Type.GO_LANG, "eight","1.0",order,peers,"save",initArgs);
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
        String initArgs[] = {"3265"};
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
