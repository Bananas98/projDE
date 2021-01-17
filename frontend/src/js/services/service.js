export default class Service {

    static deleteEntity (url, id) {
        return fetch(
            `${url}/${id}`,
            {"method": `DELETE`}
        )
    }

}