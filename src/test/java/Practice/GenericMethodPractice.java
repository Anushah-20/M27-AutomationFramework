package Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {

		int sum= add(10,2);
		System.out.println(sum);
		System.out.println(add(2,3));
		System.out.println(sub(20,10));
		

	}
	
	public static int add(int a, int b)
	{
		return a+b;
		
	}
	
	public static int sub(int a, int b)
	{
		return a-b;
	}

}
