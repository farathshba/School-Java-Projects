import java.util.Random;

public class Test 
{
	public static void main(String[] args)
	{
		Random randomSeed = new Random();
		int randomChoices = randomSeed.nextInt(9);
		Player playerOne = new Player("Sammy", Weapon.Paper);
		Player playerTwo = new Player("Caludia", Weapon.Paper);
		
		switch(randomChoices)
		{
			case 0:	 playerOne.setWeapon(Weapon.Paper);
					 playerTwo.setWeapon(Weapon.Paper);
					 break;
					 
			case 1:	 playerOne.setWeapon(Weapon.Rock);
					 playerTwo.setWeapon(Weapon.Rock);
			 		 break;
			 
			case 2:	 playerOne.setWeapon(Weapon.Scissors);
					 playerTwo.setWeapon(Weapon.Scissors);
			 		 break;
			 
			case 3:	 playerOne.setWeapon(Weapon.Paper);
					 playerTwo.setWeapon(Weapon.Scissors);
			 		 break;
			 
			case 4:	 playerOne.setWeapon(Weapon.Scissors);
			 		 playerTwo.setWeapon(Weapon.Paper);
			 		 break;
			 
			case 5:	 playerOne.setWeapon(Weapon.Rock);
			 		 playerTwo.setWeapon(Weapon.Scissors);
			 		 break;
			 
			case 6:	 playerOne.setWeapon(Weapon.Scissors);
					 playerTwo.setWeapon(Weapon.Rock);
			 		 break;
			
			case 7:	 playerOne.setWeapon(Weapon.Paper);
			 		 playerTwo.setWeapon(Weapon.Rock);
			 		 break;
			 		 
			case 8:	 playerOne.setWeapon(Weapon.Rock);
	 		 		 playerTwo.setWeapon(Weapon.Paper);
	 		 		 break;
			 		 
			default: break;
		}
		
		playerOne.play(playerTwo);
	}
}
