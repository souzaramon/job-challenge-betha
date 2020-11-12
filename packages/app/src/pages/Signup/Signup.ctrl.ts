function Controller($scope: any) {
  $scope.values = {
    name: '',
    email: '',
    password: '',
    terms: false
  };

  $scope.loading = false;

  // computed-property
  Object.defineProperty($scope, 'isFieldsEmpty', {
    get: () => !Object.values($scope.values).every(v => !!v && v !== "")
  })

  $scope.handleSubmit = (e: any) => {
    console.log($scope.values)
  }
}

Controller.$inject = ["$scope"];

export default Controller;