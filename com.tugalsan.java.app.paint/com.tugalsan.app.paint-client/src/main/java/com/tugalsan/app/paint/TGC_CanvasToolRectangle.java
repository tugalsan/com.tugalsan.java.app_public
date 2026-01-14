package com.tugalsan.java.app.paint;

public class TGC_CanvasToolRectangle implements TGC_CanvasTool {

    @Override
    public void onMouseDown(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        driver.drawing = true;
        driver.startLoc = curLoc;
        driver.saveImageData();
    }

    @Override
    public void onMouseMove(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        if (!driver.drawing) {
            return;
        }
        driver.restoreImageData();
        double width = curLoc.x - driver.startLoc.x;
        double height = curLoc.y - driver.startLoc.y;
        driver.canvas.getContext2d().setStrokeStyle(driver.strokeColor);
        driver.canvas.getContext2d().setLineWidth(driver.strokeWidth);
        driver.canvas.getContext2d().strokeRect(driver.startLoc.x, driver.startLoc.y, width, height);
    }

    @Override
    public void onMouseUp(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        if (!driver.drawing) {
            return;
        }
        driver.drawing = false;
        double width = curLoc.x - driver.startLoc.x;
        double height = curLoc.y - driver.startLoc.y;
        driver.canvas.getContext2d().setStrokeStyle(driver.strokeColor);
        driver.canvas.getContext2d().setLineWidth(driver.strokeWidth);
        driver.canvas.getContext2d().strokeRect(driver.startLoc.x, driver.startLoc.y, width, height);
    }

    @Override
    public void onMouseOut(TGC_CanvasDriver driver, TGC_CanvasLocation curLoc) {
        if (!driver.drawing) {
            return;
        }
        driver.drawing = false;
        double width = curLoc.x - driver.startLoc.x;
        double height = curLoc.y - driver.startLoc.y;
        driver.canvas.getContext2d().setStrokeStyle(driver.strokeColor);
        driver.canvas.getContext2d().setLineWidth(driver.strokeWidth);
        driver.canvas.getContext2d().strokeRect(driver.startLoc.x, driver.startLoc.y, width, height);
    }
}
