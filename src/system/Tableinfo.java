package system;

public class Tableinfo {
	
	private String [] columnName;  // 存放列名
	private String [][] tableRecord = null; //存放记录
	private int pageSize=10;  // 每页显示的记录数
	private int totalPages=1;  // 分页后的总页数
	private int currentPage=1; // 当前显示页
	
	public void setTableRecord(String [][] s) {
		this.tableRecord=s;
	}
	
	public void setColumnName(String [] s) {
		this.columnName = s;
	}
	
	public void setPageSize(int n) {
		if(n<=0) {
			return;
		}
		this.pageSize=n;
	}
	
	public void settotalPages(int t) {
		if(t<=0)
			return;
		this.totalPages=t;
	}
	
	public void setCurrentPage(int c) {
		if(c<=0)
			return;
		this.currentPage=c;
	}
	
	public String [][] getTableRecord(){
		return this.tableRecord;
	}
	
	public String[] getColumnName() {
		return this.columnName;
	}
	
	public int getPageSize() {
		return this.pageSize;
	}
	
	public int getCurrentPage() {
		return this.currentPage;
	}
	
	public int getTotalPages() {
		return this.totalPages;
	}
}
