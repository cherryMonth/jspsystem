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
            // �������ݿ���������  
            Class.forName(DRIVER);  
        } catch (ClassNotFoundException e) {  
            System.out.println("������������");  
            System.out.println(e.getMessage());  
        }  
    }  
	
	public Connection getConnection() {  
        try {  
            // ��ȡ����  
            connnection = DriverManager.getConnection(URLSTR, USERNAME,  
                    USERPASSWORD);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return connnection;  
    }
	
	public int executeUpdate(String sql, Object[] params) {  
        // ��Ӱ�������  
        int affectedLine = 0;  
          
        try {  
            // �������  
            connnection = this.getConnection();  
            // ����SQL   
            preparedStatement = connnection.prepareStatement(sql);  
              
            // ������ֵ  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ִ��  
            affectedLine = preparedStatement.executeUpdate();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // �ͷ���Դ  
            closeAll();  
        }  
        return affectedLine;  
    }
	
	private ResultSet executeQueryRS(String sql, Object[] params) {  
        try {  
            // �������  
            connnection = this.getConnection();  
              
            // ����SQL  
            preparedStatement = connnection.prepareStatement(sql);  
              
            // ������ֵ  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ִ��  
            resultSet = preparedStatement.executeQuery();  
  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
  
        return resultSet;  
    }  
      
    /** 
     * SQL ��ѯ����ѯ�����һ��һ�� 
     * @param sql SQL��� 
     * @param params �������飬��û�в�����Ϊnull 
     * @return ����� 
     */  
    public Object executeQuerySingle(String sql, Object[] params) {  
        Object object = null;  
        try {  
            // �������  
            connnection = this.getConnection();  
              
            // ����SQL  
            preparedStatement = connnection.prepareStatement(sql);  
              
            // ������ֵ  
            if (params != null) {  
                for (int i = 0; i < params.length; i++) {  
                    preparedStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ִ��  
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
     * ��ȡ������������������List�� 
     *  
     * @param sql 
     *            SQL��� 
     * @return List 
     *                       ����� 
     */  
    public List<Object> excuteQuery(String sql, Object[] params) {  
        // ִ��SQL��ý����  
        ResultSet rs = executeQueryRS(sql, params);  
          
        // ����ResultSetMetaData����  
        ResultSetMetaData rsmd = null;  
          
        // ���������  
        int columnCount = 0;  
        try {  
            rsmd = rs.getMetaData();  
              
            // ��ý��������  
            columnCount = rsmd.getColumnCount();  
        } catch (SQLException e1) {  
            System.out.println(e1.getMessage());  
        }  
  
        // ����List  
        List<Object> list = new ArrayList<Object>();  
  
        try {  
            // ��ResultSet�Ľ�����浽List��  
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
            // �ر�������Դ  
            closeAll();  
        }  
  
        return list;  
    }  
      
    /** 
     * �洢���̴���һ����������ķ��� 
     * @param sql �洢������� 
     * @param params �������� 
     * @param outParamPos �������λ�� 
     * @param SqlType ����������� 
     * @return ���������ֵ 
     */  
    public Object excuteQuery(String sql, Object[] params,int outParamPos, int SqlType) {  
        Object object = null;  
        connnection = this.getConnection();  
        try {  
            // ���ô洢����  
            callableStatement = connnection.prepareCall(sql);  
              
            // ��������ֵ  
            if(params != null) {  
                for(int i = 0; i < params.length; i++) {  
                    callableStatement.setObject(i + 1, params[i]);  
                }  
            }  
              
            // ע���������  
            callableStatement.registerOutParameter(outParamPos, SqlType);  
              
            // ִ��  
            callableStatement.execute();  
              
            // �õ��������  
            object = callableStatement.getObject(outParamPos);  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // �ͷ���Դ  
            closeAll();  
        }  
          
        return object;  
    }  
  
    /** 
     * �ر�������Դ 
     */  
    private void closeAll() {  
        // �رս��������  
        if (resultSet != null) {  
            try {  
                resultSet.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
  
        // �ر�PreparedStatement����  
        if (preparedStatement != null) {  
            try {  
                preparedStatement.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
          
        // �ر�CallableStatement ����  
        if (callableStatement != null) {  
            try {  
                callableStatement.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
  
        // �ر�Connection ����  
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
    	 * ���²���Ϊ���Բ�ѯ
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
    	 // ����Ϊ���Ը���
    	Object [] param = new Object[1];
    	param[0] = "2"; //param[1] = 50; param[2] = "���Ը���"; param[3] = "1";
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
	
