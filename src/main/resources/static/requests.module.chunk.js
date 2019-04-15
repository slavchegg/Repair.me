webpackJsonp(["requests.module"],{

/***/ "./src/app/mechanic-requests/mechanic-requests.component.css":
/***/ (function(module, exports) {

module.exports = "table {\r\n  width: 100%;\r\n  border-collapse: collapse;\r\n}\r\ntable th, table td {\r\n  padding: 4px;\r\n  border: Black 1px dotted;\r\n}\r\ntable th {\r\n  font-size: 16pt;\r\n  text-align: center;\r\n}\r\ntd.centered, td.link {\r\n  text-align: center;\r\n}\r\ntd.link {\r\n  width: 100px;\r\n}"

/***/ }),

/***/ "./src/app/mechanic-requests/mechanic-requests.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Заявки на ремонт</h1>\n<table>\n  <tr>\n    <th>Пользователь</th>\n    <th>Авто</th>\n    <th>Содержание</th>\n    <th colspan=\"3\">&nbsp;</th>\n  </tr>\n  <tr *ngFor=\"let generalRequest of (generalRequests|async)\">\n    <td>{{generalRequest.sender}}</td>\n    <td>{{generalRequest.modification}}</td>\n    <td class=\"centered\">{{generalRequest.content}}</td>\n    <td><input *ngIf=\" generalRequest.sender != 'Гость '\" type=\"button\" (click)=\"acceptGeneral(generalRequest.requestID, 'true')\" value=\"Принять\"><br>\n      <input type=\"button\" (click)=\"acceptGeneral(generalRequest.requestID, 'false')\" value=\"Отклонить\">\n    </td>\n  </tr>\n  <tr *ngFor=\"let exactRequest of (exactRequests|async)\">\n    <td>{{exactRequest.sender}}</td>\n    <td>{{exactRequest.modification}}</td>\n    <td class=\"centered\">{{exactRequest.content}}</td>\n    <td> <input type=\"button\" (click)=\"acceptExact(exactRequest.requestID, 'true')\" value=\"Принять\"> <br>\n      <input type=\"button\" (click)=\"acceptExact(exactRequest.requestID, 'false')\" value=\"Отклонить\">\n    </td>\n  </tr>\n</table>\n"

/***/ }),

/***/ "./src/app/mechanic-requests/mechanic-requests.component.ts":
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
var requests_service_1 = __webpack_require__("./src/app/requests.service.ts");
var MechanicRequestsComponent = (function () {
    function MechanicRequestsComponent(route, rs, router, title) {
        this.route = route;
        this.rs = rs;
        this.router = router;
        this.title = title;
    }
    MechanicRequestsComponent.prototype.ngOnInit = function () {
        this.generalRequests = this.rs.getGeneralRequests();
        this.exactRequests = this.rs.getExactRequests();
    };
    MechanicRequestsComponent.prototype.acceptExact = function (id, decision) {
        this.rs.acceptExactRequest(id, decision).subscribe();
        if (decision === 'false') {
            window.location.reload();
        }
        if (decision === 'true') {
            this.router.navigate(['/messaging/dialogs']);
        }
    };
    MechanicRequestsComponent.prototype.acceptGeneral = function (id, decision) {
        this.rs.acceptGeneralRequest(id, decision).subscribe();
        if (decision === 'false') {
            window.location.reload();
        }
        if (decision === 'true') {
            this.router.navigate(['/messaging/dialogs']);
        }
    };
    return MechanicRequestsComponent;
}());
MechanicRequestsComponent = __decorate([
    core_1.Component({
        selector: 'plants-mechanic-requests',
        template: __webpack_require__("./src/app/mechanic-requests/mechanic-requests.component.html"),
        styles: [__webpack_require__("./src/app/mechanic-requests/mechanic-requests.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof requests_service_1.RequestsService !== "undefined" && requests_service_1.RequestsService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object])
], MechanicRequestsComponent);
exports.MechanicRequestsComponent = MechanicRequestsComponent;
var _a, _b, _c, _d;
//# sourceMappingURL=mechanic-requests.component.js.map

/***/ }),

/***/ "./src/app/request-make/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/request-make/request-make.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  width: 200px;\r\n}"

/***/ }),

/***/ "./src/app/request-make/request-make.component.html":
/***/ (function(module, exports) {

module.exports = "<ng-container>\n  <h1>Заяка</h1>\n  <div class=\"centered\">\n    <form #requestform=\"ngForm\" (ngSubmit)=\"submitRequest()\">\n      <p>Марка<br>\n        <select [(ngModel)]=\"car.make\" (ngModelChange)=\"getModels()\" name=\"make\" >\n          <option [ngValue]=\"carName\" *ngFor=\"let carName of (carNames)\">\n            {{carName}}\n          </option>\n        </select>\n      </p>\n      <p>Модель<br>\n        <select [(ngModel)]=\"car.model\" (ngModelChange)=\"getModifications()\" name=\"carModel\">\n          <option [ngValue]=\"carModel\" *ngFor=\"let carModel of (carModels)\">\n            {{carModel}}\n          </option>\n        </select>\n      </p>\n      <p>Модификация<br>\n        <select [(ngModel)]=\"car.modification\" name=\"carModification\">\n          <option [ngValue]=\"carModification\" *ngFor=\"let carModification of (carModifications)\">\n            {{carModification}}\n          </option>\n        </select>\n      </p>\n      <p>Опишите проблему<br><input [(ngModel)]=\"request.content\" name=\"content\" required maxlength=\"500\"></p>\n      <p>Укажите номер телефона<br><input type='tel' [(ngModel)]=\"request.vin\" name=\"phone\" required maxlength=\"10\"></p>\n      <p><input type=\"submit\" value=\"Отправить\" [disabled]=\"!requestform.valid\"></p>\n    </form>\n  </div>\n</ng-container>\n"

/***/ }),

/***/ "./src/app/request-make/request-make.component.ts":
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
var requests_service_1 = __webpack_require__("./src/app/requests.service.ts");
var rrequest_1 = __webpack_require__("./src/app/rrequest.ts");
var car_1 = __webpack_require__("./src/app/car.ts");
var cars_service_1 = __webpack_require__("./src/app/cars.service.ts");
var RequestMakeComponent = (function () {
    function RequestMakeComponent(route, cs, router, title, rs) {
        this.route = route;
        this.cs = cs;
        this.router = router;
        this.title = title;
        this.rs = rs;
    }
    RequestMakeComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.car = new car_1.Car();
        this.request = new rrequest_1.Rrequest();
        this.title.setTitle('Регистрация машины' + settings_1.Settings.title);
        this.cs.getMakes().subscribe(function (data) {
            _this.carNames = JSON.parse(data.text());
        });
    };
    RequestMakeComponent.prototype.submitRequest = function () {
        var _this = this;
        this.request.car = this.car;
        this.rs.setRequest(this.request).subscribe(function (response) {
            if (response.status === 200) {
                _this.router.navigate(['/']);
            }
        });
    };
    RequestMakeComponent.prototype.getModels = function () {
        var _this = this;
        this.cs.getModels(this.car.make).subscribe(function (data) {
            _this.carModels = JSON.parse(data.text());
        });
    };
    RequestMakeComponent.prototype.getModifications = function () {
        var _this = this;
        this.cs.getModifications(this.car.model).subscribe(function (data) {
            _this.carModifications = JSON.parse(data.text());
        });
    };
    return RequestMakeComponent;
}());
RequestMakeComponent = __decorate([
    core_1.Component({
        selector: 'plants-request-make',
        template: __webpack_require__("./src/app/request-make/request-make.component.html"),
        styles: [__webpack_require__("./src/app/request-make/form.css"), __webpack_require__("./src/app/request-make/request-make.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof cars_service_1.CarsService !== "undefined" && cars_service_1.CarsService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object, typeof (_e = typeof requests_service_1.RequestsService !== "undefined" && requests_service_1.RequestsService) === "function" && _e || Object])
], RequestMakeComponent);
exports.RequestMakeComponent = RequestMakeComponent;
var _a, _b, _c, _d, _e;
//# sourceMappingURL=request-make.component.js.map

/***/ }),

/***/ "./src/app/requests-routing.module.ts":
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
var request_make_component_1 = __webpack_require__("./src/app/request-make/request-make.component.ts");
var mechanic_requests_component_1 = __webpack_require__("./src/app/mechanic-requests/mechanic-requests.component.ts");
var unregistered_guard_1 = __webpack_require__("./src/app/unregistered.guard.ts");
var specialization_guard_1 = __webpack_require__("./src/app/specialization.guard.ts");
var user_request_component_1 = __webpack_require__("./src/app/user-request/user-request.component.ts");
var user_guard_1 = __webpack_require__("./src/app/user.guard.ts");
var appRoutes = [
    { path: '', children: [
            { path: 'guest', component: request_make_component_1.RequestMakeComponent, canActivate: [unregistered_guard_1.UnregisteredGuard] },
            { path: 'user', component: user_request_component_1.UserRequestComponent, canActivate: [user_guard_1.UserGuard] },
            { path: 'get', component: mechanic_requests_component_1.MechanicRequestsComponent, canActivate: [specialization_guard_1.SpecializationGuard] },
        ] }
];
var RequestsRoutingModule = (function () {
    function RequestsRoutingModule() {
    }
    return RequestsRoutingModule;
}());
RequestsRoutingModule = __decorate([
    core_1.NgModule({
        imports: [
            router_1.RouterModule.forChild(appRoutes)
        ],
        exports: [
            router_1.RouterModule
        ],
        providers: [unregistered_guard_1.UnregisteredGuard, specialization_guard_1.SpecializationGuard, user_guard_1.UserGuard]
    })
], RequestsRoutingModule);
exports.RequestsRoutingModule = RequestsRoutingModule;
//# sourceMappingURL=requests-routing.module.js.map

/***/ }),

/***/ "./src/app/requests.module.ts":
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
var request_make_component_1 = __webpack_require__("./src/app/request-make/request-make.component.ts");
var requests_routing_module_1 = __webpack_require__("./src/app/requests-routing.module.ts");
var requests_service_1 = __webpack_require__("./src/app/requests.service.ts");
var mechanic_requests_component_1 = __webpack_require__("./src/app/mechanic-requests/mechanic-requests.component.ts");
var cars_service_1 = __webpack_require__("./src/app/cars.service.ts");
var user_request_component_1 = __webpack_require__("./src/app/user-request/user-request.component.ts");
var RequestsModule = (function () {
    function RequestsModule() {
    }
    return RequestsModule;
}());
RequestsModule = __decorate([
    core_1.NgModule({
        imports: [
            common_1.CommonModule,
            requests_routing_module_1.RequestsRoutingModule,
            forms_1.FormsModule
        ],
        declarations: [request_make_component_1.RequestMakeComponent, mechanic_requests_component_1.MechanicRequestsComponent, user_request_component_1.UserRequestComponent],
        providers: [requests_service_1.RequestsService, cars_service_1.CarsService]
    })
], RequestsModule);
exports.RequestsModule = RequestsModule;
//# sourceMappingURL=requests.module.js.map

/***/ }),

/***/ "./src/app/rrequest.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Rrequest = (function () {
    function Rrequest() {
    }
    return Rrequest;
}());
exports.Rrequest = Rrequest;
//# sourceMappingURL=rrequest.js.map

/***/ }),

/***/ "./src/app/user-request/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/user-request/user-request.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\n  width: 200px;\n}\n"

/***/ }),

/***/ "./src/app/user-request/user-request.component.html":
/***/ (function(module, exports) {

module.exports = "<ng-container>\n  <h1>Ваша Заяка</h1>\n  <div class=\"centered\">\n    <form #requestform=\"ngForm\" (ngSubmit)=\"submitRequest()\">\n      <p>Выберете Авто<br>\n        <select [(ngModel)]=\"request.car\" name=\"carModification\">\n          <option [ngValue]=\"car\" *ngFor=\"let car of (cars)\">\n            {{car.modification}}\n          </option>\n        </select>\n      </p>\n      <p>Опишите проблему<br><input [(ngModel)]=\"request.content\" name=\"content\" required maxlength=\"500\"></p>\n      <p><input type=\"submit\" value=\"Отправить\" [disabled]=\"!requestform.valid\"></p>\n    </form>\n  </div>\n</ng-container>\n"

/***/ }),

/***/ "./src/app/user-request/user-request.component.ts":
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
var cars_service_1 = __webpack_require__("./src/app/cars.service.ts");
var car_1 = __webpack_require__("./src/app/car.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var requests_service_1 = __webpack_require__("./src/app/requests.service.ts");
var rrequest_1 = __webpack_require__("./src/app/rrequest.ts");
var UserRequestComponent = (function () {
    function UserRequestComponent(route, cs, router, title, rs) {
        this.route = route;
        this.cs = cs;
        this.router = router;
        this.title = title;
        this.rs = rs;
    }
    UserRequestComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.cs.getUserCars().subscribe(function (data) {
            console.log(data);
            _this.cars = data;
        });
        this.request = new rrequest_1.Rrequest();
        this.request.car = new car_1.Car();
    };
    UserRequestComponent.prototype.ngOnDestroy = function () {
        sessionStorage.setItem('redirect', 'fromMenu');
        sessionStorage.setItem('serviceName', '');
        sessionStorage.setItem('mechanicId', '');
    };
    UserRequestComponent.prototype.submitRequest = function () {
        var _this = this;
        if (sessionStorage.getItem('redirect') === 'fromMenu') {
            this.rs.setUserRequest(this.request).subscribe(function (response) {
                if (response.status === 200) {
                    _this.router.navigate(['/']);
                }
            });
        }
        if (sessionStorage.getItem('redirect') === 'fromService') {
            this.rs.setUserRequestFromService(this.request).subscribe(function (response) {
                if (response.status === 200) {
                    _this.router.navigate(['/']);
                }
            });
        }
        if (sessionStorage.getItem('redirect') === 'fromMechanic') {
            this.rs.setUserRequestFromMechanic(this.request).subscribe(function (response) {
                if (response.status === 200) {
                    _this.router.navigate(['/']);
                }
            });
        }
    };
    return UserRequestComponent;
}());
UserRequestComponent = __decorate([
    core_1.Component({
        selector: 'plants-user-request',
        template: __webpack_require__("./src/app/user-request/user-request.component.html"),
        styles: [__webpack_require__("./src/app/user-request/form.css"), __webpack_require__("./src/app/user-request/user-request.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof cars_service_1.CarsService !== "undefined" && cars_service_1.CarsService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object, typeof (_e = typeof requests_service_1.RequestsService !== "undefined" && requests_service_1.RequestsService) === "function" && _e || Object])
], UserRequestComponent);
exports.UserRequestComponent = UserRequestComponent;
var _a, _b, _c, _d, _e;
//# sourceMappingURL=user-request.component.js.map

/***/ }),

/***/ "./src/app/user.guard.ts":
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
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var UserGuard = (function () {
    function UserGuard(as) {
        this.as = as;
    }
    UserGuard.prototype.canActivate = function (next, state) {
        return this.as.getRole().map(function (role) { return role === 'driver'; });
    };
    return UserGuard;
}());
UserGuard = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [typeof (_a = typeof auth_service_1.AuthService !== "undefined" && auth_service_1.AuthService) === "function" && _a || Object])
], UserGuard);
exports.UserGuard = UserGuard;
var _a;
//# sourceMappingURL=user.guard.js.map

/***/ })

});
//# sourceMappingURL=requests.module.chunk.js.map