<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Employee Registration</title>

<style>

body {
    font-family: Arial;
    margin: 50px;
}

table {
    width: 400px;
}

input {
    width: 100%;
    padding: 8px;
}

</style>

</head>

<body>

<h2>Employee Registration Form</h2>

<form action="employee" method="post">

<table>

<tr>
<td>Employee ID</td>
<td>
<input type="text"
name="empId"
required>
</td>
</tr>

<tr>
<td>Employee Name</td>
<td>
<input type="text"
name="empName"
required>
</td>
</tr>

<tr>
<td>Department</td>
<td>
<input type="text"
name="empDept"
required>
</td>
</tr>

<tr>
<td colspan="2">
<input type="submit"
value="Register Employee">
</td>
</tr>

</table>

</form>

</body>

</html>