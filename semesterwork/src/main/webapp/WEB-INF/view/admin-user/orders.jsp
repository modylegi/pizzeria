<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Orders">
  <div class="orders-container">

    <h2 class="sc-1n2d0ov-0 cgxKgX">Заказы</h2>

  <table class="order-table">
    <thead class="table-thead">
    <tr>
      <th scope="col">ID заказа</th>
      <th scope="col">ID пользователя</th>
      <th scope="col">Кол-во</th>
      <th scope="col">Пицца</th>
      <th scope="col">Стоимость заказа</th>
      <th scope="col">Дата</th>

        <%--                <th scope="col">Cancel</th>--%>
    </tr>
    </thead>




  <c:forEach var="order" items="${orders}">
    <tbody class="table-tbody">
    <tr>

      <td>${order.getOrderId()}</td>
      <td><a href="GetUserByIdServlet?id=${order.getUserId()}">${order.getUserId()}</a></td>
      <td>${order.getQuantity()}</td>
      <td>${order.getListOfOrderedPizza()}</td>
      <td>${order.getOrderCost()}</td>
      <td>${order.getDateOfOrder()}</td>

    </tr>
    </tbody>
    <div class="clearfix"></div>


  </c:forEach>
  </table>
</t:mainLayout>