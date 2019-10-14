package vo;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
	private int pageNow;//1.当前页
    private int pageSize;//2.每页显示几条数据
    private int totalCount;//3.共有多少条
    private int totalPage;//4.共有几页
    private List<T> list=new ArrayList<T>();//5.查询返回的结果集。
    
	
         public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
		
         
}
