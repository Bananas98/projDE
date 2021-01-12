import {listDepartment} from "./component/department/listDepartment";
import {listEmployee} from "./component/employee/listEmployee";
import {formDepartment} from "./component/department/formDepartment";
import {formEmployee} from "./component/employee/formEmployee";

export const routes = [
    {
        "component": listDepartment,
        "path": `#departments`,
    },
    {
        "component": listEmployee,
        "path": `#employees`,
    },
    {
        "component": formDepartment,
        "path": `#department`,
    },
    {
        "component": formEmployee,
        "path": `#employee`,
    }
];