import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'
import 'https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css'
// import 'https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js'
// import "/frontend/src/js/libs/underscore.js"
// import "/frontend/src/js/libs/validate.min.js"
// import "/frontend/src/js/services/employeeService.js"
// import "/frontend/src/js/services/departmentService.js"
// import "/frontend/src/js/utils/componentList.js"
// import "/frontend/src/js/utils/componentForm.js"
import * as $ from 'jquery'

import {DepartmentService} from "./services/departmentService";
$(document).ready(function () {
    new DepartmentService();
});