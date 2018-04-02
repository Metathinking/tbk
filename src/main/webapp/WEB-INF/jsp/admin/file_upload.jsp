<%--
  Created by IntelliJ IDEA.
  User: luyilaosan1
  Date: 2016/6/15.0015
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div ng-controller="fileController">
    <c:if test="${error!=null}">
        <div class="alert alert-warning">
            ${error}
        </div>
    </c:if>

    <div class="" style="margin-bottom: 12px">
            <form method="post" action="/admin/product/upload" enctype="multipart/form-data">
                <input type="file" name="file"/>
                <input type="submit" value="上传"/>
            </form>
    </div>

</div>

<script>
    app.controller("fileController", function ($scope) {
        $scope.nav.index=1;
        $scope.leftNav.index=1;
    })
</script>
