<%--
  Created by IntelliJ IDEA.
  User: anato
  Date: 07.08.2022
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/signInServlet">
        <label>Email</label>
            <input autocomplete="false" type="text" placeholder="Enter email" name="email"><br />
        <label>Password</label>
            <input autocomplete="false" type="text" placeholder="Enter password" name="password"><br />
    <div>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>
