import Builder from "src/js/component/builder";
import {validationFunction} from "src/js/validation/validator";
import EmployeeService from "../../services/emplooyeeService";

class FormEmployee extends Component {
    render () {

        $(`.app`).
            empty();
        let id;
        if (window.location.hash.split('?').length){
            id = window.location.hash.split(`=`)[1];
        }
        const promise = EmployeeService.getEmployeeList(`employees?id=${id}`).
            then((res) => res.json()).
            then((out) => out).
            catch();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            div = $(`<div>`).addClass(`form-class col-lg-5`),
            panelHeading = $(`<div>`).addClass(`panel-heading`).
                text(`Employee form`),
            forms = $(`<form>`).attr(`id`, `employee-form`),
            nameInput = Builder.inputCreator(`employee-name`, `name`, `name`, `text`, promise),
            birthDate = Builder.inputCreator(`dateOfBirthday`, `dateOfBirthday`, `Date Of Birthday`, `date`, promise),
            email = Builder.inputCreator(`email`, `email`, `Email`, `text`, promise),
            salary = Builder.inputCreator(`salary`, `salary`, `Salary`, `text`, promise),
            department = Builder.inputCreator(`departmentId`, `departmentId`, `Department`, `text`, promise),
            idDiv = Builder.hiddenFieldBuilder(),
            submit = $(`<button>`).attr(`type`, `submit`).
                addClass(`btn btn-primary`).
                text(`Save`);

        forms.append(idDiv).
            append(nameInput).
            append(birthDate).
            append(email).
            append(salary).
            append(department).
            append(submit);
        panelInfo.append(panelHeading).append(forms);
        panelInfo.append(forms);
        div.append(panelInfo);
        $(`.content`).append(div);

        validationFunction();

        $(`#employee-form`).
            validate({
                submitHandler (form, event) {
                    event.preventDefault();
                    const url = `/employees`;
                    EmployeeService.insertEmployee(url, JSON.stringify(form)).
                        then((res) => res.json()).
                        then((out) => {
                            window.location.hash = `#employees?id=${out.departmentId}`;
                        });
                }
            })
    }
}

export const formEmployee = new FormEmployee();