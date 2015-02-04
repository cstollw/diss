//= require jquery/jquery-1.11.0.js
//= require angular.js
//= require angular-animate.js
//= require angular-route.js
//= require angular-resource.js
//= require app/app.js
//= require app/animations.js
//= require app/controllers.js
//= require app/filters.js
//= require app/services.js
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}


