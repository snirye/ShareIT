<%@page import="model.Users"%>
<p>You are successfully logged in!</p>  
<%  
String bean=(String)request.getAttribute("name");  
out.print("Welcome, "+bean +"<br>");
model.Users u=(model.Users)session.getAttribute("user");
out.print("sesstion adress: "+u.getMail()+"<br>");
out.print("sesstion adress: "+u.getPhone()+"<br>");

if(request.getAttribute("good").equals("yes")) {
	out.print("some secret content of user");
	
} else {
	out.print("you are cant see this!");
}
%>  