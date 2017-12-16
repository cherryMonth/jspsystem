package system;
import system.*;

public class Course extends Base{
	
	public Course() {
		super();
	}
	
	public int add(Object[] params) {
		String sql = "insert into course values (?,?,?,?,?);";
		return this.executeUpdate(sql, params);
		
	}
	
	public int del(String no) {
		Object [] object = new Object[1];
		object[0] = no;
		String sql = "delete from course where no = ?;";
		return this.executeUpdate(sql, object);
	}
	
	public int update(Object[]params) {
		String sql = "update course set no=?,name=?,pro_no=?,work_no=?,"
				+ "credit=? where no=?;";
		return this.executeUpdate(sql, params);
	}
	public static void main(String []args) {
		Course f = new Course();
		Object [] o = new Object [8];
		o[0] = "1";
		o[1] = "计算机导论";
		o[2] = 30;
		o[3] = "1";
		o[4] = "软件工程";
		o[5] = "1";
		o[6] = "宋建";
		o[7] = 2.5;
		f.add(o);
	}
}
