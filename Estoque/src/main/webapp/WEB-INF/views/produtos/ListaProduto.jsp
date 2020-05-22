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
				<h5>Produto</h5>
			</div>

			<f:form method="get" >
				<div class="input-field col s5">
					<input id="busca" name="busca" id="search" type="text"
						placeholder="Pesquisar por Descrição" value="${busca}">

				</div>
				<div class="input-field col s1">
					<button class="btn-small" type="submit">
						<i class="material-icons">search</i>
					</button>
				</div>
			</f:form>
			
			<div class="input-field col s3">
				<a class="btn-floating btn-large waves-effect waves-light red right"
					title="novo" href="/novo"> <i class="material-icons">add</i>
				</a>
			</div>
		</div>

		<div class="row">
			<div class="responsive-table col s12">
				<table id="tabProdutos">
					<thead>
						<tr>
							<th class="center-align">Id</th>
							<th class="center-align">Decrição</th>
							<th class="center-align">Custo Unit</th>
							<th class="center-align">Fornecedor ID</th>
							<th class="center-align">Categoria</th>
							<th class="center-align">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produto" items="${produtoList.content}">
							<%
								System.out.println("produto = " + pageContext.findAttribute("produto"));
							%>

							<tr class="center-align">
								<!--${produto} <!-- Esta linha imprime todos os <td></td ou seja, todas as colunas de Produto-->
								<td class="center-align"><c:out value="${produto.id}" /></td>
								<td class="center-align"><c:out
										value="${produto.descricao}" /></td>
								<td class="center-align"><fmt:formatNumber
										value="${produto.custoUnitario}" type="currency" /></td>
								<td class="center-align"><c:out
										value="${produto.fornecedor.id}" />
								<td class="center-align"><c:out
										value="${produto.categoria}" /></td>
								<td class="center-align"><a class="btn-small green"
									title="alterar"
									href="${s:mvcUrl('alterarProdutoUrl').arg(0, produto.id).build()}"><i
										class="material-icons">edit</i></a> <a class="btn-small"
									title="detalhes"
									href="${s:mvcUrl('detalharProdutoUrl').arg(0, produto.id).build()}"><i
										class="material-icons">more_horiz</i></a>

									<button class="btn-small red modal-excluir" title="excluir"
										type="button" data-target="modalExcluir"
										data-descr="${produto.descricao}">
										<i class="material-icons">delete</i>
										<f:form
											action="${s:mvcUrl('excluirProdutoUrl').arg(0,produto.id).build()}"
											method="post">
										</f:form>
									</button>
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