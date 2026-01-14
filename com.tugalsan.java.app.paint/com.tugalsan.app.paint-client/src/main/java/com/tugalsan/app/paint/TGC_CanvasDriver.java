package com.tugalsan.java.app.paint;

import com.tugalsan.java.api.gui.client.browser.*;
import com.google.gwt.canvas.client.*;
import com.google.gwt.canvas.dom.client.*;
import com.google.gwt.event.dom.client.*;
import com.tugalsan.java.api.gui.client.widget.canvas.*;

public class TGC_CanvasDriver {

    public TGC_CanvasDriver(int canvasWidth, int canvasHeight) {
        this.drawing = false;
        this.strokeColor = "#000000";
        this.strokeWidth = 3.0d;
        this.dpr = TGC_BrowserScreenUtils.getDevicePixelRatio();
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        canvas = Canvas.createIfSupported();
        canvas.getElement().getStyle().setBorderWidth(1, com.google.gwt.dom.client.Style.Unit.PX);
        canvas.getElement().getStyle().setBorderStyle(com.google.gwt.dom.client.Style.BorderStyle.SOLID);
        canvas.setCoordinateSpaceWidth((int) (canvasWidth * dpr));
        canvas.setCoordinateSpaceHeight((int) (canvasHeight * dpr));
        canvas.setWidth(canvasWidth + "px");
        canvas.setHeight(canvasHeight + "px");
        canvas.getContext2d().scale(dpr, dpr);
        canvas.getContext2d().setLineCap(Context2d.LineCap.ROUND);
        canvas.getContext2d().setLineJoin(Context2d.LineJoin.ROUND);
        canvas.addMouseDownHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseDown(this, curLoc(e));
        });
        canvas.addMouseMoveHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseMove(this, curLoc(e));
        });
        canvas.addMouseUpHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseUp(this, curLoc(e));
        });
        canvas.addMouseOutHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseOut(this, curLoc(e));
        });
    }
    public int canvasWidth, canvasHeight;
    public double dpr;
    public Canvas canvas;
    public boolean drawing;
    public String strokeColor;
    public double strokeWidth;
    public TGC_CanvasTool tool;
    public TGC_CanvasLocation startLoc;//for rectangle

    public void saveImageData() {
        savedImageData = TGC_Canvas2DUtils.save(canvas);
    }
    public ImageData savedImageData;

    public void restoreImageData() {
        TGC_Canvas2DUtils.restore(savedImageData, canvas);
    }

    public TGC_CanvasLocation curLoc(MouseEvent e) {
        return TGC_CanvasLocation.fromClient(canvas, e.getClientX(), e.getClientY());
    }

}
