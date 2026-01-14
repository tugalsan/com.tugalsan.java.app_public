package com.tugalsan.java.app.showcase2d.widget;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;

public class AppModuleHTML extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleHTML.class);

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
        return new TGS_FileHtmlText().setText(
                TGC_LibBootGUITitleUtils.bodyTitle_cloud_app_sub_user(
                        App.loginCard, App.route,
                        AppStringsUtils.TITLE_AppModuleDefault(),
                        d.className(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        var p = AppTest_PanelHTMLUtils.create("<h1>My First Heading</h1><p>My first paragraph.</p>");
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
