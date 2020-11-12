import angular from 'angular';
import { APP_NAME } from '~/constants'

import Home from '~/pages/Home'
import Signin from '~/pages/Signin'
import Signup from '~/pages/Signup' 

const AUTH_ROUTES = [
  "/auth/signin",
  "/auth/signup"
]

angular
  .module(APP_NAME)
  .run(($rootScope: any, $route: any, $routeParams: any, $location: any) => {

    $rootScope.$on('$routeChangeStart',(e: any, next: any) => {
      console.log("MIDDLEWARE")

      const { originalPath } = next.$$route

      const user = localStorage.getItem("@app/user") || "{}";
      const parsedUser = JSON.parse(user)

      if(AUTH_ROUTES.includes(originalPath) && parsedUser.token) {
        e.preventDefault()

        $location.path('/');
      }

      if(!AUTH_ROUTES.includes(originalPath) && !parsedUser.token) {
        e.preventDefault()

        $location.path('/auth/signin');
      }
    });
  });

angular
  .module(APP_NAME)
  .config(($routeProvider: any) => {
    $routeProvider
      .when('/', Home)
      .when('/auth/signin', Signin)
      .when('/auth/signup', Signup)
      .otherwise({ redirectTo: '/auth/signin' });
  });