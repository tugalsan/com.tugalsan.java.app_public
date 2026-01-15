package com.tugalsan.java.app.showcase2d.layout;

import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.app.showcase2d.widget.*;
import com.tugalsan.java.lib.boot.client.*;
import com.google.gwt.user.client.ui.*;
import java.util.stream.*;

public class AppModuleFlex extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleFlex.class);

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
        int rowCount = 4, colCount = 3;
        var p = AppTest_PanelTableFlexUtils.create();
        var gr = AppTest_WidgetUtils.createRadioButtonGroup();
        IntStream.range(0, rowCount).forEachOrdered(ri -> {
            IntStream.range(0, colCount).forEachOrdered(ci -> {
                if (ri % 2 == 0) {
                    AppTest_PanelTableFlexUtils.set(p, AppTest_WidgetUtils.createCheckBox(null, ri + "/" + ci), ri, ci);
                } else {
                    AppTest_PanelTableFlexUtils.set(p, AppTest_WidgetUtils.createRadioButton(null, gr, ri + "/" + ci), ri, ci);
                }
            });
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
