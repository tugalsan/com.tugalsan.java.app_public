package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.canvas.dom.client.*;
import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.gui.client.widget.*;
import com.tugalsan.java.core.log.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TGC_CanvasWidgetLineCap {

    final private static TGC_Log d = TGC_Log.of(TGC_CanvasWidgetLineCap.class);
    final public static Context2d.LineCap DEFAULT = Context2d.LineCap.ROUND;

    public TGC_CanvasWidgetLineCap(Context2d.LineCap def, String label) {
        html = new HTML(label);
        this.def = def;
        listBox = TGC_ListBoxUtils.create(true);
        lst = new ArrayList();
        lst.add(Context2d.LineCap.ROUND);
        lst.add(Context2d.LineCap.BUTT);
        lst.add(Context2d.LineCap.SQUARE);
        lst.forEach(item -> listBox.addItem(item.toString()));
        var selectedIndex = findIdx(def);
        listBox.setSelectedIndex(selectedIndex);
    }

    final public HTML html;
    final public ListBox listBox;
    final public Context2d.LineCap def;
    final public List<Context2d.LineCap> lst;

    final public int findIdx(Context2d.LineCap value) {
        return IntStream.range(0, lst.size())
                .filter(i -> lst.get(i).toString().equals(value.toString()))
                .findAny().orElse(-1);
    }
}
