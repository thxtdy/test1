<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시글 상세보기</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row mt-4">
            <div class="col-sm-12">
                <h2>${post.title}</h2>
                <p><strong>작성자:</strong> ${post.author}</p>
                <p><strong>내용:</strong></p>
                <div class="border p-3">
                    <p>${post.content}</p>
                </div>
                <a href="/blog/main" class="btn btn-primary mt-3">목록으로 돌아가기</a>
            </div>
        </div>
    </div>
</body>
</html>
