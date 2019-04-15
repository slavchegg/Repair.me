webpackJsonp(["auth.module"],{

/***/ "./src/app/auth-routing.module.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var registered_guard_1 = __webpack_require__("./src/app/registered.guard.ts");
var unregistered_guard_1 = __webpack_require__("./src/app/unregistered.guard.ts");
var login_component_1 = __webpack_require__("./src/app/login/login.component.ts");
var logout_component_1 = __webpack_require__("./src/app/logout/logout.component.ts");
var appRoutes = [
    { path: '', children: [
            { path: 'login', component: login_component_1.LoginComponent, canActivate: [unregistered_guard_1.UnregisteredGuard] },
            { path: 'logout', component: logout_component_1.LogoutComponent, canActivate: [registered_guard_1.RegisteredGuard] }
        ] }
];
var AuthRoutingModule = (function () {
    function AuthRoutingModule() {
    }
    return AuthRoutingModule;
}());
AuthRoutingModule = __decorate([
    core_1.NgModule({
        imports: [
            router_1.RouterModule.forChild(appRoutes)
        ],
        exports: [
            router_1.RouterModule
        ],
        providers: [registered_guard_1.RegisteredGuard, unregistered_guard_1.UnregisteredGuard]
    })
], AuthRoutingModule);
exports.AuthRoutingModule = AuthRoutingModule;
//# sourceMappingURL=auth-routing.module.js.map

/***/ }),

/***/ "./src/app/auth.module.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
var common_1 = __webpack_require__("./node_modules/@angular/common/@angular/common.es5.js");
var forms_1 = __webpack_require__("./node_modules/@angular/forms/@angular/forms.es5.js");
var http_1 = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
var auth_routing_module_1 = __webpack_require__("./src/app/auth-routing.module.ts");
var login_component_1 = __webpack_require__("./src/app/login/login.component.ts");
var logout_component_1 = __webpack_require__("./src/app/logout/logout.component.ts");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var AuthModule = (function () {
    function AuthModule() {
    }
    return AuthModule;
}());
AuthModule = __decorate([
    core_1.NgModule({
        imports: [
            common_1.CommonModule,
            auth_routing_module_1.AuthRoutingModule,
            forms_1.FormsModule,
            http_1.HttpModule
        ],
        declarations: [login_component_1.LoginComponent, logout_component_1.LogoutComponent],
        providers: [auth_service_1.AuthService]
    })
], AuthModule);
exports.AuthModule = AuthModule;
//# sourceMappingURL=auth.module.js.map

/***/ }),

/***/ "./src/app/login/login.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  width: 200px;\r\n}\r\n"

/***/ }),

/***/ "./src/app/login/login.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Вход</h1>\n<div class=\"centered\">\n  <form #loginform=\"ngForm\" (ngSubmit)=\"login()\">\n    <p>Почта<br><input type='email'[(ngModel)]=\"credentials.username\" name=\"username\"></p>\n    <p>Пароль<br><input type=\"password\" [(ngModel)]=\"credentials.password\" name=\"password\"></p>\n    <p><input type=\"submit\" value=\"Войти\" [disabled]=\"!loginform.valid\"></p>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/login/login.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var settings_1 = __webpack_require__("./src/app/settings.ts");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var app_component_1 = __webpack_require__("./src/app/app.component.ts");
var users_service_1 = __webpack_require__("./src/app/users.service.ts");
var LoginComponent = (function () {
    function LoginComponent(as, us, router, title, ac) {
        this.as = as;
        this.us = us;
        this.router = router;
        this.title = title;
        this.ac = ac;
        this.credentials = { username: '', password: '' }; // name is mail, sent to registration/login
    }
    LoginComponent.prototype.ngOnInit = function () {
        this.title.setTitle('Вход :: ' + settings_1.Settings.title);
    };
    LoginComponent.prototype.login = function () {
        var _this = this;
        this.as.login(this.credentials).subscribe(function (role) {
            if (role !== 'guest') {
                _this.router.navigate(['']);
                console.log(role);
                _this.ac.nav.refreshRole();
            }
        });
    };
    return LoginComponent;
}());
LoginComponent = __decorate([
    core_1.Component({
        selector: 'plants-login',
        template: __webpack_require__("./src/app/login/login.component.html"),
        styles: [__webpack_require__("./src/app/user-edit/form.css"), __webpack_require__("./src/app/login/login.component.css")],
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof auth_service_1.AuthService !== "undefined" && auth_service_1.AuthService) === "function" && _a || Object, typeof (_b = typeof users_service_1.UsersService !== "undefined" && users_service_1.UsersService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object, typeof (_e = typeof app_component_1.AppComponent !== "undefined" && app_component_1.AppComponent) === "function" && _e || Object])
], LoginComponent);
exports.LoginComponent = LoginComponent;
var _a, _b, _c, _d, _e;
//# sourceMappingURL=login.component.js.map

/***/ }),

/***/ "./src/app/logout/logout.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  width: 100px;\r\n}\r\n"

/***/ }),

/***/ "./src/app/logout/logout.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Выход</h1>\n<div class=\"centered\">\n  <form (ngSubmit)=\"logout()\">\n    <p><input type=\"submit\" value=\"Выйти\"></p>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/logout/logout.component.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var settings_1 = __webpack_require__("./src/app/settings.ts");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var app_component_1 = __webpack_require__("./src/app/app.component.ts");
var LogoutComponent = (function () {
    function LogoutComponent(as, router, title, ac) {
        this.as = as;
        this.router = router;
        this.title = title;
        this.ac = ac;
    }
    LogoutComponent.prototype.ngOnInit = function () {
        this.title.setTitle('Выход :: ' + settings_1.Settings.title);
    };
    LogoutComponent.prototype.logout = function () {
        this.as.logout().subscribe();
        if (sessionStorage.getItem('role') === 'guest') {
            this.router.navigate(['']);
            this.ac.nav.refreshRole();
        }
    };
    return LogoutComponent;
}());
LogoutComponent = __decorate([
    core_1.Component({
        selector: 'plants-logout',
        template: __webpack_require__("./src/app/logout/logout.component.html"),
        styles: [__webpack_require__("./src/app/user-edit/form.css"), __webpack_require__("./src/app/logout/logout.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof auth_service_1.AuthService !== "undefined" && auth_service_1.AuthService) === "function" && _a || Object, typeof (_b = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _b || Object, typeof (_c = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _c || Object, typeof (_d = typeof app_component_1.AppComponent !== "undefined" && app_component_1.AppComponent) === "function" && _d || Object])
], LogoutComponent);
exports.LogoutComponent = LogoutComponent;
var _a, _b, _c, _d;
//# sourceMappingURL=logout.component.js.map

/***/ })

});
//# sourceMappingURL=auth.module.chunk.js.map