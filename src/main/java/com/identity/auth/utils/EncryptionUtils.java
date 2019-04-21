package com.identity.auth.utils;

import org.apache.commons.codec.digest.Crypt;

public class EncryptionUtils {

    private static final String SHA512_SALT = "$6$RANDOM_SALT";
    /**
     * Encrypt Password
     *
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText){
        //TODO: Generate Random SALT
        return Crypt.crypt(plainText,SHA512_SALT);
    }

    /**
     * Verify Password
     *
     * @param storedPassword
     * @param loginPassword
     * @return
     */
    public static Boolean verifyPassword(String storedPassword, String loginPassword){
        return storedPassword.equals(encrypt(loginPassword));
    }
}
