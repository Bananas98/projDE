import {Routes} from "../routes";

export class Starter {


    constructor(config) {
        this.routes = config.routes;
    }

    start() {
        if (this.routes) {
            this.initRoutes();
        }
    }


    initRoutes () {
        window.addEventListener(`hashchange`, this.renderRoute.bind(this));
        this.renderRoute();
    }

    renderRoute () {
        const path = Routes.prototype.getUrl(),
            route = this.routes.find((routeUnit) => routeUnit.path === path);
        this.renderComponent(route.component);
    }

    renderComponent (component) {
        component.render();
    }

}

const starter = (module) => {
    module.start();
};

export {starter}