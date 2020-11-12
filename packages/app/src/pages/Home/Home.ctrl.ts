function Controller($scope: any, $location: any) {
  
  $scope.name = JSON.parse(localStorage.getItem("@app/user")).name;

  $scope.logout = function() {
    localStorage.clear()

    $location.path('/auth/signin');
  }
}

Controller.$inject = ["$scope", "$location"];

export default Controller;