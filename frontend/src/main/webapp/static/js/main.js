var omsalung = angular.module('omsalung', [
    'ngRoute'
]);

omsalung.config([
    '$routeProvider',
    '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider
                .when('/', {
                    templateUrl: '/omsalung/page/main.html'
                })
                .when('/income', {
                    templateUrl: '/omsalung/page/income.html'
                })
                .when('/income/:tabName', {
                    templateUrl: '/omsalung/page/income.html'
                });

        $locationProvider
                .html5Mode(false)
                .hashPrefix('!');

    }
]);

omsalung.controller('mainCtrl', [
    '$scope',
    function($scope) {
        $scope.name = 'omsalung';
    }
]);

omsalung.controller('IncomeTabCtrl', [
    '$scope',
    '$routeParams',
    function($scope, $routeParams) {
        $scope.tabs = [
            {
                title: 'วัน',
                name: 'day',
                link: '#!/income/day',
                order : 1
            },
            {
                title: 'สัปดาห์',
                name: 'week',
                link: '#!/income/week',
                order : 2
            },
            {
                title: 'เดือน',
                name: 'month',
                link: '#!/income/month',
                order : 3
            },
            {
                title: 'ปี',
                name: 'year',
                link: '#!/income/year',
                order : 4
            },
            {
                title: 'ทั้งหมด',
                name: 'all',
                link: '#!/income/all',
                order : 5
            }
        ];
        
        checkActive($scope.tabs, $routeParams.tabName);

        function checkActive(tabs, tabName) {
            angular.forEach(tabs, function(value, key) {
                if (value.name === tabName || (tabName === undefined && value.order === 1)) {
                    value.active = true;
                } 
            });
        }

        $scope.$on('$routeChangeStart', function(event, current, old) {
            checkActive($scope.tabs, current.params.tabName);
        });
    }
]);