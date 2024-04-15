<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비품 대여 현황</title>
<jsp:include page="../commonheader.jsp" />
</head>
<body>
    <jsp:include page="../layout/layout.jsp" />
    <h2>비품 대여 현황</h2>
    <div class="flex">
        <div>대여중인 비품은 ${userRentalState.borrowCnt}건입니다.</div>
        <div class="flex">

        </div>
    </div>
    <div class="grid">
        <table class="table">
            <thead>
                <tr>
                    <th>비품관리 ID</th>
                    <th>비품명</th>
                    <th>대여자 ID</th>
                    <th>대여일</th>
                    <th>반납일</th>
                    <th>대여상태</th>
                </tr>
            </thead>
        </table>
        <tbody>
            <c:choose>
                <c:when test="${not empty userRentalState.borrowList}">
                    <c:foreach items="${userRentalState.borrowList}" var="product">
                        <tr>
                            <td>${product.prdtMngId}</td>
                            <td>${product.productVO.prdtName}</td>
                            <td>${product.brrwId}</td>
                            <td>${product.brrwDt}</td>
                            <c:choose>
                                <c:when test="${not empty product.rtnDt}">
                                    <td>${product.rtnDt}</td>
                                    <td>반납완료</td>
                                </c:when>
                                <c:otherwise>
                                    <td>-</td>
                                    <td>대여중</td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:foreach>

                </c:when>
                
            </c:choose>

        </tbody>
    </div>
    <jsp:include page="../layout/layout_close.jsp" />
</body>
</html>