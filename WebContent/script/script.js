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


var animation;

function RandomAnimation(){
	var random = Math.floor(Math.random() * 4) + 1; 
	
	switch(random){
	case 1:
		animation= "fadeInDown";
		break;
	case 2:
		animation= "fadeInLeft";
		break;
	case 3:
		animation= "fadeInRight";
		break;
	case 4:
		animation= "fadeInUp";
		break;
	}	
}

/*works with all buttons in the different menu's
loads corresponding content and places it into the div with id="#content"*/
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


/*
werkt niet?*/

/*$('#right1').hover(function() {
	alert('dfgbhujilfbhuji');
	    $('#left1').css('width','28%');
	    $('#right1').css('width', '68%');
	  }, function() {
	    // on mouseout, reset the background color
	    $('#left1').css('width', '68%');
	    $('#right1').css('width', '28%');
 });
*/

/*
werkt niet?*/
		
		
		
/*$(".right1").on({
    mouseenter: function () {
    	alert('awrg');
        //stuff to do on mouse enter
    	$(".left1").css('width','28%');
	    $(".right1").css('width', '68%');
    },
    mouseleave: function () {
        //stuff to do on mouse leave
	    $(".left1").css('width', '68%');
	    $(".right1").css('width', '28%');
    }
});*/