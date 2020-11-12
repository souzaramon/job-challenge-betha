function Controller($scope: any) {
  $scope.visible = false;

  $scope.toggleVisible = () => {
    if($scope.visible) {
      $scope.onModalClose();
    }

    $scope.visible = !$scope.visible;
  }
}

Controller.$inject = ["$scope"]

export default Controller;