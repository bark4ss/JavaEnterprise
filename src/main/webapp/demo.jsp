<%@ page import="java.util.Date" %>
<%@ page import="by.teachmeskills.JavaEE.util.djl.ObjectDetection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String header = "Apache Tomcat";
    int a = 5;
    int b = 4;
    Date currentDate = new Date();
    ObjectDetection djl = new ObjectDetection();
%>

<html>
<head>
    <title>Title</title>
</head>

<body>
<jsp:include page="header.jsp"/>
<h1><%=header%></h1>
<h2><%= currentDate%></h2>
<jsp:include page="footer.jsp"/>
</body>
</html>
