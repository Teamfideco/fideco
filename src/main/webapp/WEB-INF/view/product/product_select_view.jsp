<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리</title>
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
                    <h1>상품 관리</h1>
                </div>
            </div>
        </div>
    </header>

    <section class="py-4 mb-4 bg-light"></section>

    <section id="products">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <h5>상품 목록</h5>
                        </div>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead class="thead-light">
                                    <tr class="text-center">
                                        <th>상품 ID</th>
                                        <th>상품 이름</th>
                                        <th>가격</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%-- 상품 객체를 호출하고 파라미터에 저장하여 반복합니다. --%>
                                    <c:forEach var="arrayList" items="${arrayList}">
                                        <tr class="text-center">
                                            <td>${arrayList.product_id}</td>
                                            <td>${arrayList.product_name}</td>
                                            <td>${arrayList.product_price} 원</td>
                                            <td>
                                                <a href="./ProductSelectDetail.pd?product_id=${arrayList.product_id}" class="btn btn-outline-info">
                                                    상품 상세 보기
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <%-- 상품 객체가 비어 있을 경우 --%>
                                    <c:if test="${empty arrayList}">
                                        <tr>
                                            <td colspan="4">등록된 상품이 없습니다.</td>
                                        </tr>
                                    </c:if>
                                </tbody>
                            </table>
                            <div>
                                <a href="./ProductInsertView.pd" class="btn btn-success btn-block">
                                    상품 입력
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
