<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Member List</title>
<style>
body {
	background-color: #f0f0f0;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 10px;
}

table thead th {
	background-color: #f8fff5;
}

table tbody td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

table tbody tr:nth-child(even) {
	background-color: #f8fff5;
}

button {
	background-color: #4caf50;
	color: #ffffff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>

<body>
	<h2>���� ��ü ���</h2>
	<div>
		<table border='1' width='1200'>
			<tr>
				<td>å ����</td>
				<td>����</td>
				<td>���೯¥</td>
				<td>���ǻ�</td>
				<td>�ݾ�</td>
				<td>ī�װ�</td>
				<td>��������</td>
				<td>�Ǹŷ�</td>
			</tr>

			<%
			if (dataList == null) {
			%>
			<tr>
				<td colspan="6">ȸ�� ����� ����ֽ��ϴ�.</td>
			</tr>
			<%
			} else {
			%>
			<%
			for (String[] data : dataList) {
			%>
			<tr>
				<td><%=data[0]%></td>
				<td><%=data[1]%></td>
				<td><%=data[2]%></td>
				<td><%=data[3]%></td>
				<td><%=data[4]%></td>
				<td><%=data[5]%></td>
				<td><%=data[6]%></td>
				<td><%=data[7]%></td>
				<td>
					<form method="post" action="delete.do">
						<input type="hidden" name="id" value="<%=data[0]%>">
						<button type="submit">����</button>
					</form>
				</td>
				<td>
					<form method="post" action="update.do">
						<input type="hidden" name="id" value="<%=data[0]%>">
						<button type="submit">����</button>
					</form>
				</td>
			</tr>
			<%
			}
			%>
			<%
			}
			%>

		</table>
	</div>
	<button type="button" onclick="location.href='index.jsp'">Return
		Main</button>
</body>
</html> --%>