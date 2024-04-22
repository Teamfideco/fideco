<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 입력</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
</head>
<body>
<h2> 결제 정보 입력 </h2>
<form action="./PaymentInsert.py" method="post">
    <table>
        <tr>
            <td><label for="payment_id">결제 아이디</label></td>
            <td><input type="text" id="payment_id" name="payment_id" required></td>
            <td><label for="payment_amount">결제 금액</label></td>
            <td><input type="text" id="payment_amount" name="payment_amount" required></td>
            <td><label for="payment_date">결제 일자 :</label></td>
            <td><input type="date" id="payment_date" name="payment_date" required></td>
        </tr>
        <tr>
            <td colspan="6">
                <h7>결제 수단 선택</h7>
                <input type="radio" id="credit_pay" name="payment_method" value="카드 결제" checked>
                <label for="credit_pay">카드 결제</label>
                <input type="radio" id="phone_pay" name="payment_method" value="휴대폰 결제">
                <label for="phone_pay">휴대폰 결제</label>
                <input type="radio" id="simple_pay" name="payment_method" value="간편 결제">
                <label for="simple_pay">간편 결제</label>
            </td>
        </tr>
    </table>
            
    <div class="form-group"> 
        <button type="submit" class="btn"> 결제 등록 </button>
        <button type="reset" class="btn" onclick="location.href='./PaymentSelectAll.py'"> 결제 취소 </button>
    </div>
</form>
</body>
</html>
