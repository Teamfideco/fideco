<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세 조회</title>
<link rel="stylesheet" type="text/css" href="./css/su.css">
<style>
    .card-body {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .table {
        width: 80%;
        border-collapse: collapse;
        margin: 0 auto;
        text-align: center;
        border: 2px solid #ccc; /* 테이블 테두리 추가 */
    }

    .table th,
    .table td {
        border: 1px solid #ccc;
        padding: 10px;
    }

    .text-left {
        text-align: left;
    }

    .btn-group {
        display: flex;
        justify-content: center;
    }

    .btn {
        margin: 5px;
    }

    .info {
        font-size: 14px;
        text-align: left;
        margin-top: 20px;
    }

    /* 내용 부분의 높이 조정 */
    .content {
        height: 300px; /* 높이 조정 */
        overflow-y: auto; /* 내용이 넘칠 경우 스크롤 표시 */
    }
</style>
</head>
<body>
    <h5>공지사항 상세 조회</h5>
    <div class="card-body">
        <table class="table table-hover">
            <tbody>
                <tr>
                    <th class="text-left">제목</th>
                    <td colspan="5" class="text-left">${noticeDTO.notice_title}</td>
                </tr>
                <tr>
                    <th class="text-left">작성자</th>
                    <td class="text-left">${noticeDTO.notice_writer}</td>
                    <th class="text-left">등록일</th>
                    <td class="text-left">${noticeDTO.notice_registday}</td>
                    <th class="text-left">조회수</th>
                    <td class="text-left">${noticeDTO.notice_hit}</td>
                </tr>
                <tr>
                    <th class="text-left">내용</th>
                    <td class="text-left content" colspan="6">${noticeDTO.notice_content}</td>
                </tr>
            </tbody>
        </table>
        <div class="btn-group">
            <button onclick="location.href='./NoticeSelectAll.nt'" class="btn">공지사항 전체 조회</button>
            <button onclick="location.href='./NoticeUpdate.nt?notice_num=${noticeDTO.notice_num}'" class="btn">공지사항 수정</button>
            <button onclick="location.href='./NoticeDeleteView.nt?notice_num=${noticeDTO.notice_num}'" class="btn">공지사항 삭제</button>
        </div>
    </div>
</body>
</html>
