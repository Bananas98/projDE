var FormDrawer = function(entity,dataSource) {
    this.dataSource = dataSource;
    this.entity = entity;
    return this.addDepartmentTemplate();
};

FormDrawer.prototype.addDepartmentTemplate = function () {
    var dataSource = this.dataSource;
    var entity = this.entity;

    var div = $('<div class="container-center"/>');
    var form = $('<form/>').addClass("form")
        .on({
            click :  function(){
                dataSource.submitEntity();
            }
        },'button');
    div.append(form);

    if(dataSource.entityType === "department") {
        var departmentHead = $('<h1><span class="label label-default"></span></h1>');
        var inputs = $('<input type="hidden" name="id" id = "id"/>')
            .val(entity.id);
        var abbon = $('<div id="nameForm"/>').addClass("input-group input-group-lg");
        var label = $('<span class="input-group-addon" id="sizing-addon2">Name:</span>');
        var inputName = $('<input ' +
            'type = "text" ' +
            'id = "name" ' +
            'name = "name" ' +
            'placeholder="Department name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').
        val(entity.name).
        addClass("form-control");

        var departmentSubmit = $('<button id="submitDepartment type="button" class="btn btn-primary btn-lg">Submit</button>');
        //var errorSpan = $('<p/><span style="color: crimson">' + dataSource.errorMessage + '</span>').addClass("error");

        $(label).appendTo(abbon);
        $(inputName).appendTo(abbon);
        form.append(departmentHead);
        form.append(inputs);
        form.append(abbon);
        form.append(departmentSubmit);
        //form.append(errorSpan);
    } else if(dataSource.entityType === "employee") {
        var head = $('<h1><span class="label label-default"></span></h1>');

        var id = $('<input type="hidden" name="id" id = "id"/>').val(entity.id);

        var departmentId = $('<input type="hidden" name="departmentId" id = "departmentId"/>').val(entity.departmentId);

        var nameForm = $('<div/>').addClass("input-group input-group-lg");
        var name = $('<span class="input-group-addon" id="sizing-addon2">Name:</span>');
        $(name).appendTo(nameForm);
        var inputName = $('<input ' +
            'type = "text" ' +
            'id = "name" ' +
            'name = "name"'+
            'placeholder="Name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.name);
        $(inputName).appendTo(inputName);

        var dateForm = $('<div/>').addClass("input-group input-group-lg");
        var date = $('<span class="input-group-addon" id="sizing-addon2">Date of Birthday:</span>');
        $(date).appendTo(dateForm);
        var inputDate = $('<input ' +
            'type = "text" ' +
            'id = "dateOfBirthday" ' +
            'name = "dateOfBirthday"'+
            'placeholder="11-09-1998"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.dateOfBirthday);
        $(inputDate).appendTo(dateForm);

        var emailForm = $('<div/>').addClass("input-group input-group-lg");
        var email = $('<span class="input-group-addon" id="sizing-addon2">Email:</span>');
        $(email).appendTo(emailForm);
        var inputEmail = $('<input ' +
            'type = "text" ' +
            'id = "email" ' +
            'name = "email"'+
            'placeholder="david.nasirov@gmail.com"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.email);
        $(inputEmail).appendTo(emailForm);

        var salaryForm = $('<div/>').addClass("input-group input-group-lg");
        var salary = $('<span class="input-group-addon" id="sizing-addon2">Salary:</span>');
        $(salary).appendTo(salaryForm);
        var inputSalary = $('<input ' +
            'type = "text" ' +
            'id = "salary" ' +
            'name = "salary"'+
            'placeholder="Employee salary"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.salary);
        $(inputSalary).appendTo(salaryForm);

        var submit = $('<button id="submitEmployee" type="button" class="btn btn-primary btn-lg">Submit</button>');

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

