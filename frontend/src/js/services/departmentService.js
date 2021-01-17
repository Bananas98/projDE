import Builder from "../component/builder";
import Service from "./service";

export default class DepartmentService extends Service {

    static getDepartmentList (url) {
        return fetch(url);
    }


    static insertDepartment (url, object) {
        return fetch(url, {
            "body": object,
            "headers": {
                'Accept': `application/json, text/plain, */*`,
                'Content-Type': `application/json`
            },
            "method": `POST`
        });
    }
}