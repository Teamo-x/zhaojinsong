package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Contact;
import Entity.News;
import Service.pageService;
import Service.viewMessagesService;


import vo.PageBean;


public class PageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		private int pageNow;//1.当前页
//	    private int pageSize;//2.每页显示几条数据
//	    private int totalCount;//3.共有多少条
//	    private int totalPage;//4.共有几页
//	    private List<T> list=new ArrayList<T>();//5.查询返回的结果集。
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		      //1.获取当前页的值
	            String currentPage=request.getParameter("pageNow");
	           if(currentPage==null){
	        	   currentPage="1";
	           }
	      
	           int pageNow=Integer.parseInt(currentPage);
	           //2.封装PageBean.
	                pageService ps=new pageService();
	                int pageSize=12;
	                PageBean<News> pb =null;
	                        try {
			           pb = ps.findPageBean(pageNow,pageSize);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
	                    	viewMessagesService vs=new viewMessagesService();
	                		List<Contact> q=null;
	                		       try {
	                				q = vs.viewMessages();
	                			} catch (SQLException e) {
	                				// TODO Auto-generated catch block
	                				e.printStackTrace();
	                			}
	                		
	                		if(q!=null){
	                		   
	                			request.setAttribute("viewMessage", q);
	                		
	                			
	                		}
             //3.存放到域中
	                        request.setAttribute("pageBean", pb);
	          //4.请求转发
	                        request.getRequestDispatcher("operation.jsp").forward(request, response);
	            
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
