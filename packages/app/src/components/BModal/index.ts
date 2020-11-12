import angular from 'angular';
import { APP_NAME } from '~/constants';

import Controller from './BModal.ctrl'
import './BModal.styles.sass'

angular
  .module(APP_NAME)
  .directive("bModal", () => ({
    restrict: 'AE',
    template: require("./BModal.templ.html"),
    controller: Controller,
    transclude: {
      anchor: 'bModalAnchor',
      content: 'bModalContent'
    },
    scope: {
      title: '@title',
      onModalClose: '&'
    }
  }))