package com.xinyu.traceserver.controller;

import com.xinyu.traceserver.entity.Trace;
import com.xinyu.traceserver.fabric.FabricClient;
import com.xinyu.traceserver.fabric.UserContext;
import com.xinyu.traceserver.fabric.UserUtils;
import com.xinyu.traceserver.repository.TraceRepository;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.crypto.CryptoException;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.Orderer;
import org.hyperledger.fabric.sdk.Peer;
import org.hyperledger.fabric.sdk.TransactionRequest;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//----------------------------------------------


@RestController
@RequestMapping("/fabric")
public class TraceHandler {

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


    @Autowired
    private TraceRepository traceRepository;


    @GetMapping("/findAll/{page}/{size}")
    public Page<Trace> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return traceRepository.findAll(pageable);
    }


    @GetMapping("/findById/{id}")
    public JSONObject finedById(@PathVariable("id") Integer id) throws InvalidKeySpecException, NoSuchAlgorithmException, CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, ProposalException, TransactionException {
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

        String str = Integer.toString(id);
        String initArgs[] = {str};

        peers.add(peer0);
        peers.add(peer1);
        Map map = fabricClient.queryChaincode(peers, "mychannel", TransactionRequest.Type.GO_LANG, "eight", "queryHistory", initArgs);
        String first = StringUtils.strip(map.values().toString(), "[{}]");
        first = "{" + "\"data\":[{" + first + "}}]}";
        System.out.println(first);
        System.out.println("===============");
        JSONObject jsonObject = JSONObject.fromObject(first);
        System.out.println(jsonObject.getString("data"));

        return jsonObject;
    }

    @GetMapping("/findproById/{id}")
    public Trace findById(@PathVariable("id") Integer id) {
        return traceRepository.findById(id).get();
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        traceRepository.deleteById(id);
    }


    @PutMapping("/updata")
    public String updata(@RequestBody Trace trace) throws InvalidKeySpecException, NoSuchAlgorithmException, CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, ProposalException, TransactionException {
        Trace result = traceRepository.save(trace);
        if (result != null) {
            System.out.println(123);
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
            Orderer order = fabricClient.getOrderer("orderer.example.com", "grpcs://orderer.example.com:7050", ordertlsFilePath);
            List<Peer> peers = new ArrayList<>();
            peers.add(peer0);
            peers.add(peer1);

            String str = "{\"traceability_id\"" + ":" + '"' + result.getTraceability_id() + '"' + "," + "\"name\"" + ":" + '"' + result.getName() + '"' + "," + "\"date_of_manufacture\"" + ":" + '"' + result.getDate_of_manufacture() + '"' + "," + "\"manufactor\"" + ":" + '"' + result.getManufactor() + '"' + "," + "\"telephone\"" + ":" + '"' + result.getTelephone() + '"' + "," + "\"listing_date\"" + ":" + '"' + result.getListing_date() + '"' + "," + "\"courier_number\"" + ":" + '"' + result.getCourier_number() + '"' + "," + "\"term_of_validity\"" + ":" + '"' + result.getTerm_of_validity() + '"' + "," + "\"company\"" + ":" + '"' + result.getCompany() + '"' + "," + "\"tel\"" + ":" + '"' + result.getTel() + '"' + "," + "\"delivery_date\"" + ":" + '"' + result.getDelivery_date() + '"' + "}";
            String initArgs[] = {result.getTraceability_id(), str};
            fabricClient.invoke("mychannel", TransactionRequest.Type.GO_LANG, "eight", "1.0", order, peers, "save", initArgs);
            System.out.println("123执行了");
            return "success";
        } else {
            return "error";
        }
    }


    @PostMapping("/save")
    public String save(@RequestBody Trace trace) throws InvalidKeySpecException, NoSuchAlgorithmException, CryptoException, IOException, IllegalAccessException, InvalidArgumentException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, org.hyperledger.fabric.sdk.exception.CryptoException, ProposalException, TransactionException {

        Trace result = traceRepository.save(trace);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

}
