<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Login</title>
    <style type="text/css">
        body {
        	background: url("image1/jj.jpg");
            font-family: 'Hind', sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .login-container {
            max-width: 300px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 24px;
        }

        form {
            text-align: center;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: inline-block;
            margin-right: 10px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007BFF;
        }

        .error {
            color: #FF0000;
        }

        input[type="button"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: inline-block;
            margin-left: 10px;
        }

        input[type="button"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Login Page</h1>
        <form action="login" method="post">
            <label for="uid">User Name:</label>
            <input type="text" id="uid" name="uid" placeholder="Enter your username" required>
            <br>

            <label for = "pass">Password:</label>
            <input type="password" id="pass" name="pass" placeholder="Enter your password" required>
            <br>

            <div style="text-align: center;">
                <input type="submit" name="submit" value="Login">
                <input type="button" name="register" value="Register" onclick="window.location.href='userinsert.jsp';">
            </div>
        </form>
    </div>
</body>
</html>
