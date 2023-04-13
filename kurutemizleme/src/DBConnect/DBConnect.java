package DBConnect;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class DBConnect {
    private static Connection conn=null;

       public static Connection baglan(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/kurutemizleme","root","");
            return conn;
        }catch(Exception e){
            System.err.println("Error: "+e.getMessage().toString());
            return null;
        }

    }
       
       public static String   MD5þifreleme(String içerik) {
    	   try {
    	   MessageDigest md=MessageDigest.getInstance("MD5");
    	   //byt olarak okur
    	   byte[] þifrelenmiþ=md.digest(içerik.getBytes());
    	   //hexs hesaplar
    	   BigInteger no=new BigInteger(1, þifrelenmiþ);
    	   String hasiçerik=no.toString(16);
    	   
    	   while(hasiçerik.length()<32) {   
    		   hasiçerik="0"+hasiçerik;
    	   }
    	   return hasiçerik;
    	   }catch(NoSuchAlgorithmException e) {throw new RuntimeException(e);}
    	   
    	
       }
       
       
      
       
    
       
       
    }
