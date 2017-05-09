/*

Als de pagina wordt gestart doe dit:
als eerst gaan we de header/footer toevoegen op de pagina*/
$(document).ready(function(){

	 
	  $('#header').load("../standard/header.html"); 
/*	  $("#footer").load("../standard/footer.html"); */

	  SetMenu();
	 
});


/*to set the corresponding menu based on your role*/
function SetMenu(){

	
	var rol = document.getElementById("rol").value;
	if(rol != "" || rol != null){
		switch(rol){
		case "docent":
			  $('#menu').load("../standard/Menu_Docent.html"); 
		case "manager":
			  $('#menu').load("../standard/Menu_Manager.html");
		case "bedrijf":
			  $('#menu').load("../standard/Menu_Bedrijf.html");
		case "cursist":
			  $('#menu').load("../standard/Menu_Manager.html");
		}
	
	}
	
}


