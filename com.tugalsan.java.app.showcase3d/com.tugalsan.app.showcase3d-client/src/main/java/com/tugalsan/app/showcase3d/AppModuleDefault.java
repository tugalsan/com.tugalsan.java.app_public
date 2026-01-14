package com.tugalsan.java.app.showcase3d;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.gui.client.browser.*;
import com.tugalsan.java.api.gui.client.card.*;
import com.tugalsan.java.api.gui.client.widget.*;
import com.tugalsan.java.api.log.client.TGC_Log;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.resource.client.*;
import com.tugalsan.java.lib.scale.client.*;

public class AppModuleDefault extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleDefault.class);

    @Override
    public String getBrowserTitle() {
        return TGC_LibBootGUITitleUtils.browserTitle_domain_txt_user(
                App.domainCard, App.loginCard, App.route,
                AppStrings.TITLE_AppModuleDefault(),
                null
        );
    }

    @Override
    public String getBodyTitle() {
        return new TGS_FileHtmlText().setText(
                TGC_LibBootGUITitleUtils.bodyTitle_cloudlink_sub_user(
                        App.loginCard, App.route,
                        AppStrings.TITLE_AppModuleDefault(),
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
            var mdlNameGL = AppModuleWebGL.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlNameGL.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlNameGL).toUrl()
                    )
            ));
            var mdlName3JS = AppModuleThreeJS.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName3JS.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName3JS).toUrl()
                    )
            ));
            var mdlName4G_Full_false = AppModuleThree4G_TGC_LibGLPrgFull_false.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_Full_false.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_Full_false).toUrl()
                    )
            ));
            var mdlName4G_Full_true = AppModuleThree4G_TGC_LibGLPrgFull_true.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_Full_true.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_Full_true).toUrl()
                    )
            ));
            var mdlName4G_Logo = AppModuleThree4G_TGC_LibGLPrgLogo.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_Logo.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_Logo).toUrl()
                    )
            ));
            var mdlName4G_Model = AppModuleThree4G_TGC_LibGLPrgModel.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_Model.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_Model).toUrl()
                    )
            ));
            var mdlName4G_PCommon = AppModuleThree4G_TGC_LibGLPrgPrimativeCommon.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_PCommon.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_PCommon).toUrl()
                    )
            ));
            var mdlName4G_PFunc = AppModuleThree4G_TGC_LibGLPrgPrimativeFunctional.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_PFunc.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_PFunc).toUrl()
                    )
            ));
            var mdlName4G_PShape = AppModuleThree4G_TGC_LibGLPrgPrimativeShape.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_PShape.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_PShape).toUrl()
                    )
            ));
            var mdlName4G_PText = AppModuleThree4G_TGC_LibGLPrgPrimativeText.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_PText.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_PText).toUrl()
                    )
            ));
            var mdlName4G_PTube = AppModuleThree4G_TGC_LibGLPrgPrimativeTube.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_PTube.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_PTube).toUrl()
                    )
            ));
            var mdlName4G_Sprite = AppModuleThree4G_TGC_LibGLPrgSprite.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_Sprite.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_Sprite).toUrl()
                    )
            ));
            var mdlName4G_Sprite2 = AppModuleThree4G_TGC_LibGLPrgSprite2.class.getSimpleName();
            cards.add(new TGC_Card(
                    TGS_LibResourceUtils.png(showcase.app), null, mdlName4G_Sprite2.replace("AppModule", ""),
                    () -> TGC_BrowserWindowUtils.openNew(
                            App.route.setMdl(mdlName4G_Sprite2).toUrl()
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
