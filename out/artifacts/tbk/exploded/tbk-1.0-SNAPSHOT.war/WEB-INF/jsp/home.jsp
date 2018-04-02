<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2017/1/16.0016
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="baidu-site-verification" content="YmnCpEh7KA" />
    <meta name="keywords" content="${siteInfo.keywords}" />
    <meta name="description" content="${siteInfo.description}" />
    <title>${siteInfo.name}</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/resources/css/prettyPhoto.css"/>
    <link rel="stylesheet" href="/resources/css/main.css"/>
    <link rel="stylesheet" href="/resources/css/tbk.css"/>
    <script src="/resources/js/jquery-2.2.1.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/angular-1.5.0.min.js"></script>
    <link rel="shortcut icon" href="/resources/images/favicon.ico"/>
</head>
<body ng-app="app" data-spy="scroll" data-target="#navbar" data-offset="0" ng-controller="testCtrl">
<header id="header" role="banner">
    <div class="container">
        <div id="navbar" class="thumbnail navbar" style="height: 105px;">
            <div class="navbar-header">
                <a href="/">
                    <img width="400" height="80" src="/resources/images/front_logo.jpg"/>
                </a>
            </div>
            <div class="collapse navbar-collapse" style="margin-top: 35px">
                <div class="dropdown form-group" >
                    <div class="input-group" style="width:500px">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true"><span ng-bind="selectSearchType.name"></span><span class="caret"></span></button>
                            <ul class="dropdown-menu">
                                <li ng-repeat="x in searchTypeList" ng-if="x!=selectSearchType" ng-click="select(x)"><a href="javascript:void(0)">{{x.name}}</a> </li>
                            </ul>
                        </div><!-- /btn-group -->
                        <input type="text" class="form-control" aria-label="..." placeholder="总得说点什么吧" ng-model="searchName" ng-keypress="($event.which === 13)?search():0"/>
                    <span class="input-group-btn">
                         <button class="btn btn-warning" type="button" ng-click="search()">搜索</button>
                    </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<%--background-image:url(http://shapebootstrap.net/demo/html/xeon/images/slider-bg.jpg);--%>
<section id="main-slider" class="carousel" style="background-image:url('${siteInfo.topBackgroundImage}')">
    <div class="carousel-inner">
        <div class="item active">
            <div class="container">
                <div class="carousel-content">
                    <h1>${siteInfo.sloganTitle1}</h1>
                    <p class="lead">${siteInfo.sloganContent1}</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="container">
                <div class="carousel-content">
                    <h1>${siteInfo.sloganTitle2}</h1>
                    <p class="lead">${siteInfo.sloganContent2}</p>
                </div>
            </div>
        </div>
    </div>
    <a class="prev" href="http://shapebootstrap.net/demo/html/xeon/#main-slider" data-slide="prev"><i class="icon-angle-left"></i></a>
    <a class="next" href="http://shapebootstrap.net/demo/html/xeon/#main-slider" data-slide="next"><i class="icon-angle-right"></i></a>
</section>

<section id="services">
    <div class="container">
        <div class="box first">
            <c:if test="${list.size()==0}">
                <div class="alert alert-danger">
                    经过我的一番努力，还是没有找到您要找的"${pageQuery.name}"，您可以试试找点别的吧☺
                </div>
            </c:if>
            <div class="row">
                <c:forEach items="${list}" var="item">
                <div class="col-sm-6 col-md-4 col-lg-3 " >
                    <div class="thumbnail product-item">
                        <a href="${item.detail}" title="${item.name}" target="_blank">
                            <img class="lazy" src="${item.image}" style="width:230px;height: 230px;" data-src="${item.image}" alt="${item.name}"></a>
                        <div class="caption">
                            <p >
                                <span class="item-tmall"></span>
                                <span class="item-sales pull-right">${item.sales}笔成交</span>
                            </p>
                            <div>
                                <span class="quan">券 ￥ ${item.couponDetail}</span>
                                <span class="item-time">
                                    ${item.endTimeString} 截止</span>
                            </div>
                            <div>
                                <span class="price-new"><strong>￥</strong><span style="font-size: 24px"><fmt:formatNumber value="${item.newPrice}" pattern="#0.00"/> </span>
                                    <%--<span style="font-size: 12px">券后价</span>--%>
                                </span>
                                <span class="price-old">￥<fmt:formatNumber value="${item.price}" pattern="#0.00"/></span>
                            </div>
                            <p style="line-height: 1.4em;height: 2.8em;overflow:hidden;text-overflow: ellipsis;white-space:normal;">
                                <a href="${item.detail}" title="${item.name}" target="_blank" style="font-size: 12px">
                                    ${item.name}
                                    <%--${item.name.length()>32?item.name.substring(0,32):item.name}${item.name.length()>32?"...":""}--%>
                                </a>
                            </p>
                            <a class="btn btn-danger item-button" target="_blank" href="${item.tuiguangUrl}">领券下单>></a>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<c:if test="${list.size()!=0}">
<section class="center">
    <nav aria-label="Page navigation">
        <ul class="pagination pagination-lg">
            <li class="${pageQuery.index==1?'disabled':''}">
                <a href="javascript:void(0)" aria-label="Previous" ng-click="gotoPage(1)">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="${pageQuery.index==1?'disabled':''}">
                <a href="javascript:void(0)" aria-label="Previous" ng-click="prePage()">
                    <span aria-hidden="true">上一页</span>
                </a>
            </li>
            <c:forEach begin="${pageQuery.startPage}" end="${pageQuery.endPage}" var="index">
                <li class="${index==pageQuery.index?'active':''}"><a href="javascript:void(0)" ng-click="gotoPage('${index}')">${index}</a> </li>
            </c:forEach>
            <li class="${pageQuery.index==pageQuery.pageCount?'disabled':''}">
                <a href="javascript:void(0)" aria-label="Next" ng-click="nextPage()">
                    <span aria-hidden="true">下一页</span>
                </a>
            </li>
            <li class="${pageQuery.index==pageQuery.pageCount?'disabled':''}">
                <a href="javascript:void(0)" aria-label="Next" ng-click="gotoPage('${pageQuery.pageCount}')">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li class="disabled">
               <span>共${pageQuery.pageCount}页，${pageQuery.count}条</span>
            </li>
        </ul>
    </nav>
</section>
</c:if>
<footer>
    <section class="footer">
        <div class="container text-center ">
            <h3 style="margin-top: 60px;"><strong>${siteInfo.name}</strong>——${siteInfo.description}</h3>
            <h4 style="margin-top: 60px;"> ${siteInfo.footer}</h4>
        </div>
    </section>
</footer>
</body>
</html>
<script>
    angular.module("app", [])
            .controller("testCtrl", function ($scope, $http) {
                var all={name:'全部',value:'all'};
                var productName={name:'商品',value:'productName'};
                var salerName={name:'店铺',value:'salerName'};
                var category={name:'分类',value:'category'};
                $scope.searchTypeList=[all,productName,salerName,category];
                $scope.selectSearchType=null;
                for(var i=0;i<$scope.searchTypeList.length;i++){
                    if($scope.searchTypeList[i].value=="${pageQuery.searchType}"){
                        $scope.selectSearchType=$scope.searchTypeList[i];
                        break;
                    }
                }
                if($scope.selectSearchType==null){
                    $scope.selectSearchType=all;
                }
                $scope.searchName="${pageQuery.name}";
                $scope.select=function(item){
                    $scope.selectSearchType=item;
                };
                $scope.search=function () {
                    $scope.gotoPage(1);
                };
                $scope.prePage=function () {
                    if(${pageQuery.index==1}){
                        return;
                    }
                    $scope.gotoPage(${pageQuery.index-1>0?pageQuery.index-1:1})
                };
                $scope.nextPage=function () {
                    if(${pageQuery.index==pageQuery.pageCount}){
                        return;
                    }
                    $scope.gotoPage(${pageQuery.index+1<pageQuery.pageCount?pageQuery.index+1:pageQuery.pageCount})
                }
                $scope.gotoPage=function(index){
                    window.location.href="/home?searchType="+$scope.selectSearchType.value+"&name="+$scope.searchName+"&index="+index;
                }
            })
</script>
