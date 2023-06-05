<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>JSP Page</title>
</head>
<body>
                    <div class="container" style="margin-top: 50px;">
                        <div class="row" style="border: 1px darkgrey solid; border-radius: 10px;width: 50%; margin: 0 auto; padding: 20px;" >
                            <div class="col-sm-12">
                                <h3>Login</h3>
                                <form action="/postLogin" method="post">
                                    <div class="form-group">
                                        <label>UserName</label>
                                        <input type="text" class="form-control" name="ma" placeholder="Enter UserName">
                                    </div>
                                    <div class="form-group">
                                        <label>Password:</label>
                                        <input type="password" class="form-control" name="password" placeholder="Enter password">
                                    </div>
                                    <div class="checkbox">
                                        <label><input type="checkbox"> Remember me</label>
                                    </div>
                                    <c:if test="${ not empty errorMessage }">
                                        <div class="alert alert-danger bg-danger">${ errorMessage }</div>
                                    </c:if>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <button type="reset" class="btn btn-primary">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
</body>
</html>


