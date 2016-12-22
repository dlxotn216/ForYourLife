<%--
  Created by IntelliJ IDEA.
  User: dlxot
  Date: 2016-12-22
  Time: 오후 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#backBtn").click(function () {
            window.history.back();
        })
    })
</script>

<div class="container">
    <h2>로그인</h2>
    <form id="authenticationForm" action="/authenticationProcess" method="POST">
        <div class="form-group">
            <input type="text" name="userId"  class="form-control" placeholder="Enter Your Account" required/>
            <input type="password" name="passwd" class="form-control" placeholder="Enter Your Password" required/>
        </div>

        <div class="form-group">
            <p>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
            <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION" />       <!-- 새로고침시 취소하도록(error=true 파라미터 필요 없어짐) -->
        </div>
        <br>
        <div class="btn-group btn-group-justified">
            <div class="btn-group">
                <input type="submit"  class="btn btn-primary"value="가입" />
            </div>
            <div class="btn-group">
                <input id="backBtn" type="button"  class="btn btn-default"value="뒤로" />
            </div>
        </div>
    </form>
</div>
