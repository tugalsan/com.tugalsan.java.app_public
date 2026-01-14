package com.tugalsan.java.app.showcase2d.layout;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.log.client.*;

public class AppTest_PanelVerticalUtils {

    private AppTest_PanelVerticalUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelVerticalUtils.class);

    public static VerticalPanel create() {
        var p = new VerticalPanel();
        p.setBorderWidth(1);
        p.setSpacing(4);
        return p;
    }

    public static void add(VerticalPanel p, Widget w) {
        p.add(w);
    }

    public static void cls(FlowPanel p) {
        p.clear();
    }
}
