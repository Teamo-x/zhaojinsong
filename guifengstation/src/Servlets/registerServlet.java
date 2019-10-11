package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entity.Admin;
import Service.AdminService;

public class registerServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public registerServlet() {
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

	    doPost(request, response);
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		  String agree=request.getParameter("agree");
		  
		  if(agree!=null&&agree.equals("1")){
		         String name=request.getParameter("username");
			        
		          String phone =  request.getParameter("phone");
		          String pass  = request.getParameter("loginpass1");
		          Admin a=new Admin();
		              a.setAdminName(name);
		              a.setAdminPassword(pass);
		              a.setPhoneNumber(phone);
		           if(a!=null){
		        	   AdminService as=new AdminService();
		        	    boolean re = as.regist(a);
		        	    if(re==true){
		        	    	response.getWriter().print("<script language='javascript'>alert('注册成功')</script>");
							  response.setHeader("refresh", "1;URL=AdminLogin.jsp");
		        	    	
		        	    } else{
		        	    	response.getWriter().print("<script language='javascript'>alert('注册失败')</script>");
							  response.setHeader("refresh", "1;URL=AdminLogin.jsp");
		        	    }
		        	    
			  
		  }
	 
	           }else{
	 			  response.getWriter().print("<script language='javascript'>alert('请先同意注册规则')</script>");
				  response.setHeader("refresh", "1;URL=register.jsp");
			  }
          
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
