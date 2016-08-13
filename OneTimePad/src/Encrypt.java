import java.io.*;
import java.util.*;

//	Class to encrypt
public class Encrypt 
{		
	//	Method to derive random string message of '0's and '1's with message inputted
	public String sendRandomKey(String message)
	{
		int length = message.length();
		String randOnes = "";
		
		for(int i=1; i<length; i++)
		{
			randOnes = randOnes.concat("1");
		}
		int range = Integer.parseInt(randOnes, 2);
		String otpText = randBinNumber(range);
		
		//	Padding with zeros
		while(otpText.length() < length)
		{
			otpText = otpText + "0";
		}
		
		return otpText;
	}
	
	//	Method to derive random binary string
	private String randBinNumber(int range)
	{
		Random rand = new Random();
		int n = rand.nextInt(range);
		return Integer.toBinaryString(n);
	}
}
