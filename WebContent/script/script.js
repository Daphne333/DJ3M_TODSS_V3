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



function changeCursistProfile(){
	$('#profiel-section-wijzig').fadeIn(1000);

}

function CloseProfileWindow(){
	$('#profiel-section-wijzig').fadeOut(500);
}
