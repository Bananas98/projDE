import Builder from "../component/builder";
import Service from "./service";

export default class DepartmentService extends Service{

    static getDepartmentList (url) {
        return (
            fetch(url).
                then((res) => res.json()).
                then((out) => out).
                catch(() =>{
                Builder.createMessageAlert()
            }));
    }


    static insertDepartment (url, object) {
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
                window.location.hash = `#departments`;
            }).
            catch(() =>{
                Builder.createMessageAlert()
            })
    }

}