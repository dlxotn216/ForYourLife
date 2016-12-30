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
<script src="/resources/js/master/management/account.js"></script>
<link rel="stylesheet" href="/resources/css/master/management/account.css" />

<div class="table-responsive">
    <table class="table table-hover">
        <tr>
            <th class="text-center">계정</th>
            <th class="text-center">권한</th>
            <th class="text-center">이름</th>
            <th class="text-center">PERMIT</th>
            <th class="text-center">등록/변경일</th>
        </tr>
        <c:forEach var="account" items="${accounts}">
        <tr class="master-account-row" userId="${ account.userId }">
            <td class="text-center">${account.userId}</td>
            <td class="text-center">${account.description}</td>
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

<div id="userModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title">사용자 상세정보</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-userId">아이디</label>
                        <div class="col-sm-8">
                            <input id="user-modal-userId" class="form-control" disabled />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-userName">이름</label>
                        <div class="col-sm-8">
                            <input id="user-modal-userName" class="form-control" disabled />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-userEmail">이메일</label>
                        <div class="col-sm-8">
                            <input id="user-modal-userEmail" class="form-control" type="email" disabled />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-phone">전화번호</label>
                        <div class="col-sm-8">
                            <input id="user-modal-phone" class="form-control" disabled />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-regDate">등록/수정일</label>
                        <div class="col-sm-8">
                            <input id="user-modal-regDate" class="form-control" disabled />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-authority">사용자 권한</label>
                        <div class="col-sm-8">
                            <select class="form-control authoritySelect" id="user-modal-authority">
                                <c:forEach var="authority" items="${authorities}">
                                    <option value="${authority.authName}" selected>${authority.description}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="user-modal-permit">계정 허가</label>
                        <div class="col-sm-8">
                            <select class="form-control authoritySelect" id="user-modal-permit">
                                <option value="Y">Y</option>
                                <option value="N">N</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">SMS 이벤트 수신</label>
                        <div class="radio col-sm-8">
                            <label class=""><input type="radio" id="user-modal-smsY" name="smsYn" disabled >수신</label>
                            <label class=""><input type="radio" id="user-modal-smsN" name="smsYn" disabled >수신하지 않음</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-4" for="">이메일 이벤트 수신</label>
                        <div class="radio col-sm-8">
                            <label class=""><input type="radio" id="user-modal-emailY" name="emailYn" disabled >수신</label>
                            <label class=""><input type="radio" id="user-modal-emailN"name="emailYn" disabled >수신하지 않음</label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary btn-block" data-dismiss="modal">닫기</button>
            </div>
        </div>

    </div>
</div>
