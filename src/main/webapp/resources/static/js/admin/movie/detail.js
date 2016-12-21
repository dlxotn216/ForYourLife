(function () {
	// 수정버튼 클릭
	$('#btn-movie-update').on('click', function (e) {

		var $form = $('#movieEditForm');
		var formData = {
			movieName: $form.find('[name="movieName"]').val(),
			fbAccountId: $form.find('[name="fbAccountId"]').val(),
			links: (function () {
				var link = $form.find('[name="links"]');
				var linkArr = [];
				$.each(link, function (index, data) {
					linkArr.push($(data).val());
				});
				return linkArr;
			})()
		};
		var editRequest = $.ajax({
			method		: 'PUT',
			type		: 'PUT',
			url			: '/admin/movie/' + $form.attr('data-movie-id'),
			dataType	: "json",
			data        : JSON.stringify(formData),
			contentType	: 'application/json'
		});
		$.when(editRequest).then(function (response) {
			if( response['STATUS'] == '200' ){
				alert('수정되었습니다.');
			}
		}).fail(function (err) {
			console.log("DEBUG : ERROR : " + err);
		});
	});

	$('#btn-movie-delete').on('click', function (e) {
		console.log("DELETE");
		var $form = $('#movieEditForm');
		var deleteRequest = $.ajax({
			method		: 'DELETE',
			type		: 'DELETE',
			url			: '/admin/movie/' + $form.attr('data-movie-id'),
			dataType	: "json",
			contentType	: 'application/json'
		});

		$.when(deleteRequest).then(function (response) {
			if( response['STATUS'] == '200' ){
				alert('삭제되었습니다.');
				window.location.href = '/admin/movie/list';
			}
		}).fail(function (err) {
			console.log("DEBUG : ERROR : " + err);
		});
	});
})();