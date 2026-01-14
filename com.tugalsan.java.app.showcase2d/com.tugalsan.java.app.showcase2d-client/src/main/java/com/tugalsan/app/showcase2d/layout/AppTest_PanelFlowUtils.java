package com.tugalsan.java.app.showcase2d.layout;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.log.client.*;

public class AppTest_PanelFlowUtils {

    private AppTest_PanelFlowUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelFlowUtils.class);

    public static FlowPanel create() {
        return new FlowPanel();
    }

    public static void add(FlowPanel p, Widget w) {
        p.add(w);
    }

    public static void cls(FlowPanel p) {
        p.clear();
    }
}
