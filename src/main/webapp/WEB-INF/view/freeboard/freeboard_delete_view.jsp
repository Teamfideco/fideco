<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 모바일 웹 브라우저의 너비를 설정 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>자유 게시판 삭제</title>
    <!-- 스타일시트 및 자바스크립트 파일 링크 -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
    <link rel="stylesheet" type="text/css" href="./css/global.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
    <script src="./js/jquery.validate.min.js" type="text/javascript"></script>
    <!-- 자유 게시판 관련 유효성 검증을 위한 자바스크립트 -->
    <script src="./js/freeboard_validity.js" type="text/javascript"></script>
</head>
<body>
    <header id="main-header" class="py-2 btn-dark text-white">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>자유 게시판 삭제</h1>
                </div>
            </div>
        </div>
    </header>
    <section class="py-4 mb-4 bg-light"></section>

    <section id="freeboard">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h5>게시글 삭제</h5>
                        </div>
                        <div class="card-body">
                            <form action="./FreeboardDelete.fb" method="post" id="delete_form">
                                <fieldset>
                                    <div class="form-group row">
                                        <label for="num" class="ml-sm-3 col-form-label">게시글 번호</label>
                                        <div class="ml-sm-3">
                                            <!-- 게시글 ID를 readonly로 표시 -->
                                            <input type="text" name="num" id="num" class="form-control form-control-sm bg-white" value="${param.num}" readonly>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-secondary">삭제</button>
                                        <button type="reset" class="btn btn-secondary">취소</button>
                                    </div>
                                </fieldset>
                            </form>

                            <div class="row">
                                <div class="col-md-4">
                                    <a href="./FreeboardSelect.fb" class="btn btn-primary btn-block">게시판 목록</a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./FreeboardInsertView.fb" class="btn btn-success btn-block">게시글 입력</a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./FreeboardUpdateView.fb?num=${param.num}" class="btn btn-warning btn-block">게시글 수정</a>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
