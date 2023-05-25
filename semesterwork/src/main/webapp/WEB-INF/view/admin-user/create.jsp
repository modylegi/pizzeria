<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Create pizza">
    <%--    <form>--%>
    <%--        <label for="pizza-name">Pizza name:</label><br>--%>
    <%--        <input type="text" id="pizza-name" name="pizza-name"><br>--%>
    <%--        <label for="pizza-ingredients">Ingridients:</label><br>--%>
    <%--        <input type="text" id="pizza-ingredients" name="pizza-ingredients">--%>
    <%--        <label for="pizza-price">Price:</label><br>--%>
    <%--        <input type="text" id="pizza-price" name="pizza-price">--%>

    <%--    </form>--%>
    <form id="createForm" class="form-horizontal" action="<c:url value="addPizza"/>" method="POST" enctype="multipart/form-data">


        <div class="form-group">
            <label class="control-label col-sm-3" for="pizza-name">Pizza name</label>
            <div class="controls col-sm-9">
                <input id="pizza-name" name="pizza-name" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="pizza-ingredients">Ingredients</label>
            <div class="controls col-sm-9">
                <input id="pizza-ingredients" name="pizza-ingredients" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="pizza-price">Price</label>
            <div class="controls col-sm-9">
                <input id="pizza-price" name="pizza-price" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <input type="file" name="file" />
        </div>
        <button type="submit" class="btn btn-success">Confirm</button>



    </form>


</t:mainLayout>