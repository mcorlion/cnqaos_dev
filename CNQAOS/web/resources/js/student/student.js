/***
 It supports the student entity.
 Student entity has below attributes.
 {
 "idPk":1,
 "id" : "S101";
 "name":"Micheal",
 "surName":"Jackson",
 "dateOfBirth":"19/11/1980",
 "phoneNumber":"1234567892",
 "cellphoneNumber":"08046789",
 "emailAddress":"micheal.jackson@gmail.com",
 "centerId":1
 }
 
 ***/


// create the controller and inject Angular's $scope
admin.controller('StudentController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Student Controller';
    $scope.student = {};
    $scope.studentList = [];
    $scope.centerList = [];
    $scope.listURI = "/CNQAOS/rest/student/list";
    $scope.centerListURI = "/CNQAOS/rest/center/list";
    $scope.addURI = "/CNQAOS/rest/student/add";
    $scope.deleteURI = "/CNQAOS/rest/student/delete";

    // methods for student
    // Get the center list 
    $http.get($scope.centerListURI)
            .success(function(data) {
                $scope.centerList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading centers!";
            });

    // Get the student list 
    $http.get($scope.listURI)
            .success(function(data) {
                $scope.studentList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading students!";
            });
    var transform = function(data) {
        return $.param(data);
    }
    $scope.create = function() {
        $http({
            method: 'POST',
            url: $scope.addURI,
            data: $scope.student,
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transform
        })
                .success(function(data) {
                    $scope.studentList.push($scope.student);
                    $scope.student = {};
                })
                .error(function(data) {
                    $scope.error = "An Error has occured while adding student!";
                    console.log(data);
                });
    }

    $scope.edit = function(student) {
        $scope.student = student;
    }

    $scope.cancel = function() {
        $scope.student = {};
    }
    $scope.delete=function(student){
        $http.post($scope.deleteURI,student.idPk)
        .success(function(data){
            $.each($scope.studentList, function (i) {  
                if ($scope.studentList[i].idPk === student.idPk) {  
                     $scope.studentList.splice(i, 1);
                     return false;
                }
            });
        })
        .error(function(data){
            $scope.error = "An Error has occured while deleting student!"; 
            console.log(data);
        });
    }
});