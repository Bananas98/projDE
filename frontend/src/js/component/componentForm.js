import {Routes} from "../routes";

export class ComponentForm {
    constructor(department, thisObj) {
        this.dataSource = department;
        this.entity = thisObj;
        return this.addDepartmentTemplate();
    }



    addDepartmentTemplate = function () {
        const dataSource = this.dataSource;
        const entity = this.entity;

        const div = $('<div class="container-center"/>');
        const form =  Routes.prototype.getForm(dataSource);
        div.append(form);

        if (dataSource.entityType === "department") {
            const departmentHead = $('<h1><span class="label label-default"></span></h1>');
            const inputs = $('<input type="hidden" name="id" id = "id"/>')
                .val(entity.id);
            const addon = $('<div id="nameForm"/>').addClass("input-group input-group-lg");
            const label = $('<span class="input-group-addon" id="sizing-addon2">Name:</span>');
            const inputName = $('<input ' +
                'type = "text" ' +
                'id = "name" ' +
                'name = "name" ' +
                ' placeholder="Department name"' +
                ' aria-describedby="sizing-addon2"' +
                '/>').val(entity.name).addClass("form-control");

            const departmentSubmit = $('<button id="submitDepartment type="button" class="btn btn-primary btn-lg">Submit</button>');

            $(label).appendTo(addon);
            $(inputName).appendTo(addon);
            form.append(departmentHead);
            form.append(inputs);
            form.append(addon);
            form.append(departmentSubmit);

        } else if (dataSource.entityType === "employee") {
            const head = $('<h1><span class="label label-default"></span></h1>');

            const id = $('<input type="hidden" name="id" id = "id"/>').val(entity.id);

            const departmentId = $('<input type="hidden" name="departmentId" id = "departmentId"/>').val(entity.departmentId);

            const nameForm = $('<div/>').addClass("input-group input-group-lg");
            const name = $('<span class="input-group-addon" id="sizing-addon2">Name:</span>');
            $(name).appendTo(nameForm);
            const inputName = $('<input ' +
                'type = "text" ' +
                'id = "name" ' +
                'name = "name"' +
                ' placeholder="Name"' +
                ' aria-describedby="sizing-addon2"' +
                '/>').addClass("form-control").val(entity.name);
            $(inputName).appendTo(inputName);

            const dateForm = $('<div/>').addClass("input-group input-group-lg");
            const date = $('<span class="input-group-addon" id="sizing-addon2">Date of Birthday:</span>');
            $(date).appendTo(dateForm);
            const inputDate = $('<input ' +
                'type = "text" ' +
                'id = "dateOfBirthday" ' +
                'name = "dateOfBirthday"' +
                ' placeholder="11-09-1998"' +
                ' aria-describedby="sizing-addon2"' +
                '/>').addClass("form-control").val(entity.dateOfBirthday);
            $(inputDate).appendTo(dateForm);

            const emailForm = $('<div/>').addClass("input-group input-group-lg");
            const email = $('<span class="input-group-addon" id="sizing-addon2">Email:</span>');
            $(email).appendTo(emailForm);
            const inputEmail = $('<input ' +
                'type = "text" ' +
                'id = "email" ' +
                'name = "email"' +
                ' placeholder="david.nasirov@gmail.com"' +
                ' aria-describedby="sizing-addon2"' +
                '/>').addClass("form-control").val(entity.email);
            $(inputEmail).appendTo(emailForm);

            const salaryForm = $('<div/>').addClass("input-group input-group-lg");
            const salary = $('<span class="input-group-addon" id="sizing-addon2">Salary:</span>');
            $(salary).appendTo(salaryForm);
            const inputSalary = $('<input ' +
                'type = "text" ' +
                'id = "salary" ' +
                'name = "salary"' +
                ' placeholder="Employee salary"' +
                ' aria-describedby="sizing-addon2"' +
                '/>').addClass("form-control").val(entity.salary);
            $(inputSalary).appendTo(salaryForm);

            const submit = $('<button id="submitEmployee" type="button" class="btn btn-primary btn-lg">Submit</button>');

            form.append(head);
            form.append(id);
            form.append(departmentId);
            form.append(nameForm);
            form.append(dateForm);
            form.append(emailForm);
            form.append(salaryForm);
            form.append(submit);
        }
        return div;
    };
}
