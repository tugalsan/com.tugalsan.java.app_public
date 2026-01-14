package com.tugalsan.java.app.showcase2d.canvas;

import com.tugalsan.java.api.gui.client.widget.canvas.TGC_Canvas2DPaintFillUtils;
import com.tugalsan.java.api.log.client.TGC_Log;
import com.tugalsan.java.api.shape.client.*;

public class TGC_CanvasToolFillCircle extends TGC_CanvasTool {

    final static TGC_Log d = TGC_Log.of(TGC_CanvasToolFillCircle.class);

    protected TGC_CanvasToolFillCircle(TGC_CanvasDriver driver) {
        super(driver);
    }

    @Override
    public void onMouseDown(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        toolDrawing = true;
        toolStartLoc = curLoc;
        if (driver.getRadius() < 1) {
            d.ce("onMouseDown", "HATA: radius < 1");
            return;
        }

        TGC_Canvas2DPaintFillUtils.paintCirle(driver.canvas, curLoc, driver.getRadius());
    }

    @Override
    public void onMouseMove(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        if (!toolDrawing) {
            return;
        }
    }

    @Override
    public void onMouseUp(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        if (!toolDrawing) {
            return;
        }
        toolDrawing = false;
    }
}
