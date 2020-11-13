import { API_BASE_URL } from '~/constants';

function Controller($scope: any, $routeParams: any, $http: any) {
  const base_url = `${API_BASE_URL}/customers/${$routeParams.id}/phones`;

  $scope.values = {};

  $scope.phones = [];
  
  $scope.loading = true;
  
  $scope.id = $routeParams.id;

  refreshCustomersPhonesList();

  $scope.handleSubmit = ($parent: any) => {
    $scope.loading = true;

    $http
      .post(base_url, $scope.values)
      .then(refreshCustomersPhonesList)
      .finally(() => { 
        $scope.loading = false;
        $scope.values = {}; 
        $parent.toggleVisible();
      });
  }

  $scope.submitDelete = ($parent: any, id: string | number) => {
    $scope.loading = true;

    $http
      .delete(base_url + "/" + id)
      .then(refreshCustomersPhonesList)
      .finally(() => {
        $scope.loading = false;
        $parent.toggleVisible();
      });
  }
        
  function refreshCustomersPhonesList() {
    return $http
      .get(base_url)
      .then(({ data }: any) => { $scope.phones = data })
      .finally(() => { $scope.loading = false });
  }
}

Controller.$inject = ["$scope", "$routeParams", "$http"];

export default Controller;