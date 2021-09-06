<%@ page import="java.util.Date" %>
<%@ page import="by.teachmeskills.JavaEE.util.djl.ObjectDetection" %>
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
    <link href="res/styles.css" rel="stylesheet">
</head>

<body>
<jsp:include page="header.jsp"/>
<h1><%=header%></h1>
<h1 class="class-red class-border"><%=header%></h1>
<h2><%= currentDate%></h2>
<ol>
    <li>Hello</li>
    <li>back</li>
</ol>
<jsp:include page="footer.jsp"/>
</body>
</html>
