package com.tugalsan.java.app.paint;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.function.client.maythrowexceptions.unchecked.TGS_FuncMTU;
import com.tugalsan.java.api.gui.client.click.*;
import com.tugalsan.java.api.gui.client.focus.*;
import com.tugalsan.java.api.gui.client.key.*;
import com.tugalsan.java.api.gui.client.panel.*;
import com.tugalsan.java.api.gui.client.widget.*;
import com.tugalsan.java.api.icon.client.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.api.servlet.gwt.webapp.client.TGC_SGWTCalller;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.app.paint.sg.*;

public class AppModuleCanvas extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleCanvas.class);

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
        canvasDriver = new TGC_CanvasDriver(800, 600);
        recTool = new TGC_CanvasToolRectangle();
        pencilTool = new TGC_CanvasToolPencil();
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
    private TGC_CanvasDriver canvasDriver;
    private TGC_CanvasTool pencilTool, recTool;

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
            var cmd = reply.getOutput_msg();
            lblEchoOutput.setText(cmd);
            if (cmd.equals("p")) {
                canvasDriver.tool = pencilTool;
                var msg = "pencilTool";
                d.cr("onEcho", "cmd", msg, reply.getOutput_msg());
                lblEchoOutput.setText(msg);
            } else if (cmd.equals("r")) {
                canvasDriver.tool = recTool;
                var msg = "recTool";
                d.cr("onEcho", "cmd", msg, reply.getOutput_msg());
                lblEchoOutput.setText(msg);
            } else {
                canvasDriver.tool = null;
                var msg = "unknown";
                d.cr("onEcho", "cmd", msg, reply.getOutput_msg());
                lblEchoOutput.setText(msg);
            }
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
            tbEchoInput, btnEcho, lblEchoOutput,};
        var widgetGrid = TGC_PanelLayoutUtils.createGrid(TGC_PanelLayoutUtils.MAX_GRID_WIDTH(), columnPercent, widgets, true);
        widget = new VerticalPanel();
        widget.add(widgetGrid);
        widget.add(canvasDriver.canvas);
    }
    private VerticalPanel widget;

    @Override
    public Widget getWidget() {
        return widget;
    }
}
