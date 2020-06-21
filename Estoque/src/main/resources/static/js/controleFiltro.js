function myFunction(IdHtml) {

	var linhaRS = 'RS';
	var linhaDTE = 'DT';
	var limpa = 'limpa';

	console.log(IdHtml);

	var compara1 = IdHtml.localeCompare(linhaRS);
	var compara2 = IdHtml.localeCompare(linhaDTE);
	var compara3 = IdHtml.localeCompare(limpa);

	console.log("------" + compara1);
	console.log("======" + compara2);
	console.log("//////" + compara3);
	if (compara3 == 0 ){ //IdHtml.localeCompare(limpa)) {
		console.log("Limpa" + IdHtml);
		document.getElementById('linhaRS').style.display = "none";
		document.getElementById('linhaDTE').style.display = "none";
	} else if (compara2 == 0) { //IdHtml.localeCompare(linhaDTE)) {
		console.log("DT" + IdHtml);
		document.getElementById('linhaRS').style.display = "none";
		document.getElementById('linhaDTE').style.display = "block";
	} else if (compara1 == 0) { //IdHtml.localeCompare(linhaRS)) {
		console.log("RS" + IdHtml);
		document.getElementById('linhaRS').style.display = "block";
		document.getElementById('linhaDTE').style.display = "none";
	} else {
		document.getElementById('linhaRS').style.display = "block";
		document.getElementById('linhaDTE').style.display = "block";
	} 
	

//		
	document.getElementById('LinhaSelect').style.display = "block";
}