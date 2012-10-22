package com.nordpos.mobile.stripes.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author jaroslawwozniak
 */
@Deprecated
public class CryptUtils {

    private Cipher cipherDecrypt;

    @Deprecated
    public CryptUtils(String passPhrase) {

        try {
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(passPhrase.getBytes("UTF8"));
            KeyGenerator kGen = KeyGenerator.getInstance("DESEDE");
            kGen.init(168, sr);
            Key key = kGen.generateKey();

            cipherDecrypt = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            cipherDecrypt.init(Cipher.DECRYPT_MODE, key);
        } catch (UnsupportedEncodingException e) {
        } catch (NoSuchPaddingException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (InvalidKeyException e) {
        }
    }

    @Deprecated
    public String decrypt(String str) {
        try {
            return new String(cipherDecrypt.doFinal(PasswordUtils.hex2byte(str)), "UTF8");
        } catch (UnsupportedEncodingException e) {
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        }
        return null;
    }
}
