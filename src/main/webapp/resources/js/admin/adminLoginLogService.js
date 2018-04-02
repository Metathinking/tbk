app.service('adminLoginLogService',function($http){
    this.initList = function(_index){
        var req = {
            method: 'POST',
            url: context+'/admin/adminLoginLog/list',
            headers: {
                'Content-Type': 'application/json'
            },
            data: {
                index:_index
            }
        }
        return $http(req);
    }
})