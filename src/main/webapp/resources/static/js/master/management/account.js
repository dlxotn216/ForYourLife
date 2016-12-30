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
        e.stopPropagation();
    });

    $(".master-account-row").click(function(){
        var userId = $(this).attr('userId');

        $.ajax({
            type:"GET",
            url:"/master/accounts/"+userId,
            success:function(res){
                console.log("DEBUG CHECK RESPONSE:", res);
                $("#userModal").modal('toggle');
                $("#user-modal-userId").val(res.userId);
                $("#user-modal-userEmail").val(res.userEmail);
                $("#user-modal-userName").val(res.userName);
                $("#user-modal-regDate").val(res.regDate);
                $("#user-modal-permit").val(res.permit);
                $("#user-modal-phone").val(res.phone);
                $("#user-modal-permit").attr('user-id', res.userId);
                $("#user-modal-authority").attr('user-id', res.userId);

                var authName = res.authName;
                console.log("DEBUG CHECK :", $("#user-modal-authority option[value=authName]"));
                $("#user-modal-authority option[value=authName]").attr('selected', 'selected');

                if(res.permit == 'N') {
                    $("#user-modal-permit option[value='N']").attr('selected', "selected");
                }

                if(res.smsYn === 'Y'){
                    $("#user-modal-smsY").attr('checked', true);
                } else {
                    $("#user-modal-smsN").attr('checked', true);
                }
                if(res.emailYn === 'Y'){
                    $("#user-modal-emailY").attr('checked', true);
                } else {
                    $("#user-modal-emailN").attr('checked', true);
                }
            }
        });
    });

    $(".authoritySelect").click(function(e){
        e.stopPropagation();
    });

    $("#user-modal-authority").on('change', function(){
        var userId = $(this).attr('user-id');
        var authName = $(this).val();
        var self = this;

        var data = {
            "userId" : userId,
            "authName" : authName
        }
        $.ajax({
            type:"PUT",
            url:"/master/account/"+userId+"/authority",
            data: JSON.stringify(data),
            success: function(){
            }
        })
    });

    $("#user-modal-permit").on('change', function(){
        var userId = $(this).attr('user-id');
        var permit = $(this).val();
        var self = this;

        var data = {
            "userId" : userId,
            "permit" : permit
        }
        $.ajax({
            type:"PUT",
            url:"/master/account/"+userId+"/permit",
            data: JSON.stringify(data),
            success: function(){

            }
        })
    });


});