package system;
import system.*;

public class CLass extends Base{
	
	public CLass() {
		super();
		
	}

	public int add(Object[] params) {
		String sql = "insert into class values (?,?,?,?);";
		return this.executeUpdate(sql, params);
		
	}
	
	public int del(String params) {
		Object [] object = new Object[1];
		object[0] = params;
		String sql = "delete from class where no = ?;";
		return this.executeUpdate(sql, object);
	}
	
	public int update(Object[]params) {
		String sql = "update class set no=?,name=?,pro_no=? where no=?;";
		return this.executeUpdate(sql, params); 
	}
	
	public static void main(String [] args) {
			
		CLass c = new CLass();
		Object [] params = new Object[3];
		params[0] = "1";
		params[1] = 30;
		params[2] = "Èí¼þ¹¤³Ì1";
		//params[3] = "2";
		c.add(params);
		
	}
	
}
