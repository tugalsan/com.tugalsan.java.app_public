package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.gui.client.widget.*;
import com.tugalsan.java.api.log.client.*;

public class TGC_CanvasWidgetColor {

    final private static TGC_Log d = TGC_Log.of(TGC_CanvasWidgetColor.class);
    final public static String DEFAULT = "#000000";

    public TGC_CanvasWidgetColor(String def, String label) {
        this.def = def;
        html = new HTML(label);
        textBox = new TextBox();
        TGC_TextBoxUtils.setTypeColor(textBox);
        textBox.setText(def);
    }

    final public HTML html;
    final public TextBox textBox;
    final public String def;

    public String getVal() {
//        TGC_TextBoxUtils.validateTypeNumber(textBox, def);
        return textBox.getText();
    }

    public boolean setVal(String hex) {
        textBox.setText(hex);
        return true;
    }
}
