<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<% Object message = (String)request.getAttribute("message"); %>
<%--
  Created by IntelliJ IDEA.
  User: Amanite
  Date: 03/10/2016
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:simple_layout title="Coffres">
<jsp:attribute name="body_area">


  <div>
      ${requestScope.message}
  </div>


</jsp:attribute>

</t:simple_layout>


