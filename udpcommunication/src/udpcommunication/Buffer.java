package udpcommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class QueueStorage
{
	
	public static Queue<String> joe=new LinkedList<>();
	public static Queue<String> marie=new LinkedList<>();
	
}



class JoeBufferSend extends Thread
{
	//QueueStorage q=new QueueStorage();
	
	
	public void run()
	{
		
		DatagramPacket DpSend=null;
		Scanner sc;
		DatagramSocket ds=null;
		InetAddress ip=null;
		 byte buf[];
		 try {
		 ds= new DatagramSocket(); 
		
		 ip = InetAddress.getLocalHost();
		 }catch(Exception e) {}
	     buf= null; 
	
		
		//  System.out.println("JOE send started");
		       
		  
		        
		        while (true) 
		        { 
		        	
		        	try {
		        	Thread.sleep(5);
		        	}
		        	catch(Exception e) 
		        	{
		        		e.printStackTrace();
		        	}
		        	
		        	
		           while(QueueStorage.joe.size()>0) {
		        	   String inp=QueueStorage.joe.remove();
		        	  
		        	   buf = inp.getBytes(); 
		        	   DpSend = new DatagramPacket(buf, buf.length, ip, 1235); 
		        	   try {
				            ds.send(DpSend); 
				            	}catch(Exception e) {}
				
		           }
		          
		           
		          
		           
		           
		        } 
		
		
	}
	
	
	
	
}


class JoeBufferRecieve extends Thread
{
	
	Buffer o=new Buffer();
	String message[];
	public void run()
	{	
		DatagramSocket joeSocket=null;
		

		byte[] joereceive = new byte[65535]; 
		

		DatagramPacket JoeDpReceive = null; 
		
 
		try {
		
		joeSocket=new DatagramSocket(1234);
		
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		while (true)
	     { 

	     
	         
	        JoeDpReceive = new DatagramPacket(joereceive, joereceive.length); 

	        
	         try
	         {
	        	 
	         
	         
	     joeSocket.receive(JoeDpReceive); 
	         }catch(IOException e) {e.printStackTrace();}
	         
	         QueueStorage.marie.add(data(joereceive).toString());
	         
	     
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









class MarieBufferSend extends Thread
{
	
	DatagramPacket DpSend =null;
	
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
	
		
		       
		  
		        
		        while (true) 
		        { 
		        	try {
			        	Thread.sleep(5);
			        	}
			        	catch(Exception e) 
			        	{
			        		e.printStackTrace();
			        	}
		        	
		        	
		        	
		        	
		        	
		        	sc = new Scanner(System.in); 
		 
			    	while(QueueStorage.marie.size()>0)
		        	{
		        	String inp=QueueStorage.marie.remove();
		                buf = inp.getBytes(); 
		                DpSend = new DatagramPacket(buf, buf.length, ip, 1335);

		        	try {
		           	 ds.send(DpSend); 
		            	}catch(Exception e) {}
		        	}
		          
		             
		  
		          
		
		           
		        } 
		
		
			}
	
	
	
	
}


class MarieBufferRecieve extends Thread
{
	Buffer o=new Buffer();
	String message[];
	public void run()
	{	
		DatagramSocket marieSocket=null;
		byte[] receive = new byte[65535]; 
		DatagramPacket DpReceive = null; 
		try {
		
		marieSocket=new DatagramSocket(1334);
		
		
		
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		while (true)
	     { 
			
	        
	         DpReceive = new DatagramPacket(receive, receive.length); 

	         try
	         {
	        	 
	         
	         marieSocket.receive(DpReceive); 
	         }catch(IOException e) {e.printStackTrace();}
	         
	         QueueStorage.joe.add(data(receive).toString());
	        // System.out.println("marie's  message : " + ); 

	        
	         receive = new byte[65535]; 
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



public class Buffer {

	public static void main(String[] args)throws Exception 
	{
		// TODO Auto-generated method stub
		
	JoeBufferRecieve jr=new JoeBufferRecieve();
	JoeBufferSend js=new JoeBufferSend();
	MarieBufferRecieve mr=new MarieBufferRecieve();
	MarieBufferSend ms=new MarieBufferSend();
System.out.println("server started");
	mr.start();
	jr.start();
	js.start();
	ms.start();
	mr.join();
	jr.join();
	ms.join();
	
	
	
	js.join();

	//	DatagramSocket marieSocket=new DatagramSocket(1235);
		

	}

}
