//	This contains the view components for the shopping cart
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class View extends JFrame
{
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel2a;
	private JPanel panel2b;
	private JPanel panel2c;
	private JPanel panel2d;
	private JPanel panel2e;
	private GridLayout layout;
	private JTextArea cashTextArea;
	private JTextArea inputTextArea;
	
	//	Components
	private JButton pluButton;
	private JButton clearButton;
	private JButton voidButton;
	private JButton preprintButton;
	private JButton ccButton;
	private JButton couponButton;
	private JButton voucherButton;
	private JButton subButton;
	private JButton cashButton;
	private JButton multiplyButton;
	private JButton divisorButton;
	private JButton subtractButton;
	private JButton addButton;
	private JButton decimalButton;
	private JButton doubleZeroButton;
	private JButton singleZeroButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	
	public View()
	{
		//	Calling the components function
		Comp();
		
		//	Configurations of the Frame - JFrame
		this.setVisible(true);
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		layout = new GridLayout(1, 2, 5, 5);
		this.setLayout(layout);
	}
	
	public void Comp()
	{
		//	Creation of minor components
		cashTextArea = new JTextArea(34, 11);
		cashTextArea.setEditable(false);
		inputTextArea = new JTextArea(34, 11);
		inputTextArea.setEditable(false);
		
		pluButton = new JButton("PLU");
		pluButton.setMnemonic('p');
		clearButton = new JButton("C");
		clearButton.setMnemonic('C');
		voidButton = new JButton("VOID");
		voidButton.setMnemonic('V');
		preprintButton = new JButton("Pre Print");
		preprintButton.setMnemonic('P');
		ccButton = new JButton("Credit Card");
		ccButton.setMnemonic('C');
		couponButton = new JButton("Coupon");
		couponButton.setMnemonic('c');
		voucherButton = new JButton("Voucher");
		subButton = new JButton("SUB");
		cashButton = new JButton("Cash");
		multiplyButton = new JButton("X");
		divisorButton = new JButton("%");
		subtractButton = new JButton("-");
		addButton = new JButton("+");
		decimalButton = new JButton(".");
		doubleZeroButton = new JButton("00");
		singleZeroButton = new JButton("0");
		oneButton = new JButton("1");
		twoButton = new JButton("2");
		threeButton = new JButton("3");
		fourButton = new JButton("4");
		fiveButton = new JButton("5");
		sixButton = new JButton("6");
		sevenButton = new JButton("7");
		eightButton = new JButton("8");
		nineButton = new JButton("9");
		
		//	Creation of JPanels
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel2a = new JPanel();
		panel2b = new JPanel();
		panel2c = new JPanel();
		panel2d = new JPanel();
		panel2e = new JPanel();
		panel1.setBorder(BorderFactory.createTitledBorder("Screen"));
		panel2.setBorder(BorderFactory.createTitledBorder("Enter here"));
		this.add(panel1);
		this.add(panel2);
		
		//	Addition of the components onto respective Panels
		panel1.setLayout(new GridLayout(2, 1));
		panel1.add(cashTextArea);
		panel1.add(inputTextArea);
		
		panel2.setLayout(new GridLayout(5,1));
		panel2a.setLayout(new GridLayout(1,5));
		panel2a.add(pluButton);
		panel2a.add(clearButton);
		panel2a.add(voidButton);
		panel2a.add(preprintButton);
		panel2a.add(ccButton);
		
		panel2b.setLayout(new GridLayout(1,5));
		panel2b.add(multiplyButton);
		panel2b.add(sevenButton);
		panel2b.add(eightButton);
		panel2b.add(nineButton);
		panel2b.add(couponButton);
		
		panel2c.setLayout(new GridLayout(1,5));
		panel2c.add(divisorButton);
		panel2c.add(fourButton);
		panel2c.add(fiveButton);
		panel2c.add(sixButton);
		panel2c.add(voucherButton);
		
		panel2d.setLayout(new GridLayout(1,5));
		panel2d.add(subtractButton);
		panel2d.add(oneButton);
		panel2d.add(twoButton);
		panel2d.add(threeButton);
		panel2d.add(subButton);
		
		panel2e.setLayout(new GridLayout(1,5));
		panel2e.add(addButton);
		panel2e.add(singleZeroButton);
		panel2e.add(doubleZeroButton);
		panel2e.add(decimalButton);
		panel2e.add(cashButton);
		
		panel2.add(panel2a);
		panel2.add(panel2b);
		panel2.add(panel2c);
		panel2.add(panel2d);
		panel2.add(panel2e);
	}
	
	public static void main(String[] args)
	{
		new View();
	}
}
