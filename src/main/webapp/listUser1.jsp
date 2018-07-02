<%@page import="entity.User"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table{
  margin: 0 auto;
  text-align: center;
}
   .row1{
       background-color: infobackground;
   }
   .row2{
   background-color: menu;
   }
</style>
</head>
<body style="font-size: 20px">
  <table border="1" width="60%" cellpadding="0" cellspacing="0">
     <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>密码</td>
        <td>邮箱</td>
     </tr>
             <% 
               
             List<User> user = new UserDao() .findAll();
             
             for(int i=0;i<user.size();i++){
            	 User u = user.get(i);
            	 %>
            	 <tr class="row<%=i%2+1 %>">
            	   <td ><%=u.getId() %>></td>
            	   <td ><%=u.getUsername() %></td>
            	   <td ><%=u.getPassword() %></td>
            	   <td ><%=u.getEmail() %></td>
            	 </tr>
            	 <% 
             }
             
             %>
  </table>
</body>
</html>