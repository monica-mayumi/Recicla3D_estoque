<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<%@ include file="../base/header.jsp"%>

<body>
	<%@ include file="../base/navbar.jsp"%>
	<div class="container center aling ">
		<div>
			<h4>Dados do Fornecedor</h4>
		</div>
	
			<table>
			 <thead>
				<tr>
					<th>ID:</th>
					<td>${fornecedor.id}</td>
				</tr>
				<tr>
					<th>Razão Social:</th>
					<td>${fornecedor.razaoSocial}</td>
				</tr>
				<tr>
					<th>Nome Empresa:</th>
					<td>${fornecedor.nomeFantasia}</td>
				</tr>
				<tr>
					<th>CNPJ:</th>
					<td class="fmt-cnpj">${fornecedor.cnpj}</td>
				</tr>
				</thead>
			</table>
			
			<br> <br>
			<div>
				<a class="btn btn-warning red darken-2 "
					href="${s:mvcUrl('listarFornecedorUrl').build()}">voltar</a>
			</div>
		
		<%@ include file="../base/scripts.jsp"%>
</body>
</html>