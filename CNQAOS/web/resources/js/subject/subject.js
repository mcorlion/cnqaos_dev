/***
 It supports the subject entity.
 Subject entity has below attributes.
 {
 "id" : "S101";
 "subjectName":"Maths"
 }
 
 ***/

// create the controller and inject Angular's $scope
admin.controller('SubjectController', function($scope, $http) {
    // property of center
    $scope.toggleForm = false;
    $scope.message = 'Subject Conroller';
    $scope.subject = {};
    $scope.subjectList = [];
    $scope.listURI = "/CNQAOS/rest/subject/list";
    $scope.addURI = "/CNQAOS/rest/subject/add";
    $scope.deleteURI = "/CNQAOS/rest/subject/delete";

    // methods for center
    // Get the subject list 
    $http.get($scope.listURI)
            .success(function(data) {
                $scope.subjectList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading subjects!";
            });

    var transform = function(data) {
        return $.param(data);
    }

    $scope.create = function() {
        $http({
            method: 'POST',
            url: $scope.addURI,
            data: $scope.subject,
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transform
        })
                .success(function(data) {
                    var isEditSubject = false;
                    $.each($scope.subjectList, function(i) {
                        if ($scope.subjectList[i].id === data.id) {
                            $scope.subjectList[i] = data;
                            isEditSubject = true;
                        }
                    });
                    if (!isEditSubject) {
                        $scope.subjectList.push(data);
                    }
                    $scope.subject = {};
                })
                .error(function(data) {
                    $scope.error = "An Error has occured while adding subject!";
                    console.log(data);
                });
    }

    $scope.edit = function(subject) {
        $scope.subject.id = subject.id;
        $scope.subject.subjectName = subject.subjectName;
        $scope.toggleForm = true;
    }

    $scope.cancel = function() {
        $scope.subject = {};
    }

    $scope.delete = function(subject) {

        $http({
            method: 'POST',
            url: $scope.deleteURI,
            data: subject.id,
            headers: {'Content-Type': 'text/plain; charset=UTF-8'},
        })
                .success(function(data) {
                    $.each($scope.subjectList, function(i) {
                        if ($scope.subjectList[i].id === subject.id) {
                            $scope.subjectList.splice(i, 1);
                            return false;
                        }
                    });
                })
                .error(function(data) {
                    $scope.error = "An Error has occured while deleting subject!";
                    console.log(data);
                });
    }
    
    $scope.showForm=function(){
        $scope.toggleForm = true;
    }

    $scope.hideForm=function(){
        $scope.toggleForm = false;            
    }

});