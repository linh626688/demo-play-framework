package controllers;

import DTO.RSACipher;
import DTO.RSAKeyPair;
import play.mvc.Controller;
import play.mvc.Result;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;

/**
 * Created by helix on 8/22/2016.
 */
public class RSAController extends Controller {
    final static String transformation = "RSA/ECB/PKCS1PADDING";
    final static String encoding = "UTF-8";

    public String RSAcrypto(int RSALength, boolean keyexist) throws GeneralSecurityException {
        try {
            String privateKeyPathName = "E://private" + RSALength + ".key";
            String publicKeyPathName = "E://public" + RSALength + ".key";
            if (keyexist == true) {
                if (Files.exists(Paths.get(privateKeyPathName)) == false
                        || Files.exists(Paths.get(publicKeyPathName)) == false) {
                    RSAKeyPair rsaKeyPair = new RSAKeyPair(RSALength);
                    rsaKeyPair.toFileSystem(privateKeyPathName, publicKeyPathName);
                }
            }

            RSACipher rsaCipher = new RSACipher();

            String encryptedString = rsaCipher.encrypt("Hello RSA", publicKeyPathName, transformation, encoding);
            String decryptedString = rsaCipher.decrypt(encryptedString, privateKeyPathName, transformation, encoding);

            System.out.println(encryptedString + '\n');
            System.out.println(decryptedString + '\n');

            if (decryptedString.equals("Hello RSA")) System.out.println("RSA hoạt động tốt");
        } catch (Exception e) {
            System.out.println("RSA gặp vấn đề bởi: " + e.getMessage());
        }
        return "OK";
    }

    public Result RSA1024() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            RSAcrypto(1024, keyexist);
            keyexist = false;
        }
        return ok();
    }

    public Result RSA512() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            RSAcrypto(512, keyexist);
            keyexist = false;
        }
        return ok();
    }

    public Result RSA2048() throws GeneralSecurityException {
        boolean keyexist = true;
        for (int i = 0; i < 5000; i++) {
            RSAcrypto(2048, keyexist);
            keyexist = false;
        }
        return ok();

    }
}
