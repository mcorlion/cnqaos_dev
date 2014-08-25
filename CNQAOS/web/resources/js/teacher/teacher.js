/***
 It supports the teacher entity.
 Teacher entity has below attributes.
 {
 "idPk":1,
 "id" : "S101";
 "name":"Micheal",
 "surName":"Jackson",
 "dateOfBirth":"19/11/1980",
 "phoneNumber":"1234567892",
 "cellphoneNumber":"08046789",
 "emailAddress":"micheal.jackson@gmail.com",
 "subjectId":1,
 "subjectName":"Maths"
 }
 
 ***/


// create the controller and inject Angular's $scope
admin.controller('TeacherController', function($scope,$http) {
    // create a message to display in our view
    $scope.message = 'Teacher Controller';
    $scope.teacher = {};
    $scope.teacherList = [];
    $scope.subjectList = [];
    $scope.listURI = "/CNQAOS/rest/teacher/list";
    $scope.subjectListURI = "/CNQAOS/rest/subject/list";
    $scope.addURI = "/CNQAOS/rest/teacher/add";
    $scope.deleteURI = "/CNQAOS/rest/teacher/delete";

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

    $scope.create=function(){
        $http({
                method: 'POST',
                url: $scope.addURI,
                data: $scope.teacher,
                headers: {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'},
                transformRequest: transform
        })
        .success(function(data){
            var isEditTeacher = false;
            $.each($scope.teacherList, function (i) {  
                if ($scope.teacherList[i].idPk === data.idPk) {  
                     $scope.teacherList[i] = data;
                     isEditTeacher  = true;
                }
            });
            if(!isEditTeacher){
                $scope.teacherList.push(data); 
            }
            $scope.teacher={};
        })
        .error(function(data){
            $scope.error = "An Error has occured while adding teacher!"; 
            console.log(data);
        });
    }

    $scope.edit=function(teacher){
        $scope.teacher.idPk = teacher.idPk;
        $scope.teacher.id = teacher.id;
        $scope.teacher.name = teacher.name;
        $scope.teacher.surName = teacher.surName;
        $scope.teacher.dateOfBirth = teacher.dateOfBirth;
        $scope.teacher.phoneNumber = teacher.phoneNumber;
        $scope.teacher.cellphoneNumber = teacher.cellphoneNumber;
        $scope.teacher.emailAddress = teacher.emailAddress;
        $scope.teacher.subjectId = teacher.subjectId;
        $scope.teacher.subjectName = teacher.subjectName;
    }

    $scope.cancel=function(){
        $scope.teacher={};
    }

    $scope.delete=function(teacher){
        
        $http({
                method: 'POST',
                url: $scope.deleteURI,
                data:teacher.idPk,
                headers: {'Content-Type':'text/plain; charset=UTF-8'},
        })
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