package com.tugalsan.java.app.paint;

public interface TGC_CanvasTool {

    void onMouseDown(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc);

    void onMouseMove(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc);

    void onMouseUp(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc);

    void onMouseOut(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc);
}
