import java.util.*;

public class B01 
{
	public static void SimpleComparison()
	{		
		//	---------- START OF DECLARATION OF VARIABLES ------------	//
		// Initialization of the Scanner class
		Scanner input = new Scanner(System.in);
		
		// Array to store the numbers
		int[] NUMBERS = new int[3];
		
		// String used to output the prompt
		String OUTPUTdata = new String();
		
		// Array to store the sorted numbers in ascending manner
		int[] sortedNUMBERS = new int[3];
		
		//	---------- END OF DECLARATION OF VARIABLES ------------	//
		
		System.out.println("Enter three whole numbers.");
		
		//	For-Loop used to obtain the three integers from the user
		for (int counter = 0; counter < 3; counter++)
		{
			switch(counter)
			{
				//	Switch statement used to automatically ask for First, Second
				//	and Third integers without manual way of prompting
				case 0: OUTPUTdata = "First number: "; break;
				case 1: OUTPUTdata = "Second number: "; break;
				case 2: OUTPUTdata = "Third number: "; break;
			}
			
			System.out.print(OUTPUTdata);
			// Integer from the user is stuffed in the array
			NUMBERS[counter] = input.nextInt();		
			// A Extra Line is being printed
			System.out.println();					
		}
		
		//	------------------- THE COMPARISON OF THE INTEGERS ONE VERSUS THE OTHER TWO ----------------	//
		//	 	if the First integer is smaller than the other two integers in the array
		if(NUMBERS[0] < NUMBERS[1] && NUMBERS[0] < NUMBERS[2])		
		{
			// The first integer from the unsorted array is assigned to the first space of the sorted array
			sortedNUMBERS[0] = NUMBERS[0];
			// And the second integer of the unsorted array is compared against the third one
			if (NUMBERS[1] < NUMBERS[2])
			{
				//	Provided the second integer is smaller than the third integer,
				//	the second number from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third integer 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedNUMBERS[1] = NUMBERS[1];
				sortedNUMBERS[2] = NUMBERS[2];
			}
			else
			{
				//	Else, provided the second integer is greater than the third integer,
				//	the third number from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second integer 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedNUMBERS[1] = NUMBERS[2];
				sortedNUMBERS[2] = NUMBERS[1];
			}
		}
		
		// else-if the Second integer is smaller than the other two integers in the array
		else if(NUMBERS[1] < NUMBERS[0] && NUMBERS[1] < NUMBERS[2])
		{
			// The second integer from the unsorted array is assigned to the first space of the sorted array
			sortedNUMBERS[0] = NUMBERS[1];
			// And the first integer of the unsorted array is compared against the third one
			if(NUMBERS[0] < NUMBERS[2])
			{
				//	Provided the first integer is smaller than the third integer,
				//	the first number from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the third integer 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedNUMBERS[1] = NUMBERS[0];
				sortedNUMBERS[2] = NUMBERS[2];
			}
			else
			{
				//	Else, provided the first integer is greater than the third integer,
				//	the third number from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first integer 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedNUMBERS[1] = NUMBERS[2];
				sortedNUMBERS[2] = NUMBERS[0];
			}
		}
		
		// else-if the Third integer is smaller than the other two integers in the array
		else if(NUMBERS[2] < NUMBERS[0] && NUMBERS[2] < NUMBERS[1])
		{
			// The second integer from the unsorted array is assigned to the first space of the sorted array
			sortedNUMBERS[0] = NUMBERS[2];
			// And the first integer of the unsorted array is compared against the second one
			if(NUMBERS[0] < NUMBERS[1])
			{
				//	Provided the first integer is smaller than the second integer,
				//	the first number from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the second integer 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedNUMBERS[1] = NUMBERS[0];
				sortedNUMBERS[2] = NUMBERS[1];
			}
			else
			{
				//	Else, provided the first integer is greater than the second integer,
				//	the second number from the unsorted array is assigned to 
				//	the second space of the sorted array whilst the first integer 
				//	from the unsorted array is assigned to the third space of the
				//	sorted array.
				sortedNUMBERS[1] = NUMBERS[1];
				sortedNUMBERS[2] = NUMBERS[0];
			}
		}
		
		//	Now, the below statement prints out the numbers in ascending form
		//	from the Sorted Array
		System.out.println("The smallest number is: " + sortedNUMBERS[0]);
		System.out.println("The middle number is: " + sortedNUMBERS[1]);
		System.out.println("The largest number is: " + sortedNUMBERS[2]);
	}
		
}
