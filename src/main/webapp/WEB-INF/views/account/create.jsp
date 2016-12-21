<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#createForm").submit(function(){

            var data = {
                "userId": $("input[name=userId]").val(),
                "userName": $("input[name=userName]").val(),
                "userEmail": $("input[name=userEmail]").val(),
                "passwd": $("input[name=passwd]").val()
            }
            alert(JSON.stringify(data));
            $.ajax({
                type:"POST",
                url:"/account",
                headers:{
                    'Content-Type': 'application/json'
                },
                data: JSON.stringify(data),
                success:function(data){
                    console.log("DEBUG check :", data);
                    window.location.href="/";
                },
                fail: function(e){
                    console.log("DEBUGG error : ", e);
                }
            })

            return false;
        });
        $("#backBtn").click(function () {
            window.history.back();
        })
    })
</script>

<h2>회원가입</h2>
<form id="createForm">
    <div class="form-group">
        <input type="text" name="userId"  class="form-control" placeholder="Enter Your Account" required/>
        <input type="password" name="passwd" class="form-control" placeholder="Enter Your Password" required/>
        <input type="text" name="userName" class="form-control" placeholder="Enter Your Name" required/>
        <input type="text" name="userEmail" class="form-control" placeholder="Enter Your Email" required/>
        <br><br>
        <input type="submit"  class="form-control btn btn-primary"value="가입" />
        <input id="backBtn" type="button"  class="form-control btn btn-default"value="뒤로" />
    </div>
</form>

