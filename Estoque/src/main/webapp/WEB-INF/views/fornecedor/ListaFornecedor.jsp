<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<%@ include file="../base/header.jsp"%>

<body>
	<%@ include file="../base/navbar.jsp"%>

	<div class="container">
		<br>

		<c:if test="${mensagemStatus != null}">
			<div class="green">
				<p>${mensagemStatus}</p>
			</div>
		</c:if>

		<div class="row">
			<div class="input-field col s3">
				<h5>Fornecedor</h5>
			</div>

			<div class="input-field col s5">
				<input id="busca" name="busca" id="search" type="text"
					placeholder="Pesquisar por Descrição" value="${busca}">
			</div>
			<div class="input-field col s1">
				<button class="btn-small" type="submit">
					<i class="material-icons">search</i>
				</button>
			</div>

			<div class="input-field col s3">
				<a class="btn-floating btn-large waves-effect waves-light red right"
					title="novo" href="/novof"> <i class="material-icons">add</i>
				</a>
			</div>
		</div>

		<div class="row">
			<div class=" responsive-table col s12 ">
				<table id="tabProdutos">
					<thead>
						<tr>
							<th class="center-align">Id</th>
							<th class="center-align">Nome Empresa</th>
							<th class="center-align">Email</th>
							<th class="center-align">CNPJ</th>
							<th class="center-align">Telefone Comercial</th>
							<th class="center-align">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fornecedor" items="${forncedorList.content}">
							<%
								System.out.println("fornecedor = " + pageContext.findAttribute("fornecedor"));
							%>

							<tr class="center-align">
								<!-- Esta linha imprime todos os <td></td ou seja, todas as colunas de Produto-->
								<td class="center-align"><c:out value="${fornecedor.id}" /></td>
								<td class="center-align"><c:out
										value="${fornecedor.nomeEmpresa}" /></td>
								<td class="center-align"><c:out
										value="${fornecedor.fornecedorEmail}" /></td>
								<td class="center-align"><c:out value="${fornecedor.cnpj}" /></td>
								<td class="center-align"><c:out
										value="${fornecedor.telefoneComercial}" /></td>

								<td class="center-align"><a class="btn-small green"
									title="alterar"
									href="${s:mvcUrl('alterarFornecedorUrl').arg(0, fornecedor.id).build()}"><i
										class="material-icons">edit</i></a> <a class="btn-small"
									title="detalhes"
									href="${s:mvcUrl('detalharProdutoUrl').arg(0, fornecedor.id).build()}"><i
										class="material-icons">more_horiz</i></a>


									<button class="btn-small red modal-excluir" title="excluir"
										type="button" data-target="modalExcluir"
										data-descr="${fornecedor.nomeEmpresa}">
										<i class="material-icons">delete</i>
										<f:form action="${s:mvcUrl('excluirFornecedorUrl').arg(0,fornecedor.id).build()}" method="post">
										</f:form>
									</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="../base/paginacao.jsp"%>
		<div></div>
	</div>
	<%@ include file="../base/modalExcluir.jsp"%>
</body>
<%@ include file="../base/scripts.jsp"%>
</html>