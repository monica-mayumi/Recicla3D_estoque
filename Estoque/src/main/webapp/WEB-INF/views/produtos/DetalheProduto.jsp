<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<%@ include file="../base/header.jsp" %>

<body>
<c:out value=""></c:out>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container">
		<div>
			<h4>Dados Materia Prima </h4>
		</div>
		
		<div>
			<ul>
				<li>ID : ${produto.id}</li>
				<li>Descrição : ${produto.descricao}</li>
				<li>Custo Unitario : ${produto.custoUnitario}</li>
				<li>Categoria : ${produto.categoria}</li>
				<li>ID Fornecedor : ${produto.fornecedor.id}</li>
			</ul>
		</div>

		<div>
		<%//	<a class="btn btn-warning"  href="${s:mvcUrl('listarProdutoUrl'.build()}">voltar</a>  %> 
		<a class="btn btn-warning material-icons"  href="/listar">voltar</a>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>