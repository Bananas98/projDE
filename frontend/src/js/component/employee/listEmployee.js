import Component from "src/js/component/Component";
import Service from "src/js/services/service";
import Builder from "src/js/component/builder";

class EmployeeList extends Component {


    render() {
        $(`.app`).empty();
        const panelInfo = $(`<div>`).addClass(`panel panel-info`),
            panelHeader = $(`<div>`).addClass(`panel-heading`).text(`Employees`),
            promiseArray = Service.getEntityList(window.location.hash.split(`#`)[1]),
            table = $(`<table>`),
            tbody = $(`<tbody>`);

        table.addClass(`table`);
        panelInfo.append(panelHeader);
        promiseArray.then((out) => {
            out.each(item => {
                tbody.append(Builder.printEmployeeRow(item));
            });
        });
        table.append(tbody);
        panelInfo.append(table);
        $(`.content`).append(panelInfo);
    }

}

export const listEmployee = new EmployeeList();