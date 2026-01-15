package com.tugalsan.java.app.showcase3d;

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

// *!* Dont change my hardcoded classpath com.tugalsan.java.app.showcase3d.App *!*
public class App implements EntryPoint {

    final private static TGC_Log d = TGC_Log.of(App.class);
    public static final TGS_LibRoute route = TGC_LibRouteUtils.of();
    public static TGS_Time warVersion;
    public static TGS_LibDomainCard domainCard;
    public static TGS_LibLoginCard loginCard;

    public void onModuleLoad() {
        Thread.currentThread().interrupt();
        
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
                new AppModuleWebGL(),
                new AppModuleThreeJS(),
                new AppModuleThree4G_TGC_LibGLPrgFull_false(),
                new AppModuleThree4G_TGC_LibGLPrgFull_true(),
                new AppModuleThree4G_TGC_LibGLPrgLogo(),
                new AppModuleThree4G_TGC_LibGLPrgModel(),
                new AppModuleThree4G_TGC_LibGLPrgPrimativeCommon(),
                new AppModuleThree4G_TGC_LibGLPrgPrimativeFunctional(),
                new AppModuleThree4G_TGC_LibGLPrgPrimativeShape(),
                new AppModuleThree4G_TGC_LibGLPrgPrimativeText(),
                new AppModuleThree4G_TGC_LibGLPrgPrimativeTube(),
                new AppModuleThree4G_TGC_LibGLPrgSprite(),
                new AppModuleThree4G_TGC_LibGLPrgSprite2()
        );
    }
}
