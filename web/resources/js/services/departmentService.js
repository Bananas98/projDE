var DepartmentService = function() {
    this.entityType = "department";
    this.depRules = this.setRules();
    this.showEntity();
};

DepartmentService.prototype.showEntity = function () {
    var thisObj = this;
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/listDepartment",
        dataType: "json",
        timeout: 10000,
        success: function (data) {
            var table = new TableDrawer(data,thisObj);
            $('div.department').html(table);
        }
    });
};

DepartmentService.prototype.addEntity = function(department) {
    var thisObj = this;
    $.ajax({
        type : "GET",
        dataType: 'html',
        success : function () {
            var table = new FormDrawer(department,thisObj);
            $('div.department').html(table);
            $('form.form').validate(thisObj.setRules());

        }
    });
};

DepartmentService.prototype.deleteEntity = function(department) {
    var id = department.id.toString();
    var thisObj = this;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/deleteDepartment",
        data: JSON.stringify(id),
        dataType: 'html',
        success: function () {
            thisObj.showEntity();
        }
    });
};


DepartmentService.prototype.submitEntity = function() {
    var thisObj = this;
    var department = {};
    department["id"] = $('#id').val();
    department["name"] = $('#name').val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/addEditDepartment",
        data : JSON.stringify(department),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            if(data.status == "SUCCESS") {
                thisObj.showEntity();
            } else {
                var department = data.result;
                thisObj.errorMessage = data.error.name;
                var table = new FormDrawer(department,thisObj);
                $('div.department').html(table);
                thisObj.errorMessage = "";
            }
        },
        error : function(data) {
            console.log(data);
        }
    });
};

DepartmentService.prototype.setRules = function() {
    var id = $('#id').val() === undefined || $('#id').val() === "" ? null : $('#id').val();
    var url = "/checkName?id="+id;
    return {
        rules: {
            name: {
                required: true,
                minlength: 3,
                remote : {
                    contentType : "application/json",
                    type : "POST",
                    url : url,
                    dataType : 'json',
                    timeout : 100000
                }
            }
        },
        messages: {
            name: {
                required: "<li>Please enter a name.</li>",
                minlength: "<li>Your name is not long enough.</li>",
                remote : "<li>This name is using!</li>"
            }
        },

        errorElement: "span",
        errorClass: "help-block",
        highlight: function(element) {
            $(element).closest('.input-group').removeClass('has-success').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.input-group').removeClass('has-error').addClass('has-success');
        },
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    }
};


