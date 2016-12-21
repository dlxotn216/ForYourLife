(function () {
	// 수정버튼 클릭
	$('#btn-fb-update').on('click', function (e) {

		var $form = $('#fbForm');
		var formData = {
			fbUserId: $form.find('[name="fbUserId"]').val(),
			fbUserName: $form.find('[name="fbUserName"]').val()
		};
		var editRequest = $.ajax({
			method: 'PUT',
			type: 'PUT',
			url: '/admin/fb/' + $form.attr('data-fb-id'),
			dataType: "json",
			data: JSON.stringify(formData),
			contentType: 'application/json'
		});
		$.when(editRequest).then(function (response) {
			if (response['STATUS'] == '200') {
				alert('수정되었습니다.');
			}
		}).fail(function (err) {
			console.log("DEBUG : ERROR : " + err);
		});
	});

	$('#btn-fb-delete').on('click', function (e) {
		var $form = $('#fbForm');
		var deleteRequest = $.ajax({
			method: 'DELETE',
			type: 'DELETE',
			url: '/admin/fb/' + $form.attr('data-fb-id'),
			dataType: "json",
			contentType: 'application/json'
		});
		$.when(deleteRequest).then(function (response) {
			if( response['STATUS'] == '200' ){
				alert('삭제되었습니다.');
				window.location.href = '/admin/fb/list';
			}
		}).fail(function (err) {
			console.log("DEBUG : ERROR : " + err);
		});
	});

})();