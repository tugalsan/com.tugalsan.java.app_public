package com.tugalsan.java.app.showcase2d.canvas;

import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.*;
import com.tugalsan.java.core.gui.client.click.*;
import com.tugalsan.java.core.gui.client.widget.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.core.gui.client.widget.canvas.*;
import com.tugalsan.java.core.icon.client.*;
import com.tugalsan.java.core.shape.client.*;
import com.tugalsan.java.core.url.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.resource.client.*;
import com.google.gwt.dom.client.*;
import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.gui.client.dom.*;
import java.util.function.Supplier;

public class AppModulePaint extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModulePaint.class);

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
        if (!TGC_CanvasUtils.isSupported()) {
            d.ce("run", "HATA: Tuval desteklenmiyor.");
            return;
        }
        //CANVAS DRIVER & TOOLS
        canvasDriver = StableValue.supplier(() -> new TGC_CanvasDriver(CANVAS_SIZE));
        toolDrawCrop = StableValue.supplier(() -> new TGC_CanvasToolCrop(canvasDriver.get()));
        toolDrawText = StableValue.supplier(() -> new TGC_CanvasToolDrawText(canvasDriver.get()));
        toolDrawCircle = StableValue.supplier(() -> new TGC_CanvasToolDrawCircle(canvasDriver.get()));
        toolFillCircle = StableValue.supplier(() -> new TGC_CanvasToolFillCircle(canvasDriver.get()));
        toolDrawPencil = StableValue.supplier(() -> new TGC_CanvasToolDrawPencil(canvasDriver.get()));
        toolDrawLine = StableValue.supplier(() -> new TGC_CanvasToolDrawLine(canvasDriver.get()));
        toolDrawRectangle = StableValue.supplier(() -> new TGC_CanvasToolDrawRectangle(canvasDriver.get()));
        toolFillRectangle = StableValue.supplier(() -> new TGC_CanvasToolFillRectangle(canvasDriver.get()));
        //INIT
        loadParams();
        createWidgets();
        createPops();
        configInit();
        configActions();
        configFocus();
        configLayout();
    }
    private Supplier<TGC_CanvasDriver> canvasDriver;
    private Supplier<TGC_CanvasTool> toolDrawCrop, toolDrawText, toolDrawCircle, toolFillCircle, toolDrawPencil, toolDrawLine, toolDrawRectangle, toolFillRectangle;

    @Override
    public void loadParams() {
    }
    final private static TGS_ShapeDimension<Integer> CANVAS_SIZE = new TGS_ShapeDimension(1000, 400);

    @Override
    public void createWidgets() {
        var rbg = "rbg";
        btnClear = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(TGS_IconUtils.CLASS_BIN(), "Temizle"));
        btnRandom = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(TGS_IconUtils.CLASS_HAMMER(), "Rastgele"));
        btnCanvasSet = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(TGS_IconUtils.CLASS_CHECKMARK(), "Değiştir"));
        btnToolCrop = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, null, "✂ Crop"));
        btnToolText = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, TGS_IconUtils.CLASS_PENCIL(), "Yazı"));
        btnToolDrawCircle = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, null, "⚪ Daire"));
        btnToolFillCircle = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, null, "⚫ Daire"));
        btnToolPencil = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, TGS_IconUtils.CLASS_PLUS(), "Çizim"));
        btnToolLine = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, TGS_IconUtils.CLASS_MINUS(), "Çizgi"));
        btnToolDrawRectangle = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, null, "▢ Diktörgen"));
        btnToolFillRectangle = StableValue.supplier(() -> TGC_ButtonUtils.createIcon(rbg, null, "◾ Diktörgen"));
        wiCanvasWidth = StableValue.supplier(() -> new TGC_CanvasWidgetInteger(
                1, CANVAS_SIZE.width, 5120, "↔ Canvas:"
        ));
        wiCanvasHeight = StableValue.supplier(() -> new TGC_CanvasWidgetInteger(
                1, CANVAS_SIZE.height, 3840, "↕ Canvas:"
        ));
        wcColor = StableValue.supplier(() -> new TGC_CanvasWidgetColor(
                TGC_CanvasWidgetColor.DEFAULT, "🖌️ Rengi:"
        ));
        wiOpacy = StableValue.supplier(() -> new TGC_CanvasWidgetInteger(
                0, TGC_CanvasDriver.DEFAULT_Alpha, 255, "🪟 Saydamlık:"
        ));
        wfnFontName = StableValue.supplier(() -> new TGC_CanvasWidgetFontName(
                TGC_CanvasWidgetFontName.DEFAULT, "♙ Font:"
        ));
        wiFontSize = StableValue.supplier(() -> new TGC_CanvasWidgetInteger(
                1, TGC_CanvasDriver.DEFAULT_FontSize, 100, "♙ Font:"
        ));
        wlcLineCap = StableValue.supplier(() -> new TGC_CanvasWidgetLineCap(
                TGC_CanvasWidgetLineCap.DEFAULT, "🖌️ Ucu:"
        ));
        wljLineJoin = StableValue.supplier(() -> new TGC_CanvasWidgetLineJoin(
                TGC_CanvasWidgetLineJoin.DEFAULT, "🖌️ Birleşim:"
        ));
        wiLineWidth = StableValue.supplier(() -> new TGC_CanvasWidgetInteger(
                1, TGC_CanvasDriver.DEFAULT_LineWidth, 50, "🖌️ Genişliği:"
        ));
        wiRadius = StableValue.supplier(() -> new TGC_CanvasWidgetInteger(
                0, TGC_CanvasDriver.DEFAULT_Radius, 50, "🖌️ YarıÇap:"
        ));
    }
    private Supplier<PushButton> btnClear, btnRandom, btnCanvasSet, btnToolCrop, btnToolText, btnToolDrawCircle, btnToolFillCircle, btnToolPencil, btnToolLine, btnToolDrawRectangle, btnToolFillRectangle;
    private Supplier<TGC_CanvasWidgetInteger> wiLineWidth, wiRadius, wiCanvasWidth, wiCanvasHeight, wiOpacy, wiFontSize;
    private Supplier<TGC_CanvasWidgetColor> wcColor;
    private Supplier<TGC_CanvasWidgetLineCap> wlcLineCap;
    private Supplier<TGC_CanvasWidgetLineJoin> wljLineJoin;
    private Supplier<TGC_CanvasWidgetFontName> wfnFontName;

    @Override
    public void createPops() {

    }

    @Override
    public void configInit() {
    }

    @Override
    public void configActions() {
        TGC_ClickUtils.add(btnClear.get(), () -> {
            canvasDriver.get().canvasClear();
        });
        TGC_ClickUtils.add(btnRandom.get(), () -> {
            TGC_Canvas2DPaintRandomUtils.drawSomethingNew(canvasDriver.get().canvas, CANVAS_SIZE, TGS_Url.of(
                    TGS_LibResourceUtils.common.res.image.search.icon_png().toString()
            ));
        });
        TGC_ClickUtils.add(btnCanvasSet.get(), () -> {
            canvasDriver.get().setCanvasSize(new TGS_ShapeDimension(
                    wiCanvasWidth.get().getVal(), wiCanvasHeight.get().getVal()
            ));
        });
        //TOOL
        TGC_ClickUtils.add(btnToolCrop.get(), () -> {
            canvasDriver.get().setTool(toolDrawCrop.get());
            d.cr("configActions", "toolDrawCrop");
        });
        TGC_ClickUtils.add(btnToolDrawRectangle.get(), () -> {
            canvasDriver.get().setTool(toolDrawRectangle.get());
            d.cr("configActions", "btnToolDrawRectangle");
        });
        TGC_ClickUtils.add(btnToolFillRectangle.get(), () -> {
            canvasDriver.get().setTool(toolFillRectangle.get());
            d.cr("configActions", "btnToolFillRectangle");
        });
        TGC_ClickUtils.add(btnToolLine.get(), () -> {
            canvasDriver.get().setTool(toolDrawLine.get());
            d.cr("configActions", "btnToolLine");
        });
        TGC_ClickUtils.add(btnToolDrawCircle.get(), () -> {
            canvasDriver.get().setTool(toolDrawCircle.get());
            d.cr("configActions", "toolDrawCircle");
        });
        TGC_ClickUtils.add(btnToolFillCircle.get(), () -> {
            canvasDriver.get().setTool(toolFillCircle.get());
            d.cr("configActions", "toolFillCircle");
        });
        TGC_ClickUtils.add(btnToolPencil.get(), () -> {
            canvasDriver.get().setTool(toolDrawPencil.get());
            d.cr("configActions", "btnToolPencil");
        });
        TGC_ClickUtils.add(btnToolText.get(), () -> {
            var tool = (TGC_CanvasToolDrawText) toolDrawText.get();
            canvasDriver.get().setTool(tool);
            tool.showPop();
            d.cr("configActions", "btnToolText");
        });
        //CONFIG
        TGC_TextBoxUtils.onChange(wcColor.get().textBox, () -> {
            var valColor = wcColor.get().getVal();
            var valOpacy = wiOpacy.get().getVal();
            canvasDriver.get().setColorAndOpacy(valColor, valOpacy);
            d.cr("configActions", "wcColor", "Renk ve Saydamlık", valColor, valOpacy);
        });
        TGC_TextBoxUtils.onChange(wiOpacy.get().textBox, () -> {
            var valColor = wcColor.get().getVal();
            var valOpacy = wiOpacy.get().getVal();
            canvasDriver.get().setColorAndOpacy(valColor, valOpacy);
            d.cr("configActions", "wiOpacy", "Renk ve Saydamlık", valColor, valOpacy);
        });
        TGC_ClickUtils.add(wfnFontName.get().listBox, () -> {
            var idx = wfnFontName.get().listBox.getSelectedIndex();
            if (idx == -1) {
                return;
            }
            canvasDriver.get().setFontName(wfnFontName.get().lst.get(idx));
            d.cr("configActions", "wfnFontName", "Font Adı:", canvasDriver.get().getFontName());
        }, TGS_FuncMTU.empty);
        TGC_TextBoxUtils.onChange(wiFontSize.get().textBox, () -> {
            var val = wiFontSize.get().getVal();
            canvasDriver.get().setFontSize(val);
            d.cr("configActions", "wiFontSize", "Font Büyüklüğü ", val);
        });
        TGC_ClickUtils.add(wlcLineCap.get().listBox, () -> {
            var idx = wlcLineCap.get().listBox.getSelectedIndex();
            if (idx == -1) {
                return;
            }
            canvasDriver.get().setLineCap(wlcLineCap.get().lst.get(idx));
            d.cr("configActions", "wlcLineCap", "Çizim Ucu:", canvasDriver.get().getLineCap());
        }, TGS_FuncMTU.empty);
        TGC_ClickUtils.add(wljLineJoin.get().listBox, () -> {
            var idx = wljLineJoin.get().listBox.getSelectedIndex();
            if (idx == -1) {
                return;
            }
            canvasDriver.get().setLineJoin(wljLineJoin.get().lst.get(idx));
            d.cr("configActions", "wljLineJoin", "Çizim Birleşimi:", canvasDriver.get().getLineJoin());
        }, TGS_FuncMTU.empty);
        TGC_TextBoxUtils.onChange(wiLineWidth.get().textBox, () -> {
            var val = wiLineWidth.get().getVal();
            canvasDriver.get().setLineWidth(val);
            d.cr("configActions", "wiLineWidth", "Çizim Kalınlığı ", val);
        });
        TGC_TextBoxUtils.onChange(wiRadius.get().textBox, () -> {
            var val = wiRadius.get().getVal();
            canvasDriver.get().setRadius(val);
            d.cr("configActions", "wiRadius", "Yarı Çap ", val);
        });
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
        //CANVAS
        btnClear.get().addStyleName("AppModuleTable_btn");
        btnRandom.get().addStyleName("AppModuleTable_btn");

        wiCanvasWidth.get().html.addStyleName("AppModuleTable_lbl");
        wiCanvasWidth.get().textBox.addStyleName("AppModuleTable_tbInt");
        TGC_DOMUtils.setWidth(wiCanvasWidth.get().textBox.getElement(), 60);

        wiCanvasHeight.get().html.addStyleName("AppModuleTable_lbl");
        wiCanvasHeight.get().textBox.addStyleName("AppModuleTable_tbInt");
        TGC_DOMUtils.setWidth(wiCanvasHeight.get().textBox.getElement(), 60);

        btnCanvasSet.get().addStyleName("AppModuleTable_btn");
        btnToolCrop.get().addStyleName("AppModuleTable_btn");

        //TOOL-SELF
        btnToolText.get().addStyleName("AppModuleTable_btn");
        btnToolDrawCircle.get().addStyleName("AppModuleTable_btn");
        btnToolFillCircle.get().addStyleName("AppModuleTable_btn");
        btnToolPencil.get().addStyleName("AppModuleTable_btn");
        btnToolLine.get().addStyleName("AppModuleTable_btn");
        btnToolDrawRectangle.get().addStyleName("AppModuleTable_btn");
        btnToolFillRectangle.get().addStyleName("AppModuleTable_btn");

        //CONFIG-CONFIG
        wcColor.get().html.addStyleName("AppModuleTable_lbl");
        wcColor.get().textBox.addStyleName("AppModuleTable_tbInt");
        wcColor.get().html.getElement().getStyle().setWidth(73, Style.Unit.PX);
        wcColor.get().textBox.getElement().getStyle().setWidth(75, Style.Unit.PX);

        wiOpacy.get().html.addStyleName("AppModuleTable_lbl");
        wiOpacy.get().textBox.addStyleName("AppModuleTable_tbInt");
        TGC_DOMUtils.setWidth(wiOpacy.get().textBox.getElement(), 53);

        wfnFontName.get().html.addStyleName("AppModuleTable_lbl");
        wfnFontName.get().listBox.addStyleName("AppModuleTable_tbInt");
        wfnFontName.get().html.getElement().getStyle().setWidth(65, Style.Unit.PX);
        wfnFontName.get().listBox.getElement().getStyle().setWidth(180, Style.Unit.PX);

        wiFontSize.get().html.addStyleName("AppModuleTable_lbl");
        wiFontSize.get().textBox.addStyleName("AppModuleTable_tbInt");
        wiFontSize.get().html.getElement().getStyle().setWidth(50, Style.Unit.PX);

        wlcLineCap.get().html.addStyleName("AppModuleTable_lbl");
        wlcLineCap.get().listBox.addStyleName("AppModuleTable_tbInt");
        wlcLineCap.get().html.getElement().getStyle().setWidth(65, Style.Unit.PX);
        wlcLineCap.get().listBox.getElement().getStyle().setWidth(80, Style.Unit.PX);

        wljLineJoin.get().html.addStyleName("AppModuleTable_lbl");
        wljLineJoin.get().listBox.addStyleName("AppModuleTable_tbInt");
        wljLineJoin.get().html.getElement().getStyle().setWidth(65, Style.Unit.PX);
        wljLineJoin.get().listBox.getElement().getStyle().setWidth(80, Style.Unit.PX);

        wiLineWidth.get().html.addStyleName("AppModuleTable_lbl");
        wiLineWidth.get().textBox.addStyleName("AppModuleTable_tbInt");
        wiLineWidth.get().html.getElement().getStyle().setWidth(90, Style.Unit.PX);

        wiRadius.get().html.addStyleName("AppModuleTable_lbl");
        wiRadius.get().textBox.addStyleName("AppModuleTable_tbInt");
        wiRadius.get().html.getElement().getStyle().setWidth(90, Style.Unit.PX);

        //LAYOUT
        var pnlRow0_canvas = new HorizontalPanel();
        pnlRow0_canvas.add(btnClear.get());
        pnlRow0_canvas.add(btnRandom.get());
        pnlRow0_canvas.add(wiCanvasWidth.get().html);
        pnlRow0_canvas.add(wiCanvasWidth.get().textBox);
        pnlRow0_canvas.add(wiCanvasHeight.get().html);
        pnlRow0_canvas.add(wiCanvasHeight.get().textBox);
        pnlRow0_canvas.add(btnCanvasSet.get());
        pnlRow0_canvas.add(btnToolCrop.get());
        var pnlRow1_yazi = new HorizontalPanel();
        pnlRow1_yazi.add(btnToolText.get());
        pnlRow1_yazi.add(wfnFontName.get().html);
        pnlRow1_yazi.add(wfnFontName.get().listBox);
        pnlRow1_yazi.add(wiFontSize.get().html);
        pnlRow1_yazi.add(wiFontSize.get().textBox);
        pnlRow1_yazi.add(wcColor.get().html);
        pnlRow1_yazi.add(wcColor.get().textBox);
        pnlRow1_yazi.add(wiOpacy.get().html);
        pnlRow1_yazi.add(wiOpacy.get().textBox);
        var pnlRow1_tool = new HorizontalPanel();
        pnlRow1_tool.add(btnToolDrawCircle.get());
        pnlRow1_tool.add(btnToolFillCircle.get());
        pnlRow1_tool.add(btnToolPencil.get());
        pnlRow1_tool.add(btnToolLine.get());
        pnlRow1_tool.add(btnToolDrawRectangle.get());
        pnlRow1_tool.add(btnToolFillRectangle.get());
        var pnlRow1_tool2 = new HorizontalPanel();
        pnlRow1_tool2.add(wlcLineCap.get().html);
        pnlRow1_tool2.add(wlcLineCap.get().listBox);
        pnlRow1_tool2.add(wljLineJoin.get().html);
        pnlRow1_tool2.add(wljLineJoin.get().listBox);
        pnlRow1_tool2.add(wiLineWidth.get().html);
        pnlRow1_tool2.add(wiLineWidth.get().textBox);
        pnlRow1_tool2.add(wiRadius.get().html);
        pnlRow1_tool2.add(wiRadius.get().textBox);

        var pnlV = new VerticalPanel();
        pnlV.add(pnlRow0_canvas);
        pnlV.add(pnlRow1_yazi);
        pnlV.add(pnlRow1_tool);
        pnlV.add(pnlRow1_tool2);
        pnlV.add(canvasDriver.get().canvas);

        widget = new ScrollPanel(pnlV);
    }
    private Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }

}
