function Controller($scope: any, $location: any) {
    $scope.onLogout = () => {
      localStorage.clear()

      $location.path('/auth/signin');
    }
  }
  
  Controller.$inject = ["$scope", "$location"];
  
  export default Controller;