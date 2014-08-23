/***
 It supports the subject entity.
 Subject entity has below attributes.
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
	admin.controller('SubjectController', function($scope) {
		// create a message to display in our view
		$scope.message = 'Subject Controller';
	});