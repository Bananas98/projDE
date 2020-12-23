var TableDrawer = function(entityList,dataSource) {
    this.dataSource = dataSource;
    this.entityList = entityList;
    return this.getTable();
};

TableDrawer.prototype.getTable = function () {
    var dataSource = this.dataSource;
    var thisObj = this;

    var div = $('<div class="container">').
    on('click', 'button', function(e) {
        var element = $(e.target);
        var entity = element.parents('tr').data(dataSource.entityType);
        var action = e.target.id;
        if("btn_del" === action) {
            dataSource.deleteEntity(entity);
        } else if ("btn_info" === action) {
            new EmployeeService(dataSource,entity);
        } else if ("btn_edit" === action) {
            dataSource.addEntity(entity);
        } else if ("btn_add" === action && dataSource.entityType == 'department') {
            entity = new Department();
            dataSource.addEntity(entity);
        } else if ("btn_add" === action && dataSource.entityType == 'employee'){
            entity = new Employee();
            entity["id"] = dataSource.id;
            dataSource.addEntity(entity);
        }
    });
    var table = $('<table class="table table-condensed">');
    div.append(table);

    if(dataSource.entityType == 'department') {
        var departmentHead = $('<tr><th><h2>Id</h2></th><th><h2>Department name</h2></th><th colspan="3"><h2>Options<h2/></th></tr>>');
        var departmentList = _.template('<% _.each(data, function(e) {%> ' +
            '<tr data-department=<%= JSON.stringify(e) %>>' +
            '<td><h4><%= e.id %></h4></td> ' +
            '<td><h4><%= e.name %></h4></td>' +
            '<td><button class = "btn btn-danger btn-md" id = "btn_del">Delete department</button></td>' +
            '<td><button class = "btn btn-primary btn-md" id = "btn_edit">Edit department</button></td>' +
            '<td><button class = "btn btn-info btn-md" id = "btn_info">Employee list</button></td>' +
            '</tr> <% }); %>')({data: thisObj.entityList});
        $(departmentHead).appendTo(table);
        $(departmentList).appendTo(table);
        $('<button id = "btn_add" />').addClass("btn btn-primary btn-lg").text("+ Add department").appendTo(div);
    } else if (dataSource.entityType == 'employee') {
        var employeeHead = $('<tr>' +
            '<th><h2>Id</h2></th>' +
            '<th><h2>First name</h2></th>' +
            '<th><h2>Second name</h2></th>' +
            '<th><h2>Email</h2></th>' +
            '<th><h2>Age</h2></th>' +
            '<th><h2>Salary</h2></th>' +
            '<th><h2>Start date</h2></th>' +
            '<th colspan="2"><h2>Options<h2/></th></tr>>');
        var employeeList = _.template('<% _.each(data, function(e) {%> ' +
            '<tr data-employee=<%= JSON.stringify(e) %>>' +
            '<td><h4><%= e.id %></h4></td>' +
            '<td><h4><%= e.firstName %></h4></td>' +
            '<td><h4><%= e.secondName %></h4></td>' +
            '<td><h4><%= e.email %></h4></td>' +
            '<td><h4><%= e.salary %></h4></td>' +
            '<td><h4><%= e.age %></h4></td>' +
            '<td><h4><%= e.startDate %></h4></td>' +
            '<td><button class = "btn btn-danger btn-md" id = "btn_del">Delete employee</button></td>' +
            '<td><button class = "btn btn-primary btn-md" id = "btn_edit">Edit employee</button></td>' +
            '</tr> <% }); %>')({data: thisObj.entityList});
        $(employeeHead).appendTo(table);
        $(employeeList).appendTo(table);
        $('<button id = "btn_add"/>').addClass("btn btn-primary btn-lg").text("+ Add Employee").appendTo(div);
    }

    return div;
};

var Department = function() {
};

var Employee = function() {
};
