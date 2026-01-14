package com.tugalsan.java.app.showcase2d.canvas;

import com.google.gwt.canvas.client.*;
import com.google.gwt.canvas.dom.client.*;
import com.google.gwt.dom.client.*;
import com.google.gwt.dom.client.Style.*;
import com.google.gwt.event.dom.client.*;
import com.tugalsan.java.core.gui.client.widget.canvas.*;
import com.tugalsan.java.core.hex.client.*;
import com.tugalsan.java.core.shape.client.*;
import com.tugalsan.java.core.tuple.client.*;
import java.util.*;

public class TGC_CanvasDriver {

    final public static int DEFAULT_LineWidth = 3;
    final public static int DEFAULT_Alpha = 255;
    final public static int DEFAULT_FontSize = 8;
    final public static int DEFAULT_Radius = 1;
    final public static BorderStyle DEFAULT_BorderStyle = BorderStyle.DASHED;

    public TGC_CanvasDriver(TGS_ShapeDimension<Integer> canvasSize) {
        canvas = Canvas.createIfSupported();
        setCanvasBorderStyle(DEFAULT_BorderStyle);
        setCanvasBorderWidthPx(1);
        setCanvasSize(canvasSize);
        setFillStyle(TGC_CanvasWidgetColor.DEFAULT, DEFAULT_Alpha);
        setFontName(TGC_CanvasWidgetFontName.DEFAULT);
        setFontSize(DEFAULT_FontSize);
        setLineCap(TGC_CanvasWidgetLineCap.DEFAULT);
        setLineJoin(TGC_CanvasWidgetLineJoin.DEFAULT);
        setLineWidth(DEFAULT_LineWidth);
        setStrokeStyle(TGC_CanvasWidgetColor.DEFAULT, DEFAULT_Alpha);
        setRadius(DEFAULT_Radius);
        setToolNone();
        canvas.addMouseDownHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseDown(e.isAltKeyDown(), e.isControlKeyDown(), e.isShiftKeyDown(), curLoc(e));
        });
        canvas.addMouseMoveHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseMove(e.isAltKeyDown(), e.isControlKeyDown(), e.isShiftKeyDown(), curLoc(e));
        });
        canvas.addMouseUpHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseUp(e.isAltKeyDown(), e.isControlKeyDown(), e.isShiftKeyDown(), curLoc(e));
        });
        canvas.addMouseOutHandler(e -> {
            if (tool == null) {
                return;
            }
            tool.onMouseOut(e.isAltKeyDown(), e.isControlKeyDown(), e.isShiftKeyDown(), curLoc(e));
        });
    }

    private TGS_ShapeLocation<Integer> curLoc(MouseEvent e) {
        return new TGS_ShapeLocation(e.getClientX() - canvas.getAbsoluteLeft(), e.getClientY() - canvas.getAbsoluteTop());
    }

    //----------------------------------- CANVAS-SELF ---------------------
    public Context2d context2d() {
        return canvas.getContext2d();
    }
    final public Canvas canvas;

    public void canvasClear() {
        context2d().clearRect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
    }

    //----------------------------------- CANVAS-SIZE ---------------------
    final public void setCanvasSize(TGS_ShapeDimension<Integer> canvasSize) {
        this.canvasSize = canvasSize;
        TGC_CanvasUtils.setDimension(canvas, canvasSize);
        TGC_CanvasUtils.setResolution(canvas, canvasSize);
    }
    private TGS_ShapeDimension<Integer> canvasSize;

    public TGS_ShapeDimension<Integer> getCanvasSize() {
        return canvasSize;
    }

    //----------------------------------- CANVAS-BORDER-WIDTH ---------------------
    final public void setCanvasBorderWidthPx(int borderWidthPx) {
        this.canvasBorderWidthPx = borderWidthPx;
        canvas.getElement().getStyle().setBorderWidth(borderWidthPx, Style.Unit.PX);
    }
    private int canvasBorderWidthPx;

    public int getCanvasBorderWidthPx() {
        return canvasBorderWidthPx;
    }

    //----------------------------------- CANVAS-BORDER-STYLE ---------------------
    final public void setCanvasBorderStyle(BorderStyle borderStyle) {
        this.canvasBorderStyle = borderStyle;
        canvas.getElement().getStyle().setBorderStyle(borderStyle);
    }
    private BorderStyle canvasBorderStyle;

    public BorderStyle getCanvasBorderStyle() {
        return canvasBorderStyle;
    }

    //----------------------------------- LINE-CAP ---------------------
    final public void setLineCap(Context2d.LineCap lineCap) {
        this.lineCap = lineCap;
        context2d().setLineCap(lineCap);
    }
    private Context2d.LineCap lineCap;

    public Context2d.LineCap getLineCap() {
        return lineCap;
    }

    //----------------------------------- LINE-JOIN ---------------------
    final public void setLineJoin(Context2d.LineJoin lineJoin) {
        this.lineJoin = lineJoin;
        context2d().setLineJoin(lineJoin);
    }
    private Context2d.LineJoin lineJoin;

    public Context2d.LineJoin getLineJoin() {
        return lineJoin;
    }

    //----------------------------------- RADUIS ---------------------
    final public void setRadius(int radius) {
        this.radius = radius;
    }
    private int radius;

    public int getRadius() {
        return radius;
    }
    //----------------------------------- LINE-WIDTH ---------------------

    final public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
        context2d().setLineWidth(lineWidth);
    }
    private double lineWidth;

    public double getLineWidth() {
        return lineWidth;
    }

    //----------------------------------- COLOR ---------------------
    final public void setStrokeStyle(String color_hex_full) {
        context2d().setStrokeStyle(color_hex_full);
    }

    final public void setStrokeStyle(String color_hex, int opacy_int) {
        var opacy_hex = TGS_HexUtils.toHex(opacy_int);
        strokeStyle = color_hex + opacy_hex;
        context2d().setStrokeStyle(strokeStyle);
    }
    private String strokeStyle;

    public String getStrokeStyle() {
        return strokeStyle;
    }

    final public void setFillStyle(String color_hex_full) {
        context2d().setFillStyle(color_hex_full);
    }

    final public void setFillStyle(String color_hex, int opacy_int) {
        var opacy_hex = TGS_HexUtils.toHex(opacy_int);
        fillStyle = color_hex + opacy_hex;
        context2d().setFillStyle(fillStyle);
    }
    private String fillStyle;

    public String getFillStyle() {
        return fillStyle;
    }

    public void setColorAndOpacy(String color_hex, int opacy_int) {
        setStrokeStyle(color_hex, opacy_int);
        setFillStyle(color_hex, opacy_int);
    }

    //----------------------------------- FONT-DATA ---------------------
    public String getFontName() {
        return fontName;
    }
    private String fontName;

    final public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontSize() {
        return fontSize;
    }
    private int fontSize;

    final public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    //----------------------------------- IMAGE ---------------------
    public void addImageData(String tag) {
        var savedImageData = TGC_Canvas2DUtils.save(canvas);
        savedImageDatas.add(TGS_Tuple2.of(tag, savedImageData));
    }
    public List<TGS_Tuple2<String, ImageData>> savedImageDatas = new ArrayList();

    public Optional<TGS_Tuple2<String, ImageData>> getImageDataLast() {
        if (savedImageDatas.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(savedImageDatas.get(savedImageDatas.size() - 1));
    }

    public void restoreImageData(ImageData imageData) {
        TGC_Canvas2DUtils.restore(imageData, canvas);
    }

    //----------------------------------- TOOL ---------------------
    final public void setToolNone() {
        setTool(null);
    }

    public void setTool(TGC_CanvasTool tool) {
        this.tool = tool;
        if (tool != null) {
            tool.reset();
        }
    }

    private TGC_CanvasTool tool;

    public TGC_CanvasTool getTool() {
        return tool;
    }
    
    public String toUrl(){
        return canvas.toDataUrl();
    }
}
