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
    <section>
        <h1>${title}</h1>
        <jsp:invoke fragment="body_area"/>
    </section>
</body>
</html>