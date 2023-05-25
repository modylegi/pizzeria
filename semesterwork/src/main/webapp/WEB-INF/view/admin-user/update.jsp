<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Update pizza">

  <form id="createForm" class="form-horizontal" action="<c:url value="update-pizza"/>" method="POST" enctype="multipart/form-data">


    <div class="form-group">
      <label class="control-label col-sm-3" for="pizza-name">Pizza name</label>
      <div class="controls col-sm-9">
        <input id="pizza-name" name="pizza-name" class="form-control" type="text" value="${oldPizza.getPizza_name()}"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="pizza-ingredients">Ingredients</label>
      <div class="controls col-sm-9">
        <input id="pizza-ingredients" name="pizza-ingredients" class="form-control" type="text" value="${oldPizza.getIngredients()}"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="pizza-price">Price</label>
      <div class="controls col-sm-9">
        <input id="pizza-price" name="pizza-price" class="form-control" type="text" value="${oldPizza.getPrice()}"/>
      </div>
    </div>
    <div class="form-group">
      <input type="file" name="file"  />
    </div>
    <button type="submit" class="btn btn-success">Confirm</button>



  </form>


</t:mainLayout>