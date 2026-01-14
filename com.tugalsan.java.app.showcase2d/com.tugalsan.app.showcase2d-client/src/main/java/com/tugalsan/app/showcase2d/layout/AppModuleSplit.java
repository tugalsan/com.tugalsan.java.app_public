package com.tugalsan.java.app.showcase2d.layout;

import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;
import com.google.gwt.user.client.ui.*;

public class AppModuleSplit extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleSplit.class);

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
        SplitLayoutPanel p = new SplitLayoutPanel();
        p.addWest(new HTML("Navigation Tree"), 128);
        p.addNorth(new HTML("Panel 1"), 384);
        p.add(new HTML("Panel 2"));
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
