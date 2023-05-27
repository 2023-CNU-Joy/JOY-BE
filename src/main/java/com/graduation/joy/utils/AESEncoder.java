package com.graduation.joy.utils;

import com.graduation.joy.domain.dto.TestCaseResponse;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.List;

public class AESEncoder {

    public static String encryptTestCaseList(String secretKey, List<TestCaseResponse> data) throws Exception{
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(new byte[16]);
        SecretKeySpec newKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES"); // [암호화 알고리즘]
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,newKey,ivSpec);

        List<String> encryptedData = new ArrayList<>();
        for(TestCaseResponse testCaseResponse : data){
            String encryped = encryptTestCase(testCaseResponse, cipher);
            encryptedData.add(encryped);
        }

        return String.join(",", encryptedData);

    }

    private static String encryptTestCase(TestCaseResponse testCaseResponse, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException {
        StringBuilder sb = new StringBuilder();
        sb.append(testCaseResponse.getProblemId()).append(":");
        sb.append(encryptList(testCaseResponse.getInputs(), cipher)).append(":");
        sb.append(encryptList(testCaseResponse.getOutputs(), cipher)).append(":");
        return sb.toString();
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
