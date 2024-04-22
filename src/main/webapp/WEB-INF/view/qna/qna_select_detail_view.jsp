<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_a4.5.0.js" type="text/javascript"></script>
<title>글 내용</title>
</head>
<body>
<section>
<h3 class="text-muted">
    <i class="fas fa-sticky-note mr-sm-1"></i>글 내용
</h3>
     
<div class="card-body">
    <div class="row pl-1 pr-1">
        <div class="col col-md-10">
            <input type="hidden" name="num" value="${qnaDTO.num}">
          <table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
          <tr>
          <td style="background-color: #eeeeee;">작성자 </td>
          <td colspan="2">${qnaDTO.qna_id} </td>
          </tr>
        	<tr>
          <td style="background-color: #eeeeee;">제목 </td>
          <td colspan="2">${qnaDTO.qna_title} </td>
          </tr>
          <tr>
          <td style="background-color: #eeeeee;">내용 </td>
          <td colspan="2" style="min-height: 200px; text-align: center;">${qnaDTO.qna_content} </td>
          </tr>
          </table> 
           </div>
  	</div>
    </div>

      
<nav class="navbar justify-content-end">    
    <button type="button" class="btn btn-outline-secondary mr-sm-1" onclick="location.href='./QnaUpdateDetail.qb?num=${qnaDTO.num}'">
        <i class="fas fa-upload mr-sm-1"></i>글 수정
    </button>
    <button type="button" class="btn btn-outline-danger mr-sm-1" onclick="location.href='./QnaDeleteView.qb?num=${qnaDTO.num}'">
        <i class="fas fa-trash mr-sm-1"></i>글 삭제
    </button>
    <button type="button" class="btn btn-outline-success mr-sm-1" onclick="location.href='./QnaSelect.qb'">
        <i class="fas fa-file-alt mr-sm-1"></i>글 목록
    </button>
</nav>
</section>
</body>
</html>
