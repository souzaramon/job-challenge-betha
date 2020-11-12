import angular from 'angular';
import { APP_NAME } from '~/constants';

import Controller from './Home.ctrl';
import './Home.styles.sass';

const KEY = "Home";

angular
  .module(APP_NAME)
  .controller(KEY, Controller)

export default {
  template: require('./Home.templ.html'),
  controller: KEY
}

