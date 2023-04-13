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
       
       public static String   MD5�ifreleme(String i�erik) {
    	   try {
    	   MessageDigest md=MessageDigest.getInstance("MD5");
    	   //byt olarak okur
    	   byte[] �ifrelenmi�=md.digest(i�erik.getBytes());
    	   //hexs hesaplar
    	   BigInteger no=new BigInteger(1, �ifrelenmi�);
    	   String hasi�erik=no.toString(16);
    	   
    	   while(hasi�erik.length()<32) {   
    		   hasi�erik="0"+hasi�erik;
    	   }
    	   return hasi�erik;
    	   }catch(NoSuchAlgorithmException e) {throw new RuntimeException(e);}
    	   
    	
       }
       
       
      
       
    
       
       
    }
