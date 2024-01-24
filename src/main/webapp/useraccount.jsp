<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Account</title>
    <style type="text/css">
        body {
         background: url("image1/jj.jpg");
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .header {
            font-size: 28px;
            font-weight: bold;
        }

        table {
            border-collapse: collapse;
            width: 60%;
            margin: 20px auto;
            border: 3px solid black; 
        }

        th, td {
            border: 3px solid black; 
            padding: 8px;
        }

        a {
            text-decoration: none;
        }

        .user-actions {
            margin: 20px auto;
        }

        .user-actions input[name="update"] {
            background-color: #007BFF;
            color: #fff;
        }

        .user-actions input[name="delete"] {
            background-color: #FF0000;
            color: #fff;
        }

        .user-actions input[type="button"] {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        .user-actions input[type="button"]:hover {
            opacity: 0.8;
        }
    </style>
</head>

<body>
    <div class="header">User Profile</div>
    <table>
        <c:forEach var="us" items="${usDetails}">

        <c:set var="id" value="${us.uID}"/>
        <c:set var="fname" value="${us.uFirstName}"/>
        <c:set var="lname" value="${us.uLastName}"/>
        <c:set var="username" value="${us.uName}"/>
        <c:set var="password" value="${us.uPass}"/>
        <c:set var="email" value="${us.uEmail}"/>
        <c:set var="phone" value="${us.uPhoneNo}"/>

            <tr>
                <th>User ID</th>
                <td>${us.uID}</td>
            </tr>
            <tr>
                <th>First Name</th>
                <td>${us.uFirstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${us.uLastName}</td>
            </tr>
            <tr>
                <th>User Name</th>
                <td>${us.uName}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>${us.uPass}</td>
            </tr>
            <tr>
                <th>User Email</th>
                <td>${us.uEmail}</td>
            </tr>
            <tr>
                <th>PhoneNumber</th>
                <td>${us.uPhoneNo}</td>
            </tr>
        </c:forEach>
    </table>

    <div class="user-actions">
        <c:url value="updateuser.jsp" var="usupdate">
            <c:param name="id" value="${id}" />
            <c:param name="fname" value="${fname}" />
            <c:param name="lname" value="${lname}" />
            <c:param name="uname" value="${username}" />
            <c:param name="pass" value="${password}" />
            <c:param name="email" value="${email}" />
            <c:param name="phone" value="${phone}" />
        </c:url>
        <a href="${usupdate}">
            <input type="button" name="update" value="Update User Account">
        </a>
        <br>

        <c:url value="deleteuser.jsp" var="usdelete">
            <c:param name="id" value="${id}" />
            <c:param name="fname" value="${fname}" />
            <c:param name="lname" value="${lname}" />
            <c:param name="uname" value="${username}" />
            <c:param name="pass" value="${password}" />
            <c:param name="email" value="${email}" />
            <c:param name="phone" value="${phone}" />
        </c:url>
        <a href="${usdelete}">
            <input type="button" name="delete" value="Delete User Account">
        </a>
    </div>
</body>

</html>
