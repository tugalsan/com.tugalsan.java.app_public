package com.tugalsan.java.app.showcase2d.canvas;

import com.tugalsan.java.api.shape.client.*;

public abstract class TGC_CanvasTool {

    protected TGC_CanvasTool(TGC_CanvasDriver driver) {
        this.driver = driver;
        reset();
    }
    protected TGC_CanvasDriver driver;

    public void reset() {
        this.toolDrawing = false;
        this.toolStartLoc = null;
        this.brushSize = 5;
    }
    protected boolean toolDrawing;
    protected TGS_ShapeLocation<Integer> toolStartLoc;
    protected int brushSize;

    abstract void onMouseDown(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc);

    abstract void onMouseMove(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc);

    abstract void onMouseUp(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc);

    public void onMouseOut(boolean isAltKeyDown, boolean isControlKeyDown, boolean isShiftKeyDown, TGS_ShapeLocation<Integer> curLoc) {
        onMouseUp(isAltKeyDown, isControlKeyDown, isShiftKeyDown, curLoc);
    }
}
