package Servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Entity.News;
import Service.addNewsService;



public class managementConsulting extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public managementConsulting() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		
		// 上传
		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		  if (isMultipart) {// 判断前台的form是否有Multipart属性
		   FileItemFactory factory = new DiskFileItemFactory();
		   ServletFileUpload upload = new ServletFileUpload(factory);
		   // 通过parseRequest解析form中的所有请求字段，并保存到items集合中（即前台传递的sno、sname、spicture此时就保存在items中）
		   try {
		    List<FileItem> items = upload.parseRequest(request);
		    Iterator<FileItem> iter = items.iterator();
		    News n = new News();
		    while (iter.hasNext()) {
		     FileItem item = iter.next();
		     String itemName = item.getFieldName();

//		     String goodsName = null;
//		     String imgPath = null;
//		     double goodsPrice = 0;
//		     String goodsDescripe = null;
//		     int goodsNum = 0;
//		     String classification = null;
		     String title=null;
		     String content=null;
		     String author=null;
		     String imgPath=null;

		     // 判断前台字段是普通form表单字段，还是文件字段
		     if (item.isFormField()) {
		      if (itemName.equals("title")) {// 根据title属性
		               // 判断item是sno sname
		               // 还是图片
		       title= item.getString("utf-8");
		        n.setTitle(title);
		      } else if (itemName.equals("content")) {
		       content = item.getString("utf-8");
		    
		      n.setContent(content);
		      } else if (itemName.equals("author")) {
			      author = item.getString("utf-8");
				    
				     n.setAuthor(author);
				      }  else {
		       System.out.println("其他东西！");

		      }
              System.out.println(n.getAuthor()+n.getContent()+n.getTitle());
		     } else {// 图片
		       // 文件上传
		       // 文件名 getFileName 是获取普通表单字段的Name值
		       // getName()是获取文件名
		      String fileName = item.getName();
		      // 限制文件类型
		      String ext = fileName.substring(fileName.indexOf(".") + 1);// 文件后缀
		      if (ext.equals("jpg") || ext.equals("png")
		    	        || ext.equals("jpeg")) {

		    	       // 获取文件内容并上传
		    	       // 定义文件路径：指定上传的位置（服务器路径）
		    	       // 获取服务器路径

		    	       String path = "D:/赵劲松/zhaojinsong/guifengstation/WebRoot/NewsImg";

		    	       File file = new File(path, fileName);
		    	     
		    	       File file2 = new File(getServletContext().getRealPath("img"), fileName);
		    	     
		    	       item.write(file);// 上传
		    	     
		    	       item.write(file2);
		    	       //imgPath = "img/" + fileName;
		    	       imgPath = fileName;
		    	 

		    	          n.setImg(imgPath);
		  

		    	      } else {
		    	       response.sendError(888, "文件格式不正确！");
		    	      }

		    	     }

		    	    }
		    
		    //操作时间
			 Date date = new Date();
			 DateFormat df = DateFormat.getDateTimeInstance();
		        SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateTimeInstance();
		       String d = df.format(date);
		        System.out.println("当前日期时间：" + d);
		          n.setTime(d);
		    System.out.println(n.getTitle()+n.getImg()+n.getContent()+n.getAuthor()+n.getTime());
		    	    addNewsService ps = new addNewsService();
		    	  
		    	        int a=0;
		    	            a= ps.add(n); 
		    	      
		    	            
		    	            if(a!=0){
		    	            	  if (a==1) {
		    			    	    	 response.getWriter().print("<script language='javascript'>alert('添加成功')</script>");
		    							  response.setHeader("refresh", "1;URL=operation.jsp");
		    	            	
		    	            }
		    	  
		    	    } else {
		    	     response.sendError(888, "添加不成功！");

		    	    }

		    	   } catch (FileUploadException e) {

		    	    e.printStackTrace();
		    	   } catch (Exception e) {
		    	    // TODO Auto-generated catch block
		    	    e.printStackTrace();
		    	   }

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
