import Component from "src/js/component/Component";
import Service from "src/js/services/service.js";
import Builder from "src/js/component/builder";

class FormDepartment extends Component {

    render() {

        $(`.app`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            div = $(`<div>`).addClass(`form-class col-lg-5`),
            panelHeading = $(`<div>`).addClass(`panel-heading`).text(`Department List`),
            form = $(`<form>`).attr(`id`, `department-form`),
            nameDiv = $(`<div>`).addClass(`lg-form`),
            nameInput = $(`<input>`).attr(`id`, `department-name`).addClass(`form-control`).attr(`name`, `name`).attr(`placeholder`, `Name`),
            idDiv = Builder.hiddenFieldBuilder(),
            submit = $(`<button>`).attr(`type`, `submit`).addClass(`btn btn-primary`).text(`Save`);
        const id = window.location.hash.split(`=`)[1];

        Service.getEntityList(`departments?id=${id}`).then((out) => {
            nameInput.val(out.name);
        });

        nameDiv.append(nameInput);
        form.append(idDiv).append(nameDiv).append(submit);
        panelInfo.append(panelHeading).append(form);
        panelInfo.append(form);
        div.append(panelInfo);
        $(`.content`).append(div);
        Service.insertEntity(
            `/departments`,
            Service.toJsonString(form), `department`
        );
    }

}

export const formDepartment = new FormDepartment();