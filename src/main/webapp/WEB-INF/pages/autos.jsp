<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Autos Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #303030;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #333;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1 style="margin-left: 150px">Auto List</h1>

<c:if test="${!empty listAutos}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Color</th>
            <th width="120">Power</th>
            <th width="100">Weight</th>
            <th width="100">Price</th>
            <th width="100">Edit</th>
            <th width="100">Delete</th>
        </tr>
        <c:forEach items="${listAutos}" var="auto">
        <tr>
            <td>${auto.id}</td>
            <td>${auto.name}</td>
            <td>${auto.color}</td>
            <td>${auto.power}</td>
            <td>${auto.weight}</td>
            <td>${auto.price}</td>
            <td><a href="<c:url value='/editauto/${auto.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/removeauto/${auto.id}'/>">Delete</a></td>
            </c:forEach>
    </table>
</c:if>

<h1 style="margin-left: 70px">Add a Auto in Table</h1>

<c:url var="addAction" value="/autos/add"/>

<form:form action="${addAction}" commandName="auto">
    <table>
        <c:if test="${!empty auto.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="color">
                    <spring:message text="Color"/>
                </form:label>
            </td>
            <td>
                <form:input path="color"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="power">
                    <spring:message text="Power"/>
                </form:label>
            </td>
            <td>
                <form:input path="power"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="weight">
                    <spring:message text="Weight"/>
                </form:label>
            </td>
            <td>
                <form:input path="weight"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr style="margin-left: 50px">
            <td colspan="2">
                <c:if test="${empty auto.name}">
                    <input type="submit"
                           value="<spring:message text="Add auto"/>"/>
                </c:if>
                <c:if test="${!empty auto.name}">
                    <input type="submit"
                           value="<spring:message text="Edit auto"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<c:url var="addAction2" value="/refreshtable"/>

<form:form action="${addAction2}">
    <table>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Refresh"/>"/>
            </td>
        </tr>
    </table>

</form:form>

</body>
</html>
