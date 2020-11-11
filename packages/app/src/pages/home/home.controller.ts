import angular from 'angular';
import { APP_NAME, PAGE_HOME_CONTROLLER } from '~/constants'

function Controller($scope: any) {
  $scope.title = "Home Page";
}

Controller.$inject = ["$scope"];

angular
  .module(APP_NAME)
  .controller(PAGE_HOME_CONTROLLER, Controller)