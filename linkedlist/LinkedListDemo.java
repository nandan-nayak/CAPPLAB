//package linkedlist;

import java.io.*;
class LinkedList { 
    Node head; 
    class Node { 
        int data; 
        Node next; 
  
       
        Node(int d) { data = d; } 
    } 
    
    
   LinkedList addNode(LinkedList list,int data)
    {
    	Node temp=new Node(data);
    	temp.next=list.head;
    	list.head=temp;
    	return list;
    	
    	
    }
   LinkedList deleteNode(LinkedList list )
   {
	   Node temp;
	   temp=head;
	   head=head.next;
	   temp.next=null;
	      
	   
	   return list;
   }
    void display(LinkedList list)
    {
    	Node temp=list.head;
    	System.out.println("items are ");
    	while(temp!=null)
    	{
    		System.out.println(temp.data);
    		temp=temp.next;
    		
    	}
    	
    	System.out.println("\n\n");
    	
    }
    LinkedList move(LinkedList list)
    {
    	Node prev=null;
    	Node temp;
    	Node cur;
    	cur=list.head;
    	while(cur.next!=null)
    	{
    		
    		prev=cur;
    		cur=cur.next;
    		
    		
    	}
    	temp=cur;
    	temp.next=head;
    	head=temp;
    	prev.next=null;
    	
    	
    	return list;
    }
    
    
}



public class LinkedListDemo {

	
	
	public static void main(String[] args) {
		
		
		LinkedList list=new LinkedList();
		int choice=0,data=0,size=0,i;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			System.out.println("\n\n\n=======================================");
			System.out.println("1:add element to head");
			System.out.println("2:delete element from head ");
			System.out.println("3:view content");
			System.out.println("4:move last element to first");
			System.out.println("5:exit");
			System.out.println("=======================================");
			System.out.print("enter your choice : ");
			//System.out.println("\n\n");
			


			try {
			choice=Integer.parseInt(in.readLine());
			}catch(IOException e)
			{
				e.printStackTrace();
			}



			switch(choice)
			{



			case 1:



				
				System.out.print("\n\n enter the size : ");
				try {
					size=Integer.parseInt(in.readLine());
					}catch(IOException e)
					{
						e.printStackTrace();
					}
				for(i=0;i<size;i++)	
					{	
					System.out.print("enter data "+i +" : ");	
					try {
					data=Integer.parseInt(in.readLine());
					}catch(IOException e)
					{
						e.printStackTrace();
					}		
					list=list.addNode(list, data);
					}				


				
				break;






			case 2:
				System.out.println("\n\n");
				System.out.println("deleted successfully");
				list=list.deleteNode(list);
				
				break;
				
				


			case 3:


				
				System.out.println("\n\n");
				list.display(list);
				
				break;




			case 4:
				System.out.println("\n\n");
				list=list.move(list);
				System.out.println(" moved successfully ");
				
				
				
				break;




			case 5:System.exit(0);
			
			
			
			}
			
			
		}while(choice!=5);
		
		

	}

}



