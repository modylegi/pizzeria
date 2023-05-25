<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Orders">
  <div class="orders-container">

    <h2 class="sc-1n2d0ov-0 cgxKgX">Пользователи</h2>

    <table class="order-table">
      <thead class="table-thead">
      <tr>
        <th scope="col">ID </th>
        <th scope="col">email</th>
        <th scope="col">password</th>
        <th scope="col">role</th>
        <th scope="col">orders</th>

      </tr>
      </thead>




      <c:forEach var="user" items="${users}">
        <tbody class="table-tbody">
        <tr>

          <td>${user.getId()}</td>
          <td>${user.getEmail()}</td>
          <td>${user.getHashPassword()}</td>
          <td>${user.getRole()}</td>
          <td>
            <a class="btn btn-sm btn-danger" href="UserOrdersByIdServlet?id=${user.getId()}">Заказы</a>
          </td>

        </tr>
        </tbody>
        <div class="clearfix"></div>


      </c:forEach>
    </table>
</t:mainLayout>