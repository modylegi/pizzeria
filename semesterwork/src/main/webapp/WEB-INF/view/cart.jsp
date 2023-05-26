<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
    .table tbody td{
        vertical-align: middle;
    }
    .btn-incre, .btn-decre{
        box-shadow: none;
        font-size: 25px;
    }
    .counter{
        width: 15%;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .btn-danger{
        font-size: 14px;
        font-family: ‘Open Sans’;
        font-weight: 600;
        color: #E44C4C;
        cursor: pointer;
    }
    /*.button-make-order{*/
    /*    margin-top: 5px;*/
    /*    width: 100%;*/
    /*    height: 40px;*/
    /*    border: none;*/
    /*    background: linear-gradient(to bottom right, #c95809, #ee7005);*/
    /*    border-radius: 20px;*/
    /*    cursor: pointer;*/
    /*    font-size: 16px;*/
    /*    font-family: ‘Open Sans’;*/
    /*    font-weight: 600;*/
    /*    color: #ffffff;*/
    /*}*/
    hr{
        width: auto;
        float: right;
        margin-right: 5%;
    }
    .checkout{
        float: right;
        margin-right: 5%;
        width: 100%;
    }
    .total{
        width: 100%;
        display: flex;
        justify-content: space-between;
    }
    .Subtotal{
        font-size: 22px;
        font-family: ‘Open Sans’;
        font-weight: 700;
        color: #202020;
    }
    .items{
        font-size: 16px;
        font-family: ‘Open Sans’;
        font-weight: 500;
        color: #909090;
        line-height: 10px;
    }
    .total-amount{
        font-size: 22px;
        font-family: ‘Open Sans’;
        font-weight: 900;
        color: #202020;
    }
    /*.count{*/
    /*    font-size: 20px;*/
    /*    font-family: ‘Open Sans’;*/
    /*    font-weight: 900;*/
    /*    color: #202020;*/
    /*}*/
    .button-make-order{
        margin-top: 5px;
        width: 100%;
        height: 40px;
        border: none;
        background: rgb(255, 105, 0);
        border-radius: 20px;
        cursor: pointer;
        font-size: 16px;
        font-family: ‘Open Sans’;
        font-weight: 600;
        color: #ffffff;

    }


    /*body{*/
    /*    margin: 0;*/
    /*    padding: 0;*/
    /*    background: linear-gradient(to bottom right, #E3F0FF, #FAFCFF);*/
    /*    height: 100vh;*/
    /*    display: flex;*/
    /*    justify-content: center;*/
    /*    align-items: center;*/
    /*}*/
    .Cart-Container{
        margin-left: auto;
        margin-right: auto;
        width: 70%;
        height: 85%;
        background-color: #ffffff;
        border-radius: 20px;
        box-shadow: 0px 25px 40px #1687d933;
    }
    .order-table{
        margin-left: auto;
        margin-right: auto;


    }
    .table-thead{
        width: 100%;
    }
    .table-tbody{
        width: 100%;
    }
    /*.btn-inc-dec{*/
    /*    width: 40px;*/
    /*    height: 40px;*/
    /*    border-radius: 50%;*/
    /*    background-color: #d9d9d9;*/
    /*    display: flex;*/
    /*    justify-content: center;*/
    /*    align-items: center;*/
    /*    font-size: 20px;*/
    /*    font-family: ‘Open Sans’;*/
    /*    font-weight: 900;*/
    /*    color: #202020;*/
    /*    cursor: pointer;*/
    /*}*/
    /*.counter{*/
    /*    margin-left: auto;*/
    /*    margin-right: auto;*/
    /*}*/
    /*.controls col-sm-9{*/
    /*    font-size: 22px;*/
    /*    font-family: ‘Open Sans’;*/
    /*    font-weight: 700;*/
    /*    color: #202020;*/
    /*}*/


</style>
<t:mainLayout title="Pizza Cart">
    <form id="loginForm" class="form-horizontal" action="/api/v1/order" method="POST">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>






    <div class="Cart-Container">

        <table class="order-table">
            <thead class="table-thead">
            <tr>
                <th scope="col">Название</th>
<%--                <th scope="col">Кол-во</th>--%>
                <th scope="col">Цена</th>
<%--                <th scope="col">Убрать</th>--%>
<%--                <th scope="col">Убрать</th>--%>
            </tr>
            </thead>


            <c:forEach var="product" items="${productCart}">
            <tbody class="table-tbody">
            <tr>
                <td>${product.getName()}</td>
<%--                <td>--%>
<%--                    <div class="counter">--%>
<%--&lt;%&ndash;                        <a class="btn-inc-dec" href="quantityIncDecServlet?action=dec&id=${product.getId()}">-&nbsp&nbsp</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <div class="count"> ${product.getQuantity()} </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <a class="btn-inc-dec" href="quantityIncDecServlet?action=inc&id=${product.getId()}">&nbsp&nbsp+</a>&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                </td>--%>
                <td>${product.getPrice()}</td>
<%--                <td>${product.getTotalSum()}</td>--%>
                <td><a href="/remove-from-cart/${product.getId()}" class="btn btn-sm btn-danger">Убрать</a></td>


            </tr>
            </tbody>
                <div class="clearfix"></div>
            </c:forEach>



        </table>
        <hr>
        <div class="checkout">
            <div class="total">

                <div>

                    <div class="Subtotal">Сумма заказа</div>
                    <div class="items">${totalCount} блюд(а)</div>
                    <label class="address" for="address">Адрес</label>
                    <div class="controls col-sm-9">
                        <input id="address" name="address" class="address" type="text" value=""/>
                    </div>

<%--                    <div class="controls col-sm-9">--%>
<%--                        <input id="address" name="address" class="address" type="text" value=""/>--%>
<%--                    </div>--%>
                </div>
<%--                <div class="H"> </div>--%>
                <div class="total-amount">${totalSum} ₽</div>
            </div>
<%--            <a class="button-make-order" href="<c:url value="create-order"/>" method="POST">Оформить заказ</a>--%>
<%--            <a class="button-make-order" href="/create-order">Оформить заказ</a>--%>
<%--            <button type="submit" class="btn btn-success">Sign up</button>--%>
            <button type="submit" class="button-make-order">Оформить заказ</button>
        </div>
        <hr>
        <div>

        </div>
    </div>
    <script src="<c:url value="/js/index.js"/> "></script>

</t:mainLayout>