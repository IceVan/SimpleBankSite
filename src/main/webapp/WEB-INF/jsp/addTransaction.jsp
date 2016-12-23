<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="menu.jsp" />

<form:form method="POST" modelAttribute="transaction" action="${pageContext.request.contextPath}/addTransaction">
   <table>
        <tr>
                <td>Address:</td>
                <td><form:input path="accountAddress" /></td>
        </tr>
        <tr>
                <td>Amount:</td>
                <td><form:input path="amount" /></td>
        </tr>
        <tr>
                <td>Description:</td>
                <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>