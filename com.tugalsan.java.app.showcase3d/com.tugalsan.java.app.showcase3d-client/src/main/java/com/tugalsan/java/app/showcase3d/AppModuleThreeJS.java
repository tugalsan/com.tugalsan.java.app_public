package com.tugalsan.java.app.showcase3d;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.TGS_FuncMTU;
import com.tugalsan.java.core.gui.client.click.TGC_ClickUtils;
import com.tugalsan.java.core.gui.client.focus.TGC_FocusUtils;
import com.tugalsan.java.core.gui.gl.client.three4g.TGC_GLProgramAbstract;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.core.js.client.*;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.resource.client.*;

public class AppModuleThreeJS extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleThreeJS.class);

    public static String canvasDivId() {
        return "Canvas3JS";
    }

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
                        AppStrings.TITLE_AppModuleDefault(),
                        d.className(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        loadParams();
        initControllers(() -> {
            createWidgets();
            createPops();
            configInit();
            configActions();
            configFocus();
            configLayout();
            TGC_FocusUtils.setFocusAfterGUIUpdate(btnExtra);
        });
    }

    @Override
    public void loadParams() {
    }

    public void initControllers(TGS_FuncMTU exe) {
        if (!TGC_GLProgramAbstract.isWEBGL1Supported()) {
            d.ce("iniControllers", "WEBGL_1_NOT_SUPPORTED!");
            return;
        }
        TGC_JSUtils.includeJM(TGS_LibResourceUtils.common.res.js.threejs_native_utils_js().toString());
        exe.run();
    }

    @Override
    public void createWidgets() {
        btnExtra = new PushButton("JS Button");
    }
    private PushButton btnExtra;

    @Override
    public void createPops() {
    }

    @Override
    public void configInit() {
    }

    @Override
    public void configActions() {
        TGC_ClickUtils.add(btnExtra, () -> {
            d.cr("configActions", "btnExtra", "onMyButtonClick", TGC_JSUtils.onMyButtonClick());
        });
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
        var p = new HorizontalPanel();
        p.add(btnExtra);
        btnExtra.addStyleName("AppModuleTable_btn");
        widget = p;
    }
    private Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }
}
