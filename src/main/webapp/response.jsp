<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Upload File Response</title>
</head>
<body>
<%-- Using JSP EL to get message attribute value from request scope --%>
<a href="uploadImagePage.html">Upload Image</a>
<h2>${requestScope.message}</h2>
    <c:forEach var="line" items="${requestScope.lines}" varStatus="loop">
        ${loop.index} : ${line}<br/>
    </c:forEach>
<img src="${pageContext.request.contextPath}/${requestScope.imagePath}" />
</body>
</html>
