<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<meta charset="ISO-8859-1">
<%@ include file="../base/header.jsp"%>
<body>
	<%@ include file="../base/navbar.jsp"%>
	<div class="container">
		<br>
		<f:form action="${s:mvcUrl('salvaFornecedorUrl').build()}"
			method="post" modelAttribute="fornecedor">
			<a class="btn-small green " title="alterar"
				href="${s:mvcUrl('alterarFornecedorUrl').build()}"><i
				class="material-icons">edit</i></a>
			<div class="card">
				<div class="card-content">
					<span class="card-title center-align">Cadastro Fornecedor</span>
					<div class="row" hidden="">
						<div class="input-field col s12">
							<label>ID</label> <input type="text" name="id" id="id"
								value="${CadastroFornecedor.id}" />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s8">
							<label>Nome Empresa</label> <input type="text" name="nomeEmpresa"
								id="nomeEmpresa" class="nomeEmpresa"
								value="${CadastroFornecedor.nomeEmpresa}" />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s8">
							<label>Email</label> <input type="text" name="fornecedorEmail"
								id="fornecedorEmail"
								value="${CadastroFornecedor.fornecedorEmail}" />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<label>CNPJ</label> <input type="text" name="cnpj" id="cnpj"
								value="${CadastroFornecedor.cnpj}" />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<label>Telefone Comercial</label> <input type="text" type="text"
								name="telefoneComercial" id="telefoneComercial"
								value="${CadastroFornecedor.telefoneComercial}" />
						</div>
					</div>
					<div class="input-field col s10"></div>
				</div>
				<div class="card-action">
					<input class="btn-small green" type="submit" value="Salvar">
				</div>
			</div>
		</f:form>
	</div>

	<%@ include file="../base/scripts.jsp"%>

</body>
</html>