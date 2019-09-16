
public class Swap1 {
	
	static void swap1(int a,int b)
	{
	int c;
	c=a;a=b;b=c;
	System.out.println("using third variable  "+a+" "+b);
		
	}
	static void swap2(int a,int b)
	{
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("without using third variable  "+a+" "+b);
	}
	
public static void main(String args[])
{
int a,b;
a=10;b=20;
swap1(a,b);
swap2(a,b);

	
}
}
