<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html xmlns:ng="http://angularjs.org" ng-app="omsalung" ng-strict-di>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no" />
        <title>ออมสลึง</title>
        <link rel="stylesheet/less" href="static/less/integrated.less">
        <script src="//cdnjs.cloudflare.com/ajax/libs/less.js/2.3.1/less.min.js"></script>

        <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.0/angular.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.0/angular-route.min.js"></script>
        <script>
            var omsalung = angular.module('omsalung', [
                'ngRoute'
            ]);

            omsalung.factory('context', function() {
                return {
                    contextPath: '${pageContext.request.contextPath}',
                    serviceApiUrl: '/service/api/v1'
                };
            });
        </script>
        <script src="static/js/main.js"></script>
    </head>
    <body>
        <div class="os-toolbar"></div>
        <div ng-view></div>
    </body>
</html>
