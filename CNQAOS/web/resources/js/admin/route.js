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
                        
    			// route for the newsletter page
			.when('/newsletter', {
				templateUrl : 'resources/templates/newsletter/newsletter_template.html',
				controller  : 'NewsController'
			})
                        
                        // if not find anything, redirect to center
                        .otherwise({
                                redirectTo: '/'
                        });
	});


