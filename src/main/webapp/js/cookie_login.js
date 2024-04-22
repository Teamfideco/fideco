$(function() {
	member_id = $.cookie("member_id");
	// console.log(member_id);
	member_pw = $.cookie("member_pw");
	// console.log(member_pw);
	if (member_id && member_pw) {
		$("#member_id").val(member_id);
		$("#member_pw").val(member_pw);
		$("#save").prop("checked", true);
	}
	$("#save").change(function() {
		if ($(this).is(":checked")) {
			if (confirm("정보가 노출될 위험이 있습니다. 정보를 저장하시겠습니까?")) {
				// 쿠키를 365일로 설정한다.
				$.cookie("member_id", $("#member_id").val(), {
				 expires : 365,
				 path : "/"
				});
				$.cookie("member_pw", $("#member_pw").val(), {
				 expires : 365,
				 path : "/"
				});
			}
		} else {
			$.removeCookie("member_id", {
				path : "/"
			});
			$.removeCookie("member_pw", {
				path : "/"
			});
			$("#save").prop("checked", false);

		}
	});
});
