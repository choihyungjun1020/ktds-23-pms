<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>팀원 페이지</title>
    <jsp:include page="../commonheader.jsp"/>
    <script type="text/javascript" src="/js/project/teammate.js"></script>
    <link rel="stylesheet" href="/css/project/modal.css"/>
    <style>
        .btn-group {
            margin: 15px;
            float: right;
        }

        .h-59 {
            height: 59px;
        }
    </style>
</head>
<body>

<jsp:include page="modal.jsp"/>

<%-- 팀원 추가 모달 영역 --%>
<div class="modal" id="add-alert-modal" style="display:none;" data-dept-id="${project.deptId}">
    <div id="modal-cancel-button" class="close"></div>

    <div class="modal-content">

        <select id="modal-add-team-list">
        </select>

        <button id="modal-add-button">등록</button>
    </div>
</div>

<%--메인 컨텐츠--%>
<div>
    <div>
        <h4>
            프로젝트 : ${project.prjName}
        </h4>
    </div>

    <div>
        ${teammateCount}명
    </div>

    <table class="table">
        <thead>
        <tr>
            <%--      삭제기능, if 필요      --%>
            <th>
                <input type="checkbox"
                       id="checked-all"
                       data-target-class="target-teammate-id"/>
                <label for="checked-all"></label>
            </th>
            <th>부서</th>
            <th>역할</th>
            <th>이름</th>
            <th>이메일</th>

            <%--      삭제기능, if 필요      --%>
            <th></th>

        </tr>
        </thead>
        <tbody>
        <c:choose>
            <%-- projectList 내용이 존재한다면 --%>
            <c:when test="${not empty teammate}">
                <%-- 내용을 반복해서 보여줌 --%>
                <c:forEach items="${teammate}" var="teammate">
                    <tr class="teammate-row" data-teammate-id="${teammate.tmId}">
                            <%--      삭제기능, if 필요      --%>
                        <td>
                            <c:choose>
                                <c:when test="${teammate.role eq 'PM'}">
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox"
                                           class="target-teammate-id"
                                           name="targetTeammateId"
                                           value="${teammate.prjTmId}"
                                           id="${teammate.prjTmId}">
                                    <label for="${teammate.prjTmId}"></label>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${teammate.employeeVO.departmentVO.deptName}</td>
                        <td>${teammate.role}</td>
                        <td>${teammate.employeeVO.empName}</td>
                        <td>${teammate.employeeVO.email}</td>
                            <%--      삭제기능, if 필요      --%>

                        <c:choose>
                            <c:when test="${teammate.role eq 'PM'}">
                                <td class="h-59">
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <button value="${teammate.prjTmId}"
                                            name="deleteTeammate"
                                            onclick="javascript:void(0);">삭제
                                    </button>

                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </c:when>
            <%-- projectList의 내용이 존재하지 않는다면 --%>
            <c:otherwise>
                <tr>
                    <td colspan="6">
                        <p>
                            등록된 팀원이 없습니다.
                        </p>
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>


    <div class="btn-group">
        <div>
            <%--해당 버튼을 누르면 팀원 등록 모달이 생김--%>
            <button id="new-teammate" onclick="javascript:void(0);">팀원 등록</button>
            <button id="delete-massive-teammate" onclick="javascript:void(0);">일괄 삭제</button>
        </div>
    </div>
</div>
</body>
</html>
