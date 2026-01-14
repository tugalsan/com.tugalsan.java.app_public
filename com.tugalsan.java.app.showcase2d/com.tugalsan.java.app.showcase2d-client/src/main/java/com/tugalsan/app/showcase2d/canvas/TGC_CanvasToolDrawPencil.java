package com.tugalsan.java.app.showcase2d.canvas;

import com.tugalsan.java.core.log.client.TGC_Log;
import com.tugalsan.java.core.shape.client.*;

public class TGC_CanvasToolDrawPencil extends TGC_CanvasTool {

    final static TGC_Log d = TGC_Log.of(TGC_CanvasToolDrawPencil.class);

    protected TGC_CanvasToolDrawPencil(TGC_CanvasDriver driver) {
        super(driver);
    }

    @Override
    public void onMouseDown(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        toolDrawing = true;
        toolStartLoc = curLoc;
        driver.context2d().beginPath();
        driver.context2d().moveTo(curLoc.x, curLoc.y);
    }

    @Override
    public void onMouseMove(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        if (!toolDrawing) {
            return;
        }
        driver.context2d().lineTo(curLoc.x, curLoc.y);
        driver.context2d().stroke();
    }

    @Override
    public void onMouseUp(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        if (!toolDrawing) {
            return;
        }
        toolDrawing = false;
        driver.context2d().closePath();
    }
}
