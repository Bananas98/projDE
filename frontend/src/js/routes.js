import {EmployeeService} from "./services/employeeService";
import * as $ from 'jquery';

export class Routes {

    getAction(dataSource) {
        $('<div class="container">').on('click', 'button', function (e) {
            const element = $(e.target);
            let entity = element.parents('tr').data(dataSource.entityType);
            const action = e.target.id;
            if ("btn_del" === action) {
                dataSource.deleteEntity(entity);
            } else if ("btn_info" === action) {
                new EmployeeService(dataSource, entity);
            } else if ("btn_edit" === action) {
                dataSource.addEntity(entity);
            } else if ("btn_add" === action && dataSource.entityType === 'department') {
                entity = new Department();//
                dataSource.addEntity(entity);
            } else if ("btn_add" === action && dataSource.entityType === 'employee') {
                entity = new Employee();
                entity["departmentId"] = dataSource.departmentId;
                dataSource.addEntity(entity);
            }
        });
    }

    getForm(dataSource){
        return $('<form/>').addClass("form").on({
            click: function () {
                dataSource.submitEntity();
            }
        }, 'button');
    }

}



const Department = function () {
};

const Employee = function () {
};