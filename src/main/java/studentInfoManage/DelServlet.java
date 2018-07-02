package studentInfoManage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;

public class DelServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");

//		User user = new User();
//		int id = user.getId();
		
		UserDao userdao = new UserDao();
		userdao.delete(Integer.parseInt(id));
		response.sendRedirect("list");

	}

}
