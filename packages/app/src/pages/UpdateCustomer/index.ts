import angular from 'angular';
import { APP_NAME } from '~/constants';

import Controller from './UpdateCustomer.ctrl';
import './UpdateCustomer.styles.sass';

const KEY = "UpdateCustomer";

angular
  .module(APP_NAME)
  .controller(KEY, Controller)

export default {
  template: require('./UpdateCustomer.templ.html'),
  controller: KEY
}

