<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<nav class="navbar">--%>
<%--    <meta charset="UTF-8">--%>
<%--    <li><a href="<c:url value="/pizzaList"/>">Home</a></li>--%>

<%--    <c:if test="${user != null}">--%>
<%--        <c:if test="${user.getRole() == 'admin'}">--%>
<%--            <li><a href="<c:url value="addPizza"/>">Create pizza</a></li>--%>
<%--            <li><a href="<c:url value="OrdersServlet"/>">Orders</a></li>--%>
<%--            <li><a href="<c:url value="UserDetailsServlet"/>">Users</a></li>--%>
<%--        </c:if>--%>
<%--        <c:if test="${user.getRole() != 'admin'}">--%>
<%--            <li><a href="<c:url value="/cart"/>">Cart</a></li>--%>
<%--            <li><a href="<c:url value="/UserOrders"/>">My Orders</a></li--%>
<%--        </c:if>--%>

<%--        <li><a class="nav-link disabled">${user.getEmail()}</a></li>--%>
<%--        <li><a href="<c:url value="/signOut"/>">Sign Out</a></li>--%>
<%--    </c:if>--%>
<%--    <c:if test="${user == null}">--%>
<%--        <li><a href="<c:url value="/signIn"/>">Sign in</a></li>--%>
<%--        <li><a href="<c:url value="/signUp"/>">Sign Up</a></li>--%>
<%--        <li><a href="<c:url value="/cart"/>">Cart</a></li>--%>
<%--    </c:if>--%>
<%--</nav>--%>


<style type="text/css">
    .hnaHbJ .grid {
        position: relative;
        width: 1280px;
        margin-left: auto;
        margin-right: auto;
    }
    .cGecKl {
        display: inline-block;
        vertical-align: middle;
        overflow: hidden;
        font-size: 0px;
        line-height: 0;
        position: relative;
        width: 52px;
        padding-right: 16px;
        height: 36px;
    }
    .dklXKv {
        white-space: nowrap;
        list-style: none;
        margin: 0px;
        padding: 0px;
        display: inline-block;
        vertical-align: middle;
        transform: translateX(-52px);
        transition: transform 0.25s ease 0s;
    }
    .dQDTpi {
        position: absolute;
        top: 0px;
        right: 0px;
        z-index: 1;
        height: 100%;
    }
    .cxhikF:first-child {
        margin-left: 0px;
    }
    .cxhikF {
        display: inline-block;
        vertical-align: middle;
        margin-left: 20px;
    }
    .cxhikF {
        display: inline-block;
        vertical-align: middle;
        margin-left: 20px;
    }
    .dQDTpi {
        position: absolute;
        top: 0px;
        right: 0px;
        z-index: 1;
        height: 100%;
    }

    .fvOEWC {
        position: absolute;
        right: 0px;
        top: 76px;
    }
    .cpUbDl[data-size="medium"] {
        height: 40px;
        padding: 8px 20px;
        font-size: 16px;
        line-height: 24px;
    }
    .cpUbDl[data-type="primary"] {
        background-color: rgb(255, 105, 0);
        color: rgb(255, 255, 255);
    }
    .ieYvah {
        top: 9px;
        min-width: 90px;
        display: flex;
        -webkit-box-pack: center;
        justify-content: center;
    }


    .cpUbDl {
        outline: none;
        border: none;
        border-radius: 9999px;
        text-align: center;
        font-family: Dodo, system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        font-weight: 500;
        text-decoration: none;
        position: relative;
        overflow: hidden;
        cursor: pointer;
        user-select: none;
        transition-property: background-color, color;
        transition-duration: 200ms;
        transition-timing-function: ease-out;
    }
    button {
        appearance: auto;
        writing-mode: horizontal-tb !important;
        font-style: ;
        font-variant-ligatures: ;
        font-variant-caps: ;
        font-variant-numeric: ;
        font-variant-east-asian: ;
        font-weight: ;
        font-stretch: ;
        font-size: ;
        font-family: ;
        text-rendering: auto;
        color: buttontext;
        letter-spacing: normal;
        word-spacing: normal;
        line-height: normal;
        text-transform: none;
        text-indent: 0px;
        text-shadow: none;
        display: inline-block;
        text-align: center;
        align-items: flex-start;
        cursor: pointer;
        box-sizing: border-box;
        background-color: buttonface;
        margin: 0em;
        padding: 1px 6px;
        border-width: 2px;
        border-style: outset;
        border-color: buttonborder;
        border-image: initial;
    }
    * {
        box-sizing: border-box;
    }

    .add-to-cart-btn {
        /* Font & Text */
        font-family: Dodo, system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        font-size: 16px;
        font-style: normal;
        font-variant: normal;
        font-weight: 500;
        letter-spacing: normal;
        line-height: 24px;
        text-decoration: none solid rgb(209, 87, 0);
        text-align: center;
        text-indent: 0px;
        text-transform: none;
        vertical-align: baseline;
        white-space: normal;
        word-spacing: 0px;

        /* Color & Background */
        background-attachment: scroll;
        background-color: rgb(255, 240, 230);
        background-image: none;
        background-position: 0% 0%;
        background-repeat: repeat;
        color: rgb(209, 87, 0);

        /* Box */
        height: 40px;
        width: 120px;
        border: 0px none rgb(209, 87, 0);
        border-top: 0px none rgb(209, 87, 0);
        border-right: 0px none rgb(209, 87, 0);
        border-bottom: 0px none rgb(209, 87, 0);
        border-left: 0px none rgb(209, 87, 0);
        margin: 0px;
        padding: 8px 20px;
        max-height: none;
        min-height: auto;
        max-width: none;
        min-width: 120px;

        /* Positioning */
        position: relative;
        top: 0px;
        bottom: 0px;
        right: 0px;
        left: 0px;
        float: none;
        display: block;
        clear: none;
        z-index: auto;

        /* List */
        list-style-image: none;
        list-style-type: disc;
        list-style-position: outside;

        /* Table */
        border-collapse: separate;
        border-spacing: 0px 0px;
        caption-side: top;
        empty-cells: show;
        table-layout: auto;

        /* Miscellaneous */
        overflow: hidden;
        cursor: pointer;
        visibility: visible;

        /* Effects */
        transform: none;
        transition: background-color 0.2s ease-out 0s, color 0.2s ease-out 0s;
        outline: rgb(255, 0, 0) dashed 1px;
        outline-offset: 0px;
        box-sizing: border-box;
        resize: none;
        text-shadow: none;
        text-overflow: clip;
        word-wrap: normal;
        box-shadow: none;
        border-top-left-radius: 9999px;
        border-top-right-radius: 9999px;
        border-bottom-left-radius: 9999px;
        border-bottom-right-radius: 9999px;
    }







</style>



<nav class="xlo7eb-7 hnaHbJ">
    <div class="grid">
        <ul class="xlo7eb-1 dklXKv">
            <li class="xlo7eb-2 cxhikF"><a href="/products">Home</a></li>
            <sec:authorize access="!isAuthenticated()">
                <li class="xlo7eb-2 cxhikF"><a href="<c:url value="sign-in"/>">Sign in</a></li>
                <li class="xlo7eb-2 cxhikF"><a href="<c:url value="sign-up"/>">Sign Up</a></li>
<%--                <li class="xlo7eb-2 cxhikF">--%>
<%--                    <a class="nav-link disabled">--%>
<%--                        <span class="hidden-xs" <sec:authentication property="principal.username" />>--%>

<%--                        </span>--%>
<%--                    </a></li>--%>

            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <sec:authorize access="hasAuthority('ADMIN')">
                                <li class="xlo7eb-2 cxhikF"><a href="/management/create-product">Create product</a></li>
                                <li class="xlo7eb-2 cxhikF"><a href="/management/orders">Orders</a></li>
                                <li class="xlo7eb-2 cxhikF"><a href="/management/users">Users</a></li>
                </sec:authorize>
                <li class="xlo7eb-2 cxhikF"><a href="<c:url value="/auth/sign-out"/>">Sign Out</a></li>
                <sec:authorize access="hasAuthority('USER')">
                    <li class="xlo7eb-2 cxhikF"><a href="<c:url value="/UserOrders"/>">My Orders</a></li>
                </sec:authorize>
                <li class="xlo7eb-2 cxhikF"><a><sec:authentication property="principal.username" /></a>
                     

                        </li>

<%--                <li class="xlo7eb-2 cxhikF">--%>
<%--                    <a class="nav-link disabled">--%>
<%--                        <span class="hidden-xs" sec:authentication property="principal.username"></span>--%>
<%--                    </a></li>--%>


            </sec:authorize>

        </ul>
        <div data-testid="navigation__cart" class="xlo7eb-3 dQDTpi">
            <div class="sc-1iu20ya-0 fvOEWC">
                <div></div>
            </div>
            <sec:authorize access="isAuthenticated()">
                <sec:authorize access="hasAuthority('USER')">
                <button type="button" data-type="primary" data-size="medium" class="sc-1rmt3mq-0 cpUbDl xlo7eb-10 ieYvah"><a href="<c:url value="/cart"/>">Cart</a></button>
                </sec:authorize>
            </sec:authorize>
        </div>
    </div>
</nav>