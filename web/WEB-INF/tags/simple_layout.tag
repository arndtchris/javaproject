<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@attribute name="body_area" fragment="true" %>

<html>
<head>
    <title>${title}</title>

    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="screen">
</head>
<body>

<nav>
    <ul>
        <li><a>Test</a></li>
        <li><a>Essai</a></li>
        <li><a href="/index.jsp">Se connecter</a></li>
    </ul>
</nav>

<section>
    <jsp:doBody/>
</section>


</body>
</html>