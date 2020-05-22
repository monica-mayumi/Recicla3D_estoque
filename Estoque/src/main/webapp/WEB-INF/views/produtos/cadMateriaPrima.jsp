<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<%@ include file="../base/header.jsp"%>
<body>
	<%@ include file="../base/navbar.jsp"%>
	<div class="container">
		<br>
		<f:form action="${s:mvcUrl('salvarProdutoUrl').build()}" method="post"
			modelAttribute="produto">

			<a class="btn-small green " title="alterar"
				href="${s:mvcUrl('detalharProdutoUrl').build()}"><i
				class="material-icons">edit</i></a>
			<div class="card">
				<div class="card-content">
					<span class="card-title center-align">Cadastro Meteria Prima</span>

					<div class="row" hidden="">
						<div class="input-field col s12">
							<label>ID</label> <input type="text" name="id" id="id"
								value="${cadMateriaPrima.id}" />
						</div>
					</div>

					<div class="row">
						<div class="input-field col s12">
							<label>Descrição</label> <input type="text" name="descricao"
								id="descricao" class="validate"
								value="${cadMateriaPrima.descricao}" />
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<label>Custo unitario</label> <input type="number"
								name="custoUnitario" id="custoUnitario"
								value="${cadMateriaPrima.custoUnitario}" />
						</div>
						<div class="row">
							<div class="input-field col s10">
								<label>Categoria</label> <input type="text" name="categoria"
									id="categoria" value="${cadMateriaPrima.categoria}" />
							</div>
							<!--
							<div class="input-field col s10">
								<label>Id fornecedor</label> <input type="number"
									name="fornecedor_input" id="fornecedor_input" />
							
         -->
							<div class="row">

								<div class="input-field col s10">

									<select name="fornecedor" id="fornecedor" required>
										<c:forEach var="fornec" items="${fornecedorList}">
											<option value="${fornec.id}">${fornec.nomeEmpresa}"</option>

										</c:forEach>
										<label>Selecione o fornecedor</label>
									</select>
								</div>
							</div>
							<div class="card-action">
								<input class="btn-small green" type="submit" value="Salvar">
							</div>
						</div>
					</div>
				</div>
		</f:form>
	</div>

	<c:if test="${listaPaginada.hasContent()}">
		<div class="row">
			<div class="col s12">
				<ul class="pagination">
					<li class="${listaPaginada.hasPrevious() ? '' : 'disabled'}">
						<c:if test="${listaPaginada.hasPrevious()}">
							<a href="?busca=${busca}&pagina=${listaPaginada.getNumber()}"><i
								class="material-icons">chevron_left</i></a>
						</c:if> <c:if test="${!listaPaginada.hasPrevious()}">
							<a href="#"><i class="material-icons">chevron_left</i></a>
						</c:if>
					</li>

					<c:forEach var="cont" begin="0"
						end="${listaPaginada.getTotalPages()-1}">
						<li class="${cont==listaPaginada.getNumber() ? 'active' : ''}">
							<a href="?busca=${busca}&pagina=${cont+1}">${cont+1}</a>
						</li>
					</c:forEach>

					<li class="${listaPaginada.hasNext() ? '' : 'disabled'}"><c:if
							test="${listaPaginada.hasNext()}">
							<a href="?busca=${busca}&pagina=${listaPaginada.getNumber()+2}"
								rel="next"><i class="material-icons">chevron_right</i></a>
						</c:if> <c:if test="${!listaPaginada.hasNext()}">
							<a href="#" rel="next"><i class="material-icons">chevron_right</i></a>
						</c:if></li>
				</ul>
			</div>
		</div>
	</c:if>

	<%@ include file="../base/scripts.jsp"%>
</body>
</html>