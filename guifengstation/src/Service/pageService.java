package Service;


import java.sql.SQLException;
import java.util.List;

import Dao.pageDao;
import Entity.News;

import vo.PageBean;




public class pageService {
    private pageDao pd=new pageDao();
public PageBean<News> findPageBean(int pageNow, int pageSize) throws SQLException {
	// TODO Auto-generated method stub
//	private int pageNow;//1.当前页
//   private int pageSize;//2.每页显示几条数据
//   private int totalCount;//3.共有多少条
//   private int totalPage;//4.共有几页
//   private List<T> list=new ArrayList<T>();//5.查询返回的结果集。
	PageBean<News> pb=new PageBean<News>();
	//封装
	           pb.setPageNow(pageNow);
	           pb.setPageSize(pageSize);
	           //返回有多少条
	           int totalCount = pd.queryTotalCount();
	          pb.setTotalCount(totalCount);
	          //总共分了几页
          int totalPage=(int)Math.ceil(1.0*totalCount/pageSize);
              pb.setTotalPage(totalPage);
               int start=(pageNow-1)*pageSize;
                 List<News> list = pd.queryPartData(start,pageSize);
                 pb.setList(list);
	return pb;
}

}
