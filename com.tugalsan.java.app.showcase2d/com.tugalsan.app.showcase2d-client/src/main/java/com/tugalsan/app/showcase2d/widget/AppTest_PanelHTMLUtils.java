package com.tugalsan.java.app.showcase2d.widget;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.log.client.*;

public class AppTest_PanelHTMLUtils {

    private AppTest_PanelHTMLUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelHTMLUtils.class);

    public static HTMLPanel create(String htmlCode) {
        return new HTMLPanel(htmlCode);
    }
}
