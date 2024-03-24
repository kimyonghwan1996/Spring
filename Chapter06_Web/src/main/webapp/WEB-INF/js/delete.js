$(function(){
	//입력
	$('#deleteBtn').click(function(){
		if(confirm('삭제하시겠습니까?')){
			$.ajax({
				type: 'post',
				url: '/Chapter06_Web/user/delete',
				data: $('#id').val(),
				success: function(){
					alert('삭제완료');
					location.href='/Chapter06_Web/user/list';
				},
				error: function(e){
					console.log(e);
				}
			});
		}//if
	});
});