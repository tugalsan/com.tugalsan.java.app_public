package com.tugalsan.java.app.showcase2d.canvas;

import com.tugalsan.java.api.gui.client.widget.canvas.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.api.shape.client.*;

public class TGC_CanvasToolDrawRectangle extends TGC_CanvasTool {

    final static TGC_Log d = TGC_Log.of(TGC_CanvasToolDrawRectangle.class);

    protected TGC_CanvasToolDrawRectangle(TGC_CanvasDriver driver) {
        super(driver);
    }

    @Override
    public void onMouseDown(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
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
        var dim = TGS_ShapeDimension.of(curLoc.x - toolStartLoc.x, curLoc.y - toolStartLoc.y);
        TGC_Canvas2DPaintDrawUtils.paintRectRadius(driver.canvas, TGS_ShapeRectangle.of(toolStartLoc, dim), driver.getRadius());
    }
}
