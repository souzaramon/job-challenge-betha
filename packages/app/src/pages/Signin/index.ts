import angular from 'angular';
import { APP_NAME } from '~/constants'

import Controller from './Signin.ctrl'
import './Signin.styles.sass'

const KEY = 'Signin'

angular
  .module(APP_NAME)
  .controller(KEY, Controller)

export default {
  template: require('./Signin.templ.html'),
  controller: KEY
}