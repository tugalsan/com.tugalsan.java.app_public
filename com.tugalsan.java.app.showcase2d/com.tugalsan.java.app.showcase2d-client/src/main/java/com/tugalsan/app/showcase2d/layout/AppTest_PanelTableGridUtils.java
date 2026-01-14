package com.tugalsan.java.app.showcase2d.layout;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.log.client.*;

public class AppTest_PanelTableGridUtils {

    private AppTest_PanelTableGridUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelTableGridUtils.class);

    public static Grid create(int rowCount, int colCount) {
        var p = new Grid(rowCount, colCount);
        p.setBorderWidth(1);
        return p;
    }

    public static void set(Grid p, Widget w, int rowIdx, int colIdx) {
        p.setWidget(rowIdx, colIdx, w);
    }

    public static void set(Grid p, Panel w, int rowIdx, int colIdx) {
        p.setWidget(rowIdx, colIdx, w);
    }
}
