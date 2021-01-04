import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'
import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css'
import * as $ from 'jquery'
import {DepartmentService} from "./services/departmentService";

$(document).ready(function () {
    new DepartmentService();
});