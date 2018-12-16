<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>综合查询</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/linkman_moreCondition.action"
		method=post>
		

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：综合查询 &gt; 客户信息查询</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>联系人名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="lkm_name" value="${linkman.lkm_name }">
								</td></tr><tr>
								<td>性别 ：</td>
								<td>
									<select name="lkm_gender">
										<c:choose>
											<c:when test="${linkman.lkm_gender eq '男' }">
												<option value="男" selected="selected">男</option>
												<option value="女">女</option>
												<option value="">-请选择-</option>
											</c:when>
											<c:when test="${linkman.lkm_gender eq '女' }">
												<option value="男">男</option>
												<option value="女" selected="selected">女</option>
												<option value="">-请选择-</option>
											</c:when>
											<c:otherwise>
												<option value="男">男</option>
												<option value="女">女</option>
												<option selected="selected" value="">-请选择-</option>
											</c:otherwise>
										</c:choose>
									</select>
								</td>
							</TR>
							
							<TR>
								
								<td>所属客户 ：</td>
								<td>
									<select name="customer.cid">
										<option value="">-请选择-</option>
										<c:forEach items="${customerList }" var="customer">
											<c:choose>
												<c:when test="${customer.cid eq linkman.customer.cid }">
													<option value="${customer.cid }" selected="selected">${customer.custName }</option>
												</c:when>
												<c:otherwise>
													<option value="${customer.cid }">${customer.custName }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value="查询" name=sButton2>
								</td>
							</tr>
						</TABLE>
						<table id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
							<tr style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
								<td>联系人名称</td>
								<td>性别</td>
								<td>办公电话</td>
								<td>所属客户</td>
							</tr>
							<c:forEach items="${linkmanList }" var="linkman">	
								<tr style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
											
										<TD>${linkman.lkm_name }</TD>
										<TD>${linkman.lkm_gender }</TD>
										<TD>${linkman.lkm_phone }</TD>
										<TD>${linkman.customer.custName }</TD>
								</tr>
							</c:forEach>
						</table>
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
