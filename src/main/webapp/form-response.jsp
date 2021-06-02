<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result</h1>

<h2>Name: ${requestScope.person.name}</h2>
<c:if test="${requestScope.person.flag}">
    <h2>Age: ${requestScope.person.age}</h2>
</c:if>
<h2>Gender: ${requestScope.person.gender}</h2>
<h2>Country: ${requestScope.person.country}</h2>
<ul>
    <c:forEach var="courses" items="${requestScope.person.courses}" varStatus="i">
        <li>${i.index} : <c:out value="${courses}"/> </li>
    </c:forEach>
</ul>
</body>
</html>
