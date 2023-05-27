package com.graduation.joy.utils;

import com.graduation.joy.domain.dto.TestCaseResponse;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;

public class AESEncoder {

    public static List<List<List<String>>>  encryptTestCaseList(String secretKey, List<TestCaseResponse> data) throws Exception{
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(new byte[16]);
        SecretKeySpec newKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES"); // [암호화 알고리즘]
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,newKey,ivSpec);

        List<List<List<String>>> encryptedData = new ArrayList<>();
        for(TestCaseResponse testCaseResponse : data){
            List<List<String>> encryped = encryptTestCase(testCaseResponse, cipher);
            encryptedData.add(encryped);
        }

        return encryptedData;

    }

    private static List<List<String>> encryptTestCase(TestCaseResponse testCaseResponse, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        List<List<String>> encrypted = new ArrayList<>();
        List<String> input = encryptList(testCaseResponse.getInputs(), cipher);
        List<String> output = encryptList(testCaseResponse.getOutputs(), cipher);
        encrypted.add(input);
        encrypted.add(output);
        return encrypted;
    }

    private static List<String> encryptList(List<String> data, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        List<String> encryptedData = new ArrayList<>();
        for (String item : data) {
            byte[] encryptedBytes = cipher.doFinal(item.getBytes());
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            encryptedData.add(encryptedText);
        }
        return encryptedData;
    }
}
