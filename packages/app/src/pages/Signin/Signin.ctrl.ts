function Controller($scope: any, $location: any, $route: any) {
  $scope.loading = false;

  $scope.values = {};

  $scope.handleSubmit = (e: any) => {
    $scope.loading = true;

    setTimeout(() => {
      console.log($location)

      localStorage.setItem("@app/user", JSON.stringify({ ...$scope.values, token: 123, name: "potato" }))

      $route.reload();
      $location.path('/');

      $scope.loading = false
    }, 2000)
  }
}

Controller.$inject = ["$scope", "$location", "$route"];

export default Controller;