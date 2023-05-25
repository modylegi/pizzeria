<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:mainLayout title="Sign in">
  <div>${message}</div>
  <form id="loginForm" class="form-horizontal" action="<c:url value="api/v1/auth/sign-in"/>" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-3" for="email">E-mail</label>
      <div class="controls col-sm-9">
        <input id="email" name="email" class="form-control" type="text" value=""/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" for="password">Password</label>
      <div class="controls col-sm-9">
        <input id="password" name="password" class="form-control" type="password" value=""/>
      </div>
    </div>
<%--    <div class="form-group">--%>
<%--      <label class="control-label col-sm-3" for="role">Role</label>--%>
<%--      <div class="controls col-sm-9">--%>
<%--        <input id="role" name="role" class="form-control" type="text" value=""/>--%>
<%--      </div>--%>
<%--    </div>--%>
    <button type="submit" class="btn btn-success">Sign in</button>
  </form>
</t:mainLayout>

