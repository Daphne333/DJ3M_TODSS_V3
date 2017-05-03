


var myapp = angular.module("module",[]);

var mycontroler =function($scope){
	$scope.message = "angular tut";
}

$(document).ready(function(){ 
  $.get("header.html", function(data) {
    $("#header").html(data);
  });
});