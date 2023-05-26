<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Orders">
  <style>
    .table-container {
      /*margin-left: 300px;*/
      display: flex;
      justify-content: center;
      /*align-items: center;*/
      /*height: 100vh;*/
    }

    .order-table {
      /* Add any additional styles for your table */
    }
  </style>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $(document).ready(function() {
      // Make an AJAX request to the API
      $.ajax({
        url: "/management/api/orders",
        method: "GET",
        dataType: "json",
        success: function(response) {
          // Handle the response data here
          displayOrders(response);
        },
        error: function(xhr, status, error) {
          console.error(error);
        }
      });

      // Function to display the orders
      function displayOrders(orders) {
        // Access the DOM elements where you want to display the orders
        var ordersContainer = $("#ordersContainer");

        // Loop through the orders and generate HTML to display each order
        orders.forEach(function(order) {
          var orderHtml = "<tr>";
          orderHtml += "<td>" + order.email + "</td>";
          orderHtml += "<td>";

          if (order.orderedProducts && order.orderedProducts.length > 0) {
            orderHtml += order.orderedProducts.map(function(product) {
              return product.name;
            }).join(", ");
          }

          orderHtml += "</td>";
          orderHtml += "<td>" + order.address + "</td>";

          // Calculate the sum of product prices for the order
          var totalPrice = order.orderedProducts.reduce(function(sum, product) {
            return sum + product.price;
          }, 0);
          orderHtml += "<td>" + totalPrice + "</td>";

          orderHtml += "</tr>";

          // Append the order HTML to the container
          ordersContainer.append(orderHtml);
        });
      }
    });
  </script>

  <h2 class="sc-1n2d0ov-0 cgxKgX">Заказы</h2>
  <div class="table-container">

  <table class="order-table">
    <thead class="table-thead">
    <tr>
      <th scope="col">Пользователь</th>
      <th scope="col">Товары</th>
      <th scope="col">Адрес</th>
      <th scope="col">Сумма</th>
    </tr>
    </thead>
    <tbody class="table-tbody" id="ordersContainer">
    </tbody>
  </table>
  </div>
</t:mainLayout>