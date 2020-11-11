import angular from 'angular';
import { APP_NAME, PAGE_SIGNUP_CONTROLLER } from '~/constants'

function Controller($scope: any) {
  $scope.title = "SignUp Page";
}

Controller.$inject = ["$scope"];

angular
  .module(APP_NAME)
  .controller(PAGE_SIGNUP_CONTROLLER, Controller)