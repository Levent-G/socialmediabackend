package security;


import java.security.SecureRandom;

import java.util.Random;


public class PasswordHashing {
public String saltt;
    public String passwordHashing(String passwordNonHashing ,Boolean hashingControl) 
    {  
     HashClass hashclass = new HashClass();
        /* Plain text Password. */  
    
          
        /* generates the Salt value. It can be stored in a database. */  
        String saltvalue = hashclass.getSaltvalue(30);  
          
        /* generates an encrypted password. It can be stored in a database.*/  
        String encryptedpassword = hashclass.generateSecurePassword(passwordNonHashing, saltvalue);  
          
        /* Print out plain text password, encrypted password and salt value. */  
        System.out.println("Plain text password = " + passwordNonHashing);  
        System.out.println("Secure password = " + encryptedpassword);  
        System.out.println("Salt value = " + saltvalue);  
        saltt = saltvalue;
        /* verify the original password and encrypted password */  
      
        Deneme(passwordNonHashing,encryptedpassword,saltvalue);
     
        return encryptedpassword;
    }  
  
    public String saltValueGet() {
        
    	return saltt;
    }

       public Boolean Deneme(String providedPassword,  
               String securedPassword, String salt) {
    	     HashClass hashclass = new HashClass();
         Boolean status = hashclass.verifyUserPassword(providedPassword,securedPassword,salt);  
       
         return status;
       }
       public String saltValueAdd(int length) {
    	   StringBuilder finalval = new StringBuilder(length);  
    	  Random random = new SecureRandom();  
    	   String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  
           for (int i = 0; i < length; i++)   
           {  
               finalval.append(characters.charAt(random.nextInt(characters.length())));  
           }  
     
           return new String(finalval);
       }
}  
  

