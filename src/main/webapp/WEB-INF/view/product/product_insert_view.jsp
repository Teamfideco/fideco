<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 정보 입력</title>
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
                    <h1>상품 정보 입력</h1>
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
                            <h5>상품 입력</h5>
                        </div>
                        <div class="card-body">
                            <form action="./ProductInsert.pd" method="post" id="sign_product">
                                <fieldset>
                                    <div class="form-group row">
                                        <label for="product_id" class="ml-sm-3 col-form-label">상품 ID</label>
                                        <div class="ml-sm-3">
                                            <input type="text" name="product_id" id="product_id" class="form-control form-control-sm" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="product_name" class="ml-sm-3 col-form-label">상품 이름</label>
                                        <div class="ml-sm-3">
                                            <input type="text" name="product_name" id="product_name" class="form-control form-control-sm" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="product_price" class="ml-sm-3 col-form-label">상품 가격</label>
                                        <div class="ml-sm-3">
                                            <input type="number" name="product_price" id="product_price" class="form-control form-control-sm" step="0.01" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="product_intro" class="ml-sm-3 col-form-label">상품 소개</label>
                                        <div class="ml-sm-3">
                                            <textarea name="product_intro" id="product_intro" class="form-control form-control-sm" rows="4" required></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="product_category" class="ml-sm-3 col-form-label">상품 카테고리</label>
                                        <div class="ml-sm-3">
                                            <input type="text" name="product_category" id="product_category" class="form-control form-control-sm" required>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label for="product_image" class="ml-sm-3 col-form-label">상품 이미지</label>
                                        <div class="ml-sm-3">
                                            <input type="file" name="product_image" id="product_image" class="form-control form-control-sm" accept="image/*">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-secondary">등록</button>
                                        <button type="reset" class="btn btn-secondary">취소</button>
                                    </div>
                                </fieldset>
                            </form>
                            <div>
                                <a href="./ProductSelect.pd" class="btn btn-primary btn-block">상품 목록</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
