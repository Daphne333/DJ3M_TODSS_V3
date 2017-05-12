/*

Als de pagina wordt gestart doe dit:
als eerst gaan we de header/footer toevoegen op de pagina*/
$(document).ready(function(){
	  var rol = document.getElementById("rol").value;

	 

	  SetMenu();
	  SetHomePage();
	  $('#header').load("../standard/header.jsp"); 
	  /*	  $("#footer").load("../standard/footer.html"); */
	  
	  


});

/*end of page startup*/



/*works with all buttons in the different menu's
loads corresponding content and places it into the div with id="#content"*/
function menuClick(clicked_id){
		
	var rol = document.getElementById("rol").value;
	var end ='webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
	
	//laden van de content
	$('#content').load("../" + rol + "/"+ clicked_id + ".jsp");
	//voeg animatie toe
	$("#content").addClass('animated fadeInDown').one(end, function(){
		//verwijder animatie
		$('#content').removeClass('fadeInDown');
	});

};


/*to set the corresponding menu based on your role*/
function SetMenu(){

	
	var rol = document.getElementById("rol").value;
	if(rol != "" || rol != null){
		switch(rol){
		case "Docent":
				$('#menu').load("../standard/Menu_Docent.html");
				
					break;
		case "Manager":
				$('#menu').load("../standard/Menu_Manager.html");
					break;
		case "Bedrijf":
			  	$('#menu').load("../standard/Menu_Bedrijf.html");
			  		break;
		case "Cursist":
			  	$('#menu').load("../standard/Menu_Cursist.html");
			  		break;
		}	
	}	
}



function SetHomePage(){
	
	var rol = document.getElementById("rol").value;

	
	if(rol != "" || rol != null){
		$('#content').load("../" + rol + "/"+ rol +"_Home.jsp");
	}
}


/*$('#rechts1').

*/
