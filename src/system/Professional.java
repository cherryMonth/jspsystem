package system;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import system.*;

public class Professional extends Base {
	
	public Professional() {
		super();
	}

	public int add(Object[] params) {
		String sql = "insert into Professional values (?,?,?,?);";
		return this.executeUpdate(sql, params);
		
	}
	
	public int del(String no) {
		Object [] object = new Object[1];
		object[0] = no;
		String sql = "delete from Professional where no = ?;";
		return this.executeUpdate(sql, object);
	}
	
	public int update(Object[]params) {
		String sql = "update Professional set no=?,name=?,faculty_no=? where no=?;";
		return this.executeUpdate(sql, params);
	}
	
	public static void main(String []args) {
		Professional p = new Professional();
		
		Object [] o=new Object[1];
		o[0] = "1";
		String sql = "select * from Faculty where no=?";
		String sql1 = "select name from Faculty where no=?";
		System.out.println(p.executeQuerySingle(sql1, o));
		List<Object> list = p.excuteQuery(sql, o);
		for(int i=0;i<list.size();i++) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map=(Map<String, Object>) list.get(i);
			System.out.println(map.get("name"));
		}
		
		Map<String, Object> map = new HashMap<String, Object>();  
	}
	
}
