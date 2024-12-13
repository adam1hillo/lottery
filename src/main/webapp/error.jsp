<%--
  Created by IntelliJ IDEA.
  User: joann
  Date: 13.12.2024
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błąd</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <main>
        <h1><%= request.getAttribute("message")%></h1>
    </main>

</body>
</html>
