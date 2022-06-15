package uk.co.adamdon.springbooturlshorter.utilities;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public final class CodeGenerator
{
    private static CodeGenerator INSTANCE;


    private CodeGenerator()
    {
    }

    public static CodeGenerator getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new CodeGenerator();
        }

        return INSTANCE;
    }


    public String create(String inputString)
    {
        String outputString;
        MessageDigest messageDigest;
        byte[] inputStringByteArray;
        byte[] encodedHashByteArray;
//        String encodedHashString;
        String encodedHashBase64String;



        try
        {
            messageDigest = MessageDigest.getInstance("MD5");
            inputStringByteArray = inputString.getBytes(StandardCharsets.UTF_8);
            encodedHashByteArray = messageDigest.digest(inputStringByteArray);
//            encodedHashString = new String(Hex.encodeHex(encodedHashByteArray));
            encodedHashBase64String = Base64.getEncoder().encodeToString(encodedHashByteArray);
            outputString = encodedHashBase64String.replaceAll("/", "_");

            messageDigest.reset();
        }
        catch(NoSuchAlgorithmException noSuchAlgorithmException)
        {
            throw new RuntimeException(noSuchAlgorithmException);
        }


//        outputString = "";

        return outputString;
    }


}
