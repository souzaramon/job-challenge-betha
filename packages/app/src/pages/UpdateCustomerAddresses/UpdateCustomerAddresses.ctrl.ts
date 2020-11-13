import { API_BASE_URL } from '~/constants';

function Controller($scope: any, $routeParams: any, $http: any, $location: any) {
  const base_url = API_BASE_URL + '/customers/' + $routeParams.id + '/addresses';

  $scope.values = {};
  $scope.addresses = [];
  $scope.loading = true;
  $scope.id = $routeParams.id;

  refreshCustomersAddressesList();

  $scope.handleSubmit = ($parent: any) => {
    $scope.loading = true;

    $http
      .post(base_url, $scope.values)
      .then(refreshCustomersAddressesList)
      .finally(() => { 
        $scope.loading = false;
        $scope.values = {}; 

        $parent.toggleVisible();
      });  
  }

  $scope.submitDelete = ($parent: any, id: string | number) => {
    $scope.loading = true;

    $http
      .delete(base_url + "/" +id)
      .then(refreshCustomersAddressesList)
      .finally(() => {
        $scope.loading = false;
        $parent.toggleVisible();
      });
  }

  function refreshCustomersAddressesList() {
    return $http
      .get(base_url)
      .then(({ data }: any) => { $scope.addresses = data })
      .finally(() => { $scope.loading = false });
  }
}

Controller.$inject = ["$scope", "$routeParams", "$http", "$location"];

export default Controller;