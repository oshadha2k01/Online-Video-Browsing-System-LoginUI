<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Registration</title>
    <style type="text/css">
        body {
       background: url("image1/jj.jpg");
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            text-align: center;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        form input[type="text"],
        form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        form input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block;
            margin: 10px auto;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error {
            color: #FF0000;
        }
    </style>
</head>
<body>
    <form action="insert" method="post">
        <h2>User Registration</h2>
        FirstName <input type="text" name="fname" placeholder="First Name" required><br>
        LastName <input type="text" name="lname" placeholder="Last Name" required><br>
        UserName <input type="text" name="uname" placeholder="Username" required><br>
        Password <input type="password" name="passw" placeholder="Password" required><br>
        Email    <input type="text" name="email" placeholder="Email" required><br>
        PhoneNo  <input type="text" name="phone" placeholder="Phone Number" required><br>

        <span id="emailError" class="error"></span><br>
        <span id="phoneError" class="error"></span><br>

        <input type="submit" name="submit" value="Register">
    </form>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const form = document.querySelector("form");
            const emailInput = form.querySelector("[name='email']");
            const phoneInput = form.querySelector("[name='phone']");
            const emailError = document.getElementById("emailError");
            const phoneError = document.getElementById("phoneError");

            form.addEventListener("submit", function (event) {
                emailError.textContent = "";
                phoneError.textContent = "";

                if (!isValidEmail(emailInput.value)) {
                    emailError.textContent = "Invalid email format.";
                    event.preventDefault();
                }

                if (!isValidPhoneNumber(phoneInput.value)) {
                    phoneError.textContent = "Invalid phone number. It should be 10 digits.";
                    event.preventDefault();
                }
            });

            function isValidEmail(email) {
                return /\S+@\S+\.\S+/.test(email);
            }

            function isValidPhoneNumber(phone) {
                return /^\d{10}$/.test(phone);
            }
        });
    </script>
</body>
</html>
