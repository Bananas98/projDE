import Service from "./service";

export default class EmployeeService extends Service {

    static getEmployeeList (url) {
        return (
            fetch(url).
                then((res) => res.json()).
                then((out) => out).
                catch());
    }


    static insertEmployee (url, object, type) {
        fetch(url, {
            "body": object,
            "headers": {
                'Accept': `application/json, text/plain, */*`,
                'Content-Type': `application/json`
            },
            "method": `POST`
        }).
            then((res) => res.json()).
            then((out) => {
                 window.location.hash = `#employees?id=${out.departmentId}`;
            }).
            catch()
    }


}
