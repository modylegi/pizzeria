<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Sign up">
    <div>${message}</div>
    <form id="loginForm" class="form-horizontal" action="<c:url value="api/v1/auth/sign-up"/>" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-3" for="firstName">Имя</label>
            <div class="controls col-sm-9">
                <input id="firstName" name="firstName" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="lastName">Фамилия</label>
            <div class="controls col-sm-9">
                <input id="lastName" name="lastName" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="age">Возраст</label>
            <div class="controls col-sm-9">
                <input id="age" name="age" class="form-control" type="number" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="email">Email</label>
            <div class="controls col-sm-9">
                <input id="email" name="email" class="form-control" type="email" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="password">Password</label>
            <div class="controls col-sm-9">
                <input id="password" name="password" class="form-control" type="password" value=""/>
            </div>
        </div>

        <button type="submit" class="btn btn-success">Sign up</button>
    </form>
</t:mainLayout>