package udpcommunication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;






class JoeBuffer extends Thread
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
		
		joeSocket=new DatagramSocket(1234);
		
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
	        	 
	         
	         
	     joeSocket.receive(JoeDpReceive); 
	         }catch(IOException e) {e.printStackTrace();}
	         
	         System.out.println(" joe message : " + data(joereceive) ); 
	         

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








class MarieBuffer extends Thread
{
	Buffer o=new Buffer();
	String message[];
	public void run()
	{	
		DatagramSocket marieSocket=null;
		byte[] receive = new byte[65535]; 
		DatagramPacket DpReceive = null; 
		try {
		
		marieSocket=new DatagramSocket(1235);
		
		
		
		
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		
		
		while (true)
	     { 
			
	         // Step 2 : create a DatgramPacket to receive the data. 
	         DpReceive = new DatagramPacket(receive, receive.length); 

	         // Step 3 : revieve the data in byte buffer. 
	         try
	         {
	        	 
	         
	         marieSocket.receive(DpReceive); 
	         }catch(IOException e) {e.printStackTrace();}
	         
	         
	         System.out.println("marie's  message : " + data(receive)); 

	         // Exit the server if the client sends "bye" 
	         if (data(receive).toString().equals("bye")) 
	         { 
	             System.out.println("Client sent bye.....EXITING"); 
	             break; 
	         } 

	         // Clear the buffer after every message. 
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
		
	JoeBuffer j=new JoeBuffer();
	MarieBuffer m=new MarieBuffer();
System.out.println("buffer started");
	m.start();
	j.start();
	m.join();
	j.join();

	//	DatagramSocket marieSocket=new DatagramSocket(1235);
		

	}

}
