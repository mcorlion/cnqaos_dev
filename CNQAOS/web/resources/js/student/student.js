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
 "centerName":"bangalore"
 }
 
 ***/


// create the controller and inject Angular's $scope
admin.controller('StudentController', function($scope,$http) {
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
                console.log("center data..."+data);
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


    $scope.create=function(){
        $http({
                method: 'POST',
                url: $scope.addURI,
                data: $scope.student,
                headers: {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'},
                transformRequest: transform
        })
        .success(function(data){
            var isEditStudent = false;
            $.each($scope.studentList, function (i) {  
                if ($scope.studentList[i].idPk === data.idPk) {  
                     $scope.studentList[i] = data;
                     isEditStudent  = true;
                }
            });
            if(!isEditCenter){
                $scope.studentList.push(data); 
            }
            $scope.student={};
        })
        .error(function(data){
            $scope.error = "An Error has occured while adding student!"; 
            console.log(data);
        });
    }

    $scope.edit=function(student){
        $scope.student.idPk = student.idPk;
        $scope.student.id = student.id;
        $scope.student.name = student.name;
        $scope.student.surName = student.surName;
        $scope.student.dateOfBirth = student.dateOfBirth;
        $scope.student.phoneNumber = student.phoneNumber;
        $scope.student.cellphoneNumber = student.cellphoneNumber;
        $scope.student.emailAddress = student.emailAddress;
        $scope.student.centerId = student.centerId;
        $scope.student.centerName = student.centerName;
    }

    $scope.cancel=function(){
        $scope.student={};
    }

    $scope.delete=function(student){
        
        $http({
                method: 'POST',
                url: $scope.deleteURI,
                data:student.idPk,
                headers: {'Content-Type':'text/plain; charset=UTF-8'},
        })
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