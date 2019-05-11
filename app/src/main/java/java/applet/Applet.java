package java.applet;

import java.awt.Panel;
import java.util.Map;

public class Applet extends Panel {

    private Map<String, String> parameters;

    public void init() {

    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }
}
