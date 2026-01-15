package com.tugalsan.java.app.showcase3d;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.TGS_FuncMTU;
import com.tugalsan.java.core.log.client.TGC_Log;
import com.tugalsan.java.core.gui.gl.client.three4g.TGC_GLProgramAbstract;
import com.tugalsan.java.core.gui.client.browser.TGC_BrowserWindowUtils;

import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.gui.client.dim.TGC_DimensionUtils;
import com.tugalsan.java.core.shape.client.TGS_ShapeMargin;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.gl.client.prg.TGC_LibGLPrgFull;

public class AppModuleThree4G_TGC_LibGLPrgFull_true extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleThree4G_TGC_LibGLPrgFull_true.class);

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
        gl = new TGC_LibGLPrgFull(true);
        exe.run();
    }
    private TGC_GLProgramAbstract gl;

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
        TGC_BrowserWindowUtils.addResizeHandler();
        TGC_BrowserWindowUtils.exe_resizeHandlers.add(d -> onSetMargins());
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
        onSetMargins();
        widget = new HTML();
    }
    Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }

    private void onSetMargins() {
        gl.canvas.setRect(TGC_DimensionUtils.toRect(canvasMargins));
    }
    final private TGS_ShapeMargin<Integer> canvasMargins = new TGS_ShapeMargin(1, 1, 34, 79);
}
