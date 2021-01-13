import $ from 'jquery';
import Service from "../services/service";
import validate from "jquery-validation";


export function validationFunction () {

    $.validator.setDefaults({
        errorClass: "warning"
    });

    $.validator.addMethod("nameRequired", $.validator.methods.required, "Name cannot be empty");
    $.validator.addClassRules("`department-name", {nameRequired: true});

    $.validator.addClassRules("employee-name", {nameRequired: true});
    $.validator.addClassRules("dateOfBirthday", {required: true});
    $.validator.addClassRules("salary", {
        min: 0,
        required: true,
        number: true
    });
    $.validator.addClassRules("email", {
        required: true,
        email: true
    })

}
