import angular from 'angular';
import { APP_NAME } from '~/constants'

import Controller from './Signup.ctrl'
import './Signup.styles.sass'

const KEY = "Signup"

angular
  .module(APP_NAME)
  .controller(KEY, Controller)

export default {
  template: require('./Signup.templ.html'),
  controller: KEY
}