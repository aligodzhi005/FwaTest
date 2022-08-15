<%--
  Created by IntelliJ IDEA.
  User: anato
  Date: 07.08.2022
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/signUpServlet">
        <label>First Name</label>
            <input autocomplete="false" type="text" placeholder="Enter first name" name="firstName"><br />
        <labe>Last Name</labe>
            <input autocomplete="false" type="text" placeholder="Enter last name" name="lastName"><br />
        <label>Email</label>
            <input autocomplete="false" type="text" placeholder="Enter email" name="email"><br />
        <label>Password</label>
            <input autocomplete="false" type="text" placeholder="Enter password" name="password"><br />
        <label>Phone number</label>
            <input autocomplete="false" type="text" placeholder="Enter phone number" name="phoneNumber"><br />

        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
</body>
</html>
