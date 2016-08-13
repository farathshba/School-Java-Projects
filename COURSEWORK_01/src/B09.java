import java.util.*;

public class B09 
{
	public static void Loops2()
	{
		Scanner input = new Scanner(System.in);  
        int width = 7;  
          
        // Create the 'X'  
        // This prints the Row
        for(int row = 1; row <= width; row++)
        {  
            System.out.println();
            // This prints the Column
            for(int column = 1; column <= width; column++)
            {  
            	// The line would be drawn to form the one side of the 'X' exactly when the the Row's and the Columns 
            	//	having the same axises. 
            	//	Same occurs for the other opposite side by negatively.
                if(row == column || (row + column) == (width + 1))  
                    System.out.print("X");  
                else  
                    System.out.print(" ");  
            }  
        }  
	}
}
