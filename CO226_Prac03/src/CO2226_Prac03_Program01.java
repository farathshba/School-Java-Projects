import java.util.Arrays;


public class CO2226_Prac03_Program01 
{
	public static void main(String[] args)
	{
		int[] myArray = {4, 3, 6, 2, 5};
		
		myArray = reverseArrayInt(myArray);
		
		System.out.println("Reversed Array : " + Arrays.toString(myArray));
	}
	
	//	Iteractive method
	public static int[] reverseArrayInt(int[] array)
	{
		int[] temp = new int[array.length];
		for(int externalCount = 0; externalCount < array.length; externalCount++)
		{
			temp[internalCount] =
			for(int internalCount = array.length-1; internalCount >= 0; internalCount--)
			{
				temp[internalCount] = array[externalCount];
			}
		}
		
		return temp;
	}
}
