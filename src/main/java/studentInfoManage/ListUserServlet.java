package studentInfoManage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;
import util.DBUtils;

public class ListUserServlet extends HttpServlet{
	public ListUserServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询所有用户信息
//		response.setContentType("text/html;charset=utf-8");
//		
//		PrintWriter out = response.getWriter();
		
		//做Session验证
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			//没有登陆，重定向到登陆页面
			response.sendRedirect("login.jsp");
			return;
		}
		
		try {
			
			UserDao userdao = new UserDao();
			List<User> users = userdao.findAll();
			/**
			 * 因为servlet不便于生成复杂的页面，所以我们通知转发给jsp，由jsp来生成页面		 */
			//1.绑订数据到request上面
			request.setAttribute("users", users);
			//2.获得转发器
			RequestDispatcher  rd = request.getRequestDispatcher("listUser3.jsp");
			//3.转发
			rd.forward(request, response);
			
//			//依据查询到的结果生成表格
//			out.println("<table align='center' border='2'bgcolor='#add8e6' width='60%' cellpadding='0' cellspacing='0'>"); 
//			out.print("<tr><td>ID</td><td>用户名</td><td>密码</td><td>邮箱</td><td>操作</td></tr>");
//			for(User u:users){
//				int id = u.getId();
//				String username = u.getUsername();
//				String password = u.getPassword();
//				String email = u.getEmail();
//				
//				out.println("<tr><td>"+id+"</td><td>"+username+"</td><td>"+
//				      password+"</td><td>"+email+"</td><td><a href='del?id="+id+"'>删除</a></td></tr>");
//			
//			}
//			out.println("</table>"); 
//			//创建一个超链接
//			out.println("<p><a href='stuInfo.html'>添加用户</a></p>");
			 
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			//转发到系统异常处理页面
			//1.绑订数据
			request.setAttribute("error", "系统繁忙，稍后重试！");
			request.getRequestDispatcher("error.jsp")
			 .forward(request, response);
			
		}
		
		
		
		
	}

}
