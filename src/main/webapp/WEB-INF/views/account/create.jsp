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
                "passwd": $("input[name=passwd]").val(),
                "emailYn": $("input[name=emailYn]:checked").val(),
                "smsYn": $("input[name=smsYn]:checked").val(),
                "phone": $("input[name=phone]").val()
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


<div class="container">
    <h2>회원가입</h2>
    <form id="createForm">
        <div class="form-group">
            <input type="text" name="userId"  class="form-control" placeholder="Enter Your Account" required/>
            <input type="password" name="passwd" class="form-control" placeholder="Enter Your Password" required/>
        </div>
        <div class="form-group">
            <input type="text" name="userName" class="form-control" placeholder="Enter Your Name" required/>
            <input type="text" name="userEmail" class="form-control" placeholder="Enter Your Email" required/>
            <p>이메일 수신</p>
            <div class="radio">
                <label class="radio-inline"><input type="radio" name="emailYn" id="emailY" value="Y" checked >동의</label>
                <label class="radio-inline"><input type="radio" name="emailYn" id="emailN" value="N" >동의하지 않음</label>
            </div>
        </div>

        <div class="form-group">
            <input type="text" name="phone" class="form-control" placeholder="Enter Your Phone" >
            <p>SMS 수신</p>
            <div class="radio">
                <label class="radio-inline">
                    <input type="radio" name="smsYn" id="smsY" value="Y" checked >동의
                </label>
                <label class="radio-inline">
                    <input type="radio" name="smsYn" id="smsN" value="N" />동의하지 않음
                </label>
            </div>
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

