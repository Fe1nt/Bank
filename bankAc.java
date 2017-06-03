

public class bankAc {
	
protected int accNo;
protected String Name;
protected double balance;
protected double unclrMoney;
protected double wthdrLimit;
protected String address;
protected String birthDay;
protected String PIN;
protected boolean notice;
protected boolean usable;


public void payIn(double money,boolean cheaque){
	if(!this.usable){
		System.out.println("Account freezed!");
		return;
	}
	if(cheaque==false){
		balance+=money;
		System.out.println("You have just credit "+money+" yuan, your balance is "+balance+" yuan.");
		System.out.println("You have successfully saved "+money+" yuan\nYour balance is "+balance+" yuan\nThere is no money uncleared in your account.");
	}
	else{
		unclrMoney+=money;
		System.out.println("Your balance is "+balance+" yuan\nThere is "+unclrMoney+" yuan uncleared in your account, it will be credited to your account soon");
	}
}

public void withDraw(double money,String pin,boolean notice){
  if(!this.usable){
	  System.out.println("Account freezed!");
    return;
  }
	if(!pin.equals(PIN)){
    System.out.println("Invalid PIN!");
  }
	else if(balance-money>=0&&money<=wthdrLimit){
		balance-=money;
		System.out.println("You have successfully withdraw "+money+" yuan!\n"+"Your balance now is "+balance);
	}
	else if(balance-money<0&&money<=wthdrLimit){

		System.out.println("Sorry, your balance is less than you want!\nWithdraw failed!");
	}
	else{
		
		System.out.println("Sorry, you have reach the withdraw limit!\nWithdraw failed!");
	}
}

public int getAcNo() {
	return accNo;
}

public void setAcNo(int accNo) {
	this.accNo = accNo;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public double getUnclrMoney() {
	return unclrMoney;
}

public void setUnclrMoney(double unclrMoney) {
	this.unclrMoney = unclrMoney;
}

public double getWthdrLimit() {
	return wthdrLimit;
}

public void setWthdrLimit(double wthdrLimit) {
	this.wthdrLimit = wthdrLimit;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getBirthDay() {
	return birthDay;
}

public void setBirthDay(String birthDay) {
	this.birthDay = birthDay;
}

public String getPIN() {
	return PIN;
}

public void setPIN(String pIN) {
	PIN = pIN;
}


public boolean isNotice() {
	return notice;
}

public void setNotice(boolean notice) {
	this.notice = notice;
	System.out.println("You have successfully given a notice!");
}

public bankAc(int accNo,String name,String address,String birthDay) {
	super();
	this.accNo = accNo;
	Name = name;
	this.balance = 0;
	this.unclrMoney = 0;
	this.wthdrLimit = 50000;
	this.address = address;
	this.birthDay = birthDay;
	this.usable = true;
	this.PIN = (int)(Math.random()*1000000)+"";
}

@Override
public String toString() {
	return "\nAccount Number=" + accNo +"\nPIN=" + PIN+ "\nName=" + Name + "\nAddress=" + address + "\nBirthDay=" + birthDay+ "\nBalance=" + balance + "\nUncleared Money=" + unclrMoney
			+ "\nWithdraw Limit=" + wthdrLimit;
}

public boolean isUsable() {
	return usable;
}

public void setUsable(boolean usable) {
	this.usable = usable;
	if(this.usable){
		System.out.println("Your account is re-instated!");
	}
	else{
		System.out.println("Your account is suspended!");
	}
}

}