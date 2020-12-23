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

    if(dataSource.entityType == "department") {
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
    } else if(dataSource.entityType == "employee") {
        var head = $('<h1><span class="label label-default"></span></h1>');

        var id = $('<input type="hidden" name="id" id = "id"/>')
            .val(entity.id);
        var depId = $('<input type="hidden" name="depId" id = "depId"/>')
            .val(entity.depId);

        var firstNameForm = $('<div/>').addClass("input-group input-group-lg");
        var firstName = $('<span class="input-group-addon" id="sizing-addon2">First name:</span>');
        $(firstName).appendTo(firstNameForm);
        var inputFirstName = $('<input ' +
            'type = "text" ' +
            'id = "firstName" ' +
            'name = "firstName"'+
            'placeholder="First name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.firstName);
        $(inputFirstName).appendTo(firstNameForm);

        var secondNameForm = $('<div/>').addClass("input-group input-group-lg");
        var secondName = $('<span class="input-group-addon" id="sizing-addon2">Second name:</span>');
        $(secondName).appendTo(secondNameForm);
        var inputSecondName = $('<input ' +
            'type = "text" ' +
            'id = "secondName" ' +
            'name = "secondName"'+
            'placeholder="Second name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.secondName);
        $(inputSecondName).appendTo(secondNameForm);


        var emailForm = $('<div/>').addClass("input-group input-group-lg");
        var email = $('<span class="input-group-addon" id="sizing-addon2">Email:</span>');
        $(email).appendTo(emailForm);
        var inputEmail = $('<input ' +
            'type = "text" ' +
            'id = "email" ' +
            'name = "email"'+
            'placeholder="igor.petrov@gmail.com"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.email);
        $(inputEmail).appendTo(emailForm);

        var ageForm = $('<div/>').addClass("input-group input-group-lg");
        var age = $('<span class="input-group-addon" id="sizing-addon2">Age:</span>');
        $(age).appendTo(ageForm);
        var inputAge = $('<input ' +
            'type = "text" ' +
            'id = "age" ' +
            'name = "age"'+
            'placeholder="Employee age"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.age);
        $(inputAge).appendTo(ageForm);

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

        var startDateForm = $('<div/>').addClass("input-group input-group-lg");
        var startDate = $('<span class="input-group-addon" id="sizing-addon2">Start date:</span>');
        $(startDate).appendTo(startDateForm);
        var inputStartDate = $('<input ' +
            'type = "text" ' +
            'id = "startDate" ' +
            'name = "startDate"'+
            'placeholder="Second name"' +
            'aria-describedby="sizing-addon2"' +
            '/>').addClass("form-control").val(entity.startDate);
        $(inputStartDate).appendTo(startDateForm);

        var submit = $('<button id="submitEmployee" type="button" class="btn btn-primary btn-lg">Submit</button>');

        form.append(head);
        form.append(id);
        form.append(depId);
        form.append(firstNameForm);
        form.append(secondNameForm);
        form.append(emailForm);
        form.append(ageForm);
        form.append(salaryForm);
        form.append(startDateForm);
        form.append(submit);
    }

    return div;
};

