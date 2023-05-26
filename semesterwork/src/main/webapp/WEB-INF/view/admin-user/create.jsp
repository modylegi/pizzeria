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
    <form id="createForm" class="form-horizontal" action="<c:url value="api/create-product"/>" method="POST" enctype="multipart/form-data">


        <div class="form-group">
            <label class="control-label col-sm-3" for="name">Pizza name</label>
            <div class="controls col-sm-9">
                <input id="name" name="name" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="description">Ingredients</label>
            <div class="controls col-sm-9">
                <input id="description" name="description" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="price">Price</label>
            <div class="controls col-sm-9">
                <input id="price" name="price" class="form-control" type="number" value=""/>
            </div>
        </div>
        <div class="form-group">
<%--            <input type="file" name="pathToPhoto" />--%>
            <input type="file" name="image" accept="image/*" class="form-control-file">
        </div>
        <button type="submit" class="btn btn-success">Confirm</button>



    </form>


</t:mainLayout>