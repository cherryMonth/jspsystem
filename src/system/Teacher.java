package system;
import system.*;

public class Teacher extends Base{
	
	public Teacher() {
		super();
	}

	public int add(Object[] params) {
		String sql = "insert into teacher values (?,?,?,?,?);";
		return this.executeUpdate(sql, params);
		
	}
	
	public int del(String no) {
		Object [] object = new Object[1];
		object[0] = no;
		String sql = "delete from teacher where no = ?;";
		return this.executeUpdate(sql, object);
	}
	
	public int update(Object[]params) {
		String sql = "update teacher set no=?,name=?,age=?,password=?,sex=? where no=?;";
		return this.executeUpdate(sql, params);
	}
	
	public static void main(String []args) {
		Teacher t = new Teacher();
		Object [] o=new Object[5];
		o[0] = "1";
		o[1] = "ËÎ½¨";
		o[2] = 20;
		o[3] = "12345678";
		o[4] = "ÄÐ";
		//o[5] = "1";
		
		t.add(o);
	}
	
	
}
