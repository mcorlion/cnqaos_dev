/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

	// create the module and name it scotchApp
	var admin = angular.module('AdminModule', ['ngRoute']);
        
	// configure our routes
	admin.config(function($routeProvider) {
		$routeProvider

			// route for the center page
			.when('/', {
				templateUrl : 'resources/templates/center/center_template.html',
				controller  : 'CenterController'
			})

			// route for the student page
			.when('/student', {
				templateUrl : 'resources/templates/student/student_template.html',
				controller  : 'StudentController'
			})

			// route for the teacher page
			.when('/teacher', {
				templateUrl :'resources/templates/teacher/teacher_template.html',
				controller  : 'TeacherController'
			})
                        
    			// route for the student page
			.when('/subject', {
				templateUrl : 'resources/templates/subject/subject_template.html',
				controller  : 'SubjectController'
			})
                        
    			// route for the student page
			.when('/training', {
				templateUrl : 'resources/templates/training/training_template.html',
				controller  : 'TrainingController'
			})
                        
                        // if not find anything, redirect to center
                        .otherwise({
                                redirectTo: '/'
                        });
	});
