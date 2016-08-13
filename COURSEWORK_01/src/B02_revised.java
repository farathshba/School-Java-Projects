import java.util.*;


public class B02_revised 
{
	public static void B02_revised()
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
		
		// Array used to hold the alphabets a to z
		char[] lowerAlphabets = {'a', 'b', 'c', 'd'};
		
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

	}
}
