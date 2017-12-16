package system;
import system.*;

public class Result extends Base{
	
	public Result() {
		super();
	}
	
	@Override
	public int add(Object[] params) {
		String sql = "insert into result values (?,?,?,?,?,?,?);";
		return this.executeUpdate(sql, params);
	}

	@Override
	public int del(String params) {
		System.out.println("�ɼ����޷�ɾ��!");
		return -1;
	}

	@Override
	public int update(Object[] params) {
		String sql = "update result set course_no=?,course_name=?,work_no=?,"
				+ "student_no=?,student_name=?,teacher_name,result=? where no=?;";
		return this.executeUpdate(sql, params);
	}
	
	public static void main(String []args) {
		Result r = new Result();
		Object [] o = new Object[7];
		o[0] = "1";
		o[1] = "���������";
		o[2] ="1";
		o[3] = "1";
		o[4] = "�ν�";
		o[5] ="�ν�";
		o[6] = 120;
		r.add(o);
	}
	

}
