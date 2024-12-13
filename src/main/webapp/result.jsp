<%@ page import="pl.javastart.lottery.LotteryResult" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: joann
  Date: 13.12.2024
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wynik losowania</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <%
        LotteryResult lotteryResult = (LotteryResult) request.getAttribute("result");
        List<Integer> lotteryNumbers = lotteryResult.getLotteryNumbers();
        List<Integer> userNumbers = lotteryResult.getUserNumbers();
        List<Integer> matchedNumbers = lotteryResult.getMatchedNumbers();
        int totalMatches = matchedNumbers.size();
    %>
    <main>
        <h1>Wynik losowania: <%=lotteryNumbers%></h1>
        <h1>Twoje liczby: <%=userNumbers%></h1>
        <h1>Liczba trafień: <%=totalMatches%></h1>
        <h1>Trafione liczby: <%=matchedNumbers%></h1>
    </main>
</body>
</html>
