'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope','$http',function($scope,$http) {
    $scope.atakan = "atakanburak";


      $http.get('http://localhost:8080/api/titles').then(function (response) {
            $scope.titless = response.data;
            $scope.titlesss = response.content;

        })




}]);