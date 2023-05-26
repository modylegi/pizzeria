<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<t:mainLayout title="Products">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {


            $('.add-to-cart-btn').click(function () {
                var product = {
                    id:  $(this).val(),
                    // quantity: $("#quantity").val()
                };

                $.ajax({
                    type: "POST",
                    url: "/api/v1/cart",
                    contentType: "application/json",
                    data: JSON.stringify(product),
                    success: function () {
                        alert("Item added to cart!");
                    },
                    error: function () {
                        alert("Error adding item to cart!", this.data);
                    }
                });
            });
        });



    </script>


  
  <h2 class="sc-1n2d0ov-0 cgxKgX">Додо пицца</h2>
    <div>${message}</div>


  <main class="sc-1bt2sgz-2 sc-1n2d0ov-1 cLvPrd ctZmFE">
    <section id="pizzas" class="sc-1n2d0ov-2 bxiXBh">


    <c:forEach var="product" items="${products}">
      <div class="pizza-card">

          <main class="main-info">
            <article data-testid="menu__meta-product_11ED220E823D778CED54FA474E6B6120" class="sc-1tpn8pe-3 fXKtar">
              <main class="sc-1tpn8pe-0 jDJosZ">
              <picture class="sc-1js33uh-0 kAffkg sc-1tpn8pe-4 dMgSaw" data-type="1">
                <img alt="${product.getName()}"  class="img"
                     src="storage/${product.getPathToPhoto()}"
                ></picture>
              <div data-gtm-id="${product.getName()}" class="sc-1tpn8pe-1 jbQjVh">${product.getName()}</div>
                  ${product.getDescription()}
              </main>
              <footer class="sc-1tpn8pe-2 fIPpHH">
                <div class="product-control-price">${product.getPrice()} ₽</div>
<%--                <button data-testid="product__button" type="button" data-type="secondary" data-size="medium" class="sc-1rmt3mq-0 jFZvXc product-control">--%>
                    <sec:authorize access="isAuthenticated()">

                        <sec:authorize access="hasAuthority('ADMIN')">
                    <a href="update-pizza?id=${product.getId()}" >Обновить</a>
                    <a href="DeletePizzaServlet?id=${product.getId()}" >Удалить</a>
                        </sec:authorize>
                        <sec:authorize access="hasAuthority('USER')">
                            <button type="button" class="add-to-cart-btn" id="product-id" value="${product.getId()}">Add to Cart</button>

                        </sec:authorize>
                    </sec:authorize>

<%--                </button>--%>
              </footer>
            </article>

      </div>

    </c:forEach>
    </section>
  </main>


</t:mainLayout>