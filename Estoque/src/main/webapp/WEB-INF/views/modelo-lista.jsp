<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<%@ include file="../base/header.jsp" %>
	
	<body>
		<%@ include file="../base/navbar.jsp" %>
		
		<div class="container">
			<br>

			<c:if test="${mensagemStatus != null}">
				<div class="green">
					<p>${mensagemStatus}</p>
				</div>
			</c:if>
		
			<div class="row">
				<div class="input-field col s3">
					<h5>Titulo</h5>
				</div>
				
					<div class="input-field col s5">
						<input id="busca" name="busca" id="search" type="text" placeholder="Pesquisar por Descrição" value="${busca}" >
					</div>
					<div class="input-field col s1">
						<button class="btn-small" type="submit"><i class="material-icons">search</i></button>
					</div>
					
				<div class="input-field col s3">
					<a class="btn-floating btn-large waves-effect waves-light red right" title="novo" href="#" >
						<i class="material-icons">add</i>
					</a>
				</div>
			</div>			
			
				<div class="row">
					<div class="responsive-table col s12">
						<table id="tabProdutos">
							<thead>
								<tr>
									<th>Id</th>
									<th>Item 1</th>
									<th>Item 2</th>
									<th>Item 3</th>
									<th>Item 4</th>
									<th class="center-align">Ações</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>																			
									<td></td>
									<td class="center-align" >
										<a class="btn-small green" title="alterar" href="${s:mvcUrl('alterarProdutoUrl').arg(0, registro.id).build()}"><i class="material-icons">edit</i></a>
										<a class="btn-small" title="detalhes"  href="${s:mvcUrl('detalharProdutoUrl').arg(0, registro.id).build()}"><i class="material-icons">more_horiz</i></a>
										<button class="btn-small red modal-excluir" title="excluir" type="button" data-target="modalExcluir" data-descr="${registro.descricao}"  >
											<i class="material-icons">delete</i>
										</button>
									</td>
								</tr>			
							</tbody>	
						</table>
					</div>
				</div>
				<%@ include file="../base/paginacao.jsp" %>	
			
		</div>
		<%@ include file="../base/modalExcluir.jsp" %>	
	</body>
	<%@ include file="../base/scripts.jsp" %>
</html>