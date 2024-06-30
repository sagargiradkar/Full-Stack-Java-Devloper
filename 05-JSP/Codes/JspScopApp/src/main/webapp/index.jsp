<% 
	pageContext.setAttribute("p", "page");
	request.setAttribute("r", "request");
	session.setAttribute("s", "session");
	application.setAttribute("a", "application");

	pageContext.forward("./disp.jsp");

%>