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
    <title>create book</title>
    <link rel="stylesheet" href="/bookStore/resources/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="../nav.jsp"/>
        <div class="w-50 m-auto">
            <form:form method="post" action="/bookStore/authors/save" modelAttribute="author">
                <div class="form-group row">
                    <label for="title" class="col-sm-2 col-form-label">name</label>
                    <div class="col-sm-10">
                        <form:input path="name" class="form-control-plaintext" id="title" placeholder="author name ..."/>
                        <form:errors path="name"/>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>

            </form:form>
        </div>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
