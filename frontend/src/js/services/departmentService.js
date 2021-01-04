import * as $ from 'jquery';
import {ComponentList} from "../component/componentList";
import {ComponentForm} from "../component/componentForm";

export class DepartmentService {

    constructor() {
        this.entityType = "department";
        this.depRules = this.setValidation();
        this.showEntity();
    }

    showEntity = function () {
        const thisObj = this;
        $.ajax({
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            timeout: 10000,
            success: function (data) {
                const list = new ComponentList(data, thisObj);
                $('div.department').html(list);
            }
        });
    };


    addEntity = function (department) {
        const thisObj = this;
        $.ajax({
            type: "POST",
            dataType: 'html',
            success: function () {
                const list = new ComponentForm(department, thisObj);
                $('div.department').html(list);
                $('form.form').validate(thisObj.setValidation());

            }
        });
    };

    deleteEntity = function (department) {
        const id = department.id.toString();
        const thisObj = this;
        $.ajax({
            type: "DELETE",
            contentType: "application/json",
            data: JSON.stringify(id),
            dataType: 'html',
            success: function () {
                thisObj.showEntity();
            }
        });
    };



    submitEntity = function () {
        const thisObj = this;
        const department = {};
        department["id"] = $('#id').val();
        department["name"] = $('#name').val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(department),
            dataType: 'json',
            timeout: 100000,
            success: function (data) {
                if (data.status === "SUCCESS") {
                    thisObj.showEntity();
                } else {
                    const department = data.result;
                    thisObj.errorMessage = data.error.name;
                    const list = new ComponentForm(department, thisObj);
                    $('div.department').html(list);
                    thisObj.errorMessage = "";
                }
            },
            error: function (data) {
                console.log(data);
            }
        });
    };

    setValidation = function () {
        // const id = $('#id').val() === undefined || $('#id').val() === "" ? null : $('#id').val();
        // const url = "/checkName?id=" + id;
        return {
            rules: {
                name: {
                    required: true,
                    minlength: 3,
                    remote: {
                        contentType: "application/json",
                        type: "POST",
                        // url: url,
                        dataType: 'json',
                        timeout: 100000
                    }
                }
            },
            messages: {
                name: {
                    required: "<li>Please enter a name.</li>",
                    minlength: "<li>Your name is not long enough.</li>",
                    remote: "<li>This name is using!</li>"
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

