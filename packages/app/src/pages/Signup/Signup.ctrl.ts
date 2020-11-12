function Controller($scope: any) {
  $scope.values = {};
  $scope.handleSubmit = (e: any) => {
    console.log($scope.values)
  }
}

Controller.$inject = ["$scope"];

export default Controller;