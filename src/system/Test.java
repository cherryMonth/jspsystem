package system;
import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;  
import java.util.Map; 

public class Test {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URLSTR = "jdbc:mysql://120.78.144.47:3306/system";
	private static final String USERNAME = "root";
	private static final String USERPASSWORD = "sj@123456";
	private static final int Map = 0;
	private Connection connnection = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement callableStatement = null; 
	private ResultSet resultSet = null;
	static {  
        try {  
            // 加载数据库驱动程序  
            Class.forName(DRIVER);  
        } catch (ClassNotFoundException e) {  
            System.out.println("加载驱动错误");  
            System.out.println(e.getMessage());  
        }  
    }  
	
	public Connection getConnection() {  
        try {  
            // 获取连接  
            connnection = DriverManager.getConnection(URLSTR, USERNAME,  
                    USERPASSWORD);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return connnection;  
    }
	
	public int executeUpdate(String sql, Object[] params) {  
        // 受影响的行数  
        int affectedLine = 0;  
          
        try {  
            // 获得连接  
            connnection = this.getConnection();  
            // 调用SQL   
            preparedStatement = connnection.prepareStatement(sql);  
              
            // 参数赋值  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // 执行  
            affectedLine = preparedStatement.executeUpdate();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // 释放资源  
            closeAll();  
        }  
        return affectedLine;  
    }
	
	private ResultSet executeQueryRS(String sql, Object[] params) {  
        try {  
            // 获得连接  
            connnection = this.getConnection();  
              
            // 调用SQL  
            preparedStatement = connnection.prepareStatement(sql);  
              
            // 参数赋值  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // 执行  
            resultSet = preparedStatement.executeQuery();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
  
        return resultSet;  
    }  
      
    /** 
     * SQL 查询将查询结果：一行一列 
     * @param sql SQL语句 
     * @param params 参数数组，若没有参数则为null 
     * @return 结果集 
     */  
    public Object executeQuerySingle(String sql, Object[] params) {  
        Object object = null;  
        try {  
            // 获得连接  
            connnection = this.getConnection();  
              
            // 调用SQL  
            preparedStatement = connnection.prepareStatement(sql);  
              
            // 参数赋值  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // 执行  
            resultSet = preparedStatement.executeQuery();  
  
            if(resultSet.next()) {  
                object = resultSet.getObject(1);  
            }  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            closeAll();  
        }  
  
        return object;  
    }  
  
    /** 
     * 获取结果集，并将结果放在List中 
     *  
     * @param sql 
     *            SQL语句 
     * @return List 
     *                       结果集 
     */  
    public List<Object> excuteQuery(String sql, Object[] params) {  
        // 执行SQL获得结果集  
        ResultSet rs = executeQueryRS(sql, params);  
          
        // 创建ResultSetMetaData对象  
        ResultSetMetaData rsmd = null;  
          
        // 结果集列数  
        int columnCount = 0;  
        try {  
            rsmd = rs.getMetaData();  
              
            // 获得结果集列数  
            columnCount = rsmd.getColumnCount();  
        } catch (SQLException e1) {  
            System.out.println(e1.getMessage());  
        }  
  
        // 创建List  
        List<Object> list = new ArrayList<Object>();  
  
        try {  
            // 将ResultSet的结果保存到List中  
            while (rs.next()) {  
                Map<String, Object> map = new HashMap<String, Object>();  
                for (int i = 1; i <= columnCount; i++) {  
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));  
                }  
                list.add(map);  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // 关闭所有资源  
            closeAll();  
        }  
  
        return list;  
    }  
      
    /** 
     * 存储过程带有一个输出参数的方法 
     * @param sql 存储过程语句 
     * @param params 参数数组 
     * @param outParamPos 输出参数位置 
     * @param SqlType 输出参数类型 
     * @return 输出参数的值 
     */  
    public Object excuteQuery(String sql, Object[] params,int outParamPos, int SqlType) {  
        Object object = null;  
        connnection = this.getConnection();  
        try {  
            // 调用存储过程  
            callableStatement = connnection.prepareCall(sql);  
              
            // 给参数赋值  
            if(params != null) {  
                for(int i = 0; i < params.length; i++) {  
                    callableStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // 注册输出参数  
            callableStatement.registerOutParameter(outParamPos, SqlType);  
              
            // 执行  
            callableStatement.execute();  
              
            // 得到输出参数  
            object = callableStatement.getObject(outParamPos);  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // 释放资源  
            closeAll();  
        }  
          
        return object;  
    }  
  
    /** 
     * 关闭所有资源 
     */  
    private void closeAll() {  
        // 关闭结果集对象  
        if (resultSet != null) {  
            try {  
                resultSet.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
  
        // 关闭PreparedStatement对象  
        if (preparedStatement != null) {  
            try {  
                preparedStatement.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
          
        // 关闭CallableStatement 对象  
        if (callableStatement != null) {  
            try {  
                callableStatement.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
  
        // 关闭Connection 对象  
        if (connnection != null) {  
            try {  
                connnection.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }     
    }
    
    public static void main(String[]args) throws SQLException {
    	Test test = new Test();
    	test.getConnection();
    	
    	/*
    	 * 以下测试为测试查询
    	String[] param = new String[1];
    	param[0] = "1";
    	test.executeQueryRS("select * from class where class.class_no=?",param);
    	while(test.resultSet.next()) {
    		String name = test.resultSet.getString("class_no");
    		System.out.println(name);
    		System.out.println(test.resultSet.getString("people_num"));
    		System.out.println(test.resultSet.getString("class_name"));
    	}
    	
    	*/
    	
    	
    	/*
    	 // 以下为测试更新
    	Object [] param = new Object[1];
    	param[0] = "2"; //param[1] = 50; param[2] = "测试更新"; param[3] = "1";
    	int result = test.executeUpdate("delete from class where no = ?", param);
    	System.out.println(result);
    	*/
    	
    	/*
    	Object [] param = new Object[1];
    	param[0]="123";
    	
    	Object result= test.executeQuerySingle("select password from admin where no= ?;",param);
    	System.out.println(result.toString());
   			*/
    	
    	List <Object> list = new Test().excuteQuery("select * from class",null);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = (java.util.Map<String, Object>) list.get(0);
		String [] column = map.keySet().toArray(new String[map.keySet().size()]);
		for(String a: column) {
			System.out.println(a);
		}
		String [][] TableRecord = new String[list.size()][column.length];
		
		for(int i=0;i<list.size();i++) {
			map =  (java.util.Map<String, Object>) list.get(i);
			for(int j=0;j<column.length;j++) {
				TableRecord[i][j] =  map.get(column[j]).toString();
				System.out.println(TableRecord[i][j]);
			}
		}
		
    }
}  
	
