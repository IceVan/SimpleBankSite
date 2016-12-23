<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>${title}</title>
</head>
<body>
    <jsp:include page="menu.jsp" />


    <h1>Admin transactions</h1>
    <table>
      <c:forEach items="${transactions}" var="transaction">
        <tr>
          <td><c:out value="${transaction.transID}" /></td>
          <td><c:out value="${transaction.user}" /></td>
          <td><c:out value="${transaction.accountAddress}" /></td>
          <td><c:out value="${transaction.amount}" /></td>
          <td><c:out value="${transaction.description}" /></td>
          <td><c:out value="${transaction.status}" /></td>
          <td><a href="${pageContext.request.contextPath}/transactionsAdmin/${transaction.transID}a">Approve</a></td>
          <td><a href="${pageContext.request.contextPath}/transactionsAdmin/${transaction.transID}d">Decline</a></td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>