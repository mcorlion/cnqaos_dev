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
 "subjectId":1
 }
 
 ***/


// create the controller and inject Angular's $scope
admin.controller('TeacherController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Teacher Controller';
    $scope.teacher = {};
    $scope.teacherList = [];
    $scope.subjectList = [];
    $scope.listURI = "/CNQAOS/rest/teacher/list";
    $scope.subjectListURI = "/CNQAOS/rest/subject/list";
    $scope.addURI = "/CNQAOS/rest/student/add";
    $scope.deleteURI = "/CNQAOS/rest/student/delete";

    // methods for teacher
    // Get the subject list 
    $http.get($scope.subjectListURI)
            .success(function(data) {
                $scope.subjectList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading subjects!";
            });

    // Get the teacher list 
    $http.get($scope.listURI)
            .success(function(data) {
                $scope.teacherList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading teachers!";
            });

    var transform = function(data) {
        return $.param(data);
    }

    $scope.create = function() {
        $http({
            method: 'POST',
            url: $scope.addURI,
            data: $scope.teacher,
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transform
        })
                .success(function(data) {
                    $scope.teacherList.push($scope.teacher);
                    $scope.teacher = {};
                })
                .error(function(data) {
                    $scope.error = "An Error has occured while adding teacher!";
                    console.log(data);
                });
    }
    $scope.edit = function(teacher) {
        $scope.teacher = teacher;
    }

    $scope.cancel = function() {
        $scope.teacher = {};
    }
    $scope.delete=function(teacher){
        $http.post($scope.deleteURI,teacher.idPk)
        .success(function(data){
            $.each($scope.teacherList, function (i) {  
                if ($scope.teacherList[i].idPk === teacher.idPk) {  
                     $scope.teacherList.splice(i, 1);
                     return false;
                }
            });
        })
        .error(function(data){
            $scope.error = "An Error has occured while deleting teacher!"; 
            console.log(data);
        });
    }
});