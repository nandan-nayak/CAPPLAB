package udpcommunication;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;




class RecieveJoe extends Thread
{
	
	public void start()
	{
		
		
	}
	
	public void run()
	{
		
		
	}
	
	
}

class SendJoe extends Thread
{
	
	public void init()throws Exception
	{
		 
		 
	}
	
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
		        	System.out.println("enter text :   ");
		            String inp = sc.nextLine(); 
		  
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
	
		SendJoe s=new SendJoe();
		s.start();
		s.join();
		
		
	}
		        
	    
	  
	}
		        
		        
		        
		        
		        
		    
	
	
	
	




















