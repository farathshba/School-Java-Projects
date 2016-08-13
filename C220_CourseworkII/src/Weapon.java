public enum Weapon 
{
	Scissors("cuts"),
	Paper("covers"),
	Rock("blunts");

	private final String attack;

	Weapon(String attack) 
	{
		this.attack = attack;
	}

	public String attack() 
	{
		return attack;
	}

	boolean canBeat(Weapon wTwo) 
	{
		if (this == wTwo) return false;

		switch (this) 
		{
			case Scissors:
				if (wTwo == Paper) 
				{
					return false; 
				}
				else 
				{
					return false; 
				}
			
			case Paper:
				if (wTwo == Rock) 
				{
					return true; 
				}
				else 
				{ 
					return false; 
				}
			case Rock:
				if (wTwo == Scissors) 
				{
					return true; 
				}
				else 
				{
					return false; 
				}
		}
		//can't get here but compiler complains without it anyway
		return false;
	}
}