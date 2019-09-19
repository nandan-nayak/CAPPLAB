//package udpcommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;


















class RecieveJoe extends Thread
{
	Buffer o=new Buffer();
	String message[];
	
	
	public void run()
	{	
		DatagramSocket joeSocket=null;
		//DatagramSocket marieSocket=null;
		byte[] joereceive = new byte[65535]; 
		//byte[] mariereceive = new byte[65535]; 
		DatagramPacket JoeDpReceive = null; 
		//DatagramPacket MarieDpReceive = null; 
		try {
		
		joeSocket=new DatagramSocket(1235);
		
	//	marieSocket=new DatagramSocket(1235);
		
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		while (true)
	     { 
	     
	         
	  //       MarieDpReceive = new DatagramPacket(mariereceive, mariereceive.length); 
	    
			
			JoeDpReceive = new DatagramPacket(joereceive, joereceive.length); 

	        
	         try
	         {
	        	 
	      //System.out.println();   
	         
	     joeSocket.receive(JoeDpReceive); 
	         }catch(Exception e) {e.printStackTrace();}
	         
	         System.out.println("\t\t\t" + data(joereceive) ); 
	         

	         joereceive = new byte[65535];
	        
	     
	     
	     } 
		
		
		
		
		
		
		
	}
	
	
	
	
	public static StringBuilder data(byte[] a) 
	 { 
	     if (a == null) 
	         return null; 
	     StringBuilder ret = new StringBuilder(); 
	     int i = 0; 
	     while (a[i] != 0) 
	     { 
	         ret.append((char) a[i]); 
	         i++; 
	     } 
	     return ret; 
	 } 
	
	
	
	
}

class SendJoe extends Thread
{
	
	
	
	public void run()
	{
		

		Scanner sc;
		DatagramSocket ds=null;
		InetAddress ip=null;
		 byte buf[];
		 try {
		 ds= new DatagramSocket(); 
		
		 ip = InetAddress.getLocalHost();
		 }catch(Exception e) {}
	     buf= null; 
	
		
		  System.out.println("JOE started");
		       
		  
		        
		        while (true) 
		        { 
		        	
		        	
		        	
		        	
		        	
		        	sc = new Scanner(System.in); 
		        	System.out.println("");
		            String inp = sc.nextLine(); 
		        	//String inp="";
		            buf = inp.getBytes(); 
		  
		          
		            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234); 
		  
		          
		            try {
		            ds.send(DpSend); 
		            	}catch(Exception e) {}
		
		           
		        } 
		
		
	}
	
	
	
	
}
public class Joe {

	
	public static void main(String[] args)throws Exception {
	
		SendJoe s=new SendJoe();RecieveJoe r=new RecieveJoe();
		s.start();r.start();
		
		
		
	}
		        
	    
	  
	}
		        
		        
		        
		        
		        
		    
	
