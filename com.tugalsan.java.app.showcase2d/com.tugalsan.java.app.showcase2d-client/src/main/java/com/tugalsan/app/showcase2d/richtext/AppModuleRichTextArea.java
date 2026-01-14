package com.tugalsan.java.app.showcase2d.richtext;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.core.thread.client.*;
import com.tugalsan.java.app.showcase2d.*;
import com.tugalsan.java.lib.boot.client.*;

public class AppModuleRichTextArea extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleRichTextArea.class);

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
        loadParams();
        createWidgets();
        createPops();
        configInit();
        configActions();
        configFocus();
        configLayout();
    }

    @Override
    public void loadParams() {
    }

    @Override
    public void createWidgets() {
        {//EDITOR
            taInputToolbar = new TGC_RichTextToolbar();
            rtaInput = taInputToolbar.richTextArea;
            lblOutputText = new Label("Output Text:");
            taOutputText = new TextArea();
            lblOutputHtml = new Label("Output Html:");
            taOutputHtml = new TextArea();
        }
        {//TREE
            lblTreeSample = new Label("Tree Example:");
            var lbl1 = new Label("lbl1");
            var lbl2 = new Label("lbl2");
            var lbl3 = new Label("lbl3");
            var lbl4 = new Label("lbl4");
            lbl1.addClickHandler(e -> d.ce("lbl1"));
            treeSample = new Tree();
            var master = new TreeItem(lbl1);
            treeSample.addItem(master);
            master.addItem(new TreeItem(lbl2));
            master.addItem(new TreeItem(lbl3));
            master.addItem(new TreeItem(lbl4));
        }
    }
    RichTextArea rtaInput;
    TGC_RichTextToolbar taInputToolbar;
    Label lblOutputText, lblOutputHtml, lblTreeSample;
    TextArea taOutputText, taOutputHtml;
    Tree treeSample;

    @Override
    public void createPops() {
    }

    @Override
    public void configInit() {
    }

    @Override
    public void configActions() {
        TGC_ThreadUtils.run_everySeconds_afterGUIUpdate(t -> {
            taOutputText.setText(rtaInput.getText());
            taOutputHtml.setText(rtaInput.getHTML());
        }, 2);
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
        //STYLE
        taInputToolbar.setWidth("100%");
        rtaInput.setWidth("100%");
        lblOutputText.setWidth("100%");
        taOutputText.setWidth("100%");
        lblOutputHtml.setWidth("100%");
        taOutputHtml.setWidth("100%");
        lblTreeSample.setWidth("100%");
        treeSample.setWidth("100%");
        //DOM
        widget = new VerticalPanel();
        widget.add(taInputToolbar);
        widget.add(rtaInput);
        widget.add(lblOutputText);
        widget.add(taOutputText);
        widget.add(lblOutputHtml);
        widget.add(taOutputHtml);
        widget.add(lblTreeSample);
        widget.add(treeSample);
    }
    private VerticalPanel widget;

    @Override
    public Widget getWidget() {
        return widget;
    }

}
