/***
 It supports the newsletter entity.
 Newsletter entity has below attributes.
 {
 "id" : 1;
 "fileName":"xyz.pdf",
 "file":{10101010101010101010101},
 "description":"News letter for November month",
 "uploadDate":"19/11/1980",
 "issueDate":"19/11/1980",
 }
 
 ***/

// create the controller and inject Angular's $scope
admin.controller('NewsController', function($scope,$http) {
    console.log("news letter....");
     $scope.message = 'News Conroller';
    $scope.newsLetter = {};
    $scope.newsLetterList = [];
    $scope.listURI = "/CNQAOS/rest/newsletter/list";
    $scope.addURI = "/CNQAOS/rest/newsletter/add";
    $scope.deleteURI = "/CNQAOS/rest/newsletter/delete";

});


