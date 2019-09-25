
import java.util.*;


class SelectionSort
{

public static void selectionSort(int ar[],int n)
{

	int i,temp,j;

	for(i=0;i<n-1;i++)

	{


		for(j=i+1;j<n;j++)
		{
			if(ar[i]>ar[j])
			{
				
		
				temp=ar[i];
				ar[i]=ar[j];
				ar[j]=temp;
			
			}
		
		}
	
	
	}



	System.out.println("\ndata after selection sort \n");
	for(i=0;i<n;i++)
	{

		System.out.println(ar[i]);
	}




}


public static void main(String aa[])
{
	int ar[]=new int[10];
	int i,n;

	Scanner in=new Scanner(System.in);
	
	System.out.println("enter the size (<10): ");
	n=Integer.parseInt(in.nextLine());
	System.out.println("enter  elements ");
	for(i=0;i<n;i++)
	{
		ar[i]=Integer.parseInt(in.nextLine());
	}
	System.out.println("before sorting");
	for(i=0;i<n;i++)
	{
		System.out.println(ar[i]);
	}

	selectionSort(ar,n);
}


}


