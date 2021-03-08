package com.example.token;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.example.exception.AESException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author
 * @create 2021 - 03 - 03 下午 12:01
 **/
@Component
public class SecurityHelper {
    @Value("${aes.key}")
    private String key;

    public String encrypt(String str) throws AESException {
        try{
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, keyspec);
            byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder(encrypted.length * 2);
            for(byte e : encrypted){
                result.append(String.format("%02X", e));
            }
            System.out.println("str : "+result.toString());
            return Base64Helper.encode(result.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            throw new AESException();
        }
    }

    public String decrypt(String str) throws AESException {
        try{
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.DECRYPT_MODE, keyspec);

            // token base64 解碼 轉為 byte array
            byte[] deBase64 = Base64Helper.decode(str);
            String hexStr = new String(deBase64, StandardCharsets.UTF_8);
            // 16進制 轉為 byte array
            byte[] encrypted = hexToBytes(hexStr);
            // byte array aes 解碼
            byte[] decrypted = cipher.doFinal( encrypted);
            // 回傳 json
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new AESException();
        }

    }


    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
        }
        return result.toString();
    }

    public byte[] hexToBytes(String hexString) {

        char[] hex = hexString.toCharArray();
        //轉rawData長度減半
        int length = hex.length / 2;
        byte[] rawData = new byte[length];
        for (int i = 0; i < length; i++) {
            //先將hex資料轉10進位數值
            int high = Character.digit(hex[i * 2], 16);
            int low = Character.digit(hex[i * 2 + 1], 16);
            //將第一個值的二進位值左平移4位,ex: 00001000 => 10000000 (8=>128)
            //然後與第二個值的二進位值作聯集ex: 10000000 | 00001100 => 10001100 (137)
            int value = (high << 4) | low;
            //與FFFFFFFF作補集
            if (value > 127)
                value -= 256;
            //最後轉回byte就OK
            rawData [i] = (byte) value;
        }
        return rawData ;
    }
}
