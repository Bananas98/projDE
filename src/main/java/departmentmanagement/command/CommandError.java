package departmentmanagement.command;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(value = "/error")
public class CommandError implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "WEB-INF/Error.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }
}
