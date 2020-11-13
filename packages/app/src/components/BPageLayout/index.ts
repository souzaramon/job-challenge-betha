import angular from 'angular';
import { APP_NAME } from '~/constants';

import './BPageLayout.styles.sass';

angular
  .module(APP_NAME)
  .directive("bPageLayout", () => ({
    template: require("./BPageLayout.templ.html"),
    transclude: true,
    scope: {
      title: '@title',
    }
  }))