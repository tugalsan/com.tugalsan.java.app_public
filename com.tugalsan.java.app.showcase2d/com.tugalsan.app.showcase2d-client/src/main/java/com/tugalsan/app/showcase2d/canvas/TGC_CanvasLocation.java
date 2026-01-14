package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.canvas.client.Canvas;
import com.tugalsan.java.api.shape.client.TGS_ShapeLocation;

public class TGC_CanvasLocation {

    private TGC_CanvasLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    final double x, y;

    public static TGC_CanvasLocation of(double x, double y) {
        return new TGC_CanvasLocation(x, y);
    }

    public static TGC_CanvasLocation fromClient(Canvas canvas, int clientX, int clientY, double magnify) {
        var target = new TGS_ShapeLocation<Integer>(clientX - canvas.getAbsoluteLeft(), clientY - canvas.getAbsoluteTop());
        target.set((int) Math.round(target.x * magnify), (int) Math.round(target.y * magnify));

        var el = canvas.getElement();
        var left = el.getAbsoluteLeft();
        var top = el.getAbsoluteTop();
        var x = (clientX - left);
        var y = (clientY - top);
        return new TGC_CanvasLocation(x, y);
    }
}
