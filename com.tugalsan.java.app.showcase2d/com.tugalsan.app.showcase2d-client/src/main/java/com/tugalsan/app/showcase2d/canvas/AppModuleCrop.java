package com.tugalsan.java.app.showcase2d.canvas;

import com.google.code.gwt.crop.client.*;
import com.google.code.gwt.crop.client.common.*;
import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.api.thread.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;

public class AppModuleCrop extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleCrop.class);

    @Override
    public String getBrowserTitle() {
        return TGC_LibBootGUITitleUtils.browserTitle_domain_txt_user(
                App.domainCard, App.loginCard, App.route,
                AppStringsUtils.TITLE_AppModuleDefault(),
                null
        );
    }

    @Override
    public String getBodyTitle() {
        return new TGS_FileHtmlText().setText(
                TGC_LibBootGUITitleUtils.bodyTitle_cloudlink_sub_user(
                        App.loginCard, App.route,
                        AppStringsUtils.TITLE_AppModuleDefault(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        loadParams();
        createWidgets();
        createPops();
        configInit();
        configActions();
        configFocus();
        configLayout();
//        TGC_FocusUtils.setFocusAfterGUIUpdate(taSend);
    }

    @Override
    public void loadParams() {
    }

    @Override
    public void createWidgets() {
        lblWidgets = new HTML("TODO");
        pdf = new HTML("<embed src='https://ontheline.trincoll.edu/images/bookdown/sample-local-pdf.pdf' width='100%' height='200px'></embed>");
        var jpgSrc = "https://plus.unsplash.com/premium_photo-1673967770669-91b5c2f2d0ce?q=80&w=730&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
        cropper = new GWTCropper(jpgSrc);
        var cropperPreview = new GWTCropperPreview(Dimension.WIDTH, 100);
        cropper.registerPreviewWidget(cropperPreview);
        cropper.setAspectRatio(0);
        TGC_ThreadUtils.run_everySeconds_afterGUIUpdate(t -> {
            d.cr("thread", cropper.getSelectionXCoordinate(), cropper.getSelectionYCoordinate(), cropper.getSelectionWidth(), cropper.getSelectionHeight());
        }, 5);
    }
    private HTML lblWidgets, pdf;
    private GWTCropper cropper;

    @Override
    public void createPops() {
    }

    @Override
    public void configInit() {
    }

    @Override
    public void configActions() {
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
        var vp = new VerticalPanel();
        vp.add(lblWidgets);
        vp.add(pdf);
        vp.add(cropper);
        widget = new ScrollPanel(vp);
    }
    public Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }

}
