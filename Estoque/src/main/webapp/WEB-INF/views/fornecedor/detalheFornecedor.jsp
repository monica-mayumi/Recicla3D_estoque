<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container">
		<div>
			<h4>Dados do Fornecedor </h4>
		</div>
		
		<div>
			<ul>
				<li>ID : ${fornecedor.id}</li>
				<li>Nome Empresa : ${fornecedor.nomeEmpresa}</li>
				<li>Email : ${fornecedor.fornecedorEmail}</li>
				<li>CNPJ : ${fornecedor.cnpj}</li>
				<li>Telefone Comercial : ${fornecedor.telefoneComercial}</li>
			</ul>
		</div>
		<div>
			<a class="btn btn-warning"   href="/listarf">voltar</a>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>