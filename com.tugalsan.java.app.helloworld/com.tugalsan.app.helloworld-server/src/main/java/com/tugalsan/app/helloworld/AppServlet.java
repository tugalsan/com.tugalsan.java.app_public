package com.tugalsan.java.app.helloworld;

import com.tugalsan.java.api.file.common.client.TGS_FileCommonFavIcon;
import com.tugalsan.java.api.log.server.TS_Log;
import com.tugalsan.java.api.servlet.gwt.webapp.server.*;
import com.tugalsan.java.lib.boot.server.TS_LibBootUtils;
import java.time.Duration;
import module javax.servlet.api;

@WebListener
public class AppServlet implements ServletContextListener {

    final private static TS_Log d = TS_Log.of(AppServlet.class);
    final public static TGS_FileCommonFavIcon favIconSpi = TGS_FileCommonFavIcon.ofTxt("🛢️", null, false);
    final public static TGS_FileCommonFavIcon favIconBug = TGS_FileCommonFavIcon.ofTxt("🐛", null, false);
    public static String APP_NAME;

    @Override
    public void contextInitialized(ServletContextEvent evt) {
        APP_NAME = TS_LibBootUtils.warmUp_setLogPrefix_createKillTriggers_returnAppName_forApp(evt);
        TS_LibBootUtils.contextInitializedAsyncRun(
                Duration.ofMinutes(10),
                evt, "autosqlweb", "ASW", favIconSpi, favIconBug,
                killTrigger -> {
                    TS_SGWTExecutorList.add(new AppSGEEcho()
                    );
                }
        );
    }

    @Override
    public void contextDestroyed(ServletContextEvent evt) {
        TS_LibBootUtils.contextDestroyed(evt);
    }
}
