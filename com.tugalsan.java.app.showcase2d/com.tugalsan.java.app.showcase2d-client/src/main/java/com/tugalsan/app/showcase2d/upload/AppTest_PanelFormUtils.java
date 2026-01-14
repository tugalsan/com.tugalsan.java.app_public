package com.tugalsan.java.app.showcase2d.upload;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.*;
import com.tugalsan.java.core.log.client.*;

import com.tugalsan.java.core.url.client.TGC_UrlCurrentUtils;

public class AppTest_PanelFormUtils {

    private AppTest_PanelFormUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelFormUtils.class);

    /*
    ex redirect: "/formHandler"
     */
    public static FormPanel create(String servletName, boolean multipPart, boolean post, Panel child) {
        var pf = new FormPanel();
        var url = TGC_UrlCurrentUtils.getUrl();
//        var urlApp = TGC_UrlUtils.getUrlAppFolder(url);
//        pf.setAction(TGS_SURLUtils.url(urlApp, servletName));
        pf.setEncoding(multipPart ? FormPanel.ENCODING_MULTIPART : FormPanel.ENCODING_URLENCODED);
        pf.setMethod(post ? FormPanel.METHOD_POST : FormPanel.METHOD_GET);
        pf.setWidget(child);
        return pf;
    }

    public static void submit(FormPanel pf, TGS_FuncMTU_In1<String> results) {
        pf.addSubmitCompleteHandler(e -> results.run(e.getResults()));
        pf.submit();
    }
}
