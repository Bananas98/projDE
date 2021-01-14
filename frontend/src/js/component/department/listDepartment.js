import Component from "src/js/component/Component";
import Builder from "src/js/component/builder";
import Service from "../../services/service";

class ListDepartment extends Component {


    render () {
        $(`.app`).
            empty();
        const panelInfo = $(`<div>`).
                addClass(`panel panel-info`),
            panelHeader = $(`<div>`).
                addClass(`panel-heading`).
                text(`List Department`),
            promiseArray = Service.getDepartmentList(`departments`),
            table = $(`<table>`),
            tbody = $(`<tbody>`);

        table.addClass(`table`);
        panelInfo.append(panelHeader);
        promiseArray.then((out) => {
            out.each(item => {
                tbody.append(Builder.printDepartmentRow(item));
            });
        });
        table.append(tbody);
        panelInfo.append(table);
        $(`.content`).
            append(panelInfo);
    }

}

export const listDepartment = new ListDepartment();