<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container center aling">
		<div>
			<h4>Dados do Usuário</h4>
		</div>
		<div>
		<fmt:parseDate value="${registro.dataNascimento}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
		<table>
		
			 <thead>
				<tr>
					<th>ID:</th>
					<td>${registro.id}</td>
				</tr>
				<tr>
					<th>Login:</th>
					<td>${registro.username}</td>
				</tr>
				<tr>
					<th>Nome:</th>
					<td>${registro.nomeCompleto}</td>
				</tr>
				<tr>
					<th>email:</th>
					<td>${registro.email}</td>
				</tr>
				<tr>
					<th>Nascimento:</th>
					<td><fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy"/></td>
				</tr>
				</thead>
				</table>
				</div>
		<!-- <div>
			<fmt:parseDate value="${registro.dataNascimento}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
			<ul>
				<li>Id: ${registro.id}</li>
				<li>Login: ${registro.username}</li>
				<li>Nome: ${registro.nomeCompleto}</li>
				<li>email: ${registro.email}</li>
				<li>Nascimento: <fmt:formatDate value="${parsedDate}" pattern="dd/MM/yyyy"/></li>
			</ul>
		</div> -->
		<br>
		<br>
		<div class="center aling">
			<a class="btn-small red darken-2" href="${s:mvcUrl('listarUsuarioUrl').build()}">voltar</a>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>