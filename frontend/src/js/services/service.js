export default class Service {

    static getEntityList (url) {
        return (
            fetch(url).
                then((res) => res.json()).
                then((out) => out).
                catch());
    }


    static insertEntity (url, object, type) {
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
                if (type === `department`) {
                    window.location.hash = `#departments`;
                } else {
                    window.location.hash = `#employees?id=${out.departmentId}`;
                }
            }).
            catch()
    }

    static deleteEntity (url, id) {
        fetch(
            `${url}/${id}`,
            {"method": `DELETE`}
        ).
            then().
            catch()
    }

    static toJsonString (form) {
        const obj = {},
            step = 1;
        for (let count = 0;
            count < form.elements.length - step;
            count += step) {
            const element = form.elements[count],
                name = element.name,
                value = element.value;
            if (name) {
                obj[name] = value;
            }
        }
        return JSON.stringify(obj);
    }

}