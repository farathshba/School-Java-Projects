
public class B08 
{
	public static void Loops1()
	{
		//	The Topmost and the below most are been stored in a array
		char[] topNBtmCOLUMN = {'X', 'X', 'X', ' ', ' ', ' ', 'X', 'X', 'X'};
		//	The Middle Part are been stored in a array too
		char[] midCOLUMN = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'};
		
		//	Two counters are being utilised here, one is the vertical counter to keep track of the Columns
		//	and horizontal counter to keep track of the Rows
		//	For every Vertical Loop, a Horizontal Loop would execute printing the entries from the arrays
		//	but when the Vertical Counter hits the middle row, which is 3 is this context,
		//	it would execute the 'midCOLUMN' array from the context
		for(int verticalCounter = 0; verticalCounter < 7; verticalCounter++)
		{
			if(verticalCounter != 3)
			{
				for(int horizontalCounter = 0; horizontalCounter < 9; horizontalCounter++)
				{
					System.out.print(topNBtmCOLUMN[horizontalCounter]);
				}
			}
			else
			{
				for(int horizontalCounter = 0; horizontalCounter < 9; horizontalCounter++)
				{
					System.out.print(midCOLUMN[horizontalCounter]);
				}
			}
			
			// This prints a line after every Horizontal Array being printed	
			System.out.println();
		}
	}
}
