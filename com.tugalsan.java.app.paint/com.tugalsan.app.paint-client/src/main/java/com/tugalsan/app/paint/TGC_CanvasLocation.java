package com.tugalsan.java.app.paint;

import com.google.gwt.canvas.client.Canvas;

public class TGC_CanvasLocation {

    private TGC_CanvasLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    final double x, y;

    public static TGC_CanvasLocation of(double x, double y) {
        return new TGC_CanvasLocation(x, y);
    }

    public static TGC_CanvasLocation fromClient(Canvas canvas, double clientX, double clientY) {
        var el = canvas.getElement();
        var left = el.getAbsoluteLeft();
        var top = el.getAbsoluteTop();
        var x = (clientX - left);
        var y = (clientY - top);
        return new TGC_CanvasLocation(x, y);
    }
}
