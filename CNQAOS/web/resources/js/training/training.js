/***
 It supports the training entity.
 Training entity has below attributes.
 {
 "id": 1,
 "name": "test training",
 "description":"description",
 "type": "test",
 "typeId": 1,
 "subjects": [1,2]
 }
 ***/

// create the controller and inject Angular's $scope
admin.controller('TrainingController', function($scope, $http) {

    $scope.message = 'Training Controller';
    $scope.subjectList = [];
    $scope.training = {};
    $scope.trainingType = [];
    $scope.trainingList = [];
    $scope.listURI = "/CNQAOS/rest/training/list";
    $scope.subjectListURI = "/CNQAOS/rest/training/subjectlist";
    $scope.trainingTypeURI = "/CNQAOS/rest/training/typelist";
    $scope.addURI = "/CNQAOS/rest/training/add";
    $scope.deleteURI = "/CNQAOS/rest/training/delete";


    // methods for student
    // Get the subject list 
    $http.get($scope.subjectListURI)
            .success(function(data) {
                $scope.subjectList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading subjects!";
            });

    // Get the training type list 
    $http.get($scope.trainingTypeURI)
            .success(function(data) {
                $scope.trainingType = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading trainingType!";
            });

    // Get the training center list 
    $http.get($scope.listURI)
            .success(function(data) {
                $scope.trainingList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading training!";
            });

    var transform = function(data) {
        var modifydata  = $.param(data,true);
        console.log("param data "+modifydata);
        return modifydata;
    }

    $scope.create = function() {
        console.log($scope.training);
        $http({
            method: 'POST',
            url: $scope.addURI,
            data: $scope.training,
            headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
            transformRequest: transform
        })
                .success(function(data) {
                    var isEditTraining = false;
                    $.each($scope.trainingList, function(i) {
                        if ($scope.trainingList[i].id === data.id) {
                            $scope.trainingList[i] = data;
                            isEditTraining = true;
                        }
                    });
                    if (!isEditTraining) {
                        $scope.trainingList.push(data);
                    }
                    $scope.training = {};
                })
                .error(function(data) {
                    $scope.error = "An Error has occured while adding training!";
                    console.log($scope.error);
                });
    }

    $scope.edit = function(training) {
        $scope.training.id = training.id;
        $scope.training.description = training.description;
        $scope.training.name = training.name;
        $scope.training.type = training.type;
        $scope.training.typeId = training.typeId;
        $scope.training.subjects = training.subjects;
    }

    $scope.delete = function(training) {

        $http({
            method: 'POST',
            url: $scope.deleteURI,
            data: training.id,
            headers: {'Content-Type': 'text/plain; charset=UTF-8'}
        })
                .success(function(data) {
                    $.each($scope.trainingList, function(i) {
                        if ($scope.trainingList[i].id === training.id) {
                            $scope.trainingList.splice(i, 1);
                            return false;
                        }
                    });
                })
                .error(function(data) {
                    $scope.error = "An Error has occured while deleting training!";
                    console.log(data);
                });
    }

});
