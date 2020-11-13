import angular from 'angular';
import { APP_NAME } from '~/constants'
import AuthInterceptor from '~/utils/AuthInterceptor';

import Home from '~/pages/Home'
import UpdateCustomer from '~/pages/UpdateCustomer'
import UpdateCustomerAddresses from '~/pages/UpdateCustomerAddresses'
import UpdateCustomerPhones from '~/pages/UpdateCustomerPhones'
import Signin from '~/pages/Signin'
import Signup from '~/pages/Signup' 

const AUTH_ROUTES = [
  "/auth/signin",
  "/auth/signup"
]

angular
  .module(APP_NAME)
  .run(($rootScope: any, $location: any) => {

    $rootScope.$on('$routeChangeStart',(e: any, next: any) => {
      const { originalPath } = next.$$route

      if(AUTH_ROUTES.includes(originalPath) && localStorage.getItem("@app/access_token")) {
        e.preventDefault()

        $location.path('/');
      }

      if(!AUTH_ROUTES.includes(originalPath) && !localStorage.getItem("@app/access_token")) {
        e.preventDefault()

        $location.path('/auth/signin');
      }
    });
  });

angular
  .module(APP_NAME)
  .factory('AuthInterceptor', AuthInterceptor)
  .config(($routeProvider: any, $httpProvider: any) => {

    $httpProvider.interceptors.push('AuthInterceptor');

    $routeProvider
      .when('/', Home)
      .when('/update/:id', UpdateCustomer)
      .when('/update/:id/addresses', UpdateCustomerAddresses)
      .when('/update/:id/phones', UpdateCustomerPhones)
      .when('/auth/signin', Signin)
      .when('/auth/signup', Signup)
      .otherwise({ redirectTo: '/auth/signin' });
  });