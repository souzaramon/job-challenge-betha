import { API_BASE_URL } from '~/constants';

function Controller($scope: any, $routeParams: any, $http: any, $location: any) {
  $scope.loading = true;
  $scope.id = $routeParams.id;

  $scope.values = {
    name: '',
    taxId: ''
  };

  $http.get(API_BASE_URL + '/customers/' + $routeParams.id)
    .then(({ data }: any) => { $scope.values = data })
    .finally(() => { $scope.loading = false }); 
    
  $scope.handleSubmit = () => {
    $scope.loading = true

    $http
      .put(API_BASE_URL + '/customers/' + $routeParams.id, $scope.values)
      .finally(() => { $scope.loading = false }); 
  }
}

Controller.$inject = ["$scope", "$routeParams", "$http", "$location"];

export default Controller;