import * as $ from 'jquery';

export class EmployeeService {
   // function (departmentService, department) {
   //      this.department = department;
   //      this.entityType = "employee";
   //      this.emplRules = this.setRules();
   //      this.showEntity();
   //  };



    showEntity = function () {
        const id = this.department.id.toString();
        const thisObj = this;

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/employees",
            data: id,
            dataType: "json",
            timeout: 100000,
            success: function (data) {
                const employeeList = data.result;
                thisObj.departmentId = data.departmentId;
                const table = new ListDrawer(employeeList, thisObj);
                $('div.department').html(table);
            }
        });
    };


    addEntity = function (employee) {
        const thisObj = this;
        $.ajax({
            type: "POST",
            dataType: 'html',
            success: function () {
                const form = new FormDrawer(employee, thisObj);
                $('div.department').html(form);
                $('form.form').validate(thisObj.emplRules);
            }
        });
    };



    deleteEntity = function (employee) {
        const id = employee.id.toString();
        const thisObj = this;
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            url: "/employees",
            data: JSON.stringify(id),
            dataType: 'html',
            success: function () {
                thisObj.showEntity();
            }
        });
    };


 submitEntity = function () {
        const thisObj = this;

        const employee = {};
        employee["id"] = $('#id').val();
        employee["departmentId"] = $('#departmentId').val();
        employee["name"] = $('#name').val();
        employee["dateOfBirthday"] = $('#dateOfBirthday').val();
        employee["email"] = $('#email').val();
        employee["salary"] = $('#salary').val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/addEditEmployee",
            data: JSON.stringify(employee),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                if (data.status === "SUCCESS") {
                    const department = {};
                    department["departmentId"] = data.result;
                    thisObj.showEntity(department);
                }

            },
            error: function (data) {
                console.log(data);
            }
        });
    };


    setRules = function () {
        const emplId = $('#id').val() == undefined || $('#id').val() == "" ? null : $('#id').val();
        const url = "/checkEmail?emplId=" + emplId;
        return {
            rules: {
                name: {
                    required: true,
                    minlength: 3,
                    maxlength: 30
                },
                email: {
                    required: true,
                    minlength: 8,
                    maxlength: 30,
                    remote: {
                        contentType: "application/json",
                        type: "POST",
                        url: url,
                        dataType: 'json',
                        timeout: 100000
                    }
                },
                salary: {
                    required: true
                },
                age: {
                    required: true
                },
                date: {
                    required: true
                }
            },
            messages: {
                name: {
                    required: "<li>Please enter your name.</li>",
                    minlength: "<li>Your name is not long enough.</li>",
                    maxlength: "<li>Your name is long enough.</li>"
                },
                email: {
                    required: "<li>Please enter your second email.</li>",
                    minlength: "<li>Your email is not long enough.</li>",
                    maxlength: "<li>Your email is long enough.</li>",
                    remote: "<li>This email is using!</li>"
                },
                salary: {
                    required: "<li>Please enter your salary.</li>"
                },
                date: {
                    required: "<li>Please enter your date of birthday.</li>"
                }
            },
            errorElement: "span",
            errorClass: "help-block",
            highlight: function (element) {
                $(element).closest('.input-group').removeClass('has-success').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.input-group').removeClass('has-error').addClass('has-success');
            },
            errorPlacement: function (error, element) {
                if (element.parent('.input-group').length) {
                    error.insertAfter(element.parent());
                } else {
                    error.insertAfter(element);
                }
            }
        }
    };
}