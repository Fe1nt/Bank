import java.util.ArrayList;
import java.util.Calendar;



public class bank {
	
	ArrayList<bankAc> myList=new ArrayList<bankAc>();

/* Create an account */
public int open(int accNo, String name,  String address,String birthDay,int oLmt,int accKind){
	Calendar c=Calendar.getInstance();
	int year=c.get(Calendar.YEAR);
	int month=c.get(Calendar.MONTH) + 1;
	int date=c.get(Calendar.DATE);
	int yearBirth = Integer.parseInt(birthDay.substring(0,4)); 
	int monthBirth = Integer.parseInt(birthDay.substring(4,6)); 
	int dateBirth= Integer.parseInt(birthDay.substring(6,8)); 
	
	System.out.println("Date of account: "+year+" "+month+" "+date);
	System.out.println("Your birthday: "+yearBirth+" "+monthBirth+" "+dateBirth);
	
	

	
	if(accKind!=1&&accKind!=2&&accKind!=3){
		System.out.println("Error! Invalid account type!");
	}
	else if(year-yearBirth>16&&accKind==2){
		System.out.println("Sorry, your age does not meet the requirements, and you can't open a junior account.");
	}
	else if(year-yearBirth==16&&month>monthBirth&&accKind==2){
		System.out.println("Sorry, your age does not meet the requirements, and you can't open a junior account.");
	}
	else if(year-yearBirth==16&&month==monthBirth&&date>=dateBirth&&accKind==2){
		System.out.println("Sorry, your age does not meet the requirements, and you can't open a junior account.");
	}
	else if(accKind==1){
		savAc ac=new savAc(accNo, name, address, birthDay);
		myList.add(ac);
		System.out.println("You have just opened a saver account! Your PIN is "+ac.getPIN()+". Please remember it.");
	}
	else if(accKind==2){
		jnrAc ac=new jnrAc(accNo, name, address, birthDay);
		myList.add(ac);
		System.out.println("You have just opened a junior account! Your PIN is "+ac.getPIN()+". Please remember it.");
	}
	else if(accKind==3){
		curAc ac=new curAc(accNo, name, address, birthDay,oLmt);
		myList.add(ac);
		System.out.println("You have just opened a current account! Your PIN is "+ac.getPIN()+". Please remember it.");
	}
	return myList.size();
}

/* Close an account */
public void close(bankAc ac){
	if(ac.getBalance()==0.0&&ac.getUnclrMoney()==0.0){
	myList.remove(ac);
	System.out.println("Your account has been closed.");
	}
	else{
		System.out.println("Your account cannot be closed since your balance has not been cleared.");
	}	
}

/* Send the customer's details to a Credit Agency */
public void send(){
	 for(int i = 0;i < myList.size(); i++){
        if(myList.get(i).balance<0){
        	System.out.println("No. " + myList.get(i).accNo + "'s detail has been sent to Credit Agency.");
        }
    }	
}


public void clear(){
	 for(int i = 0;i < myList.size(); i ++){
	        if(myList.get(i).getUnclrMoney()>0){
	        	myList.get(i).setBalance(myList.get(i).getUnclrMoney()+myList.get(i).getBalance());
	        	myList.get(i).setUnclrMoney(0);
	        }
	    }
	 System.out.println("All the uncleared money has been cleared!");
}

/* freeze method */
public void freeze(bankAc ac){
	ac.setUsable(false);
}

/* unfreeze method */
public void unfreeze(bankAc ac){
	ac.setUsable(true);
}
}