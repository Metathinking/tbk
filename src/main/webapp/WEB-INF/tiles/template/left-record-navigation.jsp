<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2016/6/13.0013
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="nav-side-menu">
    <div class="brand">网站管理</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
    <div class="menu-list">
        <ul id="menu-content" class="menu-content collapse out">
            <li ng-class="{active:leftNav.index==1}">
                <a href="${pageContext.request.contextPath}/admin/product/upload">
                    <i class="fa fa-send fa-lg"></i>表格上传
                </a>
            </li>
            <li ng-class="{active:leftNav.index==2}">
                <a href="${pageContext.request.contextPath}/admin/adminLoginLog/list">
                    <i class="fa fa-list fa-lg"></i>登录记录
                </a>
            </li>
            <li ng-class="{active:leftNav.index==3}">
                <a href="${pageContext.request.contextPath}/admin/siteInfo/edit">
                    <i class="fa fa-gear fa-lg"></i>网站信息
                </a>
            </li>
        </ul>
    </div>
</div>
