/* rock paper scissors

1  Scissors cuts paper - scissors win
2  Paper covers rock - paper wins
3  Rock blunts scissors - rock wins

*/

public class Player
{
	private String name;
	private Weapon weapon;

	private final String printfString = "%s's %s %s %s's %s: %s %s %n";

	public Player (String name, Weapon weapon)
	{
		this.name = name;
		this.weapon = weapon;
	}

	public String getName()
	{
		return name;
	}

	public void setName (String newName)
	{
		name = newName;
	}


	public Weapon getWeapon()
	{
		return weapon;
	}

	public void setWeapon (Weapon newWeapon)
	{
		weapon = newWeapon;
	}

	public void play(Player playerTwo) 
	{
		Weapon weapTwo = playerTwo.getWeapon();

		if (weapTwo == weapon) 
		{
			draw();
		}
		else 
		{
			boolean win = weapon.canBeat(weapTwo);

			if (win) 
			{
				winner(weapTwo, playerTwo.getName());
			}
			else 
			{
				loser(weapTwo, playerTwo.getName());
			}
		}
	}

	private void draw() 
	{
		System.out.println(weapon + " vs. " + weapon + ": it's a draw");
	}

	private void winner(Weapon weaponTwo, String namePlayerTwo) 
	{
		System.out.printf(printfString, name, weapon, weapon.attack(), namePlayerTwo, weaponTwo, name, "wins");
	}

	private void loser(Weapon weaponTwo, String namePlayerTwo) 
	{
		System.out.printf(printfString, namePlayerTwo, weaponTwo, weaponTwo.attack(), name, weapon, name, "loses");
	}

}