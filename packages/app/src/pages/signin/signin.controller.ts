import angular from 'angular';
import { APP_NAME, PAGE_SIGNIN_CONTROLLER } from '~/constants'

function Controller($scope: any) {
  $scope.title = "Page SignIn";
}

Controller.$inject = ["$scope"];

angular
  .module(APP_NAME)
  .controller(PAGE_SIGNIN_CONTROLLER, Controller)