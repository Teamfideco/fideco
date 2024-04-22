<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_a4.5.0.js" type="text/javascript"></script>
<style>
  /* 테이블 행에 호버 효과 추가 */
  .table-hover tbody tr:hover {
    background-color: #f0cb11;
    cursor: pointer;
  }
</style>
</head>
<body>
<header id="main-header" class="py-2 btn-dark text-white"> 
<div class="container"> 
<div class="row"> 
<div class="col-md-6"> <h1> Review 게시판 </h1> 
</div> </div> </div> </header> 
<section class="py-4 mb-4 bg-light"> </section> 
<section id="board"> 
<div class="container"> 
<div class="row"> 
<div class="col-md-12"> 
<div class="card"> 
<div class="card-header"> 
<h3> 게시글 목록 </h3> 
<a href="./LoginMain.me" class="Login_mainHome">메인 홈</a>
</div> 
<div class="card-body"> 
<table class="table table-hover"> 
<thead class="thead-light"> 
<tr class="text-center"> 
<th width="5%" style="background-color: #eeeeee; text-align: center;"> 번호 </th> 
<th width="10%" style="background-color: #eeeeee; text-align: center;"> 작성자 </th> 
<th width="17%" style="background-color: #eeeeee; text-align: center;"> 제목 </th> 
<th width="10%" style="background-color: #eeeeee; text-align: center;"> 작성일 </th>  
</tr> 
</thead>
<tbody>
<c:forEach var="arrayList" items="${arrayList}"> 
<tr class="text-center"> 
<td width="5%" style="text-align: center;">${arrayList.num}</td>
<td width="10%" style="text-align: center;">${arrayList.review_id}</td>
<td width="17%" style="text-align: center;">
<a href="./ReviewSelectDetail.rb?num=${arrayList.num}">${arrayList.review_title}</a>
</td>
<td width="10%" style="text-align: center;">${arrayList.review_regisdate}</td> 
</tr> 
</c:forEach>
<c:if test="${empty arrayList}"> 
<tr> 
<td colspan="4"> 등록된 글이 없습니다. </td> 
</tr> 
</c:if> 
</tbody> 
</table> 
<div> <a href="./ReviewInsertView.qb" class="btn btn-success btn-block"> 글 등록 </a> 
</div> </div> </div> </div> </div> </div> </section>
</body>
</html>
