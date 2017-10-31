<%--@elvariable id="error" type="java.util.List"--%>
<html>
<head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <style type="text/css">
        .form-error-message{
            background-color: #F0574E;
            color: white;
            font-size: 1.2em;
            margin-bottom: 2px;
        }
    </style>
</head>
<body>
<div style="width: 1000px; margin: 0 auto">
    <h2>Jave EE Validation</h2>
    <c:forEach items="${requestScope.get('errors')}" var="error">
        <div class="form-error-message">
                ${error}
        </div>
    </c:forEach>
    <form action="/example-improved" method="post">
        First name : <input type="text" name="firstName"/><br/>
        Last name :  <input type="text" name="lastName"/></br>
        <input type="submit" name="submit" value="Submit"></form>
    </form>
</div>
</body>
</html>
