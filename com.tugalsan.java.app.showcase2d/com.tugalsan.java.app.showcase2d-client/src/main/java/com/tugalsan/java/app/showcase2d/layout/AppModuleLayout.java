package com.tugalsan.java.app.showcase2d.layout;

import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.core.gui.client.panel.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.app.showcase2d.widget.*;
import com.tugalsan.java.lib.boot.client.*;
import com.google.gwt.user.client.ui.*;

public class AppModuleLayout extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleLayout.class);

    @Override
    public String getBrowserTitle() {
        return TGC_LibBootGUITitleUtils.browserTitle_domain_txt_user(
                App.domainCard, App.loginCard, App.route,
                d.className(),
                null
        );
    }

      @Override
    public String getBodyTitle() {
        return new TGS_FileHtmlText().setText(TGC_LibBootGUITitleUtils.bodyTitle_cloud_app_sub_user(App.loginCard, App.route,
                        AppStringsUtils.TITLE_AppModuleDefault(),
                        d.className(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        var w0 = AppTest_WidgetUtils.createHTML("left");
        var w1 = AppTest_WidgetUtils.createHTML("right");
        var p = new LayoutPanel();
        TGC_PanelLayoutUtils.add(p, w0);
        TGC_PanelLayoutUtils.add(p, w1);
        TGC_PanelLayoutUtils.setWidthLeftPercent(p, w0, 0, 50);
        TGC_PanelLayoutUtils.setWidthRightPercent(p, w1, 0, 50);
        widget = p;
    }

    @Override
    public void loadParams() {
    }

    @Override
    public void createWidgets() {
    }

    @Override
    public void createPops() {
    }

    @Override
    public void configInit() {
    }

    @Override
    public void configActions() {
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
    }

    @Override
    public Widget getWidget() {
        return widget;
    }
    private Widget widget;
}
