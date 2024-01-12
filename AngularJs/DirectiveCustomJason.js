
    var myApp = angular.module('myModule', []);
    myApp.controller('myCtrl', function($scope) {
        
    }).directive("welcomText", function(){
        return {
            restrict: 'A',
            template: "This is Custom directive"
            // templateUrl: 'LoopScope.html'
        }
    });