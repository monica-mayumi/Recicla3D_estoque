<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<%@ include file="../base/header.jsp"%>
	<body>
		<%@ include file="../base/navbar.jsp"%>
	
		<div class="container">			
			<br>			
			<f:form action="#" method="post" modelAttribute="#">
				
				<div class="row">
					<div class="col s12">
						
						<div class="card">
							<div class="card-content">
								<span class="card-title center-align">Cadastro</span>
							
								<div class="row">
									<div class="input-field col s12">
									
									</div>
								</div>	
								
								<div class="row">
									<div class="input-field col s6">
									</div>
									
									<div class="input-field col s6">
									</div>						
								</div>
								
								<div class="row">
									<div class="input-field col s10">
									</div>								
									
									<div class="input-field col s2">
									</div>
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
	
		<%@ include file="../base/scripts.jsp"%>
		
	</body>
</html>
