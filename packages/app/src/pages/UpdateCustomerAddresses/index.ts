import angular from 'angular';
import { APP_NAME } from '~/constants';

import Controller from './UpdateCustomerAddresses.ctrl';
import './UpdateCustomerAddresses.styles.sass';

const KEY = "UpdateCustomerAddresses";

angular
  .module(APP_NAME)
  .controller(KEY, Controller)

export default {
  template: require('./UpdateCustomerAddresses.templ.html'),
  controller: KEY
}

