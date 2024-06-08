package di;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, String> stepData;

    public Context() {
        stepData = new HashMap<>();
    }

    public void setContext(String key, String value) {
        stepData.put(key, value);
    }

    public String getContext(String key) {
        return stepData.get(key);
    }
}
