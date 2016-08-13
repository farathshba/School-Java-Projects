import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EatStrings 
{
	public static void main(String[] args) throws Exception
	{
		//	Variables to hold the contents of the text files
		String universitiesString;
		String urlString;
		ArrayList<String> urlList = new ArrayList<String>();
		ArrayList<String> britainUrlList = new ArrayList<String>();
		
		try
		{
			//	Read the contents of the File onto Variables
			Scanner universitiesFileStream = new Scanner(new FileInputStream("universities.txt"), "UTF-8");
			universitiesString = universitiesFileStream.useDelimiter("\\A").next();
			
			BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("newUrls.txt")));
			
			universitiesFileStream.close();
			
			//	Retrieve the links only from the text file
			urlList.addAll(pullLinks(universitiesString));
			
			//	Retrieve the textual data only from the text file and write the URLs into 'newUrls.txt'
			for(int count = 0; count < urlList.size(); count++)
			{
				System.out.println("Contents of Arraylist index " + count + " : " + urlList.get(count));
				universitiesString = universitiesString.replaceFirst(urlList.get(count), " ");
				fout.write(urlList.get(count) + "\n");
			}
			
			fout.close();
			
			//	Write the textual data into the 'notUrls.txt'
			fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("notUrls.txt")));
			fout.write(universitiesString);
			fout.close();
			
			//	Retrieve the Brit URLs only and store in ArrayList
			for(int count = 0; count < urlList.size(); count++)
			{
				if(urlList.get(count).contains(".ac.uk"))
				{
					britainUrlList.add(urlList.get(count));
				}
			}
			
			//	Pop the Urls with "Gold" to the top
			String temp;
			for(int count=0; count < britainUrlList.size(); count++)
			{
				System.out.println("Britain Address : " + britainUrlList.get(count));
				if(britainUrlList.get(count).contains("gold"))
				{
					temp = britainUrlList.get(count);
					britainUrlList.set(count, britainUrlList.get(0));
					britainUrlList.set(0, temp);
				}
			}
			
			//	Write the Britain Only URLs onto File
			fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("BritUniUrls.txt")));
			for(int count=0; count < britainUrlList.size(); count++)
			{
				fout.write(britainUrlList.get(count) + "\n");
			}
			fout.close();
			
		}
		catch(FileNotFoundException fileNotFoundError)
		{
			System.out.println("File is not found.");
		}
	}
	
	//	Method to retrieve the URL addresses from the Textual Files
	public static ArrayList pullLinks(String text) 
	{
		ArrayList<String> links = new ArrayList<String>();
		 
		String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(text);
		
		while(match.find()) 
		{
			String urlStr = match.group();
			if (urlStr.startsWith("(") && urlStr.endsWith(")"))
			{
				urlStr = urlStr.substring(1, urlStr.length() - 1);
			}
			links.add(urlStr);
		}
		
		return links;
	}
}
