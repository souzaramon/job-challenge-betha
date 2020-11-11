import angular from 'angular';
import * as constants from '~/constants';

import './pages/home/home.controller';
import './pages/signin/signin.controller';
import './pages/signup/signup.controller';

angular.module(constants.APP_NAME)
  .config(function($routeProvider: any) {
    $routeProvider
      .when('/', {
        template: require('./pages/home/home.template.html'),
        controller: constants.PAGE_HOME_CONTROLLER
      })
      .when('/auth/signin', {
        template: require('./pages/signin/signin.template.html'),
        controller: constants.PAGE_SIGNIN_CONTROLLER
      })
      .when('/auth/signup', {
        template: require('./pages/signup/signup.template.html'),
        controller: constants.PAGE_SIGNUP_CONTROLLER
      })
      .otherwise({
        redirectTo: '/auth/signin'
      });
  });