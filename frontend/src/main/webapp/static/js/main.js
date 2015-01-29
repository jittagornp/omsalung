/**
 * @author jittagorn pitakmetagoon
 */

omsalung.config([
    '$routeProvider',
    '$locationProvider',
    function($routeProvider, $locationProvider) {
        var contextPath = '/frontend';

        $routeProvider
                .when('/', {
                    templateUrl: contextPath + '/page/main.html'
                })
                .when('/income', {
                    templateUrl: contextPath + '/page/income.html'
                })
                .when('/income/:tabId', {
                    templateUrl: contextPath + '/page/income.html'
                });

        $locationProvider
                .html5Mode(false)
                .hashPrefix('!');
    }
]);

//service ----------------------------------------------------------------------
omsalung.factory('IncomeService', [
    '$http',
    '$rootScope',
    'context',
    function($http, $rootScope, context) {

        var tabs;

        reloadTabOnUrlIsIncome();
        function reloadTabOnUrlIsIncome() {

            function isIncome(url) {
                return url === '/income';
            }

            $rootScope.$on('$routeChangeStart', function(event, next, current) {
                if (isIncome(next.$$route.originalPath)) {
                    tabs = undefined;
                }
            });
        }

        return {
            findAllTabs: function(callback) {
                if (!tabs) {
                    $http.get(context.serviceApiUrl + '/income/tabs')
                            .success(function(data) {
                                console.log(data);
                                tabs = data.data;
                                callback(tabs);
                            });
                } else {
                    return callback(tabs);
                }
            }
        };
    }
]);


//controller ------------------------------------------------------------------- 
omsalung.controller('mainCtrl', [
    '$scope',
    function($scope) {
        $scope.name = 'omsalung';
    }
]);

omsalung.controller('IncomeCtrl', [
    '$scope',
    '$routeParams',
    'IncomeService',
    function($scope, $routeParams, incomeService) {
        incomeService.findAllTabs(function(data) {
            $scope.tabs = data;
            checkActive($scope.tabs, $routeParams.tabId);
        });

        function isActiveTab(tab, tabId) {
            return tab.id === tabId
                    || (tabId === undefined && tab.order === 1);
        }

        function checkActive(tabs, tabId) {
            angular.forEach(tabs, function(value, key) {
                value.active = isActiveTab(value, tabId);
            });
        }
    }
]);