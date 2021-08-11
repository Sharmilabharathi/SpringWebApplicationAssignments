<%--
  Created by IntelliJ IDEA.
  User: Sharmila
  Date: 28-07-2021
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Error Page</title>
</head>
<body>
<div id="errorUrl"  modelAttribute="url">
    <h2> ${exception} </h2>
</div>

<div id="exceptionDetails"  modelAttribute="exception">
    <h2> ${exception} </h2>
</div>

</body>
</html>