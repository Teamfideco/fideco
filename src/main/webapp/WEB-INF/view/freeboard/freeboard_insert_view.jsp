<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>자유게시판 글 작성</title>
    <link rel="stylesheet" href="./css/bootstrap.min_4.5.0.css">
    <link rel="stylesheet" href="./css/global.css">
    <script src="./js/jquery-3.5.1.min.js"></script>
    <script src="./js/bootstrap.min_4.5.0.js"></script>
</head>
<body>
    <div class="container mt-4">
        <h1 class="mb-4">자유게시판 글 작성</h1>
        <form action="./FreeboardInsert.fb" method="POST">

            <div class="form-group">
                <label for="member_id">작성자:</label>
                <textarea id="member_id" name="member_id" class="form-control" placeholder="내용을 입력하세요" rows="5" required></textarea>
            </div>
            <div class="form-group">
                <label for="freeboard_title">제목:</label>
                <input type="text" id="freeboard_title" name="freeboard_title" class="form-control" placeholder="제목을 입력하세요" required>
            </div>
            
            <div class="form-group">
                <label for="freeboard_content">내용:</label>
                <textarea id="freeboard_content" name="freeboard_content" class="form-control" placeholder="내용을 입력하세요" rows="5" required></textarea>
            </div>
            
            <div class="text-right">
                <button type="submit" class="btn btn-primary">글 저장</button>
                <button type="reset" class="btn btn-secondary">취소</button>
               <button type="button" class="btn btn-outline-success mr-sm-1" onclick="location.href='./FreeboardSelect.fb'">
           <i class="fas fa-file-alt mr-sm-1"></i>글 목록
           </button>
            </div>
        </form>
    </div>
</body>
</html>

