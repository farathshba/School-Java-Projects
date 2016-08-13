
import java.util.*;

public class B03 
{
	public static void SimpleComparison()
	{		
		//		---------- START OF DECLARATION OF VARIABLES ------------	//
		// Initialization of the Scanner class
		Scanner input = new Scanner(System.in);
		
		// Array to store the characters
		char[] CHARC = new char[3];
		
		// String used to output the prompt
		String OUTPUTdata = new String();
		
		// Array to store the sorted characters in ascending manner
		char[] sortedCHARAC = new char[3];
		
		//		---------- END OF DECLARATION OF VARIABLES ------------	//
		
		System.out.println("Enter three whole characters.");
		
		// For-Loop used to obtain the three characters from the user
		for (int counter = 0; counter < 3; counter++)
		{
			switch(counter)
			{
				// Switch statement used to automatically ask for First, Second
				// and Third characters without manual way of prompting
				case 0: OUTPUTdata = "First character: "; break;
				case 1: OUTPUTdata = "Second character: "; break;
				case 2: OUTPUTdata = "Third character: "; break;
			}
			
			System.out.print(OUTPUTdata);
			// Alphabet from the user is converted from String to a character variable
			CHARC[counter] = (input.nextLine()).charAt(0);
			// A Extra Line is being printed
			//System.out.println();
		}
		
		//		------------------- THE COMPARISON OF THE CHARACTERS ONE VERSUS THE OTHER TWO ----------------	//
		//	 	if the First character is smaller than the other two character in the array
		if(CHARC[0] < CHARC[1] && CHARC[0] < CHARC[2])
		{
			// The first character from the unsorted array is assigned to the first space of the sorted array
			sortedCHARAC[0] = CHARC[0];
			// And the second character of the unsorted array is compared against the third one
			if (CHARC[1] < CHARC[2])
			{
				//	Provided the second character is smaller than the third character,
				//	the second character from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third character 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedCHARAC[1] = CHARC[1];
				sortedCHARAC[2] = CHARC[2];
			}
			else
			{
				//	Else, provided the second character is greater than the third character,
				//	the third character from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second character 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedCHARAC[1] = CHARC[2];
				sortedCHARAC[2] = CHARC[1];
			}
		}
		
		// else-if the Second character is smaller than the other two characters in the array
		else if(CHARC[1] < CHARC[0] && CHARC[1] < CHARC[2])
		{
			// The second character from the unsorted array is assigned to the first space of the sorted array
			sortedCHARAC[0] = CHARC[1];
			// And the first character of the unsorted array is compared against the third one
			if(CHARC[0] < CHARC[2])
			{
				//	Provided the first character is smaller than the third character,
				//	the first character from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third character 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedCHARAC[1] = CHARC[0];
				sortedCHARAC[2] = CHARC[2];
			}
			else
			{
				//	Else, provided the first character is greater than the third character,
				//	the third character from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first character 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedCHARAC[1] = CHARC[2];
				sortedCHARAC[2] = CHARC[0];
			}
		}
		
		// else-if the Third character is smaller than the other two characters in the array
		else if(CHARC[2] < CHARC[0] && CHARC[2] < CHARC[1])
		{
			// The second character from the unsorted array is assigned to the first space of the sorted array
			sortedCHARAC[0] = CHARC[2];
			// And the first character of the unsorted array is compared against the second one
			if(CHARC[0] < CHARC[1])
			{
				//	Provided the first character is smaller than the second character,
				//	the first character from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second character 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedCHARAC[1] = CHARC[0];
				sortedCHARAC[2] = CHARC[1];
			}
			else
			{
				//	Else, provided the first character is greater than the second character,
				//	the second character from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first character 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedCHARAC[1] = CHARC[1];
				sortedCHARAC[2] = CHARC[0];
			}
		}
		
		//	Now, the below statement prints out the characters in ascending form
		//	from the Sorted Array
		System.out.println("\nThe smallest character is: " + sortedCHARAC[0]);
		System.out.println("The middle character is: " + sortedCHARAC[1]);
		System.out.println("The largest character is: " + sortedCHARAC[2]);
	}
		
}
