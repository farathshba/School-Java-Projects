import java.util.Scanner;


public class CompareChar 
{
	//	Global Variables
	private static char[] unsorted = new char[3];
	private static char[] sorted = new char[3];
	
	//	-------------------- CONSTRUCTORS	------------------------	//

	CompareChar(char[] passedLetters)
	{
		unsorted = passedLetters;
		sortLetters(unsorted);
	}
	
	//	-------------------	METHODS	------------------------------	//
	
	public static char getLetter()
	{
		Scanner INPUT = new Scanner(System.in);
		return INPUT.nextLine().charAt(0);
	}
	
	public static void sortLetters(char[] unsortedLetters)
	{
		//		------------------- THE COMPARISON OF THE LETTERS ONE VERSUS THE OTHER TWO ----------------	//
		
		//	 	if the First letter is smaller than the other two letters in the array
		if(unsorted[0] < unsorted[1] && unsorted[0] < unsorted[2])
		{
			// The first letter from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[0];
			// And the second letter of the unsorted array is compared against the third one
			if (unsorted[1] < unsorted[2])
			{
				//	Provided the second letter is smaller than the third letter,
				//	the second letter from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third letter 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[1];
				sorted[2] = unsorted[2];
			}
			else
			{
				//	Else, provided the second letter is greater than the third letter,
				//	the third letter from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second letter 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[2];
				sorted[2] = unsorted[1];
			}
		}
		
		// else-if the Second letter is smaller than the other two letters in the array
		else if(unsorted[1] < unsorted[0] && unsorted[1] < unsorted[2])
		{
			// The second letter from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[1];
			// And the first letter of the unsorted array is compared against the third one
			if(unsorted[0] < unsorted[2])
			{
				//	Provided the first letter is smaller than the third letter,
				//	the first letter from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third letter 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[0];
				sorted[2] = unsorted[2];
			}
			else
			{
				//	Else, provided the first letter is greater than the third letter,
				//	the third letter from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first letter 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[2];
				sorted[2] = unsorted[0];
			}
		}
		
		// else-if the Third letter is smaller than the other two letters in the array
		else if(unsorted[2] < unsorted[0] && unsorted[2] < unsorted[1])
		{
			// The second letter from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[2];
			// And the first letter of the unsorted array is compared against the second one
			if(unsorted[0] < unsorted[1])
			{
				//	Provided the first letter is smaller than the second letter,
				//	the first letter from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second letter 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[0];
				sorted[2] = unsorted[1];
			}
			else
			{
				//	Else, provided the first letter is greater than the second letter,
				//	the second letter from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first letter 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sorted[1] = unsorted[1];
				sorted[2] = unsorted[0];
			}
		}
	}
	
	public static void SimpleComparisonII()
	{
		String[] WholeNumberPrompts = {"First Letter : ", "Second Letter : ", "Third Letter : "};
		char[] letters = new char[3];
		
		System.out.println("Enter three distinct alphabetic letters.");
		
		for(int counter = 0; counter < 3; counter++)
		{
			System.out.print(WholeNumberPrompts[counter]);
			letters[counter] = getLetter();
		}
		
		CompareChar objectCompareChar = new CompareChar(letters);
		
		System.out.println("\nThe smallest letter is : " + CompareChar.sorted[0]);
		System.out.println("The middle letter is : " + CompareChar.sorted[1]);
		System.out.println("The largest letter is : " + CompareChar.sorted[2]);
	}
}

