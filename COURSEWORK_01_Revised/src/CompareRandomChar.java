import java.util.Scanner;


public class CompareRandomChar 
{
	//	Global Variables
	private static char[] unsorted = new char[3];
	private static char[] sorted = new char[3];
	
	//	-------------------- CONSTRUCTORS	------------------------	//

	CompareRandomChar(char[] passedCharacters)
	{
		unsorted = passedCharacters;
		sortRandomCharacters(unsorted);
	}
	
	//	-------------------	METHODS	------------------------------	//

	public static char getRandomCharacter()
	{
		Scanner INPUT = new Scanner(System.in);
		return INPUT.nextLine().charAt(0);
	}
	
	public static void sortRandomCharacters(char[] unsortedCharacters)
	{
		//		------------------- THE COMPARISON OF THE ALPHABETS ONE VERSUS THE OTHER TWO ----------------	//
		//	 	if the First alphabet is smaller than the other two alphabets in the array
		if(unsorted[0] < unsorted[1] && unsorted[0] < unsorted[2])
		{
			// The first alphabet from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[0];
			// And the second alphabet of the unsorted array is compared against the third one
			if (unsorted[1] < unsorted[2])
			{
				//	Provided the second alphabet is smaller than the third alphabet,
				//	the second alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[1];
				sorted[2] = unsorted[2];
			}
			else
			{
				//	Else, provided the second alphabet is greater than the third alphabet,
				//	the third alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[2];
				sorted[2] = unsorted[1];
			}
		}
		
		// else-if the Second alphabet is smaller than the other two alphabets in the array
		else if(unsorted[1] < unsorted[0] && unsorted[1] < unsorted[2])
		{
			// The second alphabet from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[1];
			// And the first alphabet of the unsorted array is compared against the third one
			if(unsorted[0] < unsorted[2])
			{
				//	Provided the first alphabet is smaller than the third alphabet,
				//	the first alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[0];
				sorted[2] = unsorted[2];
			}
			else
			{
				//	Else, provided the first alphabet is greater than the third alphabet,
				//	the third alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[2];
				sorted[2] = unsorted[0];
			}
		}
		
		// else-if the Third alphabet is smaller than the other two alphabets in the array
		else if(unsorted[2] < unsorted[0] && unsorted[2] < unsorted[1])
		{
			// The second alphabet from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[2];
			// And the first alphabet of the unsorted array is compared against the second one
			if(unsorted[0] < unsorted[1])
			{
				//	Provided the first alphabet is smaller than the second alphabet,
				//	the first alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[0];
				sorted[2] = unsorted[1];
			}
			else
			{
				//	Else, provided the first alphabet is greater than the second alphabet,
				//	the second alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[1];
				sorted[2] = unsorted[0];
			}
		}
	}
	
	public static void SimpleComparisonII()
	{
		String[] WholeNumberPrompts = {"First character : ", "Second character : ", "Third character : "};
		char[] characters = new char[3];
		
		System.out.println("Enter any three distinct characters.");
		
		for(int counter = 0; counter < 3; counter++)
		{
			System.out.print(WholeNumberPrompts[counter]);
			characters[counter] = getRandomCharacter();
		}
		
		CompareRandomChar objectCompareChar = new CompareRandomChar(characters);
		
		System.out.println("\nThe smallest character is : " + CompareRandomChar.sorted[0]);
		System.out.println("The middle character is : " + CompareRandomChar.sorted[1]);
		System.out.println("The largest character is : " + CompareRandomChar.sorted[2]);
	}
}

