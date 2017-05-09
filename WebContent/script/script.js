
/*als eerst gaan we de header/footer toevoegen op de pagina*/
$(document).ready(function(){
	 
	  $('#header').load("/standard/header.html"); 
/*	  $("#footer").load("../standard/footer.html"); */

	  var rol = null
	  
	  if (document.getElementById('rol') == null || documenbt.getElementById('rol') == ''){
		  alert('er moet iemand ingelogd zijn');
	  }
	  else{

		  //afhankelijk van jouw rol krijg je de desbetreffende menu-bar te zien
		  switch(rol){
			  case "docent":
				  $('#menu').load("../standand/bedrijf_menu.html");
			  case "cursist":
				  $('#menu').load("../standand/cursist_menu.html");
			  case " manager":
				  $('#menu').load("../standand/manager_menu.html");
			  case "beheerder":
				  $('#men').load("../standard/beheerder_menu.html");
		  }
	  }
});



