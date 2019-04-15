webpackJsonp(["registration.module"],{

/***/ "./node_modules/angular4-multiselect-dropdown/angular4-multiselect-dropdown.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

function __export(m) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}
Object.defineProperty(exports, "__esModule", { value: true });
__export(__webpack_require__("./node_modules/angular4-multiselect-dropdown/dist/multiselect.component.js"));
//# sourceMappingURL=angular4-multiselect-dropdown.js.map

/***/ }),

/***/ "./node_modules/angular4-multiselect-dropdown/dist/clickOutside.js":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ClickOutsideDirective; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return ScrollDirective; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return styleDirective; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return SetPosition; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");

var ClickOutsideDirective = /** @class */ (function () {
    function ClickOutsideDirective(_elementRef) {
        this._elementRef = _elementRef;
        this.clickOutside = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    ClickOutsideDirective.prototype.onClick = function (event, targetElement) {
        if (!targetElement) {
            return;
        }
        var clickedInside = this._elementRef.nativeElement.contains(targetElement);
        if (!clickedInside) {
            this.clickOutside.emit(event);
        }
    };
    ClickOutsideDirective.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Directive"], args: [{
                    // tslint:disable-next-line:directive-selector
                    selector: '[clickOutside]'
                },] },
    ];
    /** @nocollapse */
    ClickOutsideDirective.ctorParameters = function () { return [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"], },
    ]; };
    ClickOutsideDirective.propDecorators = {
        'clickOutside': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"] },],
        'onClick': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["HostListener"], args: ['document:click', ['$event', '$event.target'],] }, { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["HostListener"], args: ['document:touchstart', ['$event', '$event.target'],] },],
    };
    return ClickOutsideDirective;
}());

var ScrollDirective = /** @class */ (function () {
    function ScrollDirective(_elementRef) {
        this._elementRef = _elementRef;
        this.scroll = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
    }
    ScrollDirective.prototype.onClick = function (event, targetElement) {
        this.scroll.emit(event);
    };
    ScrollDirective.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Directive"], args: [{
                    // tslint:disable-next-line:directive-selector
                    selector: '[scroll]'
                },] },
    ];
    /** @nocollapse */
    ScrollDirective.ctorParameters = function () { return [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"], },
    ]; };
    ScrollDirective.propDecorators = {
        'scroll': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"] },],
        'onClick': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["HostListener"], args: ['scroll', ['$event'],] },],
    };
    return ScrollDirective;
}());

// tslint:disable-next-line:class-name
var styleDirective = /** @class */ (function () {
    function styleDirective(el) {
        this.el = el;
    }
    // tslint:disable-next-line:use-life-cycle-interface
    styleDirective.prototype.ngOnInit = function () {
        this.el.nativeElement.style.top = this.styleVal;
    };
    // tslint:disable-next-line:use-life-cycle-interface
    styleDirective.prototype.ngOnChanges = function () {
        this.el.nativeElement.style.top = this.styleVal;
    };
    styleDirective.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Directive"], args: [{
                    // tslint:disable-next-line:directive-selector
                    selector: '[styleProp]'
                },] },
    ];
    /** @nocollapse */
    styleDirective.ctorParameters = function () { return [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"], },
    ]; };
    styleDirective.propDecorators = {
        'styleVal': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"], args: ['styleProp',] },],
    };
    return styleDirective;
}());

// tslint:disable-next-line:directive-class-suffix
var SetPosition = /** @class */ (function () {
    function SetPosition(el) {
        this.el = el;
    }
    SetPosition.prototype.ngOnInit = function () {
        if (this.height) {
            // tslint:disable-next-line:radix
            this.el.nativeElement.style.bottom = parseInt(this.height + 15 + '') + 'px';
        }
    };
    SetPosition.prototype.ngOnChanges = function () {
        if (this.height) {
            // tslint:disable-next-line:radix
            this.el.nativeElement.style.bottom = parseInt(this.height + 15 + '') + 'px';
        }
    };
    SetPosition.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Directive"], args: [{
                    // tslint:disable-next-line:directive-selector
                    selector: '[setPosition]'
                },] },
    ];
    /** @nocollapse */
    SetPosition.ctorParameters = function () { return [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"], },
    ]; };
    SetPosition.propDecorators = {
        'height': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"], args: ['setPosition',] },],
    };
    return SetPosition;
}());

//# sourceMappingURL=clickOutside.js.map

/***/ }),

/***/ "./node_modules/angular4-multiselect-dropdown/dist/list-filter.js":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ListFilterPipe; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");

var ListFilterPipe = /** @class */ (function () {
    function ListFilterPipe() {
    }
    ListFilterPipe.prototype.transform = function (items, filter, searchBy) {
        var _this = this;
        if (!items || !filter) {
            return items;
        }
        return items.filter(function (item) { return _this.applyFilter(item, filter, searchBy); });
    };
    ListFilterPipe.prototype.applyFilter = function (item, filter, searchBy) {
        var found = false;
        if (searchBy.length > 0) {
            for (var t = 0; t < searchBy.length; t++) {
                if (filter && item[searchBy[t]] && item[searchBy[t]] !== '') {
                    if (item[searchBy[t]].toString().toLowerCase().indexOf(filter.toLowerCase()) >= 0) {
                        found = true;
                    }
                }
            }
        }
        else {
            for (var prop in item) {
                if (filter && item[prop]) {
                    if (item[prop].toString().toLowerCase().indexOf(filter.toLowerCase()) >= 0) {
                        found = true;
                    }
                }
            }
        }
        return found;
    };
    ListFilterPipe.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Pipe"], args: [{
                    name: 'listFilter',
                    pure: false
                },] },
    ];
    /** @nocollapse */
    ListFilterPipe.ctorParameters = function () { return []; };
    return ListFilterPipe;
}());

//# sourceMappingURL=list-filter.js.map

/***/ }),

/***/ "./node_modules/angular4-multiselect-dropdown/dist/menu-item.js":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "b", function() { return Item; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return Badge; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return Search; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return TemplateRenderer; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");

// tslint:disable-next-line:component-class-suffix
var Item = /** @class */ (function () {
    function Item() {
    }
    Item.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"], args: [{
                    // tslint:disable-next-line:component-selector
                    selector: 'c-item',
                    template: ""
                },] },
    ];
    /** @nocollapse */
    Item.ctorParameters = function () { return []; };
    Item.propDecorators = {
        'template': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ContentChild"], args: [__WEBPACK_IMPORTED_MODULE_0__angular_core__["TemplateRef"],] },],
    };
    return Item;
}());

// tslint:disable-next-line:component-class-suffix
var Badge = /** @class */ (function () {
    function Badge() {
    }
    Badge.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"], args: [{
                    // tslint:disable-next-line:component-selector
                    selector: 'c-badge',
                    template: ""
                },] },
    ];
    /** @nocollapse */
    Badge.ctorParameters = function () { return []; };
    Badge.propDecorators = {
        'template': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ContentChild"], args: [__WEBPACK_IMPORTED_MODULE_0__angular_core__["TemplateRef"],] },],
    };
    return Badge;
}());

// tslint:disable-next-line:component-class-suffix
var Search = /** @class */ (function () {
    function Search() {
    }
    Search.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"], args: [{
                    // tslint:disable-next-line:component-selector
                    selector: 'c-search',
                    template: ""
                },] },
    ];
    /** @nocollapse */
    Search.ctorParameters = function () { return []; };
    Search.propDecorators = {
        'template': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ContentChild"], args: [__WEBPACK_IMPORTED_MODULE_0__angular_core__["TemplateRef"],] },],
    };
    return Search;
}());

// tslint:disable-next-line:component-class-suffix
var TemplateRenderer = /** @class */ (function () {
    function TemplateRenderer(viewContainer) {
        this.viewContainer = viewContainer;
    }
    TemplateRenderer.prototype.ngOnInit = function () {
        this.view = this.viewContainer.createEmbeddedView(this.data.template, {
            '\$implicit': this.data,
            'item': this.item
        });
    };
    TemplateRenderer.prototype.ngOnDestroy = function () {
        this.view.destroy();
    };
    TemplateRenderer.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"], args: [{
                    // tslint:disable-next-line:component-selector
                    selector: 'c-templateRenderer',
                    template: ""
                },] },
    ];
    /** @nocollapse */
    TemplateRenderer.ctorParameters = function () { return [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewContainerRef"], },
    ]; };
    TemplateRenderer.propDecorators = {
        'data': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"] },],
        'item': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"] },],
    };
    return TemplateRenderer;
}());

//# sourceMappingURL=menu-item.js.map

/***/ }),

/***/ "./node_modules/angular4-multiselect-dropdown/dist/multiselect.component.js":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DROPDOWN_CONTROL_VALUE_ACCESSOR", function() { return DROPDOWN_CONTROL_VALUE_ACCESSOR; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "DROPDOWN_CONTROL_VALIDATION", function() { return DROPDOWN_CONTROL_VALIDATION; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AngularMultiSelect", function() { return AngularMultiSelect; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AngularMultiSelectModule", function() { return AngularMultiSelectModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("./node_modules/@angular/core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("./node_modules/@angular/forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_common__ = __webpack_require__("./node_modules/@angular/common/@angular/common.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__multiselect_model__ = __webpack_require__("./node_modules/angular4-multiselect-dropdown/dist/multiselect.model.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__clickOutside__ = __webpack_require__("./node_modules/angular4-multiselect-dropdown/dist/clickOutside.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__list_filter__ = __webpack_require__("./node_modules/angular4-multiselect-dropdown/dist/list-filter.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__menu_item__ = __webpack_require__("./node_modules/angular4-multiselect-dropdown/dist/menu-item.js");







var DROPDOWN_CONTROL_VALUE_ACCESSOR = {
    provide: __WEBPACK_IMPORTED_MODULE_1__angular_forms__["NG_VALUE_ACCESSOR"],
    useExisting: Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["forwardRef"])(function () { return AngularMultiSelect; }),
    multi: true
};
var DROPDOWN_CONTROL_VALIDATION = {
    provide: __WEBPACK_IMPORTED_MODULE_1__angular_forms__["NG_VALIDATORS"],
    useExisting: Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["forwardRef"])(function () { return AngularMultiSelect; }),
    multi: true,
};
var noop = function () {
};
// tslint:disable-next-line:component-class-suffix
var AngularMultiSelect = /** @class */ (function () {
    function AngularMultiSelect(_elementRef, cdr) {
        this._elementRef = _elementRef;
        this.cdr = cdr;
        this.onSelect = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onDeSelect = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onSelectAll = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onDeSelectAll = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onOpen = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.onClose = new __WEBPACK_IMPORTED_MODULE_0__angular_core__["EventEmitter"]();
        this.isActive = false;
        this.isSelectAll = false;
        this.chunkIndex = [];
        this.cachedItems = [];
        this.itemHeight = 41.6;
        this.defaultSettings = {
            singleSelection: false,
            text: 'Select',
            enableCheckAll: true,
            selectAllText: 'Select All',
            unSelectAllText: 'UnSelect All',
            enableSearchFilter: false,
            searchBy: [],
            maxHeight: 300,
            badgeShowLimit: 999999999999,
            classes: '',
            disabled: false,
            searchPlaceholderText: 'Search',
            showCheckbox: true,
            noDataLabel: 'No Data Available',
            searchAutofocus: true,
            lazyLoading: false,
            labelKey: 'itemName',
            primaryKey: 'id',
            position: 'bottom'
        };
        // tslint:disable-next-line:member-ordering
        this.onTouchedCallback = noop;
        // tslint:disable-next-line:member-ordering
        this.onChangeCallback = noop;
    }
    AngularMultiSelect.prototype.ngOnInit = function () {
        var _this = this;
        this.settings = Object.assign(this.defaultSettings, this.settings);
        if (this.settings.groupBy) {
            this.groupedData = this.transformData(this.data, this.settings.groupBy);
        }
        this.totalRows = (this.data && this.data.length);
        this.cachedItems = this.data;
        this.screenItemsLen = Math.ceil(this.settings.maxHeight / this.itemHeight);
        this.cachedItemsLen = this.screenItemsLen * 3;
        this.totalHeight = this.itemHeight * this.totalRows;
        this.maxBuffer = this.screenItemsLen * this.itemHeight;
        this.lastScrolled = 0;
        this.renderChunk(0, this.cachedItemsLen / 2);
        if (this.settings.position === 'top') {
            setTimeout(function () {
                _this.selectedListHeight = { val: 0 };
                _this.selectedListHeight.val = _this.selectedListElem.nativeElement.clientHeight;
            });
        }
    };
    AngularMultiSelect.prototype.ngOnChanges = function (changes) {
        if (changes.data && !changes.data.firstChange) {
            if (this.settings.groupBy) {
                this.groupedData = this.transformData(this.data, this.settings.groupBy);
                if (this.data.length === 0) {
                    this.selectedItems = [];
                }
            }
        }
        if (changes.settings && !changes.settings.firstChange) {
            this.settings = Object.assign(this.defaultSettings, this.settings);
        }
    };
    // tslint:disable-next-line:use-life-cycle-interface
    AngularMultiSelect.prototype.ngDoCheck = function () {
        if (this.selectedItems) {
            if (this.selectedItems.length === 0 || this.data.length === 0 || this.selectedItems.length < this.data.length) {
                this.isSelectAll = false;
            }
        }
    };
    // tslint:disable-next-line:use-life-cycle-interface
    AngularMultiSelect.prototype.ngAfterViewInit = function () {
        if (this.settings.lazyLoading) {
            this._elementRef.nativeElement.getElementsByClassName('lazyContainer')[0].addEventListener('scroll', this.onScroll.bind(this));
        }
    };
    AngularMultiSelect.prototype.ngAfterViewChecked = function () {
        if (this.selectedListElem.nativeElement.clientHeight && this.settings.position === 'top' && this.selectedListHeight) {
            this.selectedListHeight.val = this.selectedListElem.nativeElement.clientHeight;
            this.cdr.detectChanges();
        }
    };
    AngularMultiSelect.prototype.onItemClick = function (item, index, evt) {
        if (this.settings.disabled) {
            return false;
        }
        var found = this.isSelected(item);
        var limit = this.selectedItems.length < this.settings.limitSelection ? true : false;
        if (!found) {
            if (this.settings.limitSelection) {
                if (limit) {
                    this.addSelected(item);
                    this.onSelect.emit(item);
                }
            }
            else {
                this.addSelected(item);
                this.onSelect.emit(item);
            }
        }
        else {
            this.removeSelected(item);
            this.onDeSelect.emit(item);
        }
        if (this.isSelectAll || this.data.length > this.selectedItems.length) {
            this.isSelectAll = false;
        }
        if (this.data.length === this.selectedItems.length) {
            this.isSelectAll = true;
        }
    };
    AngularMultiSelect.prototype.validate = function (c) {
        return null;
    };
    AngularMultiSelect.prototype.writeValue = function (value) {
        if (value !== undefined && value !== null) {
            if (this.settings.singleSelection) {
                try {
                    if (value.length > 1) {
                        this.selectedItems = [value[0]];
                        throw new __WEBPACK_IMPORTED_MODULE_3__multiselect_model__["a" /* MyException */](404, { 'msg': 'Single Selection Mode, Selected Items cannot have more than one item.' });
                    }
                    else {
                        this.selectedItems = value;
                    }
                }
                catch (e) {
                    console.error(e.body.msg);
                }
            }
            else {
                if (this.settings.limitSelection) {
                    this.selectedItems = value.splice(0, this.settings.limitSelection);
                }
                else {
                    this.selectedItems = value;
                }
                if (this.selectedItems.length === this.data.length && this.data.length > 0) {
                    this.isSelectAll = true;
                }
            }
        }
        else {
            this.selectedItems = [];
        }
    };
    // From ControlValueAccessor interface
    AngularMultiSelect.prototype.registerOnChange = function (fn) {
        this.onChangeCallback = fn;
    };
    // From ControlValueAccessor interface
    AngularMultiSelect.prototype.registerOnTouched = function (fn) {
        this.onTouchedCallback = fn;
    };
    AngularMultiSelect.prototype.trackByFn = function (index, item) {
        return item[this.settings.primaryKey];
    };
    AngularMultiSelect.prototype.isSelected = function (clickedItem) {
        var _this = this;
        var found = false;
        // tslint:disable-next-line:no-unused-expression
        this.selectedItems && this.selectedItems.forEach(function (item) {
            if (clickedItem[_this.settings.primaryKey] === item[_this.settings.primaryKey]) {
                found = true;
            }
        });
        return found;
    };
    AngularMultiSelect.prototype.addSelected = function (item) {
        if (this.settings.singleSelection) {
            this.selectedItems = [];
            this.selectedItems.push(item);
            this.closeDropdown();
        }
        else {
            this.selectedItems.push(item);
        }
        this.onChangeCallback(this.selectedItems);
        this.onTouchedCallback(this.selectedItems);
    };
    AngularMultiSelect.prototype.removeSelected = function (clickedItem) {
        var _this = this;
        // tslint:disable-next-line:no-unused-expression
        this.selectedItems && this.selectedItems.forEach(function (item) {
            if (clickedItem[_this.settings.primaryKey] === item[_this.settings.primaryKey]) {
                _this.selectedItems.splice(_this.selectedItems.indexOf(item), 1);
            }
        });
        this.onChangeCallback(this.selectedItems);
        this.onTouchedCallback(this.selectedItems);
    };
    AngularMultiSelect.prototype.toggleDropdown = function (evt) {
        var _this = this;
        if (this.settings.disabled) {
            return false;
        }
        this.isActive = !this.isActive;
        if (this.isActive) {
            if (this.settings.searchAutofocus && this.settings.enableSearchFilter && !this.searchTempl) {
                setTimeout(function () {
                    _this.searchInput.nativeElement.focus();
                }, 0);
            }
            this.onOpen.emit(true);
        }
        else {
            this.onClose.emit(false);
        }
        evt.preventDefault();
    };
    AngularMultiSelect.prototype.closeDropdown = function () {
        if (this.searchInput && this.settings.lazyLoading) {
            this.searchInput.nativeElement.value = '';
            this.data = [];
            this.data = this.cachedItems;
            this.totalHeight = this.itemHeight * this.data.length;
            this.totalRows = this.data.length;
            this.updateView(this.scrollTop);
        }
        if (this.searchInput) {
            this.searchInput.nativeElement.value = '';
        }
        this.filter = '';
        this.isActive = false;
        this.onClose.emit(false);
    };
    AngularMultiSelect.prototype.toggleSelectAll = function () {
        if (!this.isSelectAll) {
            this.selectedItems = [];
            this.selectedItems = this.data.slice();
            this.isSelectAll = true;
            this.onChangeCallback(this.selectedItems);
            this.onTouchedCallback(this.selectedItems);
            this.onSelectAll.emit(this.selectedItems);
        }
        else {
            this.selectedItems = [];
            this.isSelectAll = false;
            this.onChangeCallback(this.selectedItems);
            this.onTouchedCallback(this.selectedItems);
            this.onDeSelectAll.emit(this.selectedItems);
        }
    };
    AngularMultiSelect.prototype.transformData = function (arr, field) {
        var groupedObj = arr.reduce(function (prev, cur) {
            if (!prev[cur[field]]) {
                prev[cur[field]] = [cur];
            }
            else {
                prev[cur[field]].push(cur);
            }
            return prev;
        }, {});
        var tempArr = [];
        Object.keys(groupedObj).map(function (x) {
            tempArr.push({ key: x, value: groupedObj[x] });
        });
        return tempArr;
    };
    AngularMultiSelect.prototype.renderChunk = function (fromPos, howMany) {
        this.chunkArray = [];
        this.chunkIndex = [];
        var finalItem = fromPos + howMany;
        if (finalItem > this.totalRows) {
            finalItem = this.totalRows;
        }
        for (var i = fromPos; i < finalItem; i++) {
            this.chunkIndex.push((i * this.itemHeight) + 'px');
            this.chunkArray.push(this.data[i]);
        }
    };
    AngularMultiSelect.prototype.onScroll = function (e) {
        this.scrollTop = e.target.scrollTop;
        this.updateView(this.scrollTop);
    };
    AngularMultiSelect.prototype.updateView = function (scrollTop) {
        var scrollPos = scrollTop ? scrollTop : 0;
        var first = (scrollPos / this.itemHeight) - this.screenItemsLen;
        var firstTemp = '' + first;
        // tslint:disable-next-line:radix
        first = parseInt(firstTemp) < 0 ? 0 : parseInt(firstTemp);
        this.renderChunk(first, this.cachedItemsLen);
        this.lastRepaintY = scrollPos;
    };
    AngularMultiSelect.prototype.filterInfiniteList = function (evt) {
        // tslint:disable-next-line:prefer-const
        var filteredElems = [];
        this.data = this.cachedItems.slice();
        if (evt.target.value.toString() !== '') {
            this.data.filter(function (el) {
                for (var prop in el) {
                    if (el[prop].toString().toLowerCase().indexOf(evt.target.value.toString().toLowerCase()) >= 0) {
                        filteredElems.push(el);
                        break;
                    }
                }
            });
            // this.cachedItems = this.data;
            this.totalHeight = this.itemHeight * filteredElems.length;
            this.totalRows = filteredElems.length;
            this.data = [];
            this.data = filteredElems;
            this.updateView(this.scrollTop);
        }
        else if (evt.target.value.toString() === '' && this.cachedItems.length > 0) {
            this.data = [];
            this.data = this.cachedItems;
            this.totalHeight = this.itemHeight * this.data.length;
            this.totalRows = this.data.length;
            this.updateView(this.scrollTop);
        }
    };
    AngularMultiSelect.prototype.getObjectKey = function (nestedObj, objPath) {
        var pathArr = objPath.split('.');
        return pathArr.reduce(function (obj, key) {
            return (obj && obj[key] !== 'undefined') ? obj[key] : undefined;
        }, nestedObj);
    };
    AngularMultiSelect.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"], args: [{
                    // tslint:disable-next-line:component-selector
                    selector: 'angular4-multiselect',
                    template: "\n      <div class=\"cuppa-dropdown\" (clickOutside)=\"closeDropdown()\">\n          <div class=\"selected-list\" #selectedList>\n              <div class=\"c-btn\" (click)=\"toggleDropdown($event)\" [ngClass]=\"{'disabled': settings.disabled}\">\n                  <span *ngIf=\"selectedItems?.length == 0\">{{settings.text}}</span>\n                  <span *ngIf=\"settings.singleSelection\">\n                      <span *ngFor=\"let item of selectedItems;trackBy: trackByFn.bind(this);\">\n                          {{getObjectKey(item,settings.labelKey)}}\n                      </span>\n                  </span>\n                  <div class=\"c-list\" *ngIf=\"selectedItems?.length > 0 && !settings.singleSelection\">\n                      <div class=\"c-token\" *ngFor=\"let item of selectedItems;trackBy: trackByFn.bind(this);let k = index\" [hidden]=\"k > settings.badgeShowLimit-1\">\n                          <span *ngIf=\"!badgeTempl\" class=\"c-label\">{{getObjectKey(item,settings.labelKey)}}</span>\n                          <span *ngIf=\"badgeTempl\" class=\"c-label\">\n                              <c-templateRenderer [data]=\"badgeTempl\" [item]=\"item\"></c-templateRenderer>\n                          </span>\n                          <span class=\"c-remove\" (click)=\"onItemClick(item,k,$event)\">\n                              <svg width=\"100%\" height=\"100%\" version=\"1.1\" id=\"Capa_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n      \t viewBox=\"0 0 47.971 47.971\" style=\"enable-background:new 0 0 47.971 47.971;\" xml:space=\"preserve\">\n      <g>\n      \t<path d=\"M28.228,23.986L47.092,5.122c1.172-1.171,1.172-3.071,0-4.242c-1.172-1.172-3.07-1.172-4.242,0L23.986,19.744L5.121,0.88\n      \t\tc-1.172-1.172-3.07-1.172-4.242,0c-1.172,1.171-1.172,3.071,0,4.242l18.865,18.864L0.879,42.85c-1.172,1.171-1.172,3.071,0,4.242\n      \t\tC1.465,47.677,2.233,47.97,3,47.97s1.535-0.293,2.121-0.879l18.865-18.864L42.85,47.091c0.586,0.586,1.354,0.879,2.121,0.879\n      \t\ts1.535-0.293,2.121-0.879c1.172-1.171,1.172-3.071,0-4.242L28.228,23.986z\"/>\n      </g>\n      </svg>\n\n                          </span>\n                      </div>\n                  </div>\n                  <span class=\"countplaceholder\" *ngIf=\"selectedItems?.length > settings.badgeShowLimit\">+{{selectedItems?.length - settings.badgeShowLimit }}</span>\n                  <!--            <span class=\"fa\" [ngClass]=\"{'c-angle-down': !isActive,'fa-angle-up':isActive}\"></span>\n      --><span *ngIf=\"!isActive\" class=\"c-angle-down\">\n                      <svg version=\"1.1\" id=\"Capa_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n      \t width=\"100%\" height=\"100%\" viewBox=\"0 0 612 612\" style=\"enable-background:new 0 0 612 612;\" xml:space=\"preserve\">\n      <g>\n      \t<g id=\"_x31_0_34_\">\n      \t\t<g>\n      \t\t\t<path d=\"M604.501,134.782c-9.999-10.05-26.222-10.05-36.221,0L306.014,422.558L43.721,134.782\n      \t\t\t\tc-9.999-10.05-26.223-10.05-36.222,0s-9.999,26.35,0,36.399l279.103,306.241c5.331,5.357,12.422,7.652,19.386,7.296\n      \t\t\t\tc6.988,0.356,14.055-1.939,19.386-7.296l279.128-306.268C614.5,161.106,614.5,144.832,604.501,134.782z\"/>\n      \t\t</g>\n      \t</g>\n      </g>\n      </svg>\n\n                  </span>\n                  <span *ngIf=\"isActive\" class=\"c-angle-up\">\n                      <svg version=\"1.1\" id=\"Capa_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n      \t width=\"100%\" height=\"100%\" viewBox=\"0 0 612 612\" style=\"enable-background:new 0 0 612 612;\" xml:space=\"preserve\">\n      <g>\n      \t<g id=\"_x39__30_\">\n      \t\t<g>\n      \t\t\t<path d=\"M604.501,440.509L325.398,134.956c-5.331-5.357-12.423-7.627-19.386-7.27c-6.989-0.357-14.056,1.913-19.387,7.27\n      \t\t\t\tL7.499,440.509c-9.999,10.024-9.999,26.298,0,36.323s26.223,10.024,36.222,0l262.293-287.164L568.28,476.832\n      \t\t\t\tc9.999,10.024,26.222,10.024,36.221,0C614.5,466.809,614.5,450.534,604.501,440.509z\"/>\n      \t\t</g>\n      \t</g>\n      </g>\n\n      </svg>\n\n                  </span>\n              </div>\n          </div>\n          <div [setPosition]=\"selectedListHeight?.val\" class=\"dropdown-list\" [ngClass]=\"{'dropdown-list-top': settings.position == 'top'}\" [hidden]=\"!isActive\">\n              <div [ngClass]=\"{'arrow-up': settings.position == 'bottom', 'arrow-down': settings.position == 'top'}\" class=\"arrow-2\"></div>\n              <div [ngClass]=\"{'arrow-up': settings.position == 'bottom', 'arrow-down': settings.position == 'top'}\"></div>\n              <div class=\"list-area\">\n                  <div class=\"pure-checkbox select-all\" *ngIf=\"settings.enableCheckAll && !settings.singleSelection && !settings.limitSelection\" (click)=\"toggleSelectAll()\">\n                      <input *ngIf=\"settings.showCheckbox\" type=\"checkbox\" [checked]=\"isSelectAll\" [disabled]=\"settings.limitSelection == selectedItems?.length\" />\n                      <label>\n                      <span [hidden]=\"isSelectAll\">{{settings.selectAllText}}</span>\n                      <span [hidden]=\"!isSelectAll\">{{settings.unSelectAllText}}</span>\n                  </label>\n                  </div>\n                  <div class=\"list-filter\" *ngIf=\"settings.enableSearchFilter\">\n                      <span class=\"c-search\">\n                          <svg version=\"1.1\" id=\"Capa_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n      \t width=\"100%\" height=\"100%\" viewBox=\"0 0 615.52 615.52\" style=\"enable-background:new 0 0 615.52 615.52;\"\n      \t xml:space=\"preserve\">\n      <g>\n      \t<g>\n      \t\t<g id=\"Search__x28_and_thou_shall_find_x29_\">\n      \t\t\t<g>\n      \t\t\t\t<path d=\"M602.531,549.736l-184.31-185.368c26.679-37.72,42.528-83.729,42.528-133.548C460.75,103.35,357.997,0,231.258,0\n      \t\t\t\t\tC104.518,0,1.765,103.35,1.765,230.82c0,127.47,102.753,230.82,229.493,230.82c49.53,0,95.271-15.944,132.78-42.777\n      \t\t\t\t\tl184.31,185.366c7.482,7.521,17.292,11.291,27.102,11.291c9.812,0,19.62-3.77,27.083-11.291\n      \t\t\t\t\tC617.496,589.188,617.496,564.777,602.531,549.736z M355.9,319.763l-15.042,21.273L319.7,356.174\n      \t\t\t\t\tc-26.083,18.658-56.667,28.526-88.442,28.526c-84.365,0-152.995-69.035-152.995-153.88c0-84.846,68.63-153.88,152.995-153.88\n      \t\t\t\t\ts152.996,69.034,152.996,153.88C384.271,262.769,374.462,293.526,355.9,319.763z\"/>\n      \t\t\t</g>\n      \t\t</g>\n      \t</g>\n      </g>\n\n      </svg>\n\n                      </span>\n                      <input class=\"c-input\" *ngIf=\"!settings.lazyLoading && !searchTempl\" #searchInput type=\"text\" [placeholder]=\"settings.searchPlaceholderText\" [(ngModel)]=\"filter\">\n                      <input class=\"c-input\" *ngIf=\"settings.lazyLoading && !searchTempl\" #searchInput type=\"text\" [placeholder]=\"settings.searchPlaceholderText\" (keyup)=\"filterInfiniteList($event)\">\n                      <c-templateRenderer *ngIf=\"searchTempl\" [data]=\"searchTempl\" [item]=\"item\"></c-templateRenderer>\n                  </div>\n                  <ul *ngIf=\"!settings.groupBy\" [style.maxHeight]=\"settings.maxHeight+'px'\" class=\"lazyContainer\">\n                      <span *ngIf=\"itemTempl\">\n                  <li *ngFor=\"let item of data | listFilter: filter : settings.searchBy; let i = index;\" (click)=\"onItemClick(item,i,$event)\" class=\"pure-checkbox\">\n                  <input *ngIf=\"settings.showCheckbox\" type=\"checkbox\" [checked]=\"isSelected(item)\" [disabled]=\"settings.limitSelection == selectedItems?.length && !isSelected(item)\"/>\n                  <label></label>\n                  <c-templateRenderer [data]=\"itemTempl\" [item]=\"item\"></c-templateRenderer>\n              </li>\n              </span>\n                      <span *ngIf=\"!itemTempl && !settings.lazyLoading\">\n              <li *ngFor=\"let item of data | listFilter:filter : settings.searchBy; let i = index;\" (click)=\"onItemClick(item,i,$event)\" class=\"pure-checkbox\">\n                  <input *ngIf=\"settings.showCheckbox\" type=\"checkbox\" [checked]=\"isSelected(item)\" [disabled]=\"settings.limitSelection == selectedItems?.length && !isSelected(item)\"/>\n                  <label> {{getObjectKey(item,settings.labelKey)}}</label>\n              </li>\n              </span>\n                      <span *ngIf=\"!itemTempl && settings.lazyLoading\">\n                  <div [ngStyle]=\"{'height':totalHeight+'px'}\" style=\"position: relative;\">\n\n            \n              <li *ngFor=\"let item of chunkArray | listFilter:filter : settings.searchBy; let i = index;\" (click)=\"onItemClick(item,i,$event)\" style=\"position: absolute;width: 100%;\" class=\"pure-checkbox\" [styleProp]=\"chunkIndex[i]\">\n                  <input *ngIf=\"settings.showCheckbox\" type=\"checkbox\" [checked]=\"isSelected(item)\" [disabled]=\"settings.limitSelection == selectedItems?.length && !isSelected(item)\"/>\n                  <label>{{getObjectKey(item,settings.labelKey)}}</label>\n              </li>\n              </div>\n              </span>\n                  </ul>\n                  <div *ngIf=\"settings.groupBy\" [style.maxHeight]=\"settings.maxHeight+'px'\" style=\"overflow: auto;\">\n                      <ul *ngFor=\"let obj of groupedData ; let i = index;\" class=\"list-grp\">\n                          <h4 *ngIf=\"(obj.value | listFilter:filter : settings.searchBy ).length > 0\">{{obj.key}}</h4>\n                          <span *ngIf=\"itemTempl\">\n              <li *ngFor=\"let item of obj.value | listFilter:filter : settings.searchBy; let i = index;\" (click)=\"onItemClick(item,i,$event)\" class=\"pure-checkbox\">\n                  <input *ngIf=\"settings.showCheckbox\" type=\"checkbox\" [checked]=\"isSelected(item)\" [disabled]=\"settings.limitSelection == selectedItems?.length && !isSelected(item)\"/>\n                  <label></label>\n                  <c-templateRenderer [data]=\"itemTempl\" [item]=\"item\"></c-templateRenderer>\n              </li>\n              </span>\n                          <span *ngIf=\"!itemTempl\">\n              <li *ngFor=\"let item of obj.value | listFilter:filter : settings.searchBy; let i = index;\" (click)=\"onItemClick(item,i,$event)\" class=\"pure-checkbox\">\n                  <input *ngIf=\"settings.showCheckbox\" type=\"checkbox\" [checked]=\"isSelected(item)\" [disabled]=\"settings.limitSelection == selectedItems?.length && !isSelected(item)\"/>\n                  <label>{{getObjectKey(item,settings.labelKey)}}</label>\n              </li>\n              </span>\n                      </ul>\n                  </div>\n                  <h5 class=\"list-message\" *ngIf=\"data?.length == 0\">{{settings.noDataLabel}}</h5>\n              </div>\n          </div>\n      </div>\n    ",
                    // tslint:disable-next-line:use-host-property-decorator
                    host: { '[class]': 'defaultSettings.classes' },
                    styles: ["\n      .cuppa-dropdown{position:relative}.c-btn{display:inline-block;background:#fff;border:1px solid #ccc;border-radius:3px;font-size:14px;color:#333}.c-btn.disabled{background:#ccc}.c-btn:focus{outline:none}.selected-list .c-list{float:left;padding:0px;margin:0px;width:calc(100% - 20px)}.selected-list .c-list .c-token{list-style:none;padding:2px 8px;background:#0079FE;color:#fff;border-radius:2px;margin-right:4px;margin-top:2px;float:left;position:relative;padding-right:25px}.selected-list .c-list .c-token .c-label{display:block;float:left}.selected-list .c-list .c-token .c-remove{position:absolute;right:8px;top:50%;transform:translateY(-50%);width:10px}.selected-list .c-list .c-token .c-remove svg{fill:#fff}.selected-list .fa-angle-down,.selected-list .fa-angle-up{font-size:15pt;position:absolute;right:10px;top:50%;transform:translateY(-50%)}.selected-list .c-angle-down,.selected-list .c-angle-up{width:15px;height:15px;position:absolute;right:10px;top:50%;transform:translateY(-50%);pointer-events:none}.selected-list .c-angle-down svg,.selected-list .c-angle-up svg{fill:#333}.selected-list .countplaceholder{position:absolute;right:30px;top:50%;transform:translateY(-50%)}.selected-list .c-btn{width:100%;box-shadow:0px 1px 5px #959595;padding:10px;cursor:pointer;display:flex;position:relative}.selected-list .c-btn .c-icon{position:absolute;right:5px;top:50%;transform:translateY(-50%)}.dropdown-list{position:absolute;padding-top:14px;width:100%;z-index:9999}.dropdown-list ul{padding:0px;list-style:none;overflow:auto;margin:0px}.dropdown-list ul li{padding:10px 10px;cursor:pointer;text-align:left}.dropdown-list ul li:first-child{padding-top:10px}.dropdown-list ul li:last-child{padding-bottom:10px}.dropdown-list ul li:hover{background:#f5f5f5}.dropdown-list ::-webkit-scrollbar{width:8px}.dropdown-list ::-webkit-scrollbar-thumb{background:#cccccc;border-radius:5px}.dropdown-list ::-webkit-scrollbar-track{background:#f2f2f2}.arrow-up,.arrow-down{width:0;height:0;border-left:13px solid transparent;border-right:13px solid transparent;border-bottom:15px solid #fff;margin-left:15px;position:absolute;top:0}.arrow-down{bottom:-14px;top:unset;transform:rotate(180deg)}.arrow-2{border-bottom:15px solid #ccc;top:-1px}.arrow-down.arrow-2{top:unset;bottom:-16px}.list-area{border:1px solid #ccc;border-radius:3px;background:#fff;margin:0px;box-shadow:0px 1px 5px #959595}.select-all{padding:10px;border-bottom:1px solid #ccc;text-align:left}.list-filter{border-bottom:1px solid #ccc;position:relative;padding-left:35px;height:35px}.list-filter input{border:0px;width:100%;height:100%;padding:0px}.list-filter input:focus{outline:none}.list-filter .c-search{position:absolute;top:9px;left:10px;width:15px;height:15px}.list-filter .c-search svg{fill:#888}.pure-checkbox input[type=\"checkbox\"]{border:0;clip:rect(0 0 0 0);height:1px;margin:-1px;overflow:hidden;padding:0;position:absolute;width:1px}.pure-checkbox input[type=\"checkbox\"]:focus+label:before,.pure-checkbox input[type=\"checkbox\"]:hover+label:before{border-color:#0079FE;background-color:#f2f2f2}.pure-checkbox input[type=\"checkbox\"]:active+label:before{transition-duration:0s}.pure-checkbox input[type=\"checkbox\"]+label{position:relative;padding-left:2em;vertical-align:middle;user-select:none;cursor:pointer;margin:0px;color:#000;font-weight:300}.pure-checkbox input[type=\"checkbox\"]+label:before{box-sizing:content-box;content:'';color:#0079FE;position:absolute;top:50%;left:0;width:14px;height:14px;margin-top:-9px;border:2px solid #0079FE;text-align:center;transition:all 0.4s ease}.pure-checkbox input[type=\"checkbox\"]+label:after{box-sizing:content-box;content:'';background-color:#0079FE;position:absolute;top:50%;left:4px;width:10px;height:10px;margin-top:-5px;transform:scale(0);transform-origin:50%;transition:transform 200ms ease-out}.pure-checkbox input[type=\"checkbox\"]:disabled+label:before{border-color:#cccccc}.pure-checkbox input[type=\"checkbox\"]:disabled:focus+label:before .pure-checkbox input[type=\"checkbox\"]:disabled:hover+label:before{background-color:inherit}.pure-checkbox input[type=\"checkbox\"]:disabled:checked+label:before{background-color:#cccccc}.pure-checkbox input[type=\"checkbox\"]+label:after{background-color:transparent;top:50%;left:4px;width:8px;height:3px;margin-top:-4px;border-style:solid;border-color:#ffffff;border-width:0 0 3px 3px;border-image:none;transform:rotate(-45deg) scale(0)}.pure-checkbox input[type=\"checkbox\"]:checked+label:after{content:'';transform:rotate(-45deg) scale(1);transition:transform 200ms ease-out}.pure-checkbox input[type=\"radio\"]:checked+label:before{background-color:white}.pure-checkbox input[type=\"radio\"]:checked+label:after{transform:scale(1)}.pure-checkbox input[type=\"radio\"]+label:before{border-radius:50%}.pure-checkbox input[type=\"checkbox\"]:checked+label:before{background:#0079FE}.pure-checkbox input[type=\"checkbox\"]:checked+label:after{transform:rotate(-45deg) scale(1)}.list-message{text-align:center;margin:0px;padding:15px 0px;font-size:initial}.list-grp{padding:0 15px !important}.list-grp h4{text-transform:capitalize;margin:15px 0px 0px 0px;font-size:14px;font-weight:700}.list-grp>li{padding-left:15px !important}.c-token{background:#004f93 !important}.pure-checkbox label::before{border-color:transparent !important;background:transparent !important}.pure-checkbox label::after{border-color:#004f93 !important}.pure-checkbox input[type=\"checkbox\"]:checked+label[_ngcontent-c1]::before{background:transparent !important}.pure-checkbox input[type=\"checkbox\"]:checked+label[_ngcontent-c1]::after{border-color:#004f93 !important}\n    "],
                    providers: [DROPDOWN_CONTROL_VALUE_ACCESSOR, DROPDOWN_CONTROL_VALIDATION]
                },] },
    ];
    /** @nocollapse */
    AngularMultiSelect.ctorParameters = function () { return [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ElementRef"], },
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ChangeDetectorRef"], },
    ]; };
    AngularMultiSelect.propDecorators = {
        'data': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"] },],
        'settings': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Input"] },],
        'onSelect': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"], args: ['onSelect',] },],
        'onDeSelect': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"], args: ['onDeSelect',] },],
        'onSelectAll': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"], args: ['onSelectAll',] },],
        'onDeSelectAll': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"], args: ['onDeSelectAll',] },],
        'onOpen': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"], args: ['onOpen',] },],
        'onClose': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["Output"], args: ['onClose',] },],
        'itemTempl': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ContentChild"], args: [__WEBPACK_IMPORTED_MODULE_6__menu_item__["b" /* Item */],] },],
        'badgeTempl': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ContentChild"], args: [__WEBPACK_IMPORTED_MODULE_6__menu_item__["a" /* Badge */],] },],
        'searchTempl': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ContentChild"], args: [__WEBPACK_IMPORTED_MODULE_6__menu_item__["c" /* Search */],] },],
        'searchInput': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"], args: ['searchInput',] },],
        'selectedListElem': [{ type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"], args: ['selectedList',] },],
    };
    return AngularMultiSelect;
}());

var AngularMultiSelectModule = /** @class */ (function () {
    function AngularMultiSelectModule() {
    }
    AngularMultiSelectModule.decorators = [
        { type: __WEBPACK_IMPORTED_MODULE_0__angular_core__["NgModule"], args: [{
                    imports: [__WEBPACK_IMPORTED_MODULE_2__angular_common__["CommonModule"], __WEBPACK_IMPORTED_MODULE_1__angular_forms__["FormsModule"]],
                    // tslint:disable-next-line:max-line-length
                    declarations: [AngularMultiSelect, __WEBPACK_IMPORTED_MODULE_4__clickOutside__["a" /* ClickOutsideDirective */], __WEBPACK_IMPORTED_MODULE_4__clickOutside__["b" /* ScrollDirective */], __WEBPACK_IMPORTED_MODULE_4__clickOutside__["d" /* styleDirective */],
                        __WEBPACK_IMPORTED_MODULE_5__list_filter__["a" /* ListFilterPipe */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["b" /* Item */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["d" /* TemplateRenderer */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["a" /* Badge */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["c" /* Search */], __WEBPACK_IMPORTED_MODULE_4__clickOutside__["c" /* SetPosition */]],
                    exports: [AngularMultiSelect, __WEBPACK_IMPORTED_MODULE_4__clickOutside__["a" /* ClickOutsideDirective */], __WEBPACK_IMPORTED_MODULE_4__clickOutside__["b" /* ScrollDirective */], __WEBPACK_IMPORTED_MODULE_4__clickOutside__["d" /* styleDirective */],
                        __WEBPACK_IMPORTED_MODULE_5__list_filter__["a" /* ListFilterPipe */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["b" /* Item */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["d" /* TemplateRenderer */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["a" /* Badge */], __WEBPACK_IMPORTED_MODULE_6__menu_item__["c" /* Search */], __WEBPACK_IMPORTED_MODULE_4__clickOutside__["c" /* SetPosition */]]
                },] },
    ];
    /** @nocollapse */
    AngularMultiSelectModule.ctorParameters = function () { return []; };
    return AngularMultiSelectModule;
}());

//# sourceMappingURL=multiselect.component.js.map

/***/ }),

/***/ "./node_modules/angular4-multiselect-dropdown/dist/multiselect.model.js":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return MyException; });
var MyException = /** @class */ (function () {
    function MyException(status, body) {
        this.status = status;
        this.body = body;
    }
    return MyException;
}());

//# sourceMappingURL=multiselect.model.js.map

/***/ }),

/***/ "./src/app/car-registration/car-registration.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\n  width: 200px;\n}\n"

/***/ }),

/***/ "./src/app/car-registration/car-registration.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Регистрация авто</h1>\n<div class=\"centered\">\n  <form #userform=\"ngForm\" (ngSubmit)=\"submitCar()\">\n    <p>Марка<br>\n      <select [(ngModel)]=\"car.make\" (ngModelChange)=\"getModels()\" name=\"make\" >\n        <option [ngValue]=\"carName\" *ngFor=\"let carName of (carNames)\">\n          {{carName}}\n        </option>\n      </select>\n    </p>\n    <p>Модель<br>\n      <select [(ngModel)]=\"car.model\" (ngModelChange)=\"getModifications()\" name=\"carModel\">\n        <option [ngValue]=\"carModel\" *ngFor=\"let carModel of (carModels)\">\n          {{carModel}}\n        </option>\n      </select>\n    </p>\n    <p>Модификация<br>\n      <select [(ngModel)]=\"car.modification\" name=\"carModification\">\n        <option [ngValue]=\"carModification\" *ngFor=\"let carModification of (carModifications)\">\n          {{carModification}}\n        </option>\n      </select>\n    </p>\n    <p>VIN<br><input type='tel'[(ngModel)]=\"car.vin\" name=\"patronymic\" required maxlength=\"20\"></p>\n    <p><input type=\"submit\" value=\"Сохранить\" [disabled]=\"!userform.valid\"></p>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/car-registration/car-registration.component.ts":
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
var car_1 = __webpack_require__("./src/app/car.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var cars_service_1 = __webpack_require__("./src/app/cars.service.ts");
var settings_1 = __webpack_require__("./src/app/settings.ts");
var CarRegistrationComponent = (function () {
    function CarRegistrationComponent(route, cs, router, title) {
        this.route = route;
        this.cs = cs;
        this.router = router;
        this.title = title;
    }
    CarRegistrationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.car = new car_1.Car();
        this.title.setTitle('Регистрация машины' + settings_1.Settings.title);
        this.cs.getMakes().subscribe(function (data) {
            _this.carNames = JSON.parse(data.text());
        });
    };
    CarRegistrationComponent.prototype.submitCar = function () {
        var _this = this;
        this.cs.setCar(this.car).subscribe(function (response) {
            if (response['_body'] === 'Successful') {
                _this.router.navigate(['/']);
            }
        });
    };
    CarRegistrationComponent.prototype.getModels = function () {
        var _this = this;
        this.cs.getModels(this.car.make).subscribe(function (data) {
            _this.carModels = JSON.parse(data.text());
        });
    };
    CarRegistrationComponent.prototype.getModifications = function () {
        var _this = this;
        this.cs.getModifications(this.car.model).subscribe(function (data) {
            _this.carModifications = JSON.parse(data.text());
        });
    };
    return CarRegistrationComponent;
}());
CarRegistrationComponent = __decorate([
    core_1.Component({
        selector: 'plants-car-registration',
        template: __webpack_require__("./src/app/car-registration/car-registration.component.html"),
        styles: [__webpack_require__("./src/app/car-registration/form.css"), __webpack_require__("./src/app/car-registration/car-registration.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof cars_service_1.CarsService !== "undefined" && cars_service_1.CarsService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object])
], CarRegistrationComponent);
exports.CarRegistrationComponent = CarRegistrationComponent;
var _a, _b, _c, _d;
//# sourceMappingURL=car-registration.component.js.map

/***/ }),

/***/ "./src/app/car-registration/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/mechanic-registration/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/mechanic-registration/mechanic-registration.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\n  width: 200px;\n}\n"

/***/ }),

/***/ "./src/app/mechanic-registration/mechanic-registration.component.html":
/***/ (function(module, exports) {

module.exports = "<ng-container *ngIf=\"mechanic\">\n  <h1>Регистрация</h1>\n  <div class=\"centered\">\n    <form #userform=\"ngForm\" (ngSubmit)=\"submitMechanic()\">\n      <!--<input type=\"hidden\" [(ngModel)]=\"user.id\" name=\"id\">-->\n      <p>Имя<br><input [(ngModel)]=\"mechanic.name\" name=\"name\" required maxlength=\"20\"></p>\n      <p>Фамилия<br><input [(ngModel)]=\"mechanic.surname\" name=\"surname\" required maxlength=\"20\"></p>\n      <p>Отчество<br><input [(ngModel)]=\"mechanic.patronymic\" name=\"patronymic\" required maxlength=\"20\"></p>\n      <p>Выберете сервис<br>\n        <select [(ngModel)]=\"mechanic.service\" name=\"service\">\n        <option [ngValue]=\"service\" *ngFor=\"let service of (services|async)\">\n          {{service.name}}\n        </option>\n        </select>\n      </p>\n      <p>Должность<br><input [(ngModel)]=\"mechanic.post\" name=\"patronymic\" required maxlength=\"20\"></p>\n      <p>О себе<br><input [(ngModel)]=\"mechanic.about\" name=\"patronymic\" required maxlength=\"20\"></p>\n      <p>e-mail<br><input type='email'[(ngModel)]=\"mechanic.mail\" name=\"mail\" required></p>\n      <p>Телефон<br><input type='tel'[(ngModel)]=\"mechanic.phone\" name=\"phone\" required [maxLength]=\"10\"></p>\n      <p>Пароль<br><input type='password'[(ngModel)]=\"mechanic.password\" name=\"password\" required minlength=\"6\"></p>\n      <p><input type=\"submit\" value=\"Сохранить\" [disabled]=\"!userform.valid\"></p>\n    </form>\n  </div>\n</ng-container>\n"

/***/ }),

/***/ "./src/app/mechanic-registration/mechanic-registration.component.ts":
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
var mechanic_1 = __webpack_require__("./src/app/mechanic.ts");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var users_service_1 = __webpack_require__("./src/app/users.service.ts");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var settings_1 = __webpack_require__("./src/app/settings.ts");
var service_service_1 = __webpack_require__("./src/app/service.service.ts");
var MechanicRegistrationComponent = (function () {
    function MechanicRegistrationComponent(route, us, router, title, ss) {
        this.route = route;
        this.us = us;
        this.router = router;
        this.title = title;
        this.ss = ss;
        this.errorMessage = ' ';
    }
    MechanicRegistrationComponent.prototype.ngOnInit = function () {
        this.mechanic = new mechanic_1.Mechanic();
        this.services = this.ss.getServices();
        this.title.setTitle('Регистрация' + settings_1.Settings.title);
    };
    MechanicRegistrationComponent.prototype.submitMechanic = function () {
        var _this = this;
        if (this.checkMail()) {
            this.us.setMechanic(this.mechanic).subscribe(function (response) {
                console.log(response['_body']);
                if (response['_body'] === 'Successful registered') {
                    _this.errorMessage = ' ';
                    _this.router.navigate(['/auth/login']);
                }
                else
                    _this.errorMessage = response['_body'];
            });
        }
        else
            this.errorMessage = 'no valid mail';
    };
    MechanicRegistrationComponent.prototype.checkMail = function () {
        return this.mechanic.mail.includes('@') && (this.mechanic.mail.includes('.ru') || this.mechanic.mail.includes('.com'));
    };
    return MechanicRegistrationComponent;
}());
MechanicRegistrationComponent = __decorate([
    core_1.Component({
        selector: 'plants-mechanic-registration',
        template: __webpack_require__("./src/app/mechanic-registration/mechanic-registration.component.html"),
        styles: [__webpack_require__("./src/app/mechanic-registration/form.css"), __webpack_require__("./src/app/mechanic-registration/mechanic-registration.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof users_service_1.UsersService !== "undefined" && users_service_1.UsersService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object, typeof (_e = typeof service_service_1.ServiceService !== "undefined" && service_service_1.ServiceService) === "function" && _e || Object])
], MechanicRegistrationComponent);
exports.MechanicRegistrationComponent = MechanicRegistrationComponent;
var _a, _b, _c, _d, _e;
//# sourceMappingURL=mechanic-registration.component.js.map

/***/ }),

/***/ "./src/app/mechanic-specialization/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/mechanic-specialization/mechanic-specialization.component.css":
/***/ (function(module, exports) {

module.exports = ""

/***/ }),

/***/ "./src/app/mechanic-specialization/mechanic-specialization.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Выберете марки, на которых вы специализируетесь</h1>\n  <form #userform=\"ngForm\" (ngSubmit)=\"submitCars()\">\n    <select multiple [(ngModel)]=\"selectedCars\" name=\"make[]\">\n      <option [ngValue]=\"carName\" *ngFor=\"let carName of (carNames)\">\n        {{carName}}\n      </option>\n    </select>\n    <p><input type=\"submit\" value=\"Сохранить\" [disabled]=\"!userform.valid\"></p>\n  </form>\n"

/***/ }),

/***/ "./src/app/mechanic-specialization/mechanic-specialization.component.ts":
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
var cars_service_1 = __webpack_require__("./src/app/cars.service.ts");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var settings_1 = __webpack_require__("./src/app/settings.ts");
var MechanicSpecializationComponent = (function () {
    function MechanicSpecializationComponent(route, cs, router, title) {
        this.route = route;
        this.cs = cs;
        this.router = router;
        this.title = title;
    }
    MechanicSpecializationComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.title.setTitle('Регистрация специализации' + settings_1.Settings.title);
        this.cs.getMakes().subscribe(function (data) {
            _this.carNames = JSON.parse(data.text());
        });
    };
    MechanicSpecializationComponent.prototype.submitCars = function () {
        var _this = this;
        console.log(this.selectedCars);
        this.cs.setCars(this.selectedCars).subscribe(function (response) {
            if (response['_body'] === 'Successful') {
                _this.router.navigate(['/']);
            }
        });
    };
    return MechanicSpecializationComponent;
}());
MechanicSpecializationComponent = __decorate([
    core_1.Component({
        selector: 'plants-mechanic-specialization',
        template: __webpack_require__("./src/app/mechanic-specialization/mechanic-specialization.component.html"),
        styles: [__webpack_require__("./src/app/mechanic-specialization/form.css"), __webpack_require__("./src/app/mechanic-specialization/mechanic-specialization.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof cars_service_1.CarsService !== "undefined" && cars_service_1.CarsService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object])
], MechanicSpecializationComponent);
exports.MechanicSpecializationComponent = MechanicSpecializationComponent;
var _a, _b, _c, _d;
//# sourceMappingURL=mechanic-specialization.component.js.map

/***/ }),

/***/ "./src/app/mechanic.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

var __extends = (this && this.__extends) || (function () {
    var extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var user_1 = __webpack_require__("./src/app/user.ts");
var Mechanic = (function (_super) {
    __extends(Mechanic, _super);
    function Mechanic() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Mechanic;
}(user_1.User));
exports.Mechanic = Mechanic;
//# sourceMappingURL=mechanic.js.map

/***/ }),

/***/ "./src/app/registration-routing.module.ts":
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
var mechanic_registration_component_1 = __webpack_require__("./src/app/mechanic-registration/mechanic-registration.component.ts");
var service_registration_component_1 = __webpack_require__("./src/app/service-registration/service-registration.component.ts");
var user_registration_component_1 = __webpack_require__("./src/app/user-registration/user-registration.component.ts");
var service_registration_guard_1 = __webpack_require__("./src/app/service-registration.guard.ts");
var car_registration_component_1 = __webpack_require__("./src/app/car-registration/car-registration.component.ts");
var registered_guard_1 = __webpack_require__("./src/app/registered.guard.ts");
var mechanic_specialization_component_1 = __webpack_require__("./src/app/mechanic-specialization/mechanic-specialization.component.ts");
var specialization_guard_1 = __webpack_require__("./src/app/specialization.guard.ts");
var appRoutes = [
    { path: '', children: [
            { path: 'driver', component: user_registration_component_1.UserRegistrationComponent },
            { path: 'mechanic', component: mechanic_registration_component_1.MechanicRegistrationComponent },
            { path: 'service', component: service_registration_component_1.ServiceRegistrationComponent, canActivate: [service_registration_guard_1.ServiceRegistrationGuard] },
            { path: 'car', component: car_registration_component_1.CarRegistrationComponent, canActivate: [registered_guard_1.RegisteredGuard] },
            { path: 'specialization', component: mechanic_specialization_component_1.MechanicSpecializationComponent, canActivate: [specialization_guard_1.SpecializationGuard] },
        ] }
];
var RegistrationRoutingModule = (function () {
    function RegistrationRoutingModule() {
    }
    return RegistrationRoutingModule;
}());
RegistrationRoutingModule = __decorate([
    core_1.NgModule({
        imports: [
            router_1.RouterModule.forChild(appRoutes)
        ],
        exports: [
            router_1.RouterModule
        ],
        providers: [service_registration_guard_1.ServiceRegistrationGuard, registered_guard_1.RegisteredGuard, specialization_guard_1.SpecializationGuard]
    })
], RegistrationRoutingModule);
exports.RegistrationRoutingModule = RegistrationRoutingModule;
//# sourceMappingURL=registration-routing.module.js.map

/***/ }),

/***/ "./src/app/registration.module.ts":
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
var users_service_1 = __webpack_require__("./src/app/users.service.ts");
var mechanic_registration_component_1 = __webpack_require__("./src/app/mechanic-registration/mechanic-registration.component.ts");
var user_registration_component_1 = __webpack_require__("./src/app/user-registration/user-registration.component.ts");
var service_registration_component_1 = __webpack_require__("./src/app/service-registration/service-registration.component.ts");
var http_1 = __webpack_require__("./node_modules/@angular/http/@angular/http.es5.js");
var forms_1 = __webpack_require__("./node_modules/@angular/forms/@angular/forms.es5.js");
var service_service_1 = __webpack_require__("./src/app/service.service.ts");
var registration_routing_module_1 = __webpack_require__("./src/app/registration-routing.module.ts");
var common_1 = __webpack_require__("./node_modules/@angular/common/@angular/common.es5.js");
var car_registration_component_1 = __webpack_require__("./src/app/car-registration/car-registration.component.ts");
var cars_service_1 = __webpack_require__("./src/app/cars.service.ts");
var mechanic_specialization_component_1 = __webpack_require__("./src/app/mechanic-specialization/mechanic-specialization.component.ts");
var angular4_multiselect_dropdown_1 = __webpack_require__("./node_modules/angular4-multiselect-dropdown/angular4-multiselect-dropdown.ts");
var RegistrationModule = (function () {
    function RegistrationModule() {
    }
    return RegistrationModule;
}());
RegistrationModule = __decorate([
    core_1.NgModule({
        declarations: [
            mechanic_registration_component_1.MechanicRegistrationComponent,
            user_registration_component_1.UserRegistrationComponent,
            service_registration_component_1.ServiceRegistrationComponent,
            car_registration_component_1.CarRegistrationComponent,
            mechanic_specialization_component_1.MechanicSpecializationComponent,
        ],
        schemas: [core_1.NO_ERRORS_SCHEMA],
        imports: [
            common_1.CommonModule,
            forms_1.FormsModule,
            http_1.HttpModule,
            registration_routing_module_1.RegistrationRoutingModule,
            angular4_multiselect_dropdown_1.AngularMultiSelectModule
        ],
        providers: [users_service_1.UsersService, service_service_1.ServiceService, cars_service_1.CarsService]
    })
], RegistrationModule);
exports.RegistrationModule = RegistrationModule;
//# sourceMappingURL=registration.module.js.map

/***/ }),

/***/ "./src/app/service-registration.guard.ts":
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
var ServiceRegistrationGuard = (function () {
    function ServiceRegistrationGuard(as) {
        this.as = as;
    }
    ServiceRegistrationGuard.prototype.canActivate = function (next, state) {
        return this.as.getRole().map(function (role) { return role === 'mechanic'; });
    };
    return ServiceRegistrationGuard;
}());
ServiceRegistrationGuard = __decorate([
    core_1.Injectable(),
    __metadata("design:paramtypes", [typeof (_a = typeof auth_service_1.AuthService !== "undefined" && auth_service_1.AuthService) === "function" && _a || Object])
], ServiceRegistrationGuard);
exports.ServiceRegistrationGuard = ServiceRegistrationGuard;
var _a;
//# sourceMappingURL=service-registration.guard.js.map

/***/ }),

/***/ "./src/app/service-registration/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/service-registration/service-registration.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\n  width: 200px;\n}\n"

/***/ }),

/***/ "./src/app/service-registration/service-registration.component.html":
/***/ (function(module, exports) {

module.exports = "<h1>Ваш сервис</h1>\n<h1>При регистрации сервиса вы будете удалены из предыдущего места работы!</h1>\n<div class=\"centered\">\n  <form #userform=\"ngForm\" (ngSubmit)=\"submitService()\">\n    <p>Название<br><input [(ngModel)]=\"service.name\" name=\"name\"></p>\n    <p>Описание<br><input [(ngModel)]=\"service.about\" name=\"about\"></p>\n    <p>Ссылка<br><input [(ngModel)]=\"service.href\" name=\"href\"></p>\n    <p>Телефон<br><input type='tel'[(ngModel)]=\"service.phone\" name=\"phone\" required [maxLength]=\"10\"></p>\n    <p>Часы работы<br><input [(ngModel)]=\"service.hours\" name=\"hours\" required maxlength=\"5\"></p>\n    <p><input type=\"submit\" value=\"Сохранить\" [disabled]=\"!userform.valid\"></p>\n  </form>\n</div>\n"

/***/ }),

/***/ "./src/app/service-registration/service-registration.component.ts":
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
var service_1 = __webpack_require__("./src/app/service.ts");
var settings_1 = __webpack_require__("./src/app/settings.ts");
var platform_browser_1 = __webpack_require__("./node_modules/@angular/platform-browser/@angular/platform-browser.es5.js");
var router_1 = __webpack_require__("./node_modules/@angular/router/@angular/router.es5.js");
var service_service_1 = __webpack_require__("./src/app/service.service.ts");
var ServiceRegistrationComponent = (function () {
    function ServiceRegistrationComponent(route, ss, router, title) {
        this.route = route;
        this.ss = ss;
        this.router = router;
        this.title = title;
    }
    ServiceRegistrationComponent.prototype.ngOnInit = function () {
        this.service = new service_1.Service();
        this.title.setTitle('Регистрация сервиса' + settings_1.Settings.title);
    };
    ServiceRegistrationComponent.prototype.submitService = function () {
        var _this = this;
        this.ss.setService(this.service).subscribe(function (response) {
            if (response['_body'] === 'Successful') {
                _this.router.navigate(['/services']);
            }
        });
    };
    return ServiceRegistrationComponent;
}());
ServiceRegistrationComponent = __decorate([
    core_1.Component({
        selector: 'plants-service-registration',
        template: __webpack_require__("./src/app/service-registration/service-registration.component.html"),
        styles: [__webpack_require__("./src/app/service-registration/form.css"), __webpack_require__("./src/app/service-registration/service-registration.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof service_service_1.ServiceService !== "undefined" && service_service_1.ServiceService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object])
], ServiceRegistrationComponent);
exports.ServiceRegistrationComponent = ServiceRegistrationComponent;
var _a, _b, _c, _d;
//# sourceMappingURL=service-registration.component.js.map

/***/ }),

/***/ "./src/app/service.ts":
/***/ (function(module, exports, __webpack_require__) {

"use strict";

Object.defineProperty(exports, "__esModule", { value: true });
var Service = (function () {
    function Service() {
        this.photoHref = 'image/services/Garage 13.jpg';
    }
    return Service;
}());
exports.Service = Service;
//# sourceMappingURL=service.js.map

/***/ }),

/***/ "./src/app/user-registration/form.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  margin: 30px auto;\r\n}\r\nform {\r\n  border: Black 1px dotted;\r\n  padding: 10px;\r\n}\r\nform input, form select, form textarea {\r\n  width: calc(100% - 2 * 3px - 2 * 3px);\r\n  border: Black 3px double;\r\n  padding: 3px;\r\n}\r\nform input[type=submit], form input[type=checkbox] {\r\n  width: auto;\r\n}\r\nform *.ng-invalid.ng-dirty {\r\n  border-color: Red;\r\n}\r\n"

/***/ }),

/***/ "./src/app/user-registration/user-registration.component.css":
/***/ (function(module, exports) {

module.exports = "div.centered {\r\n  width: 200px;\r\n}"

/***/ }),

/***/ "./src/app/user-registration/user-registration.component.html":
/***/ (function(module, exports) {

module.exports = "<ng-container *ngIf=\"user\">\n  <h1>Регистрация</h1>\n  <div class=\"centered\">\n    <form #userform=\"ngForm\" (ngSubmit)=\"submitUser()\">\n      <!--<input type=\"hidden\" [(ngModel)]=\"user.id\" name=\"id\">-->\n      <p>Имя<br><input [(ngModel)]=\"user.name\" name=\"name\" required maxlength=\"20\"></p>\n      <p>Фамилия<br><input [(ngModel)]=\"user.surname\" name=\"surname\" required maxlength=\"20\"></p>\n      <p>Отчество<br><input [(ngModel)]=\"user.patronymic\" name=\"patronymic\" required maxlength=\"20\"></p>\n      <p>e-mail<br><input type='email'[(ngModel)]=\"user.mail\" name=\"mail\" required></p>\n      <p>Телефон<br><input type='tel'[(ngModel)]=\"user.phone\" name=\"phone\" required [maxLength]=\"10\"></p>\n      <p>Пароль<br><input type='password'[(ngModel)]=\"user.password\" name=\"password\" required minlength=\"6\"></p>\n      <p><input type=\"submit\" value=\"Сохранить\" [disabled]=\"!userform.valid\"></p>\n    </form>\n  </div>\n  <p>{{errorMessage}}</p>\n</ng-container>\n"

/***/ }),

/***/ "./src/app/user-registration/user-registration.component.ts":
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
var users_service_1 = __webpack_require__("./src/app/users.service.ts");
var user_1 = __webpack_require__("./src/app/user.ts");
var UserRegistrationComponent = (function () {
    function UserRegistrationComponent(route, us, router, title) {
        this.route = route;
        this.us = us;
        this.router = router;
        this.title = title;
        this.errorMessage = ' ';
    }
    UserRegistrationComponent.prototype.ngOnInit = function () {
        this.user = new user_1.User();
        this.title.setTitle('Регистрация' + settings_1.Settings.title);
        // this.getTest();
    };
    UserRegistrationComponent.prototype.submitUser = function () {
        var _this = this;
        if (this.checkMail()) {
            this.us.setUser(this.user).subscribe(function (response) {
                console.log(response['_body']);
                if (response['_body'] === 'Successful registered') {
                    _this.errorMessage = ' ';
                    _this.router.navigate(['/auth/login']);
                }
                else {
                    _this.errorMessage = 'This mail has already registered';
                }
            });
        }
        else
            this.errorMessage = 'No valid mail';
    };
    UserRegistrationComponent.prototype.checkMail = function () {
        return this.user.mail.includes('@') && (this.user.mail.includes('.ru') || this.user.mail.includes('.com'));
    };
    return UserRegistrationComponent;
}());
UserRegistrationComponent = __decorate([
    core_1.Component({
        selector: 'plants-user-registration',
        template: __webpack_require__("./src/app/user-registration/user-registration.component.html"),
        styles: [__webpack_require__("./src/app/user-registration/form.css"), __webpack_require__("./src/app/user-registration/user-registration.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof router_1.ActivatedRoute !== "undefined" && router_1.ActivatedRoute) === "function" && _a || Object, typeof (_b = typeof users_service_1.UsersService !== "undefined" && users_service_1.UsersService) === "function" && _b || Object, typeof (_c = typeof router_1.Router !== "undefined" && router_1.Router) === "function" && _c || Object, typeof (_d = typeof platform_browser_1.Title !== "undefined" && platform_browser_1.Title) === "function" && _d || Object])
], UserRegistrationComponent);
exports.UserRegistrationComponent = UserRegistrationComponent;
var _a, _b, _c, _d;
//# sourceMappingURL=user-registration.component.js.map

/***/ })

});
//# sourceMappingURL=registration.module.chunk.js.map