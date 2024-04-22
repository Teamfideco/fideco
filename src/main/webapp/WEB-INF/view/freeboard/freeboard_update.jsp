<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 자유게시판 수정 </title>
</head>
<body>
<section id="board">
  <div class="container">
   <div class="row">
    <div class="col-md-12">
     <div class="card">
      <div class="card-header">
       <h3 class="text-muted">
        <i class="fas fa-edit mr-sm-1"></i>
        글 수정
       </h3>
      </div>
      <div class="card-body">
       <form action="./FreeboardUpdate.fb" method="post" id="checkForm" >
        <fieldset>
       
         
           <input type="hidden" name="num" value="${freeboardDTO.num}">
           <input type="hidden" name="member_id" value="${freeboardDTO.member_id}">
           <div class="form-group row">
            <label for="freeboard_title" class="col-2 col-form-label pr-0">
             <i class="fas fa-pen-alt mr-sm-1"></i>
             제목
            </label>
            <div class="col-7 pl-0">
             <input type="text" name="freeboard_title" id="freeboard_title" class="form-control" value="${freeboardDTO.freeboard_title}">
            </div>
           </div>
           <div class="form-group row">
            <label for="freeboard_content" class="col-2 col-form-label pr-0">
             <i class="fas fa-edit mr-sm-1"></i>
             내용
            </label>
            <div class="col-10 pl-0">
             <textarea name="freeboard_content" id="freeboard_content" class="form-control ckeditor">${freeboardDTO.freeboard_content}</textarea>
            </div>
           </div>        
                 
         <nav class="navbar justify-content-end">
          <button type="submit" class="btn btn-outline-primary mr-sm-1" >
           <i class="fas fa-save mr-sm-1"></i>
           글 저장
          </button>
          <button type="reset" id="clear" class="btn btn-outline-warning mr-sm-1">
           <i class="fas fa-share-square mr-sm-1"></i>
           글 취소
          </button>
          <button type="button" class="btn btn-outline-success mr-sm-1" onclick="location.href='./FreeboardSelect.fb'">
           <i class="fas fa-file-alt mr-sm-1"></i>
           글 목록
          </button>
         </nav>
        </fieldset>
       </form>
      </div>
     </div>
    </div>
   </div>
  </div>
 </section>
</body>
</html>