import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'
import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css'
import {Router} from "./routes";
import {routes} from "./appRouts";

const router = new Router;
router.start({"routes": routes});
