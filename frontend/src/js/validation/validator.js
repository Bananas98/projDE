import $ from 'jquery';
import Service from "src/js/services/service";
require(`jquery-validation`);

class Validator {

    validationDepartmentFunction () {

        $(`#department-form`).validate({
            "rules": {
                "name": {
                    "maxlength": 16,
                    "minlength": 2,
                    "required": true
                }
            },
            "submitHandler": (form, event) => {
                event.preventDefault();
                Service.insertEntity(
                    `/departments`,
                    Service.toJsonString(form), `department`
                );
            }
        });
    }


    validationEmployeeFunction () {

        $(`#employee-form`).validate({
            "rules": {
                "dateOfBirthday": {
                    "date": true,
                    "dateISO": true,
                    "required": true
                },
                "email": {
                    "email": true,
                    "required": true
                },
                "name": {
                    "maxlength": 20,
                    "minlength": 2,
                    "required": true
                },
                "salary": {
                    "number": true,
                    "required": true
                }


            },
            submitHandler (form, event) {

                event.preventDefault();
                const url = `/employees`;

                Service.insertEntity(
                    url,
                    Service.toJsonString(form), `employee`
                );
            }
        });
    }
}

const validator = new Validator();

export default validator;