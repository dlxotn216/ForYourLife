<%--
  Created by IntelliJ IDEA.
  User: dlxot
  Date: 2016-12-26
  Time: 오후 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $(".active-button").click(function(e){
            var userId = $(this).prop("value");
            if($(this).attr('permit') === 'Y'){
                var permit = 'N';
                var addClass = "btn-danger";
                var removeClass = "btn-success";
                var text = "Inactive";

            } else {
                var permit = 'Y';
                var addClass = "btn-success";
                var removeClass = "btn-danger";
                var text = "Active";
            }
            var data = {
                "userId" : userId,
                "permit" : permit
            };
            var self = this;
            $.ajax({
                type:"PUT",
                url:"/master/accounts/"+userId+"/permit",
                data:JSON.stringify(data),
                headers:{
                    'Content-Type': 'application/json'
                },
                success:function(res){
                    $(self).addClass(addClass);
                    $(self).removeClass(removeClass);
                    $(self).text(text);
                    $(self).attr('permit', permit);
                }
            })

        })


    });
</script>

<div class="table-responsive">
    <table class="table table-hover">
        <tr>
            <th class="text-center">계정</th>
            <th class="text-center">이메일</th>
            <th class="text-center">PERMIT</th>
            <th class="text-center">등록/변경일</th>
        </tr>
        <c:forEach var="account" items="${accounts}">
        <tr>
            <td class="text-center">${account.userId}</td>
            <td class="text-center">${account.userName}</td>
            <c:if test="${account.permit == 'Y'}">
                <td class="text-center"><button type="button" value="${account.userId}" permit="Y" class="active-button btn btn-success btn-sm">Active</button></td>
            </c:if>
            <c:if test="${account.permit == 'N'}">
                <td class="text-center"><button type="button" value="${account.userId}" permit="N" class="active-button btn btn-danger btn-sm">Inactive</button></td>
            </c:if>
            <td class="text-center">${account.regDate}</td>
        </tr>
        </c:forEach>

    </table>
</div>
