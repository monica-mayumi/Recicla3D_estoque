<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<f:form action="#" method="POST" modelAttribute="recebimentoForm">
	<div id="dadosRegistro">
		<table class="responsive-table">
		    <thead>
			    <tr>
				    <th style="width:400px;">Produto</th>
				    <th>Quantidade</th>
				    <th>Valor Unitário</th>
				    <th>Valor Total</th>									
			    </tr>											
		    </thead>
		    <tbody>
		    	<c:forEach items="${recebimentoForm.itens}" var="itemReceb" varStatus="status" >
		    		<tr>
		    			<f:hidden path="itens[${status.index}].produto"/>
		    			<f:hidden path="itens[${status.index}].valorTotal"/>
                        <f:hidden path="itens[${status.index}].quantidade"/>
                        <f:hidden path="itens[${status.index}].precoUnitario"/>
		    			<td>${itemReceb.produto.descricao}</td>
		    			<td>
		    				<fmt:formatNumber value="${itemReceb.quantidade}" type="number"/>
		    			</td>
		    			<td>
		    			<fmt:formatNumber value="${itemReceb.precoUnitario}" type="currency"/>
		    				    				
		    			</td>
		    			<td class="right-align vlrTotal">
		    				<fmt:formatNumber value="${itemReceb.valorTotal}" type="currency"/>
		    			</td>
		    		</tr>
		    	</c:forEach>		
		    </tbody>
	    </table>									
	</div>
</f:form>