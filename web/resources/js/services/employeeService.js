var EmployeeService = function(departmentService,department) {
    this.department = department;
    this.entityType = "employee";
    //this.emplRules = this.setRules();
    this.showEntity();
};


EmployeeService.prototype.showEntity = function() {
    var id = this.department.id.toString();
    var thisObj = this;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/listEmployee",
        data: id,
        dataType : "json",
        timeout: 100000,
        success: function (data) {
            var employeeList = data.result;
            thisObj.departmentId = data.departmentId;
            var table = new ListDrawer(employeeList,thisObj);
            $('div.department').html(table);
        }
    });
};

EmployeeService.prototype.addEntity = function(employee) {
    var thisObj = this;
    $.ajax({
        type : "GET",
        dataType: 'html',
        success : function () {
            var form = new FormDrawer(employee,thisObj);
            $('div.department').html(form);
            $('form.form').validate(thisObj.emplRules);
        }
    });
};


EmployeeService.prototype.deleteEntity = function(employee) {
    var id = employee.id.toString();
    var thisObj = this;
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/deleteEmployee",
        data: JSON.stringify(id),
        dataType: 'html',
        success: function () {
            thisObj.showEntity();
        }
    });
};


EmployeeService.prototype.submitEntity = function() {
    var thisObj = this;

    var employee = {};
    employee["id"] = $('#id').val();
    employee["departmentId"] = $('#departmentId').val();
    employee["name"] = $('#name').val();
    employee["dateOfBirthday"] = $('#dateOfBirthday').val();
    employee["email"] = $('#email').val();
    employee["salary"] = $('#salary').val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/addEditEmployee",
        data : JSON.stringify(employee),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            if(data.status === "SUCCESS") {
                var department = {};
                department["departmentId"] = data.result;
                thisObj.showEntity(department);
            }

        },
        error : function(data) {
            console.log(data);
        }
    });
};
