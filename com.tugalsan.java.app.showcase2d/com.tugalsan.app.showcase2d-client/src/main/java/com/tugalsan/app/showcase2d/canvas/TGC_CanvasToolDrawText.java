package com.tugalsan.java.app.showcase2d.canvas;

import com.tugalsan.java.api.function.client.maythrowexceptions.unchecked.TGS_FuncMTU;
import com.tugalsan.java.api.gui.client.dim.TGC_Dimension;
import com.tugalsan.java.api.gui.client.pop.TGC_PopLblYesNoTextArea;
import com.tugalsan.java.api.gui.client.widget.canvas.TGC_Canvas2DPaintTextUtils;
import com.tugalsan.java.api.log.client.TGC_Log;
import com.tugalsan.java.api.shape.client.*;
import com.tugalsan.java.api.string.client.TGS_StringUtils;

public class TGC_CanvasToolDrawText extends TGC_CanvasTool {

    final static TGC_Log d = TGC_Log.of(TGC_CanvasToolDrawText.class);

    protected TGC_CanvasToolDrawText(TGC_CanvasDriver driver) {
        super(driver);
        this.popText = new TGC_PopLblYesNoTextArea(TGC_Dimension.FULLSCREEN, "Yazı", "Değiştir", "İptal", p -> {
            p.getPop().setVisible(false);
            var txt = p.textArea.getText().trim();
            if (txt.isEmpty()) {
                text = null;
                return;
            }
            text = txt;
        }, p -> {
            p.getPop().setVisible(false);
        }, TGS_FuncMTU.empty);
    }
    final private TGC_PopLblYesNoTextArea popText;

    public void showPop() {
        popText.getPop().setVisible(true);
    }
    private String text = null;

    @Override
    public void onMouseDown(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        toolStartLoc = curLoc;
        if (TGS_StringUtils.cmn().isNullOrEmpty(text)) {
            d.ce("configActions.canvas.btnModeText", "HATA: Yazı boş.");
            return;
        }
        toolDrawing = true;
        toolStartLoc = curLoc;
        driver.addImageData(d.className());
    }

    @Override
    public void onMouseMove(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        if (!toolDrawing) {
            return;
        }
        driver.restoreImageData(driver.getImageDataLast().orElseThrow().value1);
        paint(curLoc);
    }

    @Override
    public void onMouseUp(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        if (!toolDrawing) {
            return;
        }
        toolDrawing = false;
        paint(curLoc);
    }

    private void paint(TGS_ShapeLocation<Integer> curLoc) {
        TGC_Canvas2DPaintTextUtils.paint(driver.canvas, toolStartLoc, text, driver.getFontSize() + "px " + driver.getFontName());
    }
}
