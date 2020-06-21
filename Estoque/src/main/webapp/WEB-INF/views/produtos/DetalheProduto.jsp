<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container">
		<div>
			<h4>Dados do Produto</h4>
		</div>
		<div>
		<table>
			 <thead>
				<tr>
					<th>ID:</th>
					<td>${produto.id}</td>
				</tr>
				<tr>
					<th>Descrição:</th>
					<td>${produto.descricao}</td>
				</tr>
				<tr>
					<th>Categoria:</th>
					<td>${produto.categoria}</td>
				</tr>
				<tr>
					<th>Validade:</th>
					<td>${produto.validade}</td>
				</tr>
				</thead>
				</table>
			<!-- <ul>
				<li>Id: ${produto.id}</li>
				<li>Descrição: ${produto.descricao}</li>
				<li>Categoria: ${produto.categoria}</li>
				<li>Validade: ${produto.validade}</li>
			</ul>
		</div> 
		-->
		<br>
		<br>
		<div class="center aling">
			<a class="btn-small red darken-2 " href="${s:mvcUrl('listarProdutoUrl').build()}">voltar</a>
		</div>
	</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>