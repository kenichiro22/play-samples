'use strict';

/* App Module */
angular.module('phonecat', ['phonecatFilters', 'phonecatServices', 'pascalprecht.translate']).
    config(['$routeProvider', '$translateProvider', function ($routeProvider, $translateProvider) {
        $routeProvider.
            when('/phones', {templateUrl: 'assets/partials/phone-list.html', controller: PhoneListCtrl}).
            when('/phones/:phoneId', {templateUrl: 'assets/partials/phone-detail.html', controller: PhoneDetailCtrl}).
            otherwise({redirectTo: '/phones'});

        $translateProvider.registerLoader(jsRoutes.controllers.Application.messages().url);
        $translateProvider.preferredLanguage('en_US');
    }]);