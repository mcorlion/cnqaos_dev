/***
It supports the center entity.
Center entity has below attributes.
     {
          "id" : 1;
          "centerName":"Bangalore",
          "centerAddress":"247,Amarjoythi Layout",
          "street":"Ayurvedic Hospital",
          "pin":"123456",
          "description":null,
          "latitude":123456.2356,
          "longitude":8789546.2356
     }

***/

// create the controller and inject Angular's $scope
admin.controller('CenterController', function($scope,$http) {
        // property of center
        $scope.message = 'Center Conroller';
        $scope.loading = true;
        $scope.center={};
        $scope.centerList=[];
        $scope.addMode = false;
        $scope.listURI="/CNQAOS/rest/center/list";
        $scope.addURI="/CNQAOS/rest/center/add";
        $scope.deleteURI="/CNQAOS/rest/center/delete";
        

        // methods for center
        // Get the center list 
        $http.get($scope.listURI)
                .success(function(data){
                    $scope.centerList = data;
                    $scope.loading = false;
                })
                .error(function(data){
                    $scope.error = "An Error has occured while loading centers!"; 
                    console.log(data);
                    $scope.loading = false;
        });

        $scope.toggleEdit = function () {  
            this.friend.editMode = !this.friend.editMode;
        }

        $scope.create=function(center){
            console.log(center);
            $http.post($scope.addURI,center)
                    .success(function(data){
                        $scope.centerList.push(data); 
                        $scope.center={};
                    })
                    .error(function(data){
                        $scope.error = "An Error has occured while adding center!"; 
                        console.log(data);
                    });
        }

        $scope.edit=function(center){
            $scope.center = center;
        }
        
        $scope.cancel=function(){
            $scope.center={};
        }

        $scope.delete=function(center){
            $http.post($scope.deleteURI,center)
                    .success(function(data){
                        $.each($scope.centerList, function (i) {  
                            if ($scope.centerList[i].id === center.id) {  
                                 $scope.centerList.splice(i, 1);
                                 return false;
                            }
                        });
                    })
                    .error(function(data){
                        $scope.error = "An Error has occured while deleting center!"; 
                        console.log(data);
                    });
        }

});


        