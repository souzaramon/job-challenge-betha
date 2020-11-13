import { API_BASE_URL } from '~/constants';

function Controller($scope: any, $http: any, $location: any) {
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
    const { terms, ...body } = $scope.values

    $http.post(API_BASE_URL + '/register/user', body)
      .then(() => {
        $location.path('/auth/signin');
      })
  }
}

Controller.$inject = ["$scope", "$http", "$location"];

export default Controller;