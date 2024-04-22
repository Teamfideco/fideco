<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- 모바일 웹 브라우저의 너비를 설정한다. -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> 상품 정보 삭제 </title>
    <!-- 포워드로 전송할 경우 스타일시트와 자바스크립트를 지원하기 위해 경로를 현재 작업 디렉터리로 변경한다. -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
    <link rel="stylesheet" type="text/css" href="./css/global.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
    <script src="./js/jquery.validate.min.js" type="text/javascript"></script>
    <script src="./js/product_validity.js" type="text/javascript"></script>
</head>
<body>
    <header id="main-header" class="py-2 btn-dark text-white">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1> 상품 정보 삭제 </h1>
                </div>
            </div>
        </div>
    </header>
    <section class="py-4 mb-4 bg-light"></section>
    <section id="product">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h5> 상품 삭제 </h5>
                        </div>
                        <div class="card-body">
                            <form action="./ProductDelete.pd" method="post" id="product_delete">
                                <fieldset>
                                    <div class="form-group row">
                                        <label for="product_id" class="ml-sm-3 col-form-label"> 상품 ID </label>
                                        <div class="ml-sm-3">
                                            <!-- 입력한 상품 ID를 읽기 전용 필드로 표시한다. -->
                                            <input type="text" name="product_id" id="product_id" class="form-control form-control-sm bg-white"
                                            value="${param.product_id}" readonly>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-danger"> 삭제 </button>
                                        <button type="reset" class="btn btn-secondary"> 취소 </button>
                                    </div>
                                </fieldset>
                            </form>
                            <div class="row">
                                <div class="col-md-4">
                                    <a href="./ProductSelect.pd" class="btn btn-primary btn-block"> 상품 목록 </a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./ProductInsertView.pd" class="btn btn-success btn-block"> 상품 입력 </a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./ProductUpdateView.pd?product_id=${param.product_id}" class="btn btn-warning btn-block"> 상품 수정 </a>
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
