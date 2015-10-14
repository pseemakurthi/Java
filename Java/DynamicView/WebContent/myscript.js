

var dynamicViewsApp= angular.module('dynamicViews',['ngRoute']);


dynamicViewsApp.config(function($routeProvider){
	$routeProvider
	
	.when('/stocks',{templateUrl:'stocks.html',controller:'stockController'})
	.when('/graph',{templateUrl:'graph.html', controller:'graphController'})
	.when('/order',{templateUrl:'order.html', controller:'orderController'});
	
});



dynamicViewsApp.controller('mainController', function($scope){
	$scope.message="test";
});


dynamicViewsApp.controller('stockController',function($scope){
	$scope.message = "Im stocks controller";
});


dynamicViewsApp.controller('graphController',function($scope){
	$scope.message = "Im graph controller;";
	
});

dynamicViewsApp.controller('orderController',function($scope){
	
	$scope.message = "Im options controller;"
})