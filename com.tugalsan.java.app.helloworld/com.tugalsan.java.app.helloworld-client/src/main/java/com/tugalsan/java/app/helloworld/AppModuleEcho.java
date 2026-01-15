package com.tugalsan.java.app.helloworld;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.TGS_FuncMTU;
import com.tugalsan.java.core.gui.client.click.*;
import com.tugalsan.java.core.gui.client.focus.*;
import com.tugalsan.java.core.gui.client.key.*;
import com.tugalsan.java.core.gui.client.panel.*;
import com.tugalsan.java.core.gui.client.widget.*;
import com.tugalsan.java.core.icon.client.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.core.servlet.gwt.webapp.client.TGC_SGWTCalller;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.app.helloworld.sg.*;

public class AppModuleEcho extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleEcho.class);

    @Override
    public String getBrowserTitle() {
        return TGC_LibBootGUITitleUtils.browserTitle_domain_txt_user(
                App.domainCard, App.loginCard, App.route,
                AppStrings.TITLE_AppModuleEcho(),
                null
        );
    }

    @Override
    public String getBodyTitle() {
        return new TGS_FileHtmlText().setText(
                TGC_LibBootGUITitleUtils.bodyTitle_cloud_app_sub_user(
                        App.loginCard, App.route,
                        AppStrings.TITLE_AppModuleDefault(),
                        AppStrings.TITLE_AppModuleEcho(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        loadParams();
        createWidgets();
        createPops();
        configInit();
        configActions();
        configLayout();
        configFocus();
        TGC_FocusUtils.setFocusAfterGUIUpdate(tbEchoInput);
    }
    private TextBox tbEchoInput;
    private PushButton btnEcho;
    private Label lblEchoOutput;

    @Override
    public void loadParams() {
    }

    @Override
    public void createWidgets() {
        tbEchoInput = new TextBox();
        btnEcho = TGC_ButtonUtils.createIcon(TGS_IconUtils.CLASS_CHECKMARK(), "Gönder");
        lblEchoOutput = new Label("");
    }

    @Override
    public void createPops() {
    }

    @Override
    public void configInit() {
    }

    final TGS_FuncMTU onEcho = () -> {
        TGC_SGWTCalller.async(new AppSGFEcho(tbEchoInput.getText()), reply -> {
            d.cr("onEcho", "repy", reply.getOutput_msg());
        });
    };

    @Override
    public void configActions() {
        TGC_ClickUtils.add(btnEcho, onEcho);
        TGC_KeyUtils.add(tbEchoInput, onEcho, null);
    }

    @Override
    public void configFocus() {
        TGC_FocusUtils.addKeyDown(btnEcho, nativeKeyCode -> {
            var filterFocusSides = new TGS_FocusSides4(tbEchoInput, null, null, null);
            TGC_FocusUtils.focusSide(btnEcho, filterFocusSides, nativeKeyCode);
        });
    }

    @Override
    public void configLayout() {
        Integer[] columnPercent = {25, 25, 25};
        Widget[] widgets = {
            tbEchoInput, btnEcho, lblEchoOutput
        };
        widget = TGC_PanelLayoutUtils.createGrid(TGC_PanelLayoutUtils.MAX_GRID_WIDTH(), columnPercent, widgets, true);
    }
    private Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }
}
