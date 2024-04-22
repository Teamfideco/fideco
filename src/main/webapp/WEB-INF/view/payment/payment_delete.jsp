<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 정보 삭제</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
	<h5>결제 정보 삭제</h5>

	<div class="card-body">
		<form action="./PaymentDelete.py" method="post" id="sign_dept">
			<fieldset>
				<div class="form-group row">
					<label for="paymentid" class="ml-sm-3 col-form-label"> 결제
						아이디 </label>
					<div class="ml-sm-3">

						<input type="text" name="payment_id" id="payment_id"
							class="form-control form-control-sm bg-white"
							value="${param.payment_id}" readonly>
					</div>
				</div>
				<div class="form-group">
					<button type="submit" class="btn">삭제</button>
					<button type="reset" class="btn">취소</button>
				</div>
			</fieldset>
		</form>
		
		</div>


</body>
</html>