let ListDrawer = function (entityList, dataSource) {
    this.dataSource = dataSource;
    this.entityList = entityList;
    return this.getList();
};

ListDrawer.prototype.getList = function () {
    let dataSource = this.dataSource;
    let thisObj = this;

    let div = $('<div class="container">').on('click', 'button', function (e) {
        let element = $(e.target);
        let entity = element.parents('tr').data(dataSource.entityType);
        let action = e.target.id;
        if ("btn_del" === action) {
            dataSource.deleteEntity(entity);
        } else if ("btn_info" === action) {
            new EmployeeService(dataSource, entity);
        } else if ("btn_edit" === action) {
            dataSource.addEntity(entity);
        } else if ("btn_add" === action && dataSource.entityType === 'department') {
            entity = new Department();
            dataSource.addEntity(entity);
        } else if ("btn_add" === action && dataSource.entityType === 'employee') {
            entity = new Employee();
            entity["departmentId"] = dataSource.departmentId;
            dataSource.addEntity(entity);
        }
    });
    let list = $('<table class="table table-condensed">');
    div.append(list);

    if (dataSource.entityType === 'department') {
        let departmentHead = $('<tr><th><h2>Id</h2></th><th><h2>Department name</h2></th><th colspan="3"><h2>Options<h2/></th></tr>>');
        let departmentList = _.template('<% _.each(data, function(e) {%> ' +
            '<tr data-department=<%= JSON.stringify(e) %>>' +
            '<td><h4><%= e.id %></h4></td> ' +
            '<td><h4><%= e.name %></h4></td>' +
            '<td><button class = "btn btn-primary btn-md" id = "btn_edit">Edit department</button></td>' +
            '<td><button class = "btn btn-danger btn-md" id = "btn_del">Delete department</button></td>' +
            '<td><button class = "btn btn-primary btn-md" id = "btn_info">Employee list</button></td>' +
            '</tr> <% }); %>')({data: thisObj.entityList});
        $(departmentHead).appendTo(list);
        $(departmentList).appendTo(list);
        $('<button id = "btn_add" />').addClass("btn btn-primary btn-lg").text("+ Add department").appendTo(div);
    } else if (dataSource.entityType === 'employee') {
        let employeeHead = $('<tr>' +
            '<th><h2>Id</h2></th>' +
            '<th><h2>Name</h2></th>' +
            '<th><h2>Date of Birthday</h2></th>' +
            '<th><h2>Email</h2></th>' +
            '<th><h2>Salary</h2></th>' +
            '<th colspan="2"><h2>Options<h2/></th></tr>>');
        let employeeList = _.template('<% _.each(data, function(e) {%> ' +
            '<tr data-employee=<%= JSON.stringify(e) %>>' +
            '<td><h4><%= e.id %></h4></td>' +
            '<td><h4><%= e.name %></h4></td>' +
            '<td><h4><%= e.dateOfBirthday %></h4></td>' +
            '<td><h4><%= e.email %></h4></td>' +
            '<td><h4><%= e.salary %></h4></td>' +
            '<td><button class = "btn btn-danger btn-md" id = "btn_del">Delete employee</button></td>' +
            '<td><button class = "btn btn-primary btn-md" id = "btn_edit">Edit employee</button></td>' +
            '</tr> <% }); %>')({data: thisObj.entityList});
        $(employeeHead).appendTo(list);
        $(employeeList).appendTo(list);
        $('<button id = "btn_add"/>').addClass("btn btn-primary btn-lg").text("+ Add Employee").appendTo(div);
    }

    return div;
};

let Department = function () {
};

let Employee = function () {
};
