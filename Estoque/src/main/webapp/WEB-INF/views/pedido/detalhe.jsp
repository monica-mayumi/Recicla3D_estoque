<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container center aling ">
	<div class="row">
			<div class="col s12">
				<h4>Pedido de Compra Nº ${registro.id}</h4>
			</div>
		</div>
			<div>
				<fmt:parseDate value="${registro.dataEntrega}" pattern="yyyy-MM-dd" var="dataModificada" type="date" />
	<table>
			 <thead>
				<tr>
					<th>Fornecedor:</th>
					<td>${registro.fornecedor.razaoSocial}</td>
				</tr>
				<tr>
				<th>Previsão Entrega:</th>
					<td><fmt:formatDate value="${dataModificada}" pattern="dd/MM/yyyy" /></td>
				</tr>
				<tr>
				<th>Condição de Pagamento:</th>
					<td>${registro.condicaoPagamento.displayValue}</td>
				</tr>
				<tr>
				<th>Status:</th>
					<td>${registro.status.displayValue}</td>
				</tr>
				<tr>
				<th>Valor Total:</th>
					<td><fmt:formatNumber value="${registro.valorTotal}" type="currency"/></td>
				</tr>
				</thead>
				</table>
				</div>
		
		<!-- <div class="row">
			<div class="col s12">
				<fmt:parseDate value="${registro.dataEntrega}" pattern="yyyy-MM-dd" var="dataModificada" type="date" />
				<ul>
					<li><Strong>Fornecedor:</Strong> ${registro.fornecedor.razaoSocial}</li>
					<li><Strong>Previsão Entrega:</Strong> <fmt:formatDate value="${dataModificada}" pattern="dd/MM/yyyy" /></li>
					<li><Strong>Condição de Pagamento:</Strong> ${registro.condicaoPagamento.displayValue}</li>
					<li><Strong>Status:</Strong> ${registro.status.displayValue}</li>
					<li><Strong>Valor Total:</Strong> <fmt:formatNumber value="${registro.valorTotal}" type="currency"/></li>
				</ul>			
			</div>		
		</div>	 -->
			
		<div class="row">
			<div class="col s12 responsive-table">
				<table>
					<thead>
						<tr>
							<th>Produto</th>
							<th>Descrição</th>
							<th>Valor Unit.</th>
							<th>Qtde.</th>
							<th>Total</th>
						</tr>						
					</thead>
					<tbody>
						<c:forEach items="${registro.itens}" var="itemPed">
							<tr>
								<td>${itemPed.produto.id}</td>
								<td>${itemPed.produto.descricao}</td>
								<td><fmt:formatNumber value="${itemPed.precoUnitario}" type="currency"/></td>
								<td>${itemPed.quantidade}</td>
								<td><fmt:formatNumber value="${itemPed.precoTotal}" type="currency"/></td>
							</tr>						
						</c:forEach>						
					</tbody>				
				</table>
			</div>
		</div>
		
		<div>
			<a class="btn btn-warning red darken-2" href="${s:mvcUrl('listarPedidoCompraUrl').build()}">voltar</a>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp"%>
</body>

</html>