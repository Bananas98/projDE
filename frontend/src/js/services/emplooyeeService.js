import Service from "./service";

export default class EmployeeService extends Service {

    static getEmployeeList (url) {
        return fetch(url);
    }


    static insertEmployee (url, object) {
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
