<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2016/6/8.0008
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="keywords" content="${siteInfo.keywords}"/>
    <meta name="description" content="${siteInfo.description}"/>
    <title>${siteInfo.name}-后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/roboto.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/material.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design-mine.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ripples.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/dg.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/dg_admin.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angular-1.5.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/dg.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/md5.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Utils.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/material.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ripples.min.js"></script>
    <script charset="utf-8" src="${pageContext.request.contextPath}/resources/js/angular-file-upload.min.js"></script>
    <link rel="shortcut icon" href="${siteInfo.icon}"/>
    <script>
        var context = "${context}";
    </script>
</head>
<body ng-app="app">
<div ng-controller="productController">
    <div class="table-bg">
        <div class="alert alert-danger" ng-if="error">
            {{error}}
        </div>
        <div class="row">
            <input type="text" class="input-lg" ng-model="name"/>
            <button class="btn btn-primary" ng-click="initList()">查询</button>
        </div>
        <div class="row">
            <div class="col-md-2">
                平台：
            </div>
            <div class="col-md-2">
                <input type="radio" value="all" ng-model="platform"/>全部
            </div>
            <div class="col-md-2">
                <input type="radio" value="tianmao" ng-model="platform"/>天猫
            </div>
            <div class="col-md-2">
                <input type="radio" value="taobao" ng-model="platform"/>淘宝
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                查询方式：
            </div>
            <div class="col-md-10">
                <input type="radio" ng-model="searchType" value="all"/>全部
                <input type="radio" ng-model="searchType" value="productId"/>商品id
                <input type="radio" ng-model="searchType" value="productName"/>商品名称
                <input type="radio" ng-model="searchType" value="category"/>分类
                <input type="radio" ng-model="searchType" value="salerId"/>卖家Id
                <input type="radio" ng-model="searchType" value="salerName"/>卖家名称
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                排序：
            </div>
            <div class="col-md-10">
                <button ng-repeat="item in selectList" ng-click="selectList.splice($index,1)" class="btn btn-default">{{$index+1}},{{item.name}}</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-10 col-md-offset-2">
                <button ng-repeat="item in orderList" ng-click="select(item)" class="btn btn-default" ng-disabled="isSelect(item)">{{item.name}}</button>
            </div>
        </div>
        <div class="row">
            <button class="btn btn-primary" ng-click="deleteOverDue()">删除过期商品</button>
            <button class="btn btn-primary" ng-click="deleteDuplicate()">删除重复商品</button>
        </div>
        <table class="table table-striped table-hover" ng-init="initList(index)">
            <tr>
                <td>序号</td>
                <td>商品id</td>
                <td>名称</td>
                <td>图片</td>
                <%--<td>推广链接</td>--%>
                <td>分类</td>
                <td>价格</td>
                <td>优惠券面额</td>
                <td>销量</td>
                <td>佣金比例</td>
                <td>佣金</td>
                <td>卖家id</td>
                <td>卖家名称</td>
                <td>卖家平台</td>
                <%--<td>优惠券id</td>--%>
                <td>优惠券总数量</td>
                <td>优惠券剩余数量</td>
                <td>开始时间</td>
                <td>结束时间</td>
                <td>推广链接</td>
            </tr>
            <tr ng-repeat="item in list">
                <td>{{item.id}}</td>
                <td>{{item.productId}}</td>
                <td>{{item.name}}</td>
                <td><a ng-href="{{item.detail}}" target="_blank"> <img ng-src="{{item.image}}"
                                                                       style="width: 50px;height: 50px;"/></a></td>
                <%--<td>{{item.detail}}</td>--%>
                <td>{{item.category}}</td>
                <td>{{item.price}}</td>
                <td>{{item.couponDetail}}</td>
                <td>{{item.sales}}</td>
                <td>{{item.scale}}%</td>
                <td>{{item.money}}</td>
                <td>{{item.salerId}}</td>
                <td>{{item.salerName}}</td>
                <td>{{item.salerCategory}}</td>
                <%--<td>{{item.couponId}}</td>--%>
                <td>{{item.couponCount}}</td>
                <td>{{item.couponSurplus}}</td>
                <td>
                    {{item.startTime|date:'yyyy-MM-dd'}}
                </td>
                <td>
                    {{item.endTime|date:'yyyy-MM-dd'}}
                </td>
                <td><a ng-href="{{item.tuiguangUrl}}" target="_blank">链接</a></td>
                <td>
                    <button class="btn btn-raised btn-danger btn-sm" ng-click="delete(item,$index)" title="删除"><span
                            class="glyphicon glyphicon-remove"></span></button>
                    <%--<button ng-if="!item.handled" class="btn btn-raised btn-primary btn-sm" ng-click="handle(item)"--%>
                            <%--title="处理完成"><span class="glyphicon glyphicon-ok"></span></button>--%>
                </td>
            </tr>
        </table>
        <div admin-pagination-directive page-list="pageList" init-list="initList"
             page-count="pageQuery.pageCount" index="index"></div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/admin/productService.js"></script>
<script>
    app.controller("productController", function ($scope, productService) {
        $scope.nav.index=2;
//        $scope.leftNav.index=3;
        $scope.name="";
        $scope.platform="all";
        $scope.searchType="all";

        $scope.error = "";
        $scope.index = 1;
        $scope.pageQuery = {
            pageCount: 1
        };
        <%--f_money desc,f_end_time desc,f_sales desc,f_scale desc,f_price asc--%>
        $scope.orderList=[
            {order:'money',name:'佣金'},
            {order:'endTime',name:'过期时间'},
            {order:'sales',name:'销量'},
            {order:'scale',name:'佣金比例'},
            {order:'price',name:'售价'},
        ];
        $scope.selectList=[
            {order:'money',name:'佣金'},
            {order:'endTime',name:'过期时间'},
            {order:'sales',name:'销量'},
            {order:'scale',name:'佣金比例'},
            {order:'price',name:'售价'},
        ];

        $scope.select=function (order) {
            if(!$scope.isSelect(order)){
                $scope.selectList.push(order);
            }
        };
        $scope.isSelect=function(order){
            for(var i=0;i<$scope.selectList.length;i++){
                if($scope.selectList[i].order==order.order){
                    return true;
                }
            }
            return false;
        }
        $scope.deleteOverDue = function () {
            productService.deleteOverDue()
                    .success(function (response, status, headers, cfg) {
                        if(response.success){
                            $scope.error="";
                            $scope.initList(1);
                        }else{
                            $scope.error=response.msg;
                        }
                    }).error(function (response, status, headers, cfg) {
                            $scope.error="删除失败";
                     })
        };
        $scope.deleteDuplicate=function () {
            productService.deleteDuplicate()
                    .success(function (response, status, headers, cfg) {
                        if(response.success){
                            $scope.error="";
                            $scope.initList(1);
                        }else{
                            $scope.error=response.msg;
                        }
                    }).error(function (response, status, headers, cfg) {
                $scope.error="删除失败";
            })
        };
        $scope.delete = function(_product,_index){

            productService.delete(_product.id)
                    .success(function (response, status, headers, cfg) {
                        if (response.success) {
                            $scope.error="";
                            $scope.list.splice(_index,1);
                        } else {
                            $scope.error = response.msg;
                        }
                    }).error(function (response, status, headers, cfg) {
                $scope.error = response;
            })
        }
        //获取列表数据 start
        $scope.initList = function (index) {
            $scope.index = index;
            var orders=[];
            for(var i=0;i<$scope.selectList.length;i++){
                orders.push($scope.selectList[i].order);
            }
            var  data={
                index:$scope.index,
                platform:$scope.platform,
                searchType:$scope.searchType,
                name:$scope.name,
                orders:orders
            };
            productService.initList(data)
                    .success(function (response, status, headers, cfg) {
                        if (response.success) {
                            $scope.error = "";
                            $scope.list = response.data.list;
                            $scope.pageQuery = response.data.pageQuery;
                            $scope.pageList = [];
                            for (var i = 1; i < $scope.pageQuery.pageCount + 1; i++) {
                                $scope.pageList.push(i);
                            }
                        } else {
                            $scope.error = response.msg;
                        }

                    }).error(function (response, status, headers, cfg) {
                $scope.error = "请求失败";
            })
        }
        //获取列表数据 end

    })
</script>
