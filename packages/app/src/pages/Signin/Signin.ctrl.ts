import { API_BASE_URL } from '~/constants'

function Controller($scope: any, $location: any, $route: any, $http: any) {
  $scope.loading = false;

  $scope.values = {};

  $scope.handleSubmit = (e: any) => {
    $scope.loading = true;

    $http({
      method: 'POST',
      url: API_BASE_URL + '/oauth/token',
      data: {
        "grant_type": "password", 
        "username": $scope.values.email,
        "password": $scope.values.password,
      },
      headers: {
        "Content-Type": "application/x-www-form-urlencoded",
        "Authorization": "Basic Y2xpZW50OjEyMw==",
      },
      transformRequest: (data: any) => 
        Object
        .entries(data)
        .map(([k, v]: any) => encodeURIComponent(k) + "=" + encodeURIComponent(v))
        .join("&")
    }
    ).then(({ data }: any) => {
      localStorage.setItem("@app/user", JSON.stringify(data))
      localStorage.setItem("@app/access_token", data.access_token)

      $route.reload();
      $location.path('/');

    }, console.error)
    .finally(() => {
      $scope.loading = false;
    })
  }
}

Controller.$inject = ["$scope", "$location", "$route", "$http"];

export default Controller;