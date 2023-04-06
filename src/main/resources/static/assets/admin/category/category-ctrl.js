app.controller("category-ctrl", function($scope, $http) {
	$scope.items = [];
	$scope.form = {};
	
	$scope.initialize = function() {
		$http.get("/rest/categories").then((resp) => {
			$scope.items = resp.data;
		});
	};

	$scope.initialize();

	$scope.edit = function(item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab("show");
	};

	$scope.reset = function() {
		$scope.form = {
		};
	};

	$scope.create = function() {
		var item = angular.copy($scope.form);
		$http
			.post("/rest/categories", item)
			.then((resp) => {
				$scope.items.push(resp.data);
				$scope.reset();
				alert("Thêm mới tài khoản thành công!");
			})
			.catch((error) => {
				alert("Lỗi thêm mới tài khoản!");
				console.log("Error", error);
			});
	};

	$scope.update = function() {
		var item = angular.copy($scope.form);
		$http
			.put(`/rest/categories/${item.id}`, item)
			.then((resp) => {
				var index = $scope.items.findIndex((p) => p.id == item.id);
				$scope.items[index] = item;
				alert("Cập nhật tài khoản thành công!");
			})
			.catch((error) => {
				alert("Lỗi cập nhật tài khoản!");
				console.log("Error", error);
			});
	};

	$scope.delete = function(item) {
		$http
			.delete(`/rest/categories/${item.id}`, item)
			.then((resp) => {
				var index = $scope.items.findIndex((p) => p.id == item.id);
				$scope.items.splice(index, 1);
				$scope.reset();
				alert("Xóa tài khoản thành công!");
			})
			.catch((error) => {
				alert("Lỗi xóa tài khoản!");
				console.log("Error", error);
			});
	};
	
	$scope.pager = {
		page: 0,
		size: 10,
		get items() {
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil((1.0 * $scope.items.length) / this.size);
		},
		first(){
			this.page=0;
		},
		prev(){
			this.page--;
			if(this.page<0){
				this.first();
			}
		},
		next(){
			this.page++;
			if(this.page>=this.count){
				this.last();
			}
		},
		last(){
			this.page=this.count-1;
		},
	};
});
