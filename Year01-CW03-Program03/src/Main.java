import java.io.*;

public class Main 
{	
	//	--------	Main Call method		---------
	public static void main(String[] args)
	{
		Retriever.prompter(100);
		Retriever.sorter();
		Retriever.print2TextFile("Catalog");
		Retriever.CatalogReader();
	}
}
