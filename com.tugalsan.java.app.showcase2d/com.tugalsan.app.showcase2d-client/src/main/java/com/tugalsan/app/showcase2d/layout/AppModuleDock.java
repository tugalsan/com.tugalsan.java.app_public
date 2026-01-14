package com.tugalsan.java.app.showcase2d.layout;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.log.client.TGC_Log;
import com.tugalsan.java.app.showcase2d.App;
import com.tugalsan.java.app.showcase2d.AppStringsUtils;
import com.tugalsan.java.lib.boot.client.*;

public class AppModuleDock extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleDock.class);

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
        var p = new DockLayoutPanel(Style.Unit.EM);
        p.addNorth(new HTML("north"), 8);
        p.addSouth(new HTML("south"), 8);
        p.addEast(new HTML("east"), 8);
        p.addWest(new HTML("west"), 8);
        p.add(new HTML("center"));
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
