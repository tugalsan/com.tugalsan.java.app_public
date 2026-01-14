package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.cast.client.*;
import com.tugalsan.java.core.gui.client.widget.*;
import com.tugalsan.java.core.log.client.*;

public class TGC_CanvasWidgetInteger {

    final private static TGC_Log d = TGC_Log.of(TGC_CanvasWidgetInteger.class);

    public TGC_CanvasWidgetInteger(int min, int def, int max, String label) {
        this.min = min;
        this.def = def;
        this.max = max;
        html = new HTML(label);
        textBox = new TextBox();
        TGC_TextBoxUtils.setTypeNumber(textBox, min, def, max);
    }

    final public HTML html;
    final public TextBox textBox;
    final public int min, def, max;

    public int getVal() {
        TGC_TextBoxUtils.validateTypeNumber(textBox, def);
        return TGS_CastUtils.toInt(textBox.getText(), def);
    }

    public boolean setVal(int val) {
        if (val > max) {
            d.ce("setVal", "val > max");
            return false;
        }
        if (val < min) {
            d.ce("setVal", "val > max");
            return false;
        }
        textBox.setText(String.valueOf(val));
        return true;
    }
}
