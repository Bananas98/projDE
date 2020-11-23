package departmentmanagement.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CommandError implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        Exception exception = (Exception) request.getAttribute(
                "javax.servlet.error.exception");
        writer.printf("exception: %s%n", exception);
        Class exceptionClass = (Class) request.getAttribute(
                "javax.servlet.error.exception_type");
        writer.printf("exception_type: %s%n", exceptionClass);
        Integer code = (Integer) request.getAttribute(
                "javax.servlet.error.status_code");
        writer.printf("status_code: %s%n", code);
        String errorMessage = (String) request.getAttribute(
                "javax.servlet.error.message");
        writer.printf("message: %s%n", errorMessage);
        String requestUri = (String) request.getAttribute(
                "javax.servlet.error.request_uri");
        response.getWriter().printf("request_uri: %s%n",
                requestUri);
        String servletName = (String) request.getAttribute(
                "javax.servlet.error.servlet_name");
        writer.printf("servlet_name: %s%n", servletName);
    }
}
