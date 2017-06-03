

public class curAc extends bankAc {
private double oLmt;


public curAc(int accNo, String name, String address, String birthDay, int oLmt) {
	super(accNo, name, address, birthDay);
	this.oLmt=oLmt;
	this.notice=true;
}

@Override
public void withDraw(double money,String pin,boolean b){
	 if(!this.usable){
		 System.out.println("Account freezed!");
	   	return;
	 }
	System.out.println(PIN+" "+pin);
	if(!pin.equals(PIN)){
    	System.out.println("Invalid PIN!");
  }
	else if(balance-money+oLmt>=0&&money<=wthdrLimit){
	balance-=money;
	System.out.println("You have successfully withdraw "+money+" yuan!\n"+"Your balance is "+balance+" yuan.");

	}
	else if(balance-money+oLmt<0&&money<=wthdrLimit){
		System.out.println("Warning! No enough overdraft limit! Withdraw failed!");

	}
	else{
		System.out.println("Sorry, you have reached the withdraw limit!\nWithdraw failed!");
	}
}


@Override
public String toString() {
	return "\nAccount Number=" + accNo +"\nPIN=" + PIN+ "\nOverdraft Limit="+oLmt+"\nName=" + Name + "\nAddress=" + address + "\nBirthDay=" + birthDay+ "\nBalance=" + balance + "\nUncleared Money=" + unclrMoney
			+ "\nWithdraw Limit=" + wthdrLimit;
}

}