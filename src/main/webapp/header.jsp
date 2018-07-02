<%@page import="java.util.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head></head>
 <body>
 <div id="header">
					<div id="rightheader">
						<p>
							<%=new SimpleDateFormat("YYYY/MM/dd").format(new Date()) %>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
 </body>
</html>