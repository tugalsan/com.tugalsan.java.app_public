package com.tugalsan.java.app.showcase2d;

import com.tugalsan.java.app.showcase2d.canvas.*;
import com.tugalsan.java.app.showcase2d.widget.*;
import com.tugalsan.java.app.showcase2d.richtext.*;
import com.tugalsan.java.app.showcase2d.scroll.*;
import com.tugalsan.java.app.showcase2d.menu.*;
import com.tugalsan.java.app.showcase2d.upload.*;
import com.tugalsan.java.app.showcase2d.layout.*;
import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.gui.client.browser.*;
import com.tugalsan.java.api.gui.client.card.*;
import com.tugalsan.java.api.gui.client.widget.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.resource.client.*;
import com.tugalsan.java.lib.scale.client.*;

public class AppModuleDefault extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleDefault.class);

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
        var search_png = TGS_LibResourceUtils.common.res.image.search.icon_png().toString();
        var showcase = TGS_LibScaleMemUtils.showcase();

        //ADD USER APPS
        scroll = new ScrollPanel();
        var pack = TGC_CardUtils.create(scroll, null, search_png, cards -> {
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModulePaint.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModulePaint.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleCrop.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleCrop.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleRichTextArea.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleRichTextArea.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleDock.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleDock.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleFlex.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleFlex.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleFlow1.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleFlow1.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleFlow2.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleFlow2.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleGrid.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleGrid.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleHTML.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleHTML.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleLayout.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleLayout.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleMenu.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleMenu.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleScroll.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleScroll.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleSplit.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleSplit.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleStack.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleStack.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleTab.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleTab.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleUpload.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleUpload.class.getSimpleName()).toUrl()
                    )
            ));
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null,
                    AppModuleWidget.class.getSimpleName(),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(AppModuleWidget.class.getSimpleName()).toUrl()
                    )
            ));
        });
        tbInput = pack.value0;
        pnlCards = pack.value1;
    }
    private TextBox tbInput;
    private FlowPanel pnlCards;
    private ScrollPanel scroll;

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
        TGC_LibBootGUIBody.buttonHolderCenter.add(tbInput);

        scroll.setWidget(pnlCards);
        TGC_ScrollUtils.addScrollToTop(scroll);

        widget = scroll;
    }
    public Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }
}
