import java.util.ArrayList;


public class SportsClub 
{

	public static void main(String[] args) 
	{
		ArrayList<Member> list = MembersListFileManager.readMembersFromDisk();
		
		//	The ArrayList is been printed out index by index
		for(int count=0; count < list.size(); count++)
		{
			System.out.print(list.get(count).getMemberId() + ". " + list.get(count).getName() + ", " + list.get(count).getAddress() + ", " + list.get(count).getMembershipType() + ", " + list.get(count).getRenewalDate().getTime());
			System.out.println();
		}
	}

}
