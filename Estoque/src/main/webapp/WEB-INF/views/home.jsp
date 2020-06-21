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
						<img src="css/img/lixo02.jpg">

					</div>
					<div class="card-content">
						<span class="card-title">Brasil é o 4º pais do mundo que
							mais gera lixo plástico.</span>
					</div>
					<div class="card-action">
						<a
							href="https://www.wwf.org.br/?70222/Brasil-e-o-4-pais-do-mundo-que-mais-gera-lixo-plastico">Organização
							WWF</a>
					</div>

				</div>
			</article>
			<article class="col s12 l4">
				<div class="card">
					<div class="card-image">
						<img src="css/img/plasticoOceano.jpg">

					</div>
					<div class="card-content">
						<span class="card-title">Casal americano cria próteses de
							mão com plástico retirado do mar.</span>

					</div>
					<div class="card-action">
						<a
							href="https://www.reciclasampa.com.br/artigo/casal-americano-cria-proteses-de-mao-com-plastico-retirado-do-mar">Reciclasampa</a>
					</div>
				</div>
			</article>
			<article class="col s12 l4">
				<div class="card">
					<div class="card-image">
						<img src="css/img/startup01.jpg">

					</div>
					<div class="card-content">
						<span class="card-title">Inovação sustentável : Conheça 8
							startups de sustentabilidade.</span>
					</div>
					<div class="card-action">
						<a
							href="https://inovacaosebraeminas.com.br/inovacao-sustentavel-conheca-8-startups/">SEBRAE</a>
					</div>

				</div>
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