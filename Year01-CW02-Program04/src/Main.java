
public class Main 
{	
	//	--------	Main Call method		---------
	public static void main(String[] args)
	{		
		String fileName = "Catalog";
		
		Retriever.FileReader(fileName);
		Retriever.ProductSorter();
		Retriever.fileOutputter();
	}
}
