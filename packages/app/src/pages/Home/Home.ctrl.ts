import { API_BASE_URL } from '~/constants'

function Controller($scope: any, $http: any) {
  const base_url = API_BASE_URL + '/customers/';

  $scope.loading = true;
  $scope.searchTerm = "";
  $scope.values = {};

  $http.get(API_BASE_URL + '/customers')
    .then(({ data }: any) => { $scope.clients = data })
    .finally(() => { $scope.loading = false });  

  $scope.submitCreate = ($parent: any) => {
    $http
      .post(API_BASE_URL + '/customers', $scope.values)
      .then(refreshCustomersList)
      .finally(() => {
        $scope.values = {};
        $parent.toggleVisible();
      })
  }

  $scope.submitDelete = ($parent: any, id: number | string) => {
    $scope.loading = true;

    $http
      .delete(base_url + id)
      .then(refreshCustomersList)
      .finally(() => {
        $scope.loading = false;
        $parent.toggleVisible();
      });
  }

  function refreshCustomersList() {
    $http
      .get(base_url)
      .then(({ data }: any) => { $scope.clients = data })
      .finally(() => { $scope.loading = false }); 
  }
}

Controller.$inject = ["$scope", "$http"];

export default Controller;