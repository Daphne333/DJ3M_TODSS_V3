/*

Als de pagina wordt gestart doe dit:
als eerst gaan we de header/footer toevoegen op de pagina*/
$(document).ready(function(){
	  var rol = document.getElementById("rol").value;

	 

	  SetMenu();
	  //SetHomePage();
	  $('#header').load("./standard/header.jsp"); 
	  /*	  $("#footer").load("../standard/footer.html"); */

});

/*end of page startup*/


/*============================================================
	WORDT NIET GEBRUIKT!!!! HET GAAT NU VIA DE SERVER IPV JAVASCRIPT
	ANDERS KAN ER GEEN DATA WORDEN GETOONT DIE WE UIT DE DATABASE MOETEN HALEN
============================================================*/

function menuClick(clicked_id){
		
	var rol = document.getElementById("rol").value;
	
	/*end of animation*/
	var end ='webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
	
	//laden van de content
	$('#content').load("../" + rol + "/"+ clicked_id + ".jsp");
	
	//voeg animatie toe
	//animation is a random number between 1-4
/*	RandomAnimation();*/
	$("#content").addClass('animated fadeInDown').one(end, function(){
		//verwijder animatie
		$('#content').removeClass('fadeInDown');
	});
}






/*to set the corresponding menu based on your role*/
function SetMenu(){

	
	var rol = document.getElementById("rol").value;
	if(rol != "" || rol != null){
		switch(rol){
		case "DOCENT":
				$('#menu').load("./standard/Menu_Docent.html");
				break;
		case "MANAGER":
				$('#menu').load("./standard/Menu_Manager.html");
					break;
		case "BEHEERDER":
			  	$('#menu').load("./standard/Menu_Beheerder.html");
			  		break;
		case "CURSIST":
			  	$('#menu').load("./standard/Menu_Cursist.html");
			  		break;
		}	
	}	
}

