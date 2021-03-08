//package com.example.token;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import java.io.UnsupportedEncodingException;
//import java.math.BigInteger;
//import java.nio.charset.StandardCharsets;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @author
// * @create 2021 - 03 - 03 下午 03:40
// **/
//@SpringBootTest
//class SecurityHelperTest {
//
//    @Test
//    void encrypt() {
//        TokenPayload tokenPayload = new TokenPayload("80329815",1614742487);
//
//    }
//
//    @Test
//    void decrypt() {
//    }
//
//    @Autowired
//    SecurityHelper securityHelper;
//
//    @Value("${aes.company}")
//    private String company;
//
//    @Test
//    void runFlow() throws JsonProcessingException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
////        String json = TokenPayload.toJson("80329815");
//
//        String token = securityHelper.encrypt(TokenPayload.toJson(company, 1614742760L));
//        System.out.println("encrypted token : "+token);
//
//
//        byte[] deBase64 = Base64Helper.decode(token);
//        String str = new String(deBase64, StandardCharsets.UTF_8);
//        System.out.println("deBase64 : "+str);
//
//        System.out.println(" ======== ");
//        byte[] bytes = securityHelper.hexToBytes(str);
//        for (byte b : bytes) System.out.print(b);
//
//        System.out.println(" ======== ");
////        String token = "QTQ5MDcxNDAyRTVEMkIzMjFGRTExRDcyQzRBNEZEMkNDOTZFQTQwRTQ2MUY2MURBQkNGRDczMjA0MEY2NjA5OUExMzM0MUQzODk2NDg4MDEyQjUyQThBNUVGMzNEQTk0";
////        System.out.println(securityHelper.decrypt(token));
////        System.out.println(Base64Helper.decode(token));
//
//    }
//}