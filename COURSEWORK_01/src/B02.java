
import java.util.*;

public class B02 
{
	public static void SimpleComparison()
	{		
		//		---------- START OF DECLARATION OF VARIABLES ------------	//
		// Initialization of the Scanner class
		Scanner input = new Scanner(System.in);
		
		// Array to store the alphabets
		char[] CHARC = new char[3];
		
		// String used to output the prompt
		String OUTPUTdata = new String();
		
		// Array to store the sorted alphabets in ascending manner
		char[] sortedALPHA = new char[3];
		
		//		---------- END OF DECLARATION OF VARIABLES ------------	//
		
		System.out.println("Enter three characters.");
		
		// For-Loop used to obtain the three alphabets from the user
		for (int counter = 0; counter < 3; counter++)
		{
			switch(counter)
			{
				// Switch statement used to automatically ask for First, Second
				// and Third alphabets without manual way of prompting
				case 0: OUTPUTdata = "First character: "; break;
				case 1: OUTPUTdata = "Second character: "; break;
				case 2: OUTPUTdata = "Third character: "; break;
			}
			
			System.out.print(OUTPUTdata);
			// Alphabet from the user is converted from String to a character variable
			CHARC[counter] = (input.nextLine()).charAt(0);
			// A Extra Line is being printed
			System.out.println();
		}
		
		//		------------------- THE COMPARISON OF THE ALPHABETS ONE VERSUS THE OTHER TWO ----------------	//
		//	 	if the First alphabet is smaller than the other two alphabets in the array
		if(CHARC[0] < CHARC[1] && CHARC[0] < CHARC[2])
		{
			// The first alphabet from the unsorted array is assigned to the first space of the sorted array
			sortedALPHA[0] = CHARC[0];
			// And the second alphabet of the unsorted array is compared against the third one
			if (CHARC[1] < CHARC[2])
			{
				//	Provided the second alphabet is smaller than the third alphabet,
				//	the second alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedALPHA[1] = CHARC[1];
				sortedALPHA[2] = CHARC[2];
			}
			else
			{
				//	Else, provided the second alphabet is greater than the third alphabet,
				//	the third alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedALPHA[1] = CHARC[2];
				sortedALPHA[2] = CHARC[1];
			}
		}
		
		// else-if the Second alphabet is smaller than the other two alphabets in the array
		else if(CHARC[1] < CHARC[0] && CHARC[1] < CHARC[2])
		{
			// The second alphabet from the unsorted array is assigned to the first space of the sorted array
			sortedALPHA[0] = CHARC[1];
			// And the first alphabet of the unsorted array is compared against the third one
			if(CHARC[0] < CHARC[2])
			{
				//	Provided the first alphabet is smaller than the third alphabet,
				//	the first alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedALPHA[1] = CHARC[0];
				sortedALPHA[2] = CHARC[2];
			}
			else
			{
				//	Else, provided the first alphabet is greater than the third alphabet,
				//	the third alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedALPHA[1] = CHARC[2];
				sortedALPHA[2] = CHARC[0];
			}
		}
		
		// else-if the Third alphabet is smaller than the other two alphabets in the array
		else if(CHARC[2] < CHARC[0] && CHARC[2] < CHARC[1])
		{
			// The second alphabet from the unsorted array is assigned to the first space of the sorted array
			sortedALPHA[0] = CHARC[2];
			// And the first alphabet of the unsorted array is compared against the second one
			if(CHARC[0] < CHARC[1])
			{
				//	Provided the first alphabet is smaller than the second alphabet,
				//	the first alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedALPHA[1] = CHARC[0];
				sortedALPHA[2] = CHARC[1];
			}
			else
			{
				//	Else, provided the first alphabet is greater than the second alphabet,
				//	the second alphabet from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first alphabet 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedALPHA[1] = CHARC[1];
				sortedALPHA[2] = CHARC[0];
			}
		}
		
		//	Now, the below statement prints out the alphabets in ascending form
		//	from the Sorted Array
		System.out.println("The smallest alphabet is: " + sortedALPHA[0]);
		System.out.println("The middle alphabet is: " + sortedALPHA[1]);
		System.out.println("The largest alphabet is: " + sortedALPHA[2]);
	}
		
}
