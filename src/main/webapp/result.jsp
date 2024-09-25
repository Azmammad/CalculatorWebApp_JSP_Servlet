<%--
  Created by IntelliJ IDEA.
  User: Venera
  Date: 9/25/2024
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Result</title>
</head>
<body>
    <div align="center">
        <h1>Calculation Result:</h1>
        <c:if test="${not empty error}">
            <h3 style="color:red">${error}</h3>
        </c:if>
        <c:if test="${empty error}">
            <h3>Result of ${a} ${operationSymbol} ${b} is ${result}</h3>
        </c:if>
        <h2>Calculation History:</h2>
        <ul>
            <c:forEach var="calculation" items="${sessionScope.history}">
                <li>${calculation}</li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
