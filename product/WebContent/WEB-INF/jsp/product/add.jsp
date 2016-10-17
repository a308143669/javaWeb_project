<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品录入</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/product/insert.html" method="post">
		<table border="1">
			<caption align="top" style="color:red;font-size:20px">商品录入</caption>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="vipUsers.item_name" /></td>
			</tr>
			<tr>
				<td>单价</td>
				<td><input type="text" name="vipUsers.item_price" /></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" name="vipUsers.create_time" /></td>
			</tr>
			<tr>
				<td>状态</td>
				<td>
					<label><input type="radio" name="vipUsers.status" value="0" checked >上架</label>
					<label><input type="radio" name="vipUsers.status" value="1">下架</label>
				</td>
			</tr>
			
			<tr align="right">
				<td colspan="2">
					<input type="submit" value="提交" />
					<a href='${pageContext.request.contextPath }/product/getUpOrDnAll.html'><input type="button" value="返回" /></a>
				</td>
			</tr>
		</table>
	</form>
	
	<s:if test="message != null">
		<script type="text/javascript">
			alert('${message}');
		</script>
	</s:if>
</body>
</html>