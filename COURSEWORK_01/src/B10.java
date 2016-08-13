import java.util.Scanner;


public class B10 
{
	public static void Loops3()
	{
		Scanner input = new Scanner(System.in);  
        int userNum;  
          
        // Get the User Input  
        // For loop used to predetermine that width is contained between 3 to 150
        while(true)
        {  
            System.out.print("Enter in a number: ");  
            userNum = input.nextInt();  
            if(userNum >= 3 && userNum <= 25)
            {
                if(userNum%2 == 1)
                {
                	break;
                }
                else
                	System.out.println("The number must be 3-25 and should be odd.\nPlease enter the number again.");  
            }
            else  
                System.out.println("The number must be 3-25 and should be odd.\nPlease enter the number again.");  
        }  
          
        // Creation the 'X'
        //
        for(int row = 1; row <= userNum; row++)
        {  
            System.out.println("");  
            // The line would be drawn to form the one side of the 'X' exactly when the the Row's and the Columns 
        	//	having the same axises. 
        	//	Same occurs for the other opposite side by negatively.
            for(int column = 1; column <= userNum; column++)
            {  
                if(row == column || (row + column) == (userNum + 1))  
                    System.out.print("X");  
                else  
                    System.out.print(" ");  
            }  
        }  
	}
}
