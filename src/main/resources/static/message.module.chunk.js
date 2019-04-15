webpackJsonp(["message.module"],{

/***/ "./src/app/dialog-list/dialog-list.component.css":
/***/ (function(module, exports) {

module.exports = "table {\n  width: 100%;\n  border-collapse: collapse;\n}\ntable th, table td {\n  padding: 4px;\n  border: Black 1px dotted;\n}\ntable th {\n  font-size: 16pt;\n  text-align: center;\n}\ntd.centered, td.link {\n  text-align: center;\n}\ntd.link {\n  width: 100px;\n}\n"

/***/ }),

/***/ "./src/app/dialog-list/dialog-list.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Диалоги</h1>\n<table>\n  <tr>\n    <th>Пользователь</th>\n    <th>Тема</th>\n    <th></th>\n    <th colspan=\"3\">&nbsp;</th>\n  </tr>\n  <tr *ngFor=\"let dialog of (dialogs|async)\" (click)=\"redirect(dialog.dialogId)\">\n    <td>{{dialog.interlocutor}}</td>\n    <td>{{dialog.topic}}</td>\n    <td>{{dialog.lastMessage}} </td>\n    <td *ngIf = 'dialog.new == true'> Новое </td>\n  </tr>\n</table>\n"

/***/ }),

/***/ "./src/app/dialog-list/dialog-list.component.ts":
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
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var message_service_1 = __webpack_require__("./src/app/message.service.ts");
var DialogListComponent = (function () {
    function DialogListComponent(route, ms, router) {
        this.route = route;
        this.ms = ms;
        this.router = router;
    }
    DialogListComponent.prototype.ngOnInit = function () {
        if (sessionStorage.getItem('role') === 'mechanic' || sessionStorage.getItem('role') === 'serviceAdmin') {
            this.dialogs = this.ms.getMechanicDialogs();
        }
        if (sessionStorage.getItem('role') === 'driver') {
            this.dialogs = this.ms.getUserDialogs();
        }
    };
    DialogListComponent.prototype.redirect = function (id) {
        this.router.navigate(['messaging/dialog', id.toString()]);
    };
    return DialogListComponent;
}());
DialogListComponent = __decorate([
    core_1.Component({
        selector: 'plants-dialog-list',
        template: __webpack_require__("./src/app/dialog-list/dialog-list.component.html"),
        styles: [__webpack_require__("./src/app/dialog-list/dialog-list.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof message_service_1.MessageService !== "undefined" && message_service_1.MessageService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object])
], DialogListComponent);
exports.DialogListComponent = DialogListComponent;
var _a, _b, _c;
//# sourceMappingURL=dialog-list.component.js.map

/***/ }),

/***/ "./src/app/dialog/dialog.component.css":
/***/ (function(module, exports) {

module.exports = "table {\n  width: 100%;\n  border-collapse: collapse;\n}\ntable th, table td {\n  padding: 4px;\n  border: Black 1px dotted;\n}\ntable th {\n  font-size: 16pt;\n  text-align: center;\n}\ntd.centered, td.link {\n  text-align: center;\n}\ntd.link {\n  width: 100px;\n}\n"

/***/ }),

/***/ "./src/app/dialog/dialog.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Диалог</h1>\n<table>\n  <tr>\n    <th>Отправитель</th>\n    <th>Содержимое</th>\n    <th colspan=\"2\">&nbsp;</th>\n  </tr>\n  <tr *ngFor=\"let message of messages\">\n    <td>{{message.interlocutor}}</td>\n    <td>{{message.content}}</td>\n  </tr>\n</table>\n<br>\n<input type=\"text\" [(ngModel)]=\"mes.content\" name=\"content\">\n<input type=\"button\" (click)=\"sendMessage(mes.content)\" value=\"Отправить\"> <br>\n"

/***/ }),

/***/ "./src/app/dialog/dialog.component.ts":
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
var message_1 = __webpack_require__("./src/app/message.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var message_service_1 = __webpack_require__("./src/app/message.service.ts");
var DialogComponent = (function () {
    function DialogComponent(route, ms) {
        this.route = route;
        this.ms = ms;
    }
    DialogComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.mes = new message_1.Message();
        this.id = this.route.snapshot.paramMap.get('id');
        if (sessionStorage.getItem('role') === 'mechanic' || sessionStorage.getItem('role') === 'serviceAdmin') {
            this.ms.getMessagesFromMechanicDialog(this.id).subscribe(function (data) {
                _this.messages = data['messages'];
            });
        }
        if (sessionStorage.getItem('role') === 'driver') {
            this.ms.getMessagesFromUserDialog(this.id).subscribe(function (data) {
                _this.messages = data['messages'];
            });
        }
    };
    DialogComponent.prototype.sendMessage = function (content) {
        if (sessionStorage.getItem('role') === 'mechanic' || sessionStorage.getItem('role') === 'serviceAdmin') {
            this.ms.sendMechanicMessage(this.id, content).subscribe();
        }
        if (sessionStorage.getItem('role') === 'driver') {
            this.ms.sendUserMessage(this.id, content).subscribe();
        }
    };
    return DialogComponent;
}());
DialogComponent = __decorate([
    core_1.Component({
        selector: 'plants-dialog',
        template: __webpack_require__("./src/app/dialog/dialog.component.html"),
        styles: [__webpack_require__("./src/app/dialog/dialog.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof message_service_1.MessageService !== "undefined" && message_service_1.MessageService) === "function" && _b || Object])
], DialogComponent);
exports.DialogComponent = DialogComponent;
var _a, _b;
//# sourceMappingURL=dialog.component.js.map

/***/ }),

/***/ "./src/app/message-routing.module.ts":
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
var dialog_component_1 = __webpack_require__("./src/app/dialog/dialog.component.ts");
var registered_guard_1 = __webpack_require__("./src/app/registered.guard.ts");
var dialog_list_component_1 = __webpack_require__("./src/app/dialog-list/dialog-list.component.ts");
var appRoutes = [
    { path: '', children: [
            { path: 'dialog/:id', component: dialog_component_1.DialogComponent, canActivate: [registered_guard_1.RegisteredGuard] },
            { path: 'dialogs', component: dialog_list_component_1.DialogListComponent, canActivate: [registered_guard_1.RegisteredGuard] },
        ] }
];
var MessageRoutingModule = (function () {
    function MessageRoutingModule() {
    }
    return MessageRoutingModule;
}());
MessageRoutingModule = __decorate([
    core_1.NgModule({
        imports: [router_1.RouterModule.forChild(appRoutes)],
        exports: [router_1.RouterModule],
        providers: [registered_guard_1.RegisteredGuard]
    })
], MessageRoutingModule);
exports.MessageRoutingModule = MessageRoutingModule;
//# sourceMappingURL=message-routing.module.js.map

/***/ }),

/***/ "./src/app/message.module.ts":
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
var dialog_component_1 = __webpack_require__("./src/app/dialog/dialog.component.ts");
var dialog_list_component_1 = __webpack_require__("./src/app/dialog-list/dialog-list.component.ts");
var forms_1 = __webpack_require__("./node_modules/@angular/forms/@angular/forms.es5.js");
var http_1 = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
var message_service_1 = __webpack_require__("./src/app/message.service.ts");
var message_routing_module_1 = __webpack_require__("./src/app/message-routing.module.ts");
var MessageModule = (function () {
    function MessageModule() {
    }
    return MessageModule;
}());
MessageModule = __decorate([
    core_1.NgModule({
        imports: [
            common_1.CommonModule,
            message_routing_module_1.MessageRoutingModule,
            forms_1.FormsModule,
            http_1.HttpModule
        ],
        declarations: [dialog_component_1.DialogComponent, dialog_list_component_1.DialogListComponent],
        providers: [message_service_1.MessageService]
    })
], MessageModule);
exports.MessageModule = MessageModule;
//# sourceMappingURL=message.module.js.map

/***/ }),

/***/ "./src/app/message.service.ts":
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
var MessageService = (function () {
    function MessageService(http) {
        this.http = http;
    }
    MessageService.prototype.getMessagesFromMechanicDialog = function (id) {
        var params = new http_1.URLSearchParams();
        params.set('dialogId', id);
        var options = new http_1.RequestOptions({ params: params });
        return this.http.get('http://localhost:8080/mechanic/readMessages', options).map(function (r) { return r.json(); })
            .catch(function (err, caught) { return Observable_1.Observable.of([]); });
    };
    MessageService.prototype.getMessagesFromUserDialog = function (id) {
        var params = new http_1.URLSearchParams();
        params.set('dialogId', id);
        var options = new http_1.RequestOptions({ params: params });
        return this.http.get('http://localhost:8080/user/readUserMessages', options).map(function (r) { return r.json(); })
            .catch(function (err, caught) { return Observable_1.Observable.of([]); });
    };
    MessageService.prototype.getMechanicDialogs = function () {
        return this.http.get('http://localhost:8080/mechanic/readDialogs').map(function (r) { return r.json(); })
            .catch(function (err, caught) { return Observable_1.Observable.of([]); });
    };
    MessageService.prototype.getUserDialogs = function () {
        return this.http.get('http://localhost:8080/user/readUserDialogs').map(function (r) { return r.json(); })
            .catch(function (err, caught) { return Observable_1.Observable.of([]); });
    };
    MessageService.prototype.sendMechanicMessage = function (id, content) {
        var body = new http_1.URLSearchParams();
        body.set('dialogId', id);
        body.set('content', content);
        return this.http.post('http://localhost:8080/mechanic/writeMessage', body).map(function (r) { return r.json(); });
    };
    MessageService.prototype.sendUserMessage = function (id, content) {
        var body = new http_1.URLSearchParams();
        body.set('dialogId', id);
        body.set('content', content);
        return this.http.post('http://localhost:8080/user/writeMessage', body).map(function (r) { return r.json(); });
    };
    return MessageService;
}());
MessageService = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [typeof (_a = typeof http_1.Http !== "undefined" && http_1.Http) === "function" && _a || Object])
], MessageService);
exports.MessageService = MessageService;
var _a;
//# sourceMappingURL=message.service.js.map

/***/ }),

/***/ "./src/app/message.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Message = (function () {
    function Message() {
    }
    return Message;
}());
exports.Message = Message;
//# sourceMappingURL=message.js.map

/***/ })

});
//# sourceMappingURL=message.module.chunk.js.map