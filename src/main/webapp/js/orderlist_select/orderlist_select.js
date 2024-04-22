//정렬
function sortOrderlistNum() {
    sortTable(0, "sortOrderlistNum"); // 주문 내역 번호 기준으로 정렬
}

function sortOrderDate() {
    sortTable(3, "sortOrderdate"); // 주문 일시 기준으로 정렬
}

function sortTable(column, sortId) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("orderlistTable");
    switching = true;
    // 정렬 방향을 초기화합니다.
    dir = "asc";
    // 루프가 실행될 동안에 정렬이 이루어지지 않았다면 루프를 종료합니다.
    while (switching) {
        switching = false;
        rows = table.rows;
        // 모든 행(제목 행과 고정된 행 제외)을 순회합니다.
        for (i = 1; i < (rows.length - 1); i++) {
            shouldSwitch = false;
            // 현재 행과 다음 행을 비교합니다.
            x = rows[i].getElementsByTagName("TD")[column];
            y = rows[i + 1].getElementsByTagName("TD")[column];
            // 정렬 순서를 확인하고 조건에 따라 위치를 변경해야 하는지 확인합니다.
            if (column === 0) { // 주문 내역 번호일 경우
                if (dir === "asc") {
                    if (parseInt(x.innerHTML) > parseInt(y.innerHTML)) {
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir === "desc") {
                    if (parseInt(x.innerHTML) < parseInt(y.innerHTML)) {
                        shouldSwitch = true;
                        break;
                    }
                }
            } else { // 주문 일시일 경우
                if (dir === "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir === "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        shouldSwitch = true;
                        break;
                    }
                }
            }
        }
        if (shouldSwitch) {
            // 위치를 변경합니다.
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            switchcount ++;
        } else {
            // 내림차순 정렬이 필요한 경우
            if (switchcount === 0 && dir === "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
}

// 정렬 옵션 변경 시 해당 함수 호출
document.getElementById("sortOrderlist").onchange = function() {
    sortOrderlistNum();
};
document.getElementById("sortOrderdate").onchange = function() {
    sortOrderDate();
};



// 주문 상태에 따라 보기
function filterOrders() {
    var selectBox = document.getElementById("orderlistStatus");
    var selectedStatus = selectBox.value;
    var table = document.getElementById("orderlistTable");
    var rows = table.rows;

    for (var i = 1; i < rows.length; i++) {
        var row = rows[i];
        var statusCell = row.cells[2]; // 주문 상태가 있는 셀의 인덱스(0부터 시작)
        var statusText = statusCell.innerText.trim(); // 문자열 앞뒤 공백 제거

        // 주문 상태를 숫자로 변환하여 처리
        var statusValue;
        switch (statusText) {
            case "입금대기중(무통장)":
                statusValue = 1;
                break;
            case "결제완료":
                statusValue = 2;
                break;
            case "상품 준비중":
                statusValue = 3;
                break;
            case "배송중":
                statusValue = 4;
                break;
            case "배송완료":
                statusValue = 5;
                break;
            case "환불":
                statusValue = 6;
                break;
            default:
                statusValue = 0; // 알 수 없는 상태는 0으로 설정
                break;
        }

        if (selectedStatus === "all" || statusValue === parseInt(selectedStatus)) {
            row.style.display = ""; // 선택한 상태가 "전체"이거나 선택한 상태에 해당하는 주문 상태인 경우 표시
        } else {
            row.style.display = "none"; // 그렇지 않은 경우 숨김
        }
    }
}
