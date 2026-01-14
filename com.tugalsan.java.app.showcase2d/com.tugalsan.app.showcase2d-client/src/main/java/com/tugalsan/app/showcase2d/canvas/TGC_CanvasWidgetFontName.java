package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.gui.client.widget.*;
import com.tugalsan.java.api.log.client.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TGC_CanvasWidgetFontName {

    final private static TGC_Log d = TGC_Log.of(TGC_CanvasWidgetFontName.class);
    final public static String DEFAULT = "Arial, sans-serif";

    public TGC_CanvasWidgetFontName(String def, String label) {
        html = new HTML(label);
        this.def = def;
        listBox = TGC_ListBoxUtils.create(true);
        lst = new ArrayList();
        lst.add("Arial, sans-serif");
        lst.add("Tahoma, sans-serif");
        lst.add("Trebuchet MS', sans-serif");
        lst.add("Times New Roman', serif");
        lst.add("Georgia, serif");
        lst.add("Garamond, serif");
        lst.add("Courier New', monospace");
        lst.add("Brush Script MT', cursive");
        lst.add("Times New Roman', serif");
        lst.add("Times New Roman', serif");
        lst.forEach(item -> listBox.addItem(item));
        var selectedIndex = findIdx(def);
        listBox.setSelectedIndex(selectedIndex);
    }

    final public HTML html;
    final public ListBox listBox;
    final public String def;
    final public List<String> lst;

    final public int findIdx(String value) {
        return IntStream.range(0, lst.size())
                .filter(i -> lst.get(i).equals(value))
                .findAny().orElse(-1);
    }
}
