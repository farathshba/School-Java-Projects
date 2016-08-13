
public class Menu 
{
	//	Main method to start the threads which contains the Alice, Bob and Charlie window frames
	public static void main(String[] args)
	{
		Alice tx = new Alice();
		Bob rx = new Bob();
		Charlie inter = new Charlie();
		
		//	Creation of threads and running Alice, Bob and Charlie as indivudual threads
		Thread threadTwo = new Thread(tx);
		threadTwo.start();
		
		Thread threadOne = new Thread(rx);
		threadOne.start();
		
		Thread threadThree = new Thread(inter);
		threadThree.start();
	}
}
