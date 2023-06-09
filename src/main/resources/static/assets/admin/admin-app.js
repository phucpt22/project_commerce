var app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
	$routeProvider
		.when("/product", {
			templateUrl: "/assets/admin/product/index.html",
			controller: "product-ctrl"
		})
		.when("/authorize", {
			templateUrl: "/assets/admin/authority/index.html",
			controller: "authority-ctrl"
		})
		.when("/unauthorized", {
			templateUrl: "/assets/admin/authority/unauthorized.html",
		})
		.when("/account", {
			templateUrl: "/assets/admin/account/index.html",
			controller: "account-ctrl"
		})
		.when("/orders", {
			templateUrl: "/assets/admin/order/index.html",
			controller: "order-ctrl"
		})
		.when("/categories", {
			templateUrl: "/assets/admin/category/index.html",
			controller: "category-ctrl"
		}).when("/homeadmin", {
			templateUrl: "/assets/admin/index.html",
		})
		.otherwise({
			//template: "<h1 class='text-center'>FPT Polytechnic Administrator</h1>",
			templateUrl: "/assets/admin/current.html"
		})
})