
import java.util.*;


class BubbleSort
{

public static void bubbleSort(int ar[],int n)
{

	int i,temp,j;

	
	for ( i = 0; i < n-1; i++)
        for ( j = 0; j < n-i-1; j++)
            if (ar[j] > ar[j+1])
            {
                // swap temp and arr[i]
                 temp = ar[j];
                ar[j] = ar[j+1];
                ar[j+1] = temp;
            }



	System.out.println("\ndata after bubble sort \n");
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

	bubbleSort(ar,n);
}


}


