package java.applet;

import java.awt.Panel;

public class Applet extends Panel {

    public void init() {

    }

    public String getParameter(String name) {
        //TODO String getParameter(String name)
        if ("positions".equals(name)) {
            return "730161011122421040,A30191012150806162,A30191404101212252,A30191012120211242,A30191303110300131";
        } else if ("nodes".equals(name)) {
            return "2144013641245,4145850246941368,4145850246942568,51246750257941458,4136850347942467";
        } else if ("titles".equals(name)) {
            return "sample, sample, sample, sample, sample";
        }
        return null;
    }
}
