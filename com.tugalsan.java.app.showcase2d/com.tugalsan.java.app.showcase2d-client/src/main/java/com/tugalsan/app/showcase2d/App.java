package com.tugalsan.java.app.showcase2d;

import com.tugalsan.java.app.showcase2d.canvas.*;
import com.tugalsan.java.app.showcase2d.widget.*;
import com.tugalsan.java.app.showcase2d.richtext.*;
import com.tugalsan.java.app.showcase2d.scroll.*;
import com.tugalsan.java.app.showcase2d.menu.*;
import com.tugalsan.java.app.showcase2d.upload.*;
import com.tugalsan.java.app.showcase2d.layout.*;
import com.google.gwt.core.client.*;
import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.gui.client.browser.*;
import com.tugalsan.java.core.gui.client.click.*;
import com.tugalsan.java.core.gui.client.widget.*;
import com.tugalsan.java.core.icon.client.*;
import com.tugalsan.java.core.log.client.*;
import com.tugalsan.java.core.time.client.*;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.domain.client.*;
import com.tugalsan.java.lib.login.client.*;
import com.tugalsan.java.lib.route.client.*;
import com.tugalsan.java.lib.scale.client.*;

// *!* Dont change my hardcoded classpath com.tugalsan.java.app.showcase2d.App *!*
public class App implements EntryPoint {

    final private static TGC_Log d = TGC_Log.of(App.class);
    public static final TGS_LibRoute route = TGC_LibRouteUtils.of();
    public static TGS_Time warVersion;
    public static TGS_LibDomainCard domainCard;
    public static TGS_LibLoginCard loginCard;

    public void onModuleLoad() {
        TGC_LibBootUtils.onModuleLoad(route, (warVersion, domainCard, runAcc2Url) -> {
            TGC_LibLoginCardUtils.async(loginCard -> {
                if (!loginCard.userAdmin) {
                    var err = new TGS_FileHtmlText().setBold(true).setHexcolor("FF0000")
                            .setText("HATA: Kullanıcı admin değil:<br>- Geri dönmek için basınız.");
                    var btn = TGC_ButtonUtils.createIcon(TGS_IconUtils.CLASS_BUG(), err.toString());
                    TGC_ClickUtils.add(btn, () -> TGC_BrowserWindowUtils.openSame(
                            route.setRouteApp(TGS_LibScaleMemUtils.cloud()).delMdl().toUrl())
                    );
                    TGC_LibBootGUIBody.setToCenter(btn);
                    d.ce("onModuleLoad", "loginCard", err);
                    return;
                }
                App.warVersion = warVersion;
                App.domainCard = domainCard;
                App.loginCard = loginCard;
                runAcc2Url.run();
            });
        },
                new AppModuleDefault(),
                new AppModulePaint(),
                new AppModuleCrop(),
                new AppModuleRichTextArea(),
                new AppModuleDock(),
                new AppModuleFlex(),
                new AppModuleFlow1(),
                new AppModuleFlow2(),
                new AppModuleGrid(),
                new AppModuleHTML(),
                new AppModuleLayout(),
                new AppModuleMenu(),
                new AppModuleScroll(),
                new AppModuleSplit(),
                new AppModuleStack(),
                new AppModuleTab(),
                new AppModuleUpload(),
                new AppModuleWidget()
        );
    }
}
