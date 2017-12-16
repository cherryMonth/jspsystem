package system;
import system.*;

public class Faculty extends Base{
	public Faculty() {
		super();
	}

	public int add(Object[] params) {
		String sql = "insert into Faculty values (?,?,?);";
		return this.executeUpdate(sql, params);
		
	}
	
	public int del(String params) {
		Object [] object = new Object[1];
		object[0] = params;
		String sql = "delete from Faculty where no = ?;";
		return this.executeUpdate(sql, object);
	}
	
	public int update(Object[]params) {
		String sql = "update Faculty set no=?,name=?,dean=? where no=?;";
		return this.executeUpdate(sql, params); 
	}
	
	public static void main(String []args) {
		Faculty f = new Faculty();
		Object [] o = new Object [3];
		o[0] = "1";
		o[1] = "信息科学";
		o[2] = "宋健";
		f.add(o);
	}
}
