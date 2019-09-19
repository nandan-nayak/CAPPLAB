//package udpcommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;



class SendMarie extends Thread
{
	
	public void run()

	{
		 System.out.println("MARIE started");
		 Scanner sc = new Scanner(System.in);
		 DatagramSocket ds =null;
		 InetAddress ip=null;
	
	try
	{
		 ds= new DatagramSocket(); 
	
		 
		        ip = InetAddress.getLocalHost(); 
	}catch(Exception e) {e.printStackTrace();}
	
	byte buf[] = null; 
		  
		        
		        while (true) 
		        { 
		        	System.out.println("");
		            String inp = sc.nextLine(); 
		  
		          
		            buf = inp.getBytes(); 
		  
		            
		            DatagramPacket DpSend = 
		                  new DatagramPacket(buf, buf.length, ip, 1334); 
		  
		            
		            try {
		            	
		            
		            ds.send(DpSend); 
		            }catch(Exception e) {e.printStackTrace();}
		            
		            
		            
		        } 
		
		
	}
	
	
}


class RecieveMarie extends Thread
{
	Buffer o=new Buffer();
	String message[];
	
	
	public void run()
	{	
		DatagramSocket marieSocket=null;
		//DatagramSocket marieSocket=null;
		byte[] mariereceive = new byte[65535]; 
		//byte[] mariereceive = new byte[65535]; 
		DatagramPacket marieDpReceive = null; 
		//DatagramPacket MarieDpReceive = null; 
		try {
		
		marieSocket=new DatagramSocket(1335);
		
	//	marieSocket=new DatagramSocket(1235);
		
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		while (true)
	     { 
	     
	         
	  //       MarieDpReceive = new DatagramPacket(mariereceive, mariereceive.length); 
	    
			
			marieDpReceive = new DatagramPacket(mariereceive, mariereceive.length); 

	        
	         try
	         {
	        	 
	      //System.out.println();   
	         
	     marieSocket.receive(marieDpReceive); 
	         }catch(Exception e) {e.printStackTrace();}
	         
	         System.out.println("\t\t\t" + data(mariereceive) ); 
	         

	         mariereceive = new byte[65535];
	        
	     
	     
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

public class Marie {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		SendMarie s=new SendMarie();
		RecieveMarie r=new RecieveMarie();
		s.start();r.start();
	

	}
		
		
		
		
		
}
