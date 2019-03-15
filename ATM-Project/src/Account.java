import java.awt.Panel;

public class Account {
	public String cardnum;
	public String password;
	public double balance;
	String history[]=new String[5];
	int i;
	
	public Account(String cardnum, String password, double balance) {
		this.cardnum = cardnum;
		this.password = password;
		this.balance = balance;
		
	}





	/**public String getCardnum() {
		return cardnum;
	}



	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}*/



	boolean login (String n,String p)
	{
		if (n.equals(cardnum) && p.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	boolean withdraw (double x)
	{
		if (x>balance)
		{
			return false;
		}
		else
		{
			balance = balance - x;
			for(i=3;i>=0;i--)
			{
				history[i+1]=history[i];
			}
			history[0]="you have withdrawn $"+x;
			return true;
		}
		
	}
	
	void deposit (double x)
	{
		balance = balance + x;
		for(i=3;i>=0;i--)
		{
			history[i+1]=history[i];
		}
		history[0]="you have deposit $"+x;
	}
	
	String printbalance (String s)
	{
		s = Double.toString(balance);
		return s;
	}
	
	String next ()
	{
		return history[++i];
	}
	
	String previous ()
	{
		return history[--i];
	}
	
	

}
