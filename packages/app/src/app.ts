import angular from 'angular';
import { APP_NAME } from './constants';

angular.module(APP_NAME, ['ngRoute']);

angular.module(APP_NAME)
  .run(function($rootScope: any, $route: any, $routeParams: any, $location: any) {
    
    $rootScope.$on('$routeChangeStart',function(evt:any, next: any, current: any){
      console.log('Nome do Evento:'+evt.name);
      console.log('Próxima Rota:'+ angular.toJson(next));
      console.log('Rota Atual:'+ angular.toJson(current));
    });

    $rootScope.$route = $route;
    $rootScope.$location = $location;
    $rootScope.$routeParams = $routeParams;
  });