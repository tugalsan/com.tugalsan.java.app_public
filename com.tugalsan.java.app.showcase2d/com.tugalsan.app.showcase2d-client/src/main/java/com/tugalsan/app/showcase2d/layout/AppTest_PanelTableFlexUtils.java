package com.tugalsan.java.app.showcase2d.layout;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.log.client.*;

public class AppTest_PanelTableFlexUtils {

    private AppTest_PanelTableFlexUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelTableFlexUtils.class);

    public static FlexTable create() {
        var p = new FlexTable();
        p.setBorderWidth(1);
        return p;
    }

    public static void set(FlexTable p, Widget w, int rowIdx, int colIdx) {
        p.setWidget(rowIdx, colIdx, w);
    }

    public static void set(FlexTable p, Panel w, int rowIdx, int colIdx) {
        p.setWidget(rowIdx, colIdx, w);
    }

    public static void removeRow(FlexTable p, int rowIdx) {
        p.removeRow(rowIdx);
    }

    public static void removeCell(FlexTable p, int rowIdx, int colIdx) {
        p.removeCell(rowIdx, colIdx);
    }

    public static void cls(FlexTable p, int rowIdx, int colIdx) {
        p.removeAllRows();
    }
}
