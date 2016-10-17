<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示商品</title>
</head>
<body>
	<table border="1">
		<caption align="top" style="color:red;font-size:20px">商品管理系统</caption>
		<tr>
			<td colspan="5">
				<a href="add">添加商品</a>
				<span style="margin-left:80px;">查询</span>
				<select id="checked" name="type">
					<option value="-1">请选择</option>
					<option value="0">已上架</option>
					<option value="1">已下架</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>商品名称</td>
			<td>价格</td>
			<td>录入时间</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<tbody>
			<s:iterator value="vipUsersList">
				<tr>
					<td><s:property value="item_name"/></td>
					<td><s:property value="item_price"/></td>
					<td><s:date format="yyyy-MM-dd" name="create_time"/> </td>
					<td><s:property value="%{status == 0 ? '已上架' : '已下架'}"/></td>
					<td>
						<s:if test="status == 0">
							<a href="update.html?vipUsers.item_id=<s:property value='item_id' />&vipUsers.status=<s:property value="status" />">下架</a>
						</s:if>
						<s:else>
							<a href="update.html?vipUsers.item_id=<s:property value="item_id" />&vipUsers.status=<s:property value="status" />">上架</a>
						</s:else>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<script type="text/javascript">
		var sel = document.getElementById("checked");
		sel.onchange = function (){
			location.href = "${pageContext.request.contextPath }/product/getUpOrDnAll.html?status=" + this.value;
		}
	</script>
</body>
</html>