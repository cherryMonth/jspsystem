package system;

public class Tableinfo {
	
	private String [] columnName;  // �������
	private String [][] tableRecord = null; //��ż�¼
	private int pageSize=10;  // ÿҳ��ʾ�ļ�¼��
	private int totalPages=1;  // ��ҳ�����ҳ��
	private int currentPage=1; // ��ǰ��ʾҳ
	
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
