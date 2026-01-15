package com.tugalsan.java.app.showcase2d.scroll;

import com.tugalsan.java.app.showcase2d.widget.*;
import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;
import com.google.gwt.user.client.ui.*;
import java.util.stream.*;

public class AppModuleScroll extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleScroll.class);

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
        var sb = new StringBuilder();
        IntStream.range(0, 50).forEachOrdered(i -> sb.append("<B>ALİ GEL</B>VELİ GEL"));
        var html0 = AppTest_WidgetUtils.createHTML(sb.toString());
        var html1 = AppTest_WidgetUtils.createHTML(sb.toString());
        var html2 = AppTest_WidgetUtils.createHTML(sb.toString());
        var pf0 = AppTest_PanelScrollUtils.create(html0, 50, 50);
        var pf1 = AppTest_PanelScrollUtils.create(html1, 100, 100);
        var pf2 = AppTest_PanelScrollUtils.create(html2, 200, 50);
        var p = new AbsolutePanel();
        p.add(pf0, 0, 0);
        p.add(pf1, 0, 200);
        p.add(pf2, 0, 400);
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
