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
  <form:form method="post" action="/bookStore/books/update" modelAttribute="book">
    <div class="form-group row">
      <label for="title" class="col-sm-2 col-form-label">title</label>
      <div class="col-sm-10">
        <form:input path="title" class="form-control-plaintext" id="title" placeholder="book name ..."/>
        <form:errors path="title"/>
      </div>
    </div>


    <div class="form-group row">
      <label for="title" class="col-sm-2 col-form-label">price</label>
      <div class="col-sm-10">
        <form:input path="price" class="form-control-plaintext" id="title" placeholder="book price ..."/>
        <form:errors path="price"/>

      </div>
    </div>

    <div class="form-group">
      <label for="author" class="form-label mt-4">Author</label>
      <form:select path="author.id" class="form-select" id="author">
        <c:forEach var="item" items="${authors}">
          <option value="${item.id}" ${item.id eq book.author.id ? 'selected' : ''}>${item.name}</option>
        </c:forEach>
      </form:select>
    </div>

    <form:hidden path="id" value="${book.id}" />

    <button type="submit" class="btn btn-primary">Save</button>

  </form:form>
</div>

<jsp:include page="../footer.jsp"/>
</body>
</html>
