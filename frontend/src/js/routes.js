import {Starter} from "./utils/starter";
import {listDepartment} from "src/js/component/listDepartment";
import {listEmployee} from "src/js/component/listEmployee";
import {formDepartment} from "src/js/component/formDepartment";
import {formEmployee} from "src/js/component/formEmployee";
export class Routes {
    routes = new Starter({"routes": routes});

    getUrl () {
        const url = window.location.hash;
        if (url === `#` || url === ``) {
            window.location.hash = `departments`;
        }
        return url.split(`?`)[0];
    }

}

export const routes = [
    {
        "component": listDepartment,
        "path": `#departments`,
        "type": `GET`
    },
    {
        "component": listEmployee,
        "path": `#employees`,
        "type": `GET`
    },
    {
        "component": formDepartment,
        "path": `#departments`,
        "type": `POST`
    },
    {
        "component": formEmployee,
        "path": `#employees`,
        "type": `POST`
    }
];

export const appModule = new Starter({"routes": routes});