<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 정보</title>
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
    <link rel="stylesheet" type="text/css" href="./css/global.css">
    <script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
    <header id="main-header" class="py-2 btn-dark text-white">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>상품 상세 정보</h1>
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
                            <h5>상품 상세 보기</h5>
                        </div>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead class="thead-light">
                                    <tr class="text-center">
                                        <th>상품 ID</th>
                                        <th>상품 이름</th>
                                        <th>가격</th>
                                        <th>등록일</th>
                                        <th>소개</th>
                                        <th>카테고리</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="text-center">
                                        <td>${productDTO.product_id}</td>
                                        <td>${productDTO.product_name}</td>
                                        <td>${productDTO.product_price}</td>
                                        <td>${productDTO.product_regisdate}</td>
                                        <td>${productDTO.product_intro}</td>
                                        <td>${productDTO.product_category}</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-md-4">
                                    <a href="./ProductSelect.pd" class="btn btn-primary btn-block">상품 목록</a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./ProductUpdate.pd?product_id=${productDTO.product_id}" class="btn btn-warning btn-block">상품 수정</a>
                                </div>
                                <div class="col-md-4">
                                    <a href="./ProductDeleteView.pd?product_id=${productDTO.product_id}" class="btn btn-danger btn-block">상품 삭제</a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-center">
                                    <img src="${productDTO.product_image}" alt="${productDTO.product_name}" class="img-fluid" />
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
