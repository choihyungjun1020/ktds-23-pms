<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �� ������</title>
<jsp:include page="../commonheader.jsp" />
</head>
<body>
	<h1>���� ��ȸ</h1>
    <div class="grid" data-id="${memoVO.memoId}">
      <label for="name">���� ���</label>
      <div>${memoVO.rcvId}</div>

      <label for="crtDt">���� ��¥</label>
      <div>${memoVO.crtDt}</div>

      <label for="content">����</label>
      <div>${memoVO.memoCntnt}</div>

        <div class="btn-group">
          <div class="right-align">
            
            <a class="delete-board" href="javascript:void(0);">����</a>
          </div>
        </div>
    </div>
</body>
</html>