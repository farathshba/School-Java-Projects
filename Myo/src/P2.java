import java.io.*;
import java.util.*;
public class P2 {

//this method is just a short way of writing System.out.print
//so everytime instead of full , just need to write SOP to print out data
public static void SOP(String data)
{
System.out.print(data); // it will print data
}

//this method is just a short way of writing System.out.println
//so everytime instead of full , just need to write SOPln to print out data
public static void SOPln(String data)
{
System.out.println(data); // it will print data and go to next line
}

// this method will catch the value that the user key in
// return it as string type
public static String getString()
{
Scanner sc = new Scanner(System.in); // use the scanner class
String s = sc.next(); // value that user enter will store
return s; // inside s.
}

public static void main(String[] args)
{
Vector<Catalog> vec = new Vector(); // declare new vector
String product_code; // declare variables
String product_desc;
String product_price;
String product_phr;
int t = 0;
boolean ForeverLoop= true;
try // to try & catch exception
{
// read in from the external file called Catalog.txt
Scanner sc = new Scanner (new File("Catalog.txt"));
while(sc.hasNext()) // this loop will read in line by line
{
t++;
product_code = sc.next(); // store only code from the file inside the product_code
product_desc = sc.nextLine(); // store the rest data from the file to product_desc
vec.add(new Catalog(product_code, product_desc)); //add the value to the vector
}
sc.close(); // close the file
}
catch(Exception ex) // catch the exception and print message
{
System.out.println("Exception found");
}

while(ForeverLoop)
{
SOP("Enter product description: "); // prompt the message
product_desc = getString(); // store the value user enter to the product_desc
if(product_desc.equals("#")) // when '#' is pressed, it will stop the while loop
{
break;
}
SOP("Enter product code: "); // to display the message
product_code = getString(); // to store the vlaue user enter to the product_code
SOP("Enter product unit price: "); // to display the message
product_price = getString(); // to store the value user enter to the product_price
SOP("Enter product unit phrase: "); // to display the message
product_phr = getString(); // t o store the value user enter to the product_phr
SOP("\n"); // to have a blank line
vec.add(t, new Catalog(product_code,(", "+ product_desc+", "+ product_price+", "+ product_phr)));
t++;
}

SOPln("Please enter the product code of the item that you wish to delete. If you wish to stop, press '#'. ");
while(ForeverLoop)
{
SOP("Enter product code: ");
product_code = getString();
if(product_code.equals("#"))
{
break;
}
for(int q=0;q<t;q++)
{
System.out.println(product_code);
System.out.println(vec.get(q).returnPC());
if(product_code.equals(vec.get(q).returnPC().replaceAll(",", "")))
{
System.out.println("if-else");
vec.remove(q);
SOP("Item has been removed");
t--;
}

}
}
for(int i=0; i<t; i++) // this loop will perform bubble sorting
{
for(int n=i+1; n<t; n++)
{
// retrieve the different values of product codes and compare
int op = vec.get(i).returnPC().compareTo(vec.get(n).returnPC());
if(op > 0)
{
Catalog a = vec.get(i);
vec.set(i, vec.get(n));
vec.set(n, a);
}
}
}

// once the sorting is done
// this loop will finally display the data from the file.
SOPln("\nYour catalog : ");

int k=0;
while(k<t)
{
SOPln(vec.get(k).displayPD());
k++;
}

try // if there is an exception it will catch and print out error occur
{
// this will create a new text file call catalog
PrintWriter pw = new PrintWriter(new File(("Catalog.txt")));

// for loop will keep looping for the number of product description the user enter
for(int p=0; p<k; p++)
{
// exporting the
pw.println(vec.get(p).displayPD());
}
pw.close();
}
catch(Exception exp)
{
System.out.println ("Exception found!");
}
}
}