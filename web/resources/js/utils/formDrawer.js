let FormDrawer = function (entity, dataSource) {
    this.dataSource = dataSource;
    this.entity = entity;
    return this.addDepartmentTemplate();
};

FormDrawer.prototype.addDepartmentTemplate = function () {
    let dataSource = this.dataSource;
    let entity = this.entity;

    let div = $('<div class="container-center"/>');
    let form = $('<form/>').addClass("form")
        .on({
            click: function () {
                dataSource.submitEntity();
            }
        }, 'button');
    div.append(form);

    if (dataSource.entityType === "department") {
        let departmentHead = $('<h1><span class="label label-default"></span></h1>');
        let inputs = $('<input type="hidden" name="id" id = "id"/>')
            .val(entity.id);
        let abbon = $('<div id="nameForm"/>').addClass("input-group input-group-lg");
        let label = $('<span class="input-group-addon" id="sizing-addon2">Name:</span>');
        let inputName = $('<input ' +
            'type = "text" ' +
            'id = "name" ' +
            'name = "name" ' +
            'placeholder="Department name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').val(entity.name).addClass("form-control");

        let departmentSubmit = $('<button id="submitDepartment type="button" class="btn btn-primary btn-lg">Submit</button>');
        //let errorSpan = $('<p/><span style="color: crimson">' + dataSource.errorMessage + '</span>').addClass("error");

        $(label).appendTo(abbon);
        $(inputName).appendTo(abbon);
        form.append(departmentHead);
        form.append(inputs);
        form.append(abbon);
        form.append(departmentSubmit);
        //form.append(errorSpan);
    } else if (dataSource.entityType === "employee") {
        let head = $('<h1><span class="label label-default"></span></h1>');

        let id = $('<input type="hidden" name="id" id = "id"/>').val(entity.id);

        let departmentId = $('<input type="hidden" name="departmentId" id = "departmentId"/>').val(entity.departmentId);

        let nameForm = $('<div/>').addClass("input-group input-group-lg");
        let name = $('<span class="input-group-addon" id="sizing-addon2">Name:</span>');
        $(name).appendTo(nameForm);
        let inputName = $('<input ' +
            'type = "text" ' +
            'id = "name" ' +
            'name = "name"' +
            'placeholder="Name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.name);
        $(inputName).appendTo(inputName);

        let dateForm = $('<div/>').addClass("input-group input-group-lg");
        let date = $('<span class="input-group-addon" id="sizing-addon2">Date of Birthday:</span>');
        $(date).appendTo(dateForm);
        let inputDate = $('<input ' +
            'type = "text" ' +
            'id = "dateOfBirthday" ' +
            'name = "dateOfBirthday"' +
            'placeholder="11-09-1998"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.dateOfBirthday);
        $(inputDate).appendTo(dateForm);

        let emailForm = $('<div/>').addClass("input-group input-group-lg");
        let email = $('<span class="input-group-addon" id="sizing-addon2">Email:</span>');
        $(email).appendTo(emailForm);
        let inputEmail = $('<input ' +
            'type = "text" ' +
            'id = "email" ' +
            'name = "email"' +
            'placeholder="david.nasirov@gmail.com"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.email);
        $(inputEmail).appendTo(emailForm);

        let salaryForm = $('<div/>').addClass("input-group input-group-lg");
        let salary = $('<span class="input-group-addon" id="sizing-addon2">Salary:</span>');
        $(salary).appendTo(salaryForm);
        let inputSalary = $('<input ' +
            'type = "text" ' +
            'id = "salary" ' +
            'name = "salary"' +
            'placeholder="Employee salary"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.salary);
        $(inputSalary).appendTo(salaryForm);

        let submit = $('<button id="submitEmployee" type="button" class="btn btn-primary btn-lg">Submit</button>');

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

