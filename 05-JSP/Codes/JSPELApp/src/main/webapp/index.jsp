
<%
    pageContext.setAttribute("p", "page");
    request.setAttribute("r", "request");
    session.setAttribute("s", "session");
    application.setAttribute("a", "application");

    // Forward to disp.jsp
    pageContext.forward("./disp.jsp");
%>
