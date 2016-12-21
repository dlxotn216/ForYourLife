<%--
  Created by IntelliJ IDEA.
  User: kim
  Date: 2016-12-01
  Time: 오후 5:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#updateForm").submit(function(){

            var data = {
                "userName": $("#userName").val(),
                "userEmail": $("#userEmail").val(),
                "passwd": $("#passwd").val()
            }
            alert(JSON.stringify(data));
            $.ajax({
                type:"PUT",
                url:"http://localhost:8080/account",
                headers:{
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data),
                success:function(data){
                    console.log("DEBUG check :", data);
                },
                fail: function(e){
                    console.log("DEBUGG error : ", e);
                }
            })

            return false;
        });
    })
</script>
<h2>User Account Update Page</h2>
<form id="updateForm">
    <input type="text" id="userName" name="userName" placeholder="user id" /><br>
    <input type="text" id="passwd" name="passwd" placeholder="user name" /><br>
    <input type="text" id="userEmail" name="userEmail" placeholder="user name" /><br>

    <button id="updateBtn">수정</button>
</form>