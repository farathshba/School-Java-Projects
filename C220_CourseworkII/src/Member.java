import java.io.Serializable;
import java.util.Calendar;


public class Member implements Serializable 
{

	private static final long serialVersionUID = 2555376110266661816L;

	private int memberId;
	private MembershipType membershipType;
	private String name;
	private String address;
	private Calendar renewalDate;
	
	public Member(int id, String name, String address, MembershipType membershipType, Calendar accountExpires) 
	{
		memberId = id;
		this.name = name;
		this.address = address;
		this.membershipType = membershipType;
		renewalDate = accountExpires;
	}

	//memberId only has a getter, no setter. Ids shouldn't change
	public int getMemberId() 
	{
		return memberId;
	}

	public MembershipType getMembershipType() 
	{
		return membershipType;
	}

	public void setMembershipType(MembershipType membershipType) 
	{
		this.membershipType = membershipType;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public Calendar getRenewalDate() 
	{
		return renewalDate;
	}

	public void setRenewalDate(Calendar renewalDate) 
	{
		this.renewalDate = renewalDate;
	}
}
