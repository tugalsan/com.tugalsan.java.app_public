package com.tugalsan.java.app.paint;

public class TGC_CanvasToolPencil implements TGC_CanvasTool {

    @Override
    public void onMouseDown(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        driver.drawing = true;
        driver.canvas.getContext2d().setStrokeStyle(driver.strokeColor);
        driver.canvas.getContext2d().setLineWidth(driver.strokeWidth);
        driver.canvas.getContext2d().beginPath();
        driver.canvas.getContext2d().moveTo(curLoc.x, curLoc.y);
        driver.canvas.getContext2d().beginPath();
        driver.canvas.getContext2d().moveTo(curLoc.x, curLoc.y);
    }

    @Override
    public void onMouseMove(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        if (!driver.drawing) {
            return;
        }
        driver.canvas.getContext2d().lineTo(curLoc.x, curLoc.y);
        driver.canvas.getContext2d().stroke();
        driver.canvas.getContext2d().beginPath();
        driver.canvas.getContext2d().moveTo(curLoc.x, curLoc.y);
    }

    @Override
    public void onMouseUp(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        if (!driver.drawing) {
            return;
        }
        driver.drawing = false;
        driver.canvas.getContext2d().closePath();
    }

    @Override
    public void onMouseOut(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        if (!driver.drawing) {
            return;
        }
        driver.drawing = false;
        driver.canvas.getContext2d().closePath();
    }
}
