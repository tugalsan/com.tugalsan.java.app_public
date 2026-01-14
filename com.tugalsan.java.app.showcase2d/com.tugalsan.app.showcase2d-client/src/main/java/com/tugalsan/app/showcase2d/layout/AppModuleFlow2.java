package com.tugalsan.java.app.showcase2d.layout;

import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.app.showcase2d.widget.*;
import com.tugalsan.java.lib.boot.client.*;
import com.google.gwt.user.client.ui.*;
import java.util.stream.*;

public class AppModuleFlow2 extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleFlow2.class);

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
        var p = AppTest_PanelFlowUtils.create();
        IntStream.range(0, 8).forEachOrdered(i -> {
            var b = AppTest_WidgetUtils.createButtonPush("ButtonPush " + i);
            b.addClickHandler(e -> d.ci("btn", "act " + i));
            AppTest_PanelFlowUtils.add(p, b);
        });
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
