package com.tugalsan.java.app.showcase2d.menu;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.file.html.client.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;

public class AppModuleMenu extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleMenu.class);

    @Override
    public String getBrowserTitle() {
        return TGC_LibBootGUITitleUtils.browserTitle_domain_txt_user(
                App.domainCard, App.loginCard, App.route,
                d.className(),
                null
        );
    }

    @Override
    public String getBodyTitle() {
        return new TGS_FileHtmlText().setText(
                TGC_LibBootGUITitleUtils.bodyTitle_cloud_app_sub_user(
                        App.loginCard, App.route,
                        AppStringsUtils.TITLE_AppModuleDefault(),
                        d.className(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        var menu = new MenuBar();
        menu.setAutoOpen(true);
        menu.setWidth("100px");
        menu.setAnimationEnabled(true);

        var fileMenu = new MenuBar(true);
        fileMenu.setAnimationEnabled(true);

        fileMenu.addItem("New", () -> d.cr("New"));
        fileMenu.addItem("Open", () -> d.cr("Open"));

        fileMenu.addSeparator();
        fileMenu.addItem("Exit", () -> d.cr("Exit"));

        var editMenu = new MenuBar(true);
        editMenu.setAnimationEnabled(true);

        editMenu.addItem("Undo", () -> d.cr("Undo"));
        editMenu.addItem("Redo", () -> d.cr("redo"));
        editMenu.addItem("Cut", () -> d.cr("Cut"));
        editMenu.addItem("Copy", () -> d.cr("Copy"));
        editMenu.addItem("Paste", () -> d.cr("Paste"));

        menu.addItem(new MenuItem("File", fileMenu));
        menu.addSeparator();
        menu.addItem(new MenuItem("Edit", editMenu));

        widget = menu;
    }

    @Override
    public void loadParams() {
    }

    @Override
    public void createWidgets() {
    }

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
    }

    @Override
    public Widget getWidget() {
        return widget;
    }
    private Widget widget;
}
