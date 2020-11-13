import angular from 'angular';
import { APP_NAME } from '~/constants';

import Controller from './UpdateCustomerPhones.ctrl';
import './UpdateCustomerPhones.styles.sass';

const KEY = "UpdateCustomerPhones";

angular
  .module(APP_NAME)
  .controller(KEY, Controller)

export default {
  template: require('./UpdateCustomerPhones.templ.html'),
  controller: KEY
}

