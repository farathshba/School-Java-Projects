
public class Main 
{
	//	--------	Main Call method		---------
	public static void main(String[] args)
	{	
		Retriever.prompter(100);		
		//Retriever.sorter();
		Retriever.bubble_sort();
		System.out.println("Your catalog:");
		Retriever.CatalogPrinter();
	}
}
