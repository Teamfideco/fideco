function checkDeliveryDetail(orderId) {
    // AJAX를 사용하여 서버에 해당 주문의 배송 내역이 있는지 확인
    $.ajax({
        url: "./CheckDeliveryDetail.do", // 확인할 배송 내역을 확인하는 서블릿 또는 컨트롤러의 URL
        method: "GET",
        data: {orderId: orderId},
        success: function(response) {
            if (response === "true") {
                // 배송 내역이 있는 경우, 해당 주문의 배송 상세 페이지로 이동
                window.location.href = "./DeliverySelectDetail.de?order_id=" + orderId;
            } else {
                // 배송 내역이 없는 경우, 경고창을 표시하여 사용자에게 입력 여부를 묻는다.
                var confirmMsg = "배송 정보가 없습니다. 배송 정보를 입력하시겠습니까?";
                if (confirm(confirmMsg)) {
                    // 사용자가 확인을 선택한 경우, 배송 정보 입력 페이지로 이동
                    window.location.href = "./DeliveryInsertView.de";
                }
            }
        },
        error: function(xhr, status, error) {
            // AJAX 요청이 실패한 경우 에러 메시지를 콘솔에 출력
            console.error("AJAX Error: " + error);
        }
    });
}
