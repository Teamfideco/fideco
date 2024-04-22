<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body> 
<c:choose>
 <c:when test="${sessionScope.id == 'admin'}">
  <script type="text/javascript">
    if (confirm("게시글을 삭제하시겠습니까?")) {
      location.href="./QnaDelete.qb?num=${param.num}&id=admin";
    } else {
      window.history.back();
    }
  </script>
 </c:when>
 <c:otherwise>
  <script type="text/javascript">
    if (confirm("게시글을 삭제하시겠습니까?")) {
      location.href="./QnaDelete.qb?num=${param.num}&id=${sessionScope.id}";
    } else {
      window.history.back();
    }
  </script>
 </c:otherwise>
</c:choose>
</body>
</html>
