'use strict';

/* Services */

var angugrailsServices = angular.module('angugrailsServices', ['ngResource']);

angugrailsServices.factory('Phone', ['$resource',
  function($resource){
    return $resource('phones/:phoneId.json', {}, {
      query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
    });
  }]);
