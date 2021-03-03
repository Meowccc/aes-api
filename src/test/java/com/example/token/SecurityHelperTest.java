package com.example.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author
 * @create 2021 - 03 - 03 下午 03:40
 **/
@SpringBootTest
class SecurityHelperTest {

    @Test
    void encrypt() {
        TokenPayload tokenPayload = new TokenPayload("80329815",1614742487);

    }

    @Test
    void decrypt() {
    }

    @Autowired
    SecurityHelper securityHelper;

    @Test
    void runFlow() throws JsonProcessingException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        String json = TokenPayload.toJson("80329815");
        String key = "m69p*H0!*Xyz#Lg8";


        String encrypted = securityHelper.encrypt(json);
        System.out.println("encrypt : "+encrypted);

        String decrypted = securityHelper.decrypt(encrypted);
        System.out.println("decrypted : "+decrypted);


        System.out.println(TokenPayload.parseJson(decrypted).toString());

        String token = "pJBxQC5dKzIf4R1yxKT9LMlupA5GH2HavP1zIED2YJkgib3mh+GxLScvIICYgOGb";
        System.out.println(securityHelper.decrypt(token));

    }
}