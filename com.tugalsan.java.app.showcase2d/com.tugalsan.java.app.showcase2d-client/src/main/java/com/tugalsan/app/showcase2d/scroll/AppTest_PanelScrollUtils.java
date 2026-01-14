package com.tugalsan.java.app.showcase2d.scroll;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.log.client.*;

public class AppTest_PanelScrollUtils {

    private AppTest_PanelScrollUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelScrollUtils.class);

    @Deprecated
    public static ScrollPanel create(Widget w, int widthPx, int heightPx) {
        var ps = new ScrollPanel(w);
        ps.setSize(widthPx + "px", heightPx + "px");
        return ps;
    }

    public static ScrollPanel create(Panel p, int widthPx, int heightPx) {
        var ps = new ScrollPanel(p);
        ps.setSize(widthPx + "px", heightPx + "px");
        return ps;
    }

    public static ScrollPanel create(HTML h, int widthPx, int heightPx) {
        var ps = new ScrollPanel(h);
        ps.setSize(widthPx + "px", heightPx + "px");
        return ps;
    }
}
