<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container center aling">
		<div>
			<h4>Dados do Perfil</h4>
		</div>
		<div>
		<table>
			 <thead>
				<tr>
					<th>ID:</th>
					<td> ${registro.authority}</td>
				</tr>
				<tr>
					<th>Descrição:</th>
					<td>${registro.descricao}</td>
				</tr>
				</thead>
				</table>
				
			<!-- <ul>
				<li>Id: ${registro.authority}</li>
				<li>Descrição: ${registro.descricao}</li>
			</ul>
		</div>
		<div> --> 
		<br>
		<br>	
			<a class="btn btn-warning center aling  red darken-2" href="${s:mvcUrl('listarPerfilUrl').build()}">voltar</a>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>