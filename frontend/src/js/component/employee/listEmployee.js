import Component from "src/js/component/Component";
import Service from "src/js/services/service";
import Builder from "src/js/component/builder";

class EmployeeTable extends Component {


    render() {
        $(`.app`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            panelHeader = $(`<div>`).addClass(`panel-heading`).text(`Employees`),
            promiseArray = Service.getEntityList(window.location.hash.split(`#`)[1]),
            tabl = $(`<table>`),
            tbody = $(`<tbody>`);

        tabl.addClass(`table`);
        panelInfo.append(panelHeader);
        promiseArray.then((out) => {

            for (let i = 0; i < out.length; i++) {
                const row = Builder.printEmployeeRow(out[i]);
                tbody.append(row);
            }
        });
        tabl.append(tbody);
        panelInfo.append(tabl);
        $(`.content`).append(panelInfo);
    }

}

export const listEmployee = new EmployeeTable();