(function () {
  'use strict';

  console.debug('site.js');

  var siteModule = angular.module('monitor.site', ['ngResource']);

  siteModule.factory('SiteService', ['$resource',
      function ($resource) {
        return $resource('service/site/all', {}, {
          all: {method: 'GET', params: {}, isArray: true},
        });
      }]
  );

  siteModule.controller('SiteCtrl', ['$scope', 'SiteService',
    function ($scope, siteService) {
      $scope.sites = siteService.all();
    }]);


})();
