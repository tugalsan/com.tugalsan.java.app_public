package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.canvas.dom.client.*;
import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.gui.client.widget.*;
import com.tugalsan.java.api.log.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TGC_CanvasWidgetLineJoin {

    final private static TGC_Log d = TGC_Log.of(TGC_CanvasWidgetLineJoin.class);
    final public static Context2d.LineJoin DEFAULT = Context2d.LineJoin.ROUND;

    public TGC_CanvasWidgetLineJoin(Context2d.LineJoin def, String label) {
        html = new HTML(label);
        this.def = def;
        listBox = TGC_ListBoxUtils.create(true);
        lst = new ArrayList();
        lst.add(Context2d.LineJoin.BEVEL);
        lst.add(Context2d.LineJoin.MITER);
        lst.add(Context2d.LineJoin.ROUND);
        lst.forEach(item -> listBox.addItem(item.toString()));
        var selectedIndex = findIdx(def);
        listBox.setSelectedIndex(selectedIndex);
    }

    final public HTML html;
    final public ListBox listBox;
    final public Context2d.LineJoin def;
    final public List<Context2d.LineJoin> lst;

    final public int findIdx(Context2d.LineJoin value) {
        return IntStream.range(0, lst.size())
                .filter(i -> lst.get(i).toString().equals(value.toString()))
                .findAny().orElse(-1);
    }
}
