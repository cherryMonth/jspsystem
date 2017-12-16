package system;
import system.*;

public class Admin extends Base{
	
	public Admin() {
		super();
	}
	
	@Override
	public int add(Object[] params) {
		System.out.println("管理员无法被添加!");
		return -1;
	}

	@Override
	public int del(String params) {
		System.out.println("管理员无法被删除!");
		return -1;
	}

	@Override
	public int update(Object[] params) {
		String sql = "update admin set no=?,password=? where no=?;";
		return this.executeUpdate(sql, params); 
	}
	
	public static void main(String [] args) {
		
		Admin c = new Admin();
		Object [] params = new Object[2];
		params[0] = "123";
		params[1] = "1234";
		//params[2] = "123";
		c.add(params);
		
	}

}
