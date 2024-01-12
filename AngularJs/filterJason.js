
    var myApp = angular.module('myModule', []);
    myApp.controller('myCtrl', function($scope){
        var Nhanvien = [
            {Name : 'Hung', Salary: 10000, BDate: new Date('7/27/1999')},
            {Name : 'Xuan', Salary: 90000, BDate: new Date('2/16/1999')},
            {Name : 'Trang', Salary: 80000, BDate: new Date('8/20/1999')},
            {Name : 'Thao', Salary: 40000, BDate: new Date('2/1/1999')}
        ];
        $scope.nv = Nhanvien;
    });
