$(document).ready(function() {
	$('.sidenav').sidenav();
	$(".dropdown-trigger").dropdown();	 
	$('ul.tabs').tabs();
	$('select').formSelect();
	$('.modal').modal();
});

//mascaras para dados e inputs
$(".fmt-cnpj").mask("00.000.000/0000-00");
$(".fmt-cpf").mask("000.000.000-00");
$(".fmt-cep").mask("00000-000");

