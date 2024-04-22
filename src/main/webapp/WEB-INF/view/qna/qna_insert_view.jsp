<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<title>글 입력</title>
</head>
<body>
<div class="card-header">
       <h3 class="text-muted"><i class="fas fa-edit mr-sm-1"></i>글 등록</h3>
      </div>
      <form action="./QnaInsert.qb" method="post" id="checkForm">
      <fieldset>
      
         <div class="form-group row">
         <label for="qna_id" class="col-2 col-form-label pr-0"><i class="fas fa-pen-alt mr-sm-1"></i>작성자</label>
          <div class="col-6 pl-0">
          <input type="text" name="qna_id" id="qna_id" class="form-control">
          </div>           
          <label for="qna_title" class="col-2 col-form-label pr-0"><i class="fas fa-pen-alt mr-sm-1"></i>제목</label>
          <div class="col-6 pl-0">
           <input type="text" name="qna_title" id="qna_title" class="form-control">
          </div>
         </div>
         <div class="form-group row">
          <label for="qna_content" class="col-2 col-form-label pr-0"><i class="fas fa-edit mr-sm-1"></i>내용</label>
          <div class="col-10 pl-0">
           <textarea name="qna_content" id="qna_content" class="form-control ckeditor"></textarea>
          </div>
         </div>
         <button type="submit" class="btn btn-outline-primary mr-sm-1" >
           <i class="fas fa-save mr-sm-1"></i>글 저장
          </button>
          <button type="reset" id="clear" class="btn btn-outline-warning mr-sm-1">
           <i class="fas fa-share-square mr-sm-1"></i>글 취소
          </button>
          <button type="button" class="btn btn-outline-success mr-sm-1" onclick="location.href='./QnaSelect.qb'">
           <i class="fas fa-file-alt mr-sm-1"></i>글 목록
          </button>
      </fieldset>
      </form>
</body>
</html>