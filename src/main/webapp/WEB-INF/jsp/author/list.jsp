<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 04/29/2023
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>list of books</title>
    <link rel="stylesheet" href="/bookStore/resources/css/bootstrap.min.css">
</head>
<body>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <jsp:include page="../nav.jsp"/>
    <div class="mt-3">
        <div class="w-75 m-auto">
            <div class="d-grid gap-2 w-25">
                <a class="btn btn-lg btn-primary" href="${context}/authors/create">create author</a>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">name</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authors}" var="author">
                    <tr class="table-light">
                        <th scope="row">${author.id}</th>
                        <td>${author.name}</td>

<%--                        <td>--%>
<%--                            <form action="${context}/books/remove" method="post" class="d-inline">--%>
<%--                                <input type="hidden"  name="id" value="${book.id}"/>--%>
<%--                                <button type="submit" class="btn btn-danger btn-sm">delete</button>--%>
<%--                            </form>--%>
<%--                            <a href="${context}/books/${book.id}/edit" class="btn btn-success btn-sm">update</a>--%>
<%--                        </td>--%>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
