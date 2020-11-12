function Controller($scope: any, $location: any) {
  $scope.searchTerm = "";
  $scope.values = {
    create: {},
    update: {},
  }

  $scope.clients = [
    { name: 'Ramon 1', taxId: '10609975927', addresses: [{main: true, country: 'BR', state: 'SC', zip: '88904190', city: 'Araranguá', street: 'João Belmiro Nunes', number: 850 }]},  
    { name: 'Ramon 2', taxId: '99999', addresses: [{main: true, country: 'BR', state: 'SC', zip: '88904190', city: 'Araranguá', street: 'João Belmiro Nunes', number: 850 }]}
  ]

  $scope.submitCreate = () => {
    console.log($scope.values.create)
  }

  $scope.submitUpdate = (id: number | string) => {
    console.log($scope.values.update[id])
  }

  $scope.submitDelete = (id: number | string) => {
    console.log(id)
  }

  $scope.resetCreateValues = () => {
    $scope.values.create = {}
  }

  $scope.resetUpdateValues = () => {
    $scope.values.update = {}
  }

  $scope.onLogout = () => {
    localStorage.clear()
    $location.path('/auth/signin');
  }
}

Controller.$inject = ["$scope", "$location"];

export default Controller;