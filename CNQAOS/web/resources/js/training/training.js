/***
 It supports the training entity.
 Training entity has below attributes.
 {
 "id": 1,
 "name": "test training",
 "description":"description",
 "type": "test",
 "typeId": 1,
 "centers": [1,2]
 }
 ***/

// create the controller and inject Angular's $scope
admin.controller('TrainingController', function($scope, $http) {

    $scope.message = 'Training Controller';
    $scope.centerList = [];
    $scope.training = {};
    $scope.trainingType = [];
    $scope.trainingList = [];
    $scope.listURI = "/CNQAOS/rest/training/trainingcenter/list";
    $scope.centerListURI = "/CNQAOS/rest/center/list";
    $scope.trainingTypeURI = "/CNQAOS/rest/training/typelist";
    $scope.addURI = "/CNQAOS/rest/training/add";
    $scope.deleteURI = "/CNQAOS/rest/training/delete";


    // methods for student
    // Get the center list 
    $http.get($scope.centerListURI)
            .success(function(data) {
                $scope.centerList = data;
            })
            .error(function(data) {
                $scope.error = "An Error has occured while loading centers!";
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
                $scope.error = "An Error has occured while loading training centers!";
            });

    var transform = function(data) {
        return $.param(data);
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
        $scope.training.centers = training.centers;
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
