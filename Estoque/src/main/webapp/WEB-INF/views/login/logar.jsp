<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<meta charset="ISO-8859-1">
	<%@ include file="../base/header.jsp"%>
	<body>
	<%@ include file="../base/navbar.jsp" %>
		<div class="container"> 
			<div class="row">
				<div class="col s6 offset-s3">
					<!--<c:if test="${param != null}">
						<p>Login ou senha invalidos</p>					
					</c:if>-->
					
					<c:if test="${msgSenha != null}">
						<p>${msgSenha}</p>					
					</c:if>
					
					
					<div class="card">
						<div class="card-content">
							<span class="card-title">Entrar no Sistema</span>
							
							<f:form class="form-signin" action="${s:mvcUrl('loginUrl').build()}" method="POST" >
								<label for="inputUsername" class="sr-only">Login</label>
								<input id="inputUsername" name="username" placeholder="login" required autofocus>
								
								<label for="inputPassword" class="sr-only">Senha</label>
								<input type="password" name="password" id="inputPassword" placeholder="senha" required>
								
						  		<button class="btn waves-effect waves-light black" type="submit">
						  			Entrar<i class="material-icons right">send</i>
						  		</button>
							</f:form>	
							
							<br>
							<a href="${s:mvcUrl('recupSenhaFormUrl').build()}">Esqueceu a senha?</a>						
						</div>
					
					</div>
				 
				</div>			
			</div>
		</div>
	</body>	
	<%@ include file="../base/scripts.jsp" %>
</html>