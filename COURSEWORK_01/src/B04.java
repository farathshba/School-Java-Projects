import java.text.*;

public class B04 
{
	//	This method would print Empty Line Breaks for the number of arguments been passed
	public static void LINEBREAK(int noOfLineBreaks)
	{
		for(int counter = 0; counter < noOfLineBreaks; counter++)
		{
			System.out.println();
		}
	}
	public static void FormattingOutput()
	{
		//	This segment illustrates numbers to be printed with different precisions and widths
		//	An example would be utilised to illustrate that below: 
		double DECIMAL_NUMBER = 8.0 / 3;
		
		System.out.println("The double value by default is " + DECIMAL_NUMBER + "\n");
		
		
		//	The decimal printed to three decimal places and a width of 5
		System.out.printf("The decimal value printed to the nearest three places and a width of 5 would be %5.3f", DECIMAL_NUMBER);
		
		//	Print a Line Break
		LINEBREAK(1);
		
		//	The decimal printed to one decimal places and a width of 3
		System.out.printf("The decimal value printed to the nearest ONE place and a width of 3 would be %3.1f", DECIMAL_NUMBER);
		LINEBREAK(3);
		
		//	This segment illustrates rows of String be printed with different justifications
		String[] NAMES = {"Sam", "Tom", "Harry", "Michael", "Steve"};
		
		//	Several rows of names being printed with left justification
		System.out.println("Left Justified : ");
		for (int counter = 0; counter < 5; counter++)
		{
			System.out.printf("%-8s", NAMES[counter]);
		}
		
		LINEBREAK(2);
		
		//	Several rows of names being printed with right justification
		System.out.println("Right Justified : ");
		for (int counter = 0; counter < 5; counter++)
		{
			System.out.printf("%8s", NAMES[counter]);
		}
		
		LINEBREAK(3);
		
		//	Line up several decimal numbers alligned accordingly to their 
		double[] values = {1.41, 12.44, 767.98, 2341.9, 1.98346};
		
		//	Several rows of decimal numbers printed alligned to their decimal points
		System.out.println("Decimals Alligned accordingly to their decimal points: \n\n");
		for (int counter = 0; counter < 5; counter++)
		{
			//	The Decimal's would hold a width of 21 and a matissa of 15 would be supported as illustrated by the following statement
			System.out.printf("%21.15f", values[counter]);
			LINEBREAK(1);
		}
	}
}
