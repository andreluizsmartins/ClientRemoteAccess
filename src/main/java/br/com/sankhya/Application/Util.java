package br.com.sankhya.Application;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Util {
    public static String getDecoded(String a) throws Exception{
     
       Base64.Decoder decoder = Base64.getDecoder();
       byte[] decodedByteArray = decoder.decode(a);
       
       String b = new String(decodedByteArray);
       
       return b;
    }
    
    public static String getEncoded(String a) throws Exception{
        
       Base64.Encoder encoder = Base64.getEncoder();
       String b = encoder.encodeToString(a.getBytes(StandardCharsets.UTF_8) );
         
        return b;
     }
}
