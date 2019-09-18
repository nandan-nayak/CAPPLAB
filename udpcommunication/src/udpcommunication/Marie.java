package udpcommunication;

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
		        	System.out.println("enter text :   ");
		            String inp = sc.nextLine(); 
		  
		          
		            buf = inp.getBytes(); 
		  
		            
		            DatagramPacket DpSend = 
		                  new DatagramPacket(buf, buf.length, ip, 1235); 
		  
		            
		            try {
		            	
		            
		            ds.send(DpSend); 
		            }catch(Exception e) {e.printStackTrace();}
		            
		            
		            
		        } 
		
		
	}
	
	
}


class RecieveMarie extends Thread
{
	
	
	
	
}

public class Marie {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		SendMarie s=new SendMarie();
		s.start();
	

	}
		
		
		
		
		
}

