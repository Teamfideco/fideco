<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>자유 게시판</title>
    <!-- 아이콘과 스타일시트 로드 -->
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="./css/global.css">
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>

<body>
    <!-- 고정 네비게이션 바 -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">자유 게시판</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="./index.jsp">
                            <i class="fa fa-home"></i> 홈
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- 게시판 섹션 -->
    <section id="board" class="container mt-5 pt-5">
        <div class="card">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h3>글 목록</h3>
            </div>

            <div class="card-body">
                <table class="table table-hover">
                    <thead class="thead-light">
                        <tr class="text-center">
                            <th>번호</th>
                            <th>작성자</th>
                            <th>제목</th>
                            <th>작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                      <c:forEach var="arrayList" items="${arrayList}"> 
<tr class="text-center"> 
<td>${arrayList.num}</td>
<td>${arrayList.member_id}</td>
<td>
<a href="./FreeboardSelectDetail.fb?num=${arrayList.num}">${arrayList.freeboard_title}</a>
</td>
<td>${arrayList.freeboard_registdate}</td> 
</tr> 
                        </c:forEach>
                    </tbody>
                </table>

                <!-- 글 작성 버튼 -->
                <div class="text-right mt-3">
                    <button type="button" class="btn btn-primary" onclick="location.href='./FreeboardInsertView.fb'">
                        <i class="fa fa-plus"></i> 글 작성
                    </button>
                </div>
            </div>
        </div>
    </section>

    <!-- 푸터 -->
    <footer class="bg-dark text-white text-center mt-3 py-3">
        <div class="container">
            <p>© 자유 게시판</p>
        </div>
    </footer>
</body>

</html>
