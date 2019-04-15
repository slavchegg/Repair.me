webpackJsonp(["common"],{

/***/ "./src/app/car.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Car = (function () {
    function Car() {
    }
    return Car;
}());
exports.Car = Car;
//# sourceMappingURL=car.js.map

/***/ }),

/***/ "./src/app/cars.service.ts":
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
var http_1 = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
var Observable_1 = __webpack_require__("./node_modules/rxjs/Observable.js");
__webpack_require__("./node_modules/rxjs/add/operator/map.js");
__webpack_require__("./node_modules/rxjs/add/operator/catch.js");
__webpack_require__("./node_modules/rxjs/add/observable/of.js");
var CarsService = (function () {
    function CarsService(http) {
        this.http = http;
        this.cars = '';
    }
    CarsService.prototype.setCar = function (car) {
        var body = new http_1.URLSearchParams();
        body.set('model', car.model);
        body.set('modification', car.modification);
        body.set('vin', car.vin.toString());
        return this.http.post('http://localhost:8080/registration/newCar', body); // .map((r: Response) => r.json());
    };
    CarsService.prototype.setCars = function (cars) {
        this.cars = '';
        var body = new http_1.URLSearchParams();
        for (var i = 0; i < cars.length; i++) {
            this.cars = this.cars.concat(cars[i]).concat(',').toString();
        }
        this.cars = this.cars.substring(0, this.cars.length - 1);
        body.set('makes', this.cars);
        // body.set('makes', cars[0]);
        return this.http.get('http://localhost:8080/registration/regModifications?makes=' + this.cars); // .map((r: Response) => r.json());
    };
    CarsService.prototype.getMakes = function () {
        return this.http.get('http://localhost:8080/getAllMakes');
    };
    CarsService.prototype.getModels = function (make) {
        var params = new http_1.URLSearchParams();
        params.set('makeName', make);
        var options = new http_1.RequestOptions({ params: params });
        return this.http.get('http://localhost:8080/getAllModels', options);
    };
    CarsService.prototype.getModifications = function (model) {
        var params = new http_1.URLSearchParams();
        params.set('modelName', model);
        var options = new http_1.RequestOptions({ params: params });
        return this.http.get('http://localhost:8080/getAllModifications', options);
    };
    CarsService.prototype.getUserCars = function () {
        return this.http.get('http://localhost:8080/user/getCars').map(function (r) { return r.json(); })
            .catch(function (err, caught) { return Observable_1.Observable.of([]); });
    };
    return CarsService;
}());
CarsService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [typeof (_a = typeof http_1.Http !== "undefined" && http_1.Http) === "function" && _a || Object])
], CarsService);
exports.CarsService = CarsService;
var _a;
//# sourceMappingURL=cars.service.js.map

/***/ }),

/***/ "./src/app/specialization.guard.ts":
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
var SpecializationGuard = (function () {
    function SpecializationGuard(as) {
        this.as = as;
    }
    SpecializationGuard.prototype.canActivate = function (next, state) {
        return this.as.getRole().map(function (role) { return role === 'mechanic' || role === 'serviceAdmin'; });
    };
    return SpecializationGuard;
}());
SpecializationGuard = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [typeof (_a = typeof auth_service_1.AuthService !== "undefined" && auth_service_1.AuthService) === "function" && _a || Object])
], SpecializationGuard);
exports.SpecializationGuard = SpecializationGuard;
var _a;
//# sourceMappingURL=specialization.guard.js.map

/***/ }),

/***/ "./src/app/unregistered.guard.ts":
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
__webpack_require__("./node_modules/rxjs/add/operator/map.js");
var auth_service_1 = __webpack_require__("./src/app/auth.service.ts");
var UnregisteredGuard = (function () {
    function UnregisteredGuard(as) {
        this.as = as;
    }
    UnregisteredGuard.prototype.canActivate = function (next, state) {
        return this.as.getRole().map(function (role) { return role === 'guest'; });
    };
    return UnregisteredGuard;
}());
UnregisteredGuard = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [typeof (_a = typeof auth_service_1.AuthService !== "undefined" && auth_service_1.AuthService) === "function" && _a || Object])
], UnregisteredGuard);
exports.UnregisteredGuard = UnregisteredGuard;
var _a;
//# sourceMappingURL=unregistered.guard.js.map

/***/ }),

/***/ "./src/app/user-edit/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/user.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var User = (function () {
    function User() {
        this.photoHref = 'image/users/Default avatar.png';
        this.role = 'guest';
    }
    return User;
}());
exports.User = User;
//# sourceMappingURL=user.js.map

/***/ })

});
//# sourceMappingURL=common.chunk.js.map