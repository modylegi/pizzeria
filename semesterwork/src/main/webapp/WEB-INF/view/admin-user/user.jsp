<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Orders">
    <div class="orders-container">

        <h2 class="sc-1n2d0ov-0 cgxKgX">Пользователь</h2>

        <table class="order-table">
            <thead class="table-thead">
            <tr>
                <th scope="col">ID пользователя</th>
                <th scope="col">email</th>
                <th scope="col">password</th>


                    <%--                <th scope="col">Cancel</th>--%>
            </tr>
            </thead>




<%--            <c:forEach var="order" items="${orders}">--%>
                <tbody class="table-tbody">
                <tr>

                    <td>${userInfo.getId()}</td>
                    <td>${userInfo.getEmail()}</td>
                    <td>${userInfo.getHashPassword()}</td>


                </tr>
                </tbody>
                <div class="clearfix"></div>


<%--            </c:forEach>--%>
        </table>
</t:mainLayout>