import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

/*
 * This main program would contain the Frame Model and the Listeners for simplicity means
 */

public class Main extends JFrame implements ActionListener
{
	/*
	 * The set of working variables and the window components are stored under the class for ease of access
	 * amongst the interfaces, listeners and methods.
	 */
	
	//	To keep track of the objects been stored in the ArrayList
	public static int getCount = 0;
		
	//	An Dynamic Array of type Products would store the products' objects inside this array
	public static ArrayList<Product> products = new ArrayList<Product>();
		
	//	An Dynamic Array of type Products would store the purchased products' objects inside this array
	public static ArrayList<Cart> cart = new ArrayList<Cart>();
	
	/*
	 * Set of Discrete Components to be added to the Frame
	 */
	
	//	Two empty panels created
	private JPanel panelA = new JPanel();
	private JPanel panelB = new JPanel();
	
	//	Individual discrete components
	private static JTextArea catalogArea = new JTextArea(10,42);
	private static JTextArea cartArea = new JTextArea(15,42);
	private JTextField orderNumberField = new JTextField(10);
	private JTextField productQuantityField = new JTextField(2);
	private JButton okBut = new JButton("Enter Order");
	
	/*
	 * Accessor Methods are stated below
	 */
	
	//	To write to the Catalog Area TextField 
	public static void setTextOnCatalog(String text)
	{
		catalogArea.append(text);
		catalogArea.setLineWrap(true);
		catalogArea.setEditable(false);
		catalogArea.setBorder(BorderFactory.createTitledBorder("Catalog"));
		catalogArea.setToolTipText("This panel contains the product information");
		//catalogArea.setText(text);		//	EXPLAIN THIS
	}
	
	//	To write to the Cart Area TextField
	public static void setTextOnCart(String text)
	{
		cartArea.append(text);
		cartArea.setLineWrap(true);
		cartArea.setEditable(false);
		cartArea.setBorder(BorderFactory.createTitledBorder("Cart"));
		cartArea.setToolTipText("This panel contains the purchased products.");
	}
	
	//	To clear the contents of the Cart TextField
	public static void eraseTextOnCart()
	{
		cartArea.setText("");
	}
	
	//	To read in the String from the Order Number Field
	public String getOrderNumber()
	{
		return orderNumberField.getText();
	}
	
	//	To read in the String from the Quantity Field
	public String getProductQuantity()
	{
		return productQuantityField.getText();
	}
	
	//	To return the privatized button
	public JButton getButton()
	{
		return this.okBut;
	}
	
	//	To set the text in the Order Field
	public void setOrderText(String text)
	{
		this.orderNumberField.setText(text);
	}
	
	//	To set the text in the Quantity Field
	public void setQuantityText(String text)
	{
		this.productQuantityField.setText(text);	
	}
	
	/*	
	 *  Constructor which defines the structure of the Frame and adds the
	 *  discrete components as in order.
	 */
	public Main()
	{
		//	Layout of the Frame
		this.setTitle("Shopping Cart");
		this.setSize(500,550);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		//	Addition of the components into the Frame
		panelA.setBorder(BorderFactory.createTitledBorder("Ordering Panel"));
		panelA.add(catalogArea);
		panelA.add(cartArea);
		
		panelB.add(new JLabel("Order no. : "));
		panelB.add(orderNumberField);
		panelB.add(new JLabel("Product Quantity : "));
		panelB.add(productQuantityField);
		panelB.add(okBut);
		
		this.add(panelA, BorderLayout.CENTER);
		this.add(panelB, BorderLayout.PAGE_END);
		
		//	Creation and registration of listeners
		okBut.addActionListener(this);
	}
	
	/*
	 * These following methods are inherited from the Program 07
	 */
	
	//	Method to return the product descriptions as a whole line
	public static Product getProductInfo(String productLine)
	{		
		return new Product(productLine);
	}
	
	//	Method used to sort the Product Objects based on the Product Codes (Bubble Sort method used)
	public static ArrayList<Product> Bubble_Sort(ArrayList<Product> products, int getCount)
	{
		for (int i = 0; i < getCount; i++) 
		{
			for (int j = i + 1; j < getCount; j++) 
			{
				int result = products.get(i).getProductCode().compareTo(products.get(j).getProductCode());
				if (result > 0) 
				{
					Product temp = products.get(i);
					products.set(i, products.get(j));
					products.set(j, temp);
				}
			}
		}
		return products;
	}
	//	Method to print the product line accordingly
	public static void printf(String f, String c, int q, double p, String dollarSign, double t)
	{
		DecimalFormat decfor = new DecimalFormat("0.00");
		System.out.printf(f,c,q,"$" + decfor.format(p), dollarSign, decfor.format(t));
	}
	
	//	Overrided method used to print the formatted "Your order and current date"
	public static void printf(String f, String o, String d)
	{
		System.out.printf(f, o, d);
	}
	
	//	Overrided method used to print the formatted "Amount been spent" output
	public static void printf(String f, String s, String dollarSign, double v)
	{
		DecimalFormat decfor = new DecimalFormat("0.00");
		System.out.printf(f, s, dollarSign, decfor.format(v));
	}
	
	//	Method to print the contents of the dynamic array
	public static void printCart()
	{
		eraseTextOnCart();
		setTextOnCart("Order Summary: \n");
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("dd MMMM yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		setTextOnCart(String.format("%-45s %32s %n%n","YOUR ORDER",dateNow));
		
		double totalAmount = 0.00;
		for(int k=0; k < cart.size(); k++)
		{
			totalAmount = (cart.get(k).getProductCartPrice()*cart.get(k).getProductCartQuantity()) + totalAmount;
			setTextOnCart(String.format("%-30s %10s %15s %12s %6s%n", cart.get(k).getProductCartPhrase(), cart.get(k).getProductCartQuantity(), cart.get(k).getProductCartPrice(),"$", (cart.get(k).getProductCartPrice()*cart.get(k).getProductCartQuantity())));
		}
		setTextOnCart("\n\n");
		setTextOnCart(String.format("%80s %10s %5s%n", "Subtotal: ", "$ ", totalAmount));
		setTextOnCart(String.format("%81s %4s %5s%n", "Tax @ 20%: ", "$ ", (totalAmount*0.2)));
		setTextOnCart(String.format("%83s %3s %5s%n", "Grand Total: ", "$ ", (totalAmount + (totalAmount*0.2))));
	}
	
	/*
	 * Start of Main Method
	 */
	
	public static void main(String[] args)
	{				
		//	Start of reading in from the File
		try
		{
			Scanner fileRdr = new Scanner(new File("Products"));
		
			while(fileRdr.hasNext())
			{						
				getCount = getCount + 1;
				String productLine = fileRdr.nextLine();;
			
				products.add(getProductInfo(productLine));
				
			}
			fileRdr.close();
		}
		catch(IOException ex)
		{
			System.out.println("IO Exception occured!");
		}
		
		//	Products array are passed to the method to be sorted
		products = Bubble_Sort(products, getCount);

		//	Frame is being activated
		new Main();
		
		//	Outputting the catalog contents on the Frame
		for(int i=0; i<getCount; i++)
		{	
			setTextOnCatalog(products.get(i).printProductLine() + "\n");
		}		
	}
	
	//	Listener Method
	public void actionPerformed(ActionEvent e) 
	{
		/*
		 * 	Once the button has been depressed, a linkage of activities should happen,
		 * 	For example, get the contents of the orderField and Quantity field and
		 * 	pass to the Main Class!!
		 */
		
		boolean errorCase = true;
		String productCode = getOrderNumber();
		int nextProduct;			
		
		/*
		 * The code entered would check for the product which is in the dynamic array by comparing
		 * with each and every content of the array.  
		 */
		for(int j=0; j < getCount; j++)
		{
			if(products.get(j).getProductCode().compareTo(productCode) == 0)
			{
				String productQuantity = getProductQuantity();
				
				if(productQuantity.length() != 0 && Integer.parseInt(getProductQuantity()) != 0)
				{
					System.out.println("Inner loop executed : " + Integer.parseInt(getProductQuantity()));	//	DEBUGGER's
					cart.add(new Cart(products.get(j).getProductDesc(), Integer.parseInt(productQuantity), products.get(j).printStrippedPrice()));
					errorCase = true;
				
					nextProduct = JOptionPane.showOptionDialog(null, "Is there any more products? ", "Any more ?", 0, 0, null, null, e);
				
					if(nextProduct != 0)	//	If user presses No
					{
						//	Flush the contents of the userOrderTextField
						this.setOrderText("");
						this.setQuantityText("");
						printCart();
						cart = new ArrayList<Cart>();
						break;
					}
					else					//	If user presses Yes
					{
						//	Flush the contents of the userOrderTextField
						this.setOrderText("");
						this.setQuantityText("");
						continue;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Product Quantity is invalid");
					errorCase = true;
				}
			}
			else
				errorCase = false;
		}	
		if(errorCase != true)
		{
			JOptionPane.showMessageDialog(null, "No product codes found.");
		}
	}
}
