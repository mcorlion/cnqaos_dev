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
        $scope.center={};
        $scope.centerList=[];
        $scope.listURI="/CNQAOS/rest/center/list";
        $scope.addURI="/CNQAOS/rest/center/add";
        $scope.deleteURI="/CNQAOS/rest/center/delete";
        

        // methods for center
        // Get the center list 
        $http.get($scope.listURI)
                .success(function(data){
                    $scope.centerList = data;
                })
                .error(function(data){
                    $scope.error = "An Error has occured while loading centers!"; 
        });
        var transform = function(data){
               return $.param(data);
        }
        
        $scope.create=function(){
            $http({
                    method: 'POST',
                    url: $scope.addURI,
                    data: $scope.center,
                    headers: {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'},
                    transformRequest: transform
            })
            .success(function(data){
                var isEditCenter = false;
                $.each($scope.centerList, function (i) {  
                    if ($scope.centerList[i].id === data.id) {  
                         $scope.centerList[i] = data;
                         isEditCenter  = true;
                    }
                });
                if(!isEditCenter){
                    $scope.centerList.push(data); 
                }
                $scope.center={};
            })
            .error(function(data){
                $scope.error = "An Error has occured while adding center!"; 
                console.log(data);
            });
        }

        $scope.edit=function(center){
            $scope.center.id=center.id;
            $scope.center.centerName= center.centerName;
            $scope.center.addressLine1 = center.addressLine1;
            $scope.center.addressLine2 = center.addressLine2;
            $scope.center.city=center.city;
            $scope.center.pin = center.pin;
            $scope.center.description = center.description;
            $scope.center.latitude = center.latitude;
            $scope.center.longitude = center.longitude;
        }
        
        $scope.assignValue=
        
        
        $scope.cancel=function(){
            $scope.center={};
        }

        $scope.delete=function(center){
            
            $http({
                    method: 'POST',
                    url: $scope.deleteURI,
                    data:center.id,
                    headers: {'Content-Type':'text/plain; charset=UTF-8'},
            })
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


        