package ec.gob.agricultura.dsii.sw.servicio.rna;

import java.util.HashMap;
import java.util.Map;

public class Util {
  public static String fixEmail(String mail, String cedula) {
	  if(mail==null  || mail.equals("") )
	  {
		  System.out.println("----------------------------          WARNING !!!!      ------------------------------");
		  System.out.println("---------------------------- EL MAIL NO HA SIDO ENVIADO ------------------------------");
			 
		  if(cedula==null || cedula.equals("") ) {
			  int i=(int) (Math.random()*6 + 10000);
			  return "notiene_"+i+"@hotmail.com"; 
		  }
		  else {
			  return cedula+"@hotmail.com"; 
		  }
	  }
	  else {
	        Map<String, String> map = new HashMap();
	        map.put("banecuador.fin.ec", "banecuador.fin.ec");
	        map.put("banecuador.fin", "banecuador.fin.ec");
	        map.put("banecuador.fin.", "banecuador.fin.ec");
	        map.put("banecuador.fin.ec", "banecuador.fin.ec");
	        map.put("gmail.com", "gmail.com");
	        map.put("gmail", "gmail.com");
	        map.put("gmail.", "gmail.com");
	        map.put("hotmail.com", "hotmail.com");
	        map.put("hotmail.", "hotmail.com");
	        map.put("hotmail", "hotmail.com");
	        map.put("yahoo.com", "yahoo.com");
	        map.put("yahoo.", "yahoo.com");
	        map.put("yahoo", "yahoo.com");
	        map.put("mag.gob.ec", "mag.gob.ec");
	        map.put("mag.", "mag.gob.ec");
	        map.put("mag.gob", "mag.gob.ec");
	        map.put("mag.gob.", "mag.gob.ec");
	        String mailFix="";
	        String [] mailArrayPart = mail.split("@");
	        if(mailArrayPart.length>1){
	             String mailSecondPar = mailArrayPart[1];
	             String [] mailSecondArrayPart = mailSecondPar.split("\\.");
	             if(mailSecondArrayPart.length==1){
	                 mailSecondPar=mailSecondPar.replace(".","");
	                 if(mailSecondPar.equals("banecuador"))
	                    mailSecondPar=mailSecondPar+".fin.ec";
	                else
	                    mailSecondPar=mailSecondPar+".com";
	             }
	             mailFix=mailArrayPart[0]+"@"+mailSecondPar;
	            System.out.println("mail fix:" +mailFix+ "  "+mailSecondArrayPart.length); 
	            return mailFix;   
	        }
	        else{
	            for (Map.Entry<String, String> entry : map.entrySet()) {
	                int index=mail.indexOf(entry.getKey());
	                if(index>0){
	                  mailFix=mail.substring(0,index)+"@"+entry.getValue();
	                }
	            }
	            if(mailFix.equals(""))
	              mailFix=mail+"@gmail.com";
	            System.out.println("Mail fix:" + mailFix);
	            return mailFix;
	        }
	  }
  }
}
