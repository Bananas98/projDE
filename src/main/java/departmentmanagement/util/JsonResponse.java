package departmentmanagement.util;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {
    private String status = null;
    private Object result = null;
    private Map<String,String> error;
    private Integer depId = null;

    public JsonResponse() {
        this.error = new HashMap<>();
    }

    public void setError(Map<String, String> error) {
        this.error = error;
    }

    public Map<String, String> getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}
