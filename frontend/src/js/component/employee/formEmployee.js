import Builder from "src/js/component/builder";
import validator from "src/js/validation/validator";
import Service from "../../services/service";

class FormEmployee extends Component {
    render() {

        $(`.app`).empty();
        const id = window.location.hash.split(`=`)[1];
        const promise = Service.getEntityList(`employees?id=${id}`);
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            div = $(`<div>`).addClass(`form-class col-lg-5`),
            panelHeading = $(`<div>`).addClass(`panel-heading`).text(`Employee form`),
            form = $(`<form>`).attr(`id`, `employee-form`),
            nameInput = Builder.inputCreator(
                `employee-name`,
                `name`, `name`, `text`, promise
            ),
            birthDate = Builder.inputCreator(
                `dateOfBirthday`, `dateOfBirthday`,
                `Date Of Birthday`, `date`, promise
            ),
            email = Builder.inputCreator(`email`, `email`, `Email`, `text`, promise),
            salary = Builder.inputCreator(
                `salary`, `salary`,
                `Salary`, `text`, promise
            ),
            department = Builder.inputCreator(`departmentId`, `departmentId`, `Department`, `text`, promise),
            idDiv = Builder.hiddenFieldBuilder(),
            submit = $(`<button>`).attr(`type`, `submit`).addClass(`btn btn-primary`).text(`Save`);

        form.append(idDiv).append(nameInput).append(birthDate).append(email).append(salary).append(department).append(submit);
        panelInfo.append(panelHeading).append(form);
        panelInfo.append(form);
        div.append(panelInfo);
        $(`.content`).append(div);
        validator.validationEmployeeFunction();

    }
}

export const formEmployee = new FormEmployee();