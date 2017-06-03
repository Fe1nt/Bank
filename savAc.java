

public class savAc extends bankAc{
	
	public savAc(int accNo, String name, String address, String birthDay) {
		super(accNo, name, address, birthDay);
		this.notice=false;
	}
  
  @Override
	public void withDraw(double money, String pin, boolean notice){
		if(!this.usable){
			System.out.println("Account freezed!");
		   return;
		}
	  if(notice==false){
		  System.out.println("You must give a notice before withdraw!\nWithdraw failed!");
	    return;
	  }
		else if(!pin.equals(PIN)){
	    System.out.println("Invalid PIN!");
	    return;
	  }
		else if(balance-money>=0&&money<=wthdrLimit){
		balance-=money;
		this.notice=false;
		System.out.println("You have successfully withdraw "+money+" yuan!\n"+"Your balance is "+balance+" yuan.");
		return;
		}
		else if(balance-money<0&&money<=wthdrLimit){
			System.out.println("Sorry, your balance is less than your requirement!\nWithdraw failed!");
			
			return;
		}
		else{
			System.out.println("Sorry, you have reached the withdraw limit!\nWithdraw failed!");
			
			return;
		}
	}

}