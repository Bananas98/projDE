package departmentmanagement.controller;


import departmentmanagement.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class Controller extends HttpServlet {

    private final ControllerFactory controllerFactory = new ControllerFactory();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = controllerFactory.getCommand(req);
        command.execute(req, resp);
    }

}
