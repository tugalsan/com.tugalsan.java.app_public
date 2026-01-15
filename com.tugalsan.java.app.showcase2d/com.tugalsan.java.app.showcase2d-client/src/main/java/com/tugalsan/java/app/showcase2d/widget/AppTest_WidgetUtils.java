package com.tugalsan.java.app.showcase2d.widget;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.*;
import com.tugalsan.java.core.log.client.*;

public class AppTest_WidgetUtils {

    private AppTest_WidgetUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_WidgetUtils.class);

    public static HTML createHTML(String content) {
        return new HTML(content);
    }

    public static RadioButton createRadioButton(String formVariableName, String groupName, String label) {
        var w = new RadioButton(groupName, label);
        if (formVariableName != null) {
            w.setName(formVariableName);
        }
        return w;
    }

    public static String createRadioButtonGroup() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static CheckBox createCheckBox(String formVariableName, String label) {
        var w = new CheckBox(label);
        if (formVariableName != null) {
            w.setName(formVariableName);
        }
        return w;
    }

    public static ListBox createListBox(String formVariableName) {
        var w = new ListBox();
        if (formVariableName != null) {
            w.setName(formVariableName);
        }
        return w;
    }

    public static TextBox createTextBox(String formVariableName) {
        var w = new TextBox();
        if (formVariableName != null) {
            w.setName(formVariableName);
        }
        return w;
    }

    public static Button createButton(String label) {
        var w = new Button(label);
        return w;
    }

    public static PushButton createButtonPush(String label) {
        var w = new PushButton(label);
        return w;
    }

    public static void addItem(ListBox lb, String itemName, String itemValue) {
        lb.addItem(itemName, itemValue);
    }

    public static void addAction(Button b, TGS_FuncMTU action) {
        b.addClickHandler(e -> action.run());
    }
}
