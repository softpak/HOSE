package net.minecraft.server;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinecraftEncryption {

    private static final Logger a = LogManager.getLogger();

    public static KeyPair b() {
        try {
            KeyPairGenerator keypairgenerator = KeyPairGenerator.getInstance("RSA");

            keypairgenerator.initialize(1024);
            return keypairgenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            nosuchalgorithmexception.printStackTrace();
            MinecraftEncryption.a.error("Key pair generation failed!");
            return null;
        }
    }

    public static byte[] a(String s, PublicKey publickey, SecretKey secretkey) {
        try {
            return a("SHA-1", new byte[][] { s.getBytes("ISO_8859_1"), secretkey.getEncoded(), publickey.getEncoded()});
        } catch (UnsupportedEncodingException unsupportedencodingexception) {
            unsupportedencodingexception.printStackTrace();
            return null;
        }
    }

    private static byte[] a(String s, byte[]... abyte) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance(s);
            byte[][] abyte1 = abyte;
            int i = abyte.length;

            for (int j = 0; j < i; ++j) {
                byte[] abyte2 = abyte1[j];

                messagedigest.update(abyte2);
            }

            return messagedigest.digest();
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
    }

    public static PublicKey a(byte[] abyte) {
        try {
            X509EncodedKeySpec x509encodedkeyspec = new X509EncodedKeySpec(abyte);
            KeyFactory keyfactory = KeyFactory.getInstance("RSA");

            return keyfactory.generatePublic(x509encodedkeyspec);
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            ;
        } catch (InvalidKeySpecException invalidkeyspecexception) {
            ;
        }

        MinecraftEncryption.a.error("Public key reconstitute failed!");
        return null;
    }

    public static SecretKey a(PrivateKey privatekey, byte[] abyte) {
        return new SecretKeySpec(b(privatekey, abyte), "AES");
    }

    public static byte[] b(Key key, byte[] abyte) {
        return a(2, key, abyte);
    }

    private static byte[] a(int i, Key key, byte[] abyte) {
        try {
            return a(i, key.getAlgorithm(), key).doFinal(abyte);
        } catch (IllegalBlockSizeException illegalblocksizeexception) {
            illegalblocksizeexception.printStackTrace();
        } catch (BadPaddingException badpaddingexception) {
            badpaddingexception.printStackTrace();
        }

        MinecraftEncryption.a.error("Cipher data failed!");
        return null;
    }

    private static Cipher a(int i, String s, Key key) {
        try {
            Cipher cipher = Cipher.getInstance(s);

            cipher.init(i, key);
            return cipher;
        } catch (InvalidKeyException invalidkeyexception) {
            invalidkeyexception.printStackTrace();
        } catch (NoSuchAlgorithmException nosuchalgorithmexception) {
            nosuchalgorithmexception.printStackTrace();
        } catch (NoSuchPaddingException nosuchpaddingexception) {
            nosuchpaddingexception.printStackTrace();
        }

        MinecraftEncryption.a.error("Cipher creation failed!");
        return null;
    }

    public static Cipher a(int i, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding");

            cipher.init(i, key, new IvParameterSpec(key.getEncoded()));
            return cipher;
        } catch (GeneralSecurityException generalsecurityexception) {
            throw new RuntimeException(generalsecurityexception);
        }
    }
}
