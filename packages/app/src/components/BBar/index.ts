import angular from 'angular';
import { APP_NAME } from '~/constants';

import Controller from './BBar.ctrl';
import './BBar.styles.sass';

angular
  .module(APP_NAME)
  .directive("bBar", () => ({
    template: require("./BBar.templ.html"),
    controller: Controller
  }))