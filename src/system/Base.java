package system;
import system.Test;

public abstract class Base extends Test{
	
	public Base() {
		super.getConnection();
	}
	
	public abstract int add(Object[] params);
	
	public abstract int del(String params);
	
	public abstract int update(Object[]params);

}
