<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- header.jsp 포함 -->
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- 시작 부분 -->
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h2>게시글 목록</h2>
            <br>

            <!-- 게시글 목록 출력 -->
            <c:if test="${not empty posts}">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>내용</th>
                            <th>작성자</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="post" items="${posts}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${post.title}</td>
                                <td>${post.content}</td>
                                <td>${post.author}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <form action="/blog/update/${post.id}" method="get" style="display: inline;">
                                            <button type="submit" class="btn btn-warn btn-sm">수정</button>
                                        </form>
                                        <form action="/blog/delete/${post.id}" method="get" style="display: inline;">
                                            <button type="submit" class="btn btn-danger btn-sm">삭제</button>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>

            <c:if test="${empty posts}">
                <p>게시글이 없습니다.</p>
            </c:if>
        </div>
    </div>
</div>
