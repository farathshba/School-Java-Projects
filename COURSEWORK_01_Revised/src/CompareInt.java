import java.util.*;

public class CompareInt 
{
	//	Global Variables
	private static int[] unsorted = new int[3];
	private static int[] sorted = new int[3];
	
	//	-------------------- CONSTRUCTORS	------------------------	//
	public CompareInt(int[] passedNumbers)
	{
		unsorted = passedNumbers;
		sortingAlgorithm(unsorted);			
	}
	
	//	-------------------	METHODS	------------------------------	//
	public static int getInteger()
	{
		Scanner INPUT = new Scanner(System.in);
		return INPUT.nextInt();
	}
	
	public static void sortingAlgorithm(int[] unsortedIntegers)
	{
		unsorted = unsortedIntegers;
		//		Algorithm process to sort out the integers in  the array
		
		//		------------------- THE COMPARISON OF THE INTEGERS ONE VERSUS THE OTHER TWO ----------------	//
		//	 	if the First integer is smaller than the other two integers in the array
		if(unsorted[0] < unsorted[1] && unsorted[0] < unsorted[2])		
		{
			// The first integer from the unsorted array is assigned to the first space of the sorted array
			sorted[0] = unsorted[0];
					// And the second integer of the unsorted array is compared against the third one
					if (unsorted[1] < unsorted[2])
					{
						//	Provided the second integer is smaller than the third integer,
						//	the second number from the unsorted array is assigned to 
						//	the second space of the sorted array whilst the third integer 
						//	from the unsorted array is assigned to the third space of the
						//	sorted array.
						sorted[1] = unsorted[1];
						sorted[2] = unsorted[2];
					}
					else
					{
						//	Else, provided the second integer is greater than the third integer,
						//	the third number from the unsorted array is assigned to 
						//	the second space of the sorted array whilst the second integer 
						//	from the unsorted array is assigned to the third space of the
						//	sorted array.
						sorted[1] = unsorted[2];
						sorted[2] = unsorted[1];
					}
				}
				
				// else-if the Second integer is smaller than the other two integers in the array
				else if(unsorted[1] < unsorted[0] && unsorted[1] < unsorted[2])
				{
					// The second integer from the unsorted array is assigned to the first space of the sorted array
					sorted[0] = unsorted[1];
					// And the first integer of the unsorted array is compared against the third one
					if(unsorted[0] < unsorted[2])
					{
						//	Provided the first integer is smaller than the third integer,
						//	the first number from the unsorted array is assigned to 
						//	the second space of the sorted array whilst the third integer 
						//	from the unsorted array is assigned to the third space of the
						//	sorted array.
						sorted[1] = unsorted[0];
						sorted[2] = unsorted[2];
					}
					else
					{
						//	Else, provided the first integer is greater than the third integer,
						//	the third number from the unsorted array is assigned to 
						//	the second space of the sorted array whilst the first integer 
						//	from the unsorted array is assigned to the third space of the
						//	sorted array.
						sorted[1] = unsorted[2];
						sorted[2] = unsorted[0];
					}
				}
				
				// else-if the Third integer is smaller than the other two integers in the array
				else if(unsorted[2] < unsorted[0] && unsorted[2] < unsorted[1])
				{
					// The second integer from the unsorted array is assigned to the first space of the sorted array
					sorted[0] = unsorted[2];
					// And the first integer of the unsorted array is compared against the second one
					if(unsorted[0] < unsorted[1])
					{
						//	Provided the first integer is smaller than the second integer,
						//	the first number from the unsorted array is assigned to 
						//	the second space of the sorted array whilst the second integer 
						//	from the unsorted array is assigned to the third space of the
						//	sorted array.
						sorted[1] = unsorted[0];
						sorted[2] = unsorted[1];
					}
					else
					{
						//	Else, provided the first integer is greater than the second integer,
						//	the second number from the unsorted array is assigned to 
						//	the second space of the sorted array whilst the first integer 
						//	from the unsorted array is assigned to the third space of the
						//	sorted array.
						sorted[1] = unsorted[1];
						sorted[2] = unsorted[0];
					}
				}
	}

	
	public static void SimpleComparisonI()
	{
		//	Local Variables
		String[] WholeNumberPrompts = {"First number : ", "Second number : ", "Third number : "};
		int[] NUMBERS = new int[3];
		
		System.out.println("Enter three whole numbers.");
		
		//	Get the integers from the User and Store in a Array
		for(int counter = 0; counter < 3; counter++)
		{
			System.out.print(WholeNumberPrompts[counter]);
			NUMBERS[counter] = getInteger();
		}
		
		//	Pass the numbers to the class method
		CompareInt objectCompareInt = new CompareInt(NUMBERS);
		
		System.out.println("\nThe smallest number is : " + CompareInt.sorted[0]);
		System.out.println("The middle number is : " + CompareInt.sorted[1]);
		System.out.println("The largest number is : " + CompareInt.sorted[2]);
	}
}
