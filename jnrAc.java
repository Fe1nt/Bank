public class jnrAc extends bankAc{

	public jnrAc(int accNo, String name, String address, String birthDay) {
		super(accNo, name, address, birthDay);
		this.notice=true;
	}

}