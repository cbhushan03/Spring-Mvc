/* use strict */

var app=angular.module("ServiceApp",[])

.controller("testCtrl",function($scope,$http){
	$http.get('http://localhost:8081/SpringRest/user').
	then(function(response) {
		console.log(response.data);
        $scope.serviceData = response.data;
    });
	
	$scope.ButtonClick = function () {
		console.log( $scope.idName);
		
		$http.get('http://localhost:8081/SpringRest/user',JSON.stringify($scope.idName)).
		then(function(response) {
			console.log(response.data);
	        $scope.serviceData = response.data;
	    });
	}
})
