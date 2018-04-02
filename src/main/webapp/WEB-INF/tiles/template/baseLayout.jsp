<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2016/3/9.0009
  Time: 9:12
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="${siteInfo.keywords}" />
    <meta name="description" content="${siteInfo.description}" />
    <title>${siteInfo.name}-后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/roboto.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/material.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design-mine.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/ripples.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
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
<div class="container-fluid" ng-controller="mainController">

    <tiles:insertAttribute name="top-navigation"/>

    <div class="row" style="margin-top:<tiles:insertAttribute name="margin-top"/>">
        <div class="col-md-2">
            <tiles:insertAttribute name="left-navigation"/>
        </div>
        <div class="col-md-9" style="padding-top:40px">
            <tiles:insertAttribute name="content"/>
        </div>
    </div>
    <tiles:insertAttribute name="main"/>
    <%--<div class="panel-footer">--%>
    <%--<tiles:insertAttribute name="footer"/>--%>
    <%--</div>--%>
</div>
</body>
</html>
<script>
    app.controller("mainController",function($scope){
        $scope.nav={
            index:1
        };
        $scope.leftNav={
            index:1
        }
    })
</script>
<script>
    $.material.init();
</script>