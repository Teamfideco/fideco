<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>자유게시판 상세보기</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
    <section class="container mt-4">
        <h3 class="text-muted mb-4">
            <i class="fas fa-sticky-note mr-1"></i>글 내용
        </h3>
        
        <div class="card">
            <div class="card-body">
                <input type="hidden" name="num" value="${freeboardDTO.num}">

                <div class="form-group row">
                    <label for="member_id" class="col-2 col-form-label pr-0"><i class="fas fa-portrait mr-1"></i>작성자</label>
                    <div class="col-10 pl-0 py-1">
                        ${freeboardDTO.member_id}
                    </div>
                </div>

                <div class="form-group row">
                    <label for="freeboard_title" class="col-2 col-form-label pr-0"><i class="fas fa-pen-alt mr-1"></i>제목</label>
                    <div class="col-10 pl-0 py-1">
                        ${freeboardDTO.freeboard_title}
                    </div>
                </div>

                <div class="form-group row">
                    <label for="freeboard_content" class="col-2 col-form-label pr-0"><i class="fas fa-edit mr-1"></i>내용</label>
                    <div class="col-10 pl-0 py-1">
                        <div class="form-control-plaintext">${freeboardDTO.freeboard_content}</div>
                    </div>
                </div>
            </div>
        </div>

        <nav class="navbar justify-content-end mt-3">
            <button type="button" class="btn btn-outline-secondary mr-1" onclick="location.href='./FreeboardUpdateDetail.fb?num=${freeboardDTO.num}'">
                <i class="fas fa-upload mr-1"></i>글 수정
            </button>
            <button type="button" class="btn btn-outline-danger mr-1" onclick="location.href='./FreeboardDeleteView.fb?num=${freeboardDTO.num}'">
                <i class="fas fa-trash mr-1"></i>글 삭제
            </button>
            <button type="button" class="btn btn-outline-success" onclick="location.href='./FreeboardSelect.fb'">
                <i class="fas fa-file-alt mr-1"></i>글 목록
            </button>
        </nav>
    </section>
    </body>
</html>