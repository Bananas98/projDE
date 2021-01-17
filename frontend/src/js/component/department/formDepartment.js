import Component from "src/js/component/Component";
import Builder from "src/js/component/builder";
import {
    validationFunction
} from "../../validation/validator";

import DepartmentService from "../../services/departmentService";

class FormDepartment extends Component {

    render () {
        $(`.app`).
            empty();
        const panelInfo = $(`<div>`).
                addClass(`panel panel-info`),
            div = $(`<div>`).
                addClass(`form-class col-lg-5`),
            panelHeading = $(`<div>`).
                addClass(`panel-heading`).
                text(`Department List`),
            forms = $(`<form>`).
                attr(`id`, `department-form`),
            nameDiv = $(`<div>`).
                addClass(`lg-form`),
            nameInput = $(`<input>`).
                attr(`id`, `department-name`).
                addClass(`form-control`).
                attr(`name`, `name`).
                attr(`placeholder`, `Name`),
            idDiv = Builder.hiddenFieldBuilder(),
            submit = $(`<button>`).
                attr(`type`, `submit`).
                addClass(`btn btn-primary`).
                text(`Save`);

        let id;
        if (window.location.hash.split(`=`).length) {
            id = window.location.hash.split(`=`)[1]
        }
        DepartmentService.getDepartmentList(`departments?id=${id}`).
            then((res) => res.json()).
            then((out) => {
                nameInput.val(out.name);
            }).
            catch(() => {
                Builder.createMessageAlert()
            });
        nameDiv.append(nameInput);
        forms.append(idDiv).
            append(nameDiv).
            append(submit);
        panelInfo.append(panelHeading).
            append(forms);
        panelInfo.append(forms);
        div.append(panelInfo);

        $(`.content`).
            append(div);

        validationFunction();

        $(`#department-form`).
            validate({
                submitHandler: (form, event) => {
                    event.preventDefault();
                    DepartmentService.insertDepartment(
                        `/departments`,
                        JSON.stringify(form)
                    ).
                        then((res) => res.json()).
                        then((out) => {
                            window.location.hash = `#departments`;
                        }).
                        catch(() => {
                            Builder.createMessageAlert()
                        })
                }
            })
    }
}

export const formDepartment = new FormDepartment();