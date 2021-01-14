export default class Service {

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