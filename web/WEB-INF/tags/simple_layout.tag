<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@attribute name="body_area" fragment="true" %>

<html>
<head>
    <title>${title}</title>

    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/afficheAgences">Agences</a></li>
        <li><a href="${pageContext.request.contextPath}/mesCoffres">Mes Coffres</a></li>
        <li><a href="/index.jsp">Se connecter</a></li>
    </ul>
</nav>

<section class="container container-fluid">
    <jsp:doBody/>
</section>


</body>
</html>