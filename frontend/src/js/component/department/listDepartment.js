import Component from "src/js/component/Component";
import Service from "src/js/services/service";
import Builder from "src/js/component/builder";

class ListDepartment extends Component {


    render() {
        $(`.app`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            panelHeader = $(`<div>`).addClass(`panel-heading`).text(`List Department`),
            promiseArray = Service.getEntityList(`departments`),
            tabl = $(`<table>`),
            tbody = $(`<tbody>`);

        tabl.addClass(`table`);
        panelInfo.append(panelHeader);
        promiseArray.then((out) => {
            for (let i = 0; i < out.length; i++) {
                const row = Builder.printDepartmentRow(out[i]);
                tbody.append(row);
            }
        });
        tabl.append(tbody);
        panelInfo.append(tabl);
        $(`.content`).append(panelInfo);
    }

}

export const listDepartment = new ListDepartment();