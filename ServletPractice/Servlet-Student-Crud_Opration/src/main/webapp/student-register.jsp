<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Registration Form</title>
<link rel="stylesheet" href="styles.css"> <!-- Link to the External CSS file -->
<style type="text/css">
/* No styles here since they are moved to styles.css */
</style>
</head>
<body>

<form action="submit" method="get" class="blur-effect">
<h2>Student Registration Form</h2>
 <!-- Added class for blur effect -->
 <label for="f">Id</label> <input type="text" placeholder="Enter Student Id" id="f" name="id"> 
    <label for="f1">Name</label> <input type="text" placeholder="Enter Student Name" id="f1" name="name"> 
    <label for="f2">Email</label> <input type="email" placeholder="Enter Student Email" id="f2" name="email"> 
    <label for="f3">Password</label> <input type="password" placeholder="Enter password No" id="f3" name="password"> 
    <label for="f4">Phone</label> <input type="tel" placeholder="Enter Student phone No" id="f4" name="phone">

    <!-- Degree, Branch, and Gender in row -->
    <div class="flex-container">
        <div class="radio-container">
            <label>Degree</label> 
            <input type="radio" name="degree" value="B.tech"> B.tech 
            <input type="radio" name="degree" value="BCA"> BCA 
            <input type="radio" name="degree" value="Others"> Others
        </div>
        <div class="radio-container">
            <label>Branch</label> 
            <input type="radio" name="branch" value="CS"> CS 
            <input type="radio" name="branch" value="Non-CS"> Non-CS 
            <input type="radio" name="branch" value="Others"> Others
        </div>
        <div class="radio-container">
            <label>Gender</label> 
            <input type="radio" name="gender" value="M"> Male 
            <input type="radio" name="gender" value="F"> Female 
            <input type="radio" name="gender" value="O"> Others
        </div>
    </div>

    <input type="submit" name="submit" value="Submit Here">
</form>
</body>
</html>
