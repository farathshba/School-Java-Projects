import java.util.*;

public class Scramble 
{	
	//	Method to set the Seed into the Random Class
	public static int setSeed(int SEED)
	{
		return (int)(Math.random() * SEED);
	}
	
	//	Global Variables
	//	The First Variable contains random integers from 0 to 1000
	private static int ComputerGeneratedRandomNo;
	private static boolean NOT_MATCH_CASE = true;
	
	//	Constructor to pass the Number by the user and interpret it
	Scramble(int guessingNumber)
	{
		if(guessingNumber < ComputerGeneratedRandomNo)
		{
			System.out.println("Too Low!");
			NOT_MATCH_CASE = true;
		}
		else if(guessingNumber > ComputerGeneratedRandomNo)
		{
			System.out.println("Too High!");
			NOT_MATCH_CASE = true;
		}
		else if(guessingNumber == ComputerGeneratedRandomNo)
		{
			System.out.println("You got it!");
			NOT_MATCH_CASE = false;
		}
	}
	
	public static void Scramble()
	{
		//	Local Variables
		//	The seed number is set by the local user and passed to the global variables
		ComputerGeneratedRandomNo = setSeed(1000);
		Scanner input = new Scanner(System.in);

		System.out.println("Guess my number! It's between 1 and 1000.");
		//	If a Match isn't found, the Loop would keep on looping
		while(NOT_MATCH_CASE)
		{
			System.out.print("Your guess : ");
			//	The program would start prompting for the user input from this very stage,
			//	and would pass to the constructor of this class
			Scramble randomclass = new Scramble(input.nextInt());
		}
	}
}
