package system;
import system.*;

public class Student extends Base{
	
	public Student() {
		
	}
	
	public int add(Object[] params) {
		String sql = "insert into student values (?,?,?,?,?,?,?,?,?,?);";
		return this.executeUpdate(sql, params);
		
	}
	
	public int del(String params) {
		Object [] object = new Object[1];
		object[0] = params;
		String sql = "delete from student where no = ?;";
		return this.executeUpdate(sql, object);
	}
	
	public int update(Object[]params) {
		String sql = "update student set no=?,name=?,sex=?,password=?,"
				+ "birthday=?, age=?,Pro_No=?,Grade=?,Total_Credits=?"
				+ ",class_no=? where no=?;";
		return this.executeUpdate(sql, params); 
		
	}

	public static void main(String[]args) {
		
		Student s = new Student();
		Object [] o = new Object[12];
		o[0] = "1";
		o[1] = "宋建";
		o[2] = "男";
		o[3] = "123456";
		o[4] = "1997-9-16";
		o[5] = 20;
		o[6] = "1";
		o[7] = "软件工程";
		o[8] = 3;
		o[9] = 80;
		o[10] = "1";
		o[11] = "软件工程1";
		s.add(o);
		
	}
	
	
}
