<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html lang="pt-br">
<%@ include file="./base/header.jsp"%>
<head>
<link href="../css/fundo.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file="./base/navbar.jsp"%>

	  <div class="slider">

		<ul class="slides">
			<li><img src="css/img/sustentabilidade.jpg"> 
				<div class="caption center-align">
					<h3>Tecnologia e Sustentabilidade</h3>
				</div></li>
			<li><img src="css/img/3d.jpeg"> 
				<div class="caption left-align">
					<h3>Ultilizando a tecnologia</h3>
				</div>
			<li><img src="css/img/foto001.jpg"> 
				<div class="caption center-align">
					<h3>Preservando a natureza!</h3>

				</div></li>
		</ul>
	</div>
	
	
	<div class="row container">
	<section class=" grey darken-2 col s12 m12 l12 card-panel hoverable">
	<article class="col s12 l4 ">
	<div class="card">
        <div class="card-image">
          <img src="css/img/3d.jpeg">
        
        </div>
        <div class="card-content">
          <span class="card-title">Card Title</span>
          <p>I am a very simple card. I am good at containing small bits of information.
          I am convenient because I require little markup to use effectively.</p>
        </div>
        
      </div>
	</article>
		<article class="col s12 l4">
	<div class="card">
        <div class="card-image">
          <img src="css/img/3d.jpeg">
        
        </div>
        <div class="card-content">
          <span class="card-title">Card Title</span>
          <p>I am a very simple card. I am good at containing small bits of information.
          I am convenient because I require little markup to use effectively.</p>
        </div>
       
      </div>
	</article>
		<article class="col s12 l4">
	<div class="card">
        <div class="card-image">
          <img src="css/img/3d.jpeg">
        
        </div>
        <div class="card-content">
          <span class="card-title">Card Title</span>
          <p>I am a very simple card. I am good at containing small bits of information.
          I am convenient because I require little markup to use effectively.</p>
        </div>
        
      </div>
	</article>

	</section>
	</div>	
	<div class="row container ">
	<section class=" grey darken-2  col s12 m12 l12 card-panel hoverable">
	<article class="col s12 l12">
	<h5 class="center-align ">UM POUCO SOBRE NÓS</h5> 
	<img src="css/img/logo2.png" class=" responsive-img">
	  <p class="flow-text center-alignfont-weight: bold;
        font-size: 30px;
        font-family: arial, sans-serif; ">O projeto surgiu visando questões ambientais e a implementação de novas tecnologias com o intuito de preservar a natureza.
    O  nosso objetivo e  produzir através do  plástico reciclável um utensilio decorativo com o auxílio de uma máquina 3D. 
 
          
         </p>
          
</article>
</section>
</div>
	<!-- <div class="col s12 m8 offset-m2 l6 offset-l3"> -->
		<!-- <div class="card-panel grey lighten-5 z-depth-1 ">
			 <div class="row valign-wrapper grey lighten-1 lighten-3">
				<div class="col l10">
					<img src="css/img/2.jpg" alt="" class="circle responsive-img">
					
				</div>
				<div class="col l10">
					<img src="css/img/4.jpg" alt="" class="circle responsive-img">
					
				</div>
				<div class="col l10">
					<img src="css/img/1.jpg" alt="" class="circle responsive-img">
					
				</div>
				<div class="col l10">
					<img src="css/img/3.jpg" alt="" class="circle responsive-img">
					
				</div> -->


			</div>
		</div>


	<%@ include file="./base/scripts.jsp"%>
</body>
</html>