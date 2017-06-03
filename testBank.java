import java.io.Console;


public class testBank {
	
	
	static bank mybank=new bank();
	
	

	public static void main(String[] args) {  
		testBank simpbank=new testBank();
		
		String c = readDataFromConsole("Choose a function you want:\n1.Open\n2.Withdraw\n3.Pay in\n4.Close\n5.Clear\n6.Notice\n7.Suspend\n8.Re-instate\nYour choice:");  
         
        
        switch(Integer.parseInt(c)) 

		{ 

		case 1: 

			simpbank.new openListener().actionPerformed();

		break; 

		case 2: 

			simpbank.new withdrawListener().actionPerformed();

		break;
		
		case 3: 

			simpbank.new putinListener().actionPerformed();

			break;
			
		case 4: 

			simpbank.new closeListener().actionPerformed();

			break;
			
		case 5: 

			simpbank.new clearListener().actionPerformed();

			break;
		case 6: 

			simpbank.new noticeListener().actionPerformed();

			break;
		case 7: 

			simpbank.new freezeListener();

			break;
		case 8: 

			simpbank.new unfreezeListener();

			break;
			
			
		

		default: 

		System.out.println("Not a right choice"); 

		break; 

		} 
        
        
    } 
	
	private static String readDataFromConsole(String prompt) {  
        Console console = System.console();  
        if (console == null) {  
            throw new IllegalStateException("Console is not available!");  
        }  
        return console.readLine(prompt);  
    }
	
	public int getC(String a){
		int i=Integer.parseInt(a);
		return i;
	}
	

	
	class openListener {
		public void actionPerformed(){
			String name = inputName();
			String address = inputAddress();
			String birthday = inputBirthday();
			int type = inputType();
			int accNo = genAcc();
			int accIndex = mybank.myList.size();
			try{
			mybank.open(accNo,name,address,birthday,1000,type);
			System.out.println("New Account Has Been Opened!"+mybank.myList.get(accIndex).toString()+"\nPlease Remember Your ID And PIN!");
			
			}
			catch(Exception ex){
				System.out.println("Open New Account Failed! You Can Not Open Such Type Of Account!");
				
			}
			for(int i = 0;i < mybank.myList.size(); i ++){
				System.out.println(mybank.myList.get(i).toString());
			}
			
			
		}

	private String inputName(){
		String name = readDataFromConsole("Please Enter Your Name£º");
		while(name.equals("")){
			name = readDataFromConsole("Please Enter Your Name£º");
		} 
		return name;
	}		

	private String inputAddress(){
		String address = readDataFromConsole("Please Enter Your Address£º");
		while(address.equals("")){
			address = readDataFromConsole("Please Enter Your Address£º");
		} 
		return address;
	}		

	private String inputBirthday() {
		String birthday = readDataFromConsole("Please Enter Your Birthday£º");
		while(birthday.length()!=8){
			birthday = readDataFromConsole("Invalid Birthday Format! \nPlease Enter Your Birthday Again \nFormat Example: 19900101£º");
		} 
			
		try{
			Integer.parseInt(birthday);
		} catch (NumberFormatException e) {
			  return inputBirthday();
		}
			   
				double a=Integer.parseInt(birthday.substring(0,4))/4.0;
				double b=Integer.parseInt(birthday.substring(0,4))/400.0;
				String checkYear=""+a;
				String checkYear2=""+b;
				String intYear=""+Math.round(a)+".0";
				String intYear2=""+Math.round(b)+".0";
				
				 boolean more30=(Integer.parseInt(birthday.substring(4,6))!=1&&
							Integer.parseInt(birthday.substring(4,6))!=2&&
							Integer.parseInt(birthday.substring(4,6))!=3&&
							Integer.parseInt(birthday.substring(4,6))!=5&&
							Integer.parseInt(birthday.substring(4,6))!=7&&
							Integer.parseInt(birthday.substring(4,6))!=8&&
							Integer.parseInt(birthday.substring(4,6))!=10&&
							Integer.parseInt(birthday.substring(4,6))!=12
							)&&Integer.parseInt(birthday.substring(6,8))>30;
							boolean checkBig2=checkYear.equals(intYear)&&checkYear2.equals(intYear2)&&birthday.substring(2,4).equals("00")||checkYear.equals(intYear)&&!checkYear2.equals(intYear2)&&!birthday.substring(2,4).equals("00");
							boolean feburaryMore28=Integer.parseInt(birthday.substring(4,6))==2&&!checkBig2&&Integer.parseInt(birthday.substring(6,8))>28;
					boolean feburaryMore29=Integer.parseInt(birthday.substring(4,6))==2&&checkBig2&&Integer.parseInt(birthday.substring(6,8))>29;
					boolean more31=Integer.parseInt(birthday.substring(6,8))>31;
					boolean checkDate=Integer.parseInt(birthday.substring(6,8))<=0;
					boolean checkMonth=Integer.parseInt(birthday.substring(4,6))>13||Integer.parseInt(birthday.substring(4,6))<=0;
					while(more30||feburaryMore28||feburaryMore29||more31||checkMonth||checkDate){
						if(checkBig2){
							System.out.println("111111111");
						}
						return inputBirthday();
					}
				
			 return birthday;
			
		}
		
		private int inputType() {
			String type = readDataFromConsole("Please Enter What Type Of Account You Would Like To Open\n1 For Saver Account \n2 For Junior Account\n3 For Current Account\nYour choice:");
			while(type.length()!=1){
				type = readDataFromConsole("Invalid Type Format! \nPlease Enter The Type Again \n1 For Saver Account \n2 For Junior Account\n3 For Current Account\nYour choice:");
			} 
			
				try {
					Integer.parseInt(type);
				} catch (NumberFormatException e) {
					  return inputType();
				}
				if(Integer.parseInt(type)!=1&&Integer.parseInt(type)!=2&&Integer.parseInt(type)!=3){
					return inputType();
				}
			 	return Integer.parseInt(type);
			
		}
	    
		private int genAcc(){
			String ID=(int)(Math.random()*1000000)+"";
			int accNo=Integer.parseInt(ID);
			for(int i = 0;i < mybank.myList.size(); i ++){
			   if(mybank.myList.get(i).getAcNo()==accNo){
			      ID=(int)(Math.random()*1000000)+"";
						accNo=Integer.parseInt(ID);
			      i=0;
			   }  
			}
			return accNo;
			
		}
	
	
	}
	
    class withdrawListener {
        public void actionPerformed(){
        	String ID = readDataFromConsole("Please Enter Your ID£º");
        	String PIN = readDataFromConsole("Please Enter Your PIN£º");
        	String money = readDataFromConsole("Please Enter How Much You Want to Withdraw£º");
        	int accNo=Integer.parseInt(ID);
        	double amount=Double.parseDouble(money);
        	for(int i = 0;i < mybank.myList.size(); i++){
        		if(mybank.myList.get(i).getAcNo()==accNo&&mybank.myList.get(i).getPIN().equals(PIN)){
        			mybank.myList.get(i).withDraw(amount,PIN,mybank.myList.get(i).isNotice());
        			break;
        		}
        		else if((mybank.myList.get(i).getAcNo()!=accNo||!mybank.myList.get(i).getPIN().equals(PIN))&&i==mybank.myList.size()-1){
        			System.out.println("Invalid ID Or PIN!");
        		}
			    }
        }	
		}
	
    class putinListener{
        public void actionPerformed(){
        	int ID = inputID();
       	 	String money = readDataFromConsole("How Much Do You Want To Save?£º");
        	
        	int choice= (Integer.parseInt(readDataFromConsole("Using cheaque?"))); 
 		    	boolean cheaque;
 		   		if(choice==1)
		    	{
		    		cheaque=true;
		    	}
		    	else{
		    		cheaque=false;
		    	}
        	
        	int amount=Integer.parseInt(money);
        	for(int i = 0;i < mybank.myList.size(); i++){
         		if(mybank.myList.get(i).getAcNo()==ID){
         			mybank.myList.get(i).payIn(amount,cheaque);
         			break;
         		}
        	}
				}
        private int inputID(){
        	String ID = readDataFromConsole("Please Enter Your ID£º");
        	int accNo=Integer.parseInt(ID);
        	for(int i = 0;i < mybank.myList.size(); i++){
         		if(mybank.myList.get(i).getAcNo()==accNo){
         			break;
         		}
         		else if((mybank.myList.get(i).getAcNo()!=accNo)&&(i==mybank.myList.size()-1)){
         		  return inputID();
         		}
         	}
        	return accNo;
        }
}
    class closeListener {
    	 public void actionPerformed(){
         	String ID = readDataFromConsole("Please Enter Your ID£º");
         	String PIN = readDataFromConsole("Please Enter Your PIN£º");
         	int accNo=Integer.parseInt(ID);
         	for(int i = 0;i < mybank.myList.size(); i++){
         		if(mybank.myList.get(i).getAcNo()==accNo&&mybank.myList.get(i).getPIN().equals(PIN)){
         			mybank.close(mybank.myList.get(i));
         			break;
         		}
         		else if(mybank.myList.get(i).getAcNo()!=accNo||!mybank.myList.get(i).getPIN().equals(PIN)&&i==mybank.myList.size()-1){
         			System.out.println("Invalid ID Or PIN!");
         		}
         	}	
 			 }   
    }     	
 		
    class clearListener{
    	public void actionPerformed(){
 				mybank.clear();
 			}
    }
    
    class noticeListener{    	
    	public void actionPerformed(){
    	  String ID = readDataFromConsole("Please Enter Your ID£º");
    	  String PIN = readDataFromConsole("Please Enter Your PIN£º");
    	  int accNo=Integer.parseInt(ID);
    	  for(int i = 0;i < mybank.myList.size(); i++){
    	    if(mybank.myList.get(i).getAcNo()==accNo&&mybank.myList.get(i).getPIN().equals(PIN)){
    	      mybank.myList.get(i).setNotice(true);
    	      break;
    	    }
    	    else if((mybank.myList.get(i).getAcNo()!=accNo||!mybank.myList.get(i).getPIN().equals(PIN))&&i==mybank.myList.size()-1){
    	    	System.out.println("Invalid ID Or PIN!");
    	    }    		
    	  }      		
    	}			    
    }	        	
    			   	
    class freezeListener{
			public void actionPerformed(String arg0) {
				int ID = inputID();
				bankAc acc;
				for(int i=0;i<mybank.myList.size();i++){
					if(mybank.myList.get(i).getAcNo()==ID){
         		acc=mybank.myList.get(i);
         		mybank.freeze(acc);
         		break;
         	}
				}
			}
		
		 	private int inputID(){
        String ID = readDataFromConsole("Please Enter The ID To Susbend£º");
        int accNo=Integer.parseInt(ID);
        for(int i = 0;i < mybank.myList.size(); i++){
         	if(mybank.myList.get(i).getAcNo()==accNo){
         		break;
         	}
         	else if((mybank.myList.get(i).getAcNo()!=accNo)&&(i==mybank.myList.size()-1)){
         		return inputID();
         	}
        }
        return accNo;
      }
    } 
       
    class unfreezeListener {
    	public void actionPerformed(String arg0) {
				int ID = inputID();
				bankAc acc;
				for(int i=0;i<mybank.myList.size();i++){
					if(mybank.myList.get(i).getAcNo()==ID){
         		acc=mybank.myList.get(i);
         		mybank.unfreeze(acc);
         		break;
        	}
				}	
			}
		
		 	private int inputID(){
        String ID = readDataFromConsole("Please Enter The ID To Re-instate£º");
        int accNo=Integer.parseInt(ID);
        for(int i = 0;i < mybank.myList.size(); i++){
         	if(mybank.myList.get(i).getAcNo()==accNo){
         		break;
         	}
         	else if((mybank.myList.get(i).getAcNo()!=accNo)&&(i==mybank.myList.size()-1)){
         		return inputID();
         	}
        }
        return accNo;
      }
    }


}