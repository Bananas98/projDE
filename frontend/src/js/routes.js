
export class Router {

    start(routes) {
        routes.initRoutes();
    }

    initRoutes () {
        window.addEventListener(`hashchange`, this.renderRoute.bind(this));
        this.renderRoute();
    }

    getUrl () {
        const url = window.location.hash;
        if (url === `#` || url === ``) {
            window.location.hash = `departments`;
        }
        if (url.split(`?`)[0] !== undefined){
            return url.split(`?`)[0];
        }
    }

    renderRoute () {
        const path = Router.prototype.getUrl(),
            route = routes.find((routeUnit) => routeUnit.path === path);
        this.renderComponent(route.component);
    }

    renderComponent (component) {
        component.render();
    }

}