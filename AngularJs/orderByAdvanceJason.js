
    var myApp = angular.module('myModule', []);
    myApp.controller('myCtrl', function($scope){
        var Nhanvien = [
            {Name : 'Hung', Salary: 10000, BDate: new Date('7/27/1999')},
            {Name : 'Xuan', Salary: 90000, BDate: new Date('2/16/1999')},
            {Name : 'Trang', Salary: 80000, BDate: new Date('8/20/1999')},
            {Name : 'Thao', Salary: 40000, BDate: new Date('2/1/1999')}
        ];
        $scope.nv = Nhanvien;
        $scope.sortColumn = 'Name';
        $scope.reverse = false;

        $scope.sort = function (column) {
            if ($scope.sortColumn == column)
                $scope.reverse = !$scope.reverse;
            else
                $scope.reverse = false;
            $scope.sortColumn = column;
        }
        $scope.getSortClass = function (column) {
            if ($scope.sortColumn == column) {
                return $scope.reverse ? 'arrow-up' : 'arrow-down';
            }
            return '';
        }
    });
