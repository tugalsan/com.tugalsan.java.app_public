package com.tugalsan.java.app.paint;

import com.tugalsan.java.api.log.server.*;
import com.tugalsan.java.api.tuple.client.*;
import com.tugalsan.java.api.servlet.gwt.webapp.client.*;
import com.tugalsan.java.api.servlet.gwt.webapp.server.*;
import com.tugalsan.java.api.thread.server.sync.TS_ThreadSyncTrigger;
import com.tugalsan.java.app.paint.sg.AppSGFEcho;
import com.tugalsan.java.lib.login.server.*;
import javax.servlet.http.*;

public class AppSGEEcho extends TS_SGWTExecutor {

    final private static TS_Log d = TS_Log.of(AppSGEEcho.class);

    @Override
    public TS_SGWTValidationResult validate(TS_ThreadSyncTrigger servletKillTrigger, HttpServletRequest rq, TGS_SGWTFuncBase funcBase) {
        var f = (AppSGFEcho) funcBase;
        var u_loginCard = TS_LibLoginCardUtils.get(servletKillTrigger, rq, f);
        if (u_loginCard.isExcuse()) {
            var msg = "loginCard==" + u_loginCard.excuse().getMessage() + ":" + funcBase.getInput_url();
            f.setExceptionMessage(msg);
            d.ce("validate", msg);
            return new TS_SGWTValidationResult(false, null);
        }
        var loginCard = u_loginCard.value();
        if (!loginCard.userAdmin) {
            var msg = "!loginCard.userAdmin:" + funcBase.getInput_url();
            f.setExceptionMessage(msg);
            d.ce("validate", msg);
            return new TS_SGWTValidationResult(false, loginCard);
        }
        return new TS_SGWTValidationResult(true, loginCard);
    }

    @Override
    public String name() {
        return AppSGFEcho.class.getSimpleName();
    }

    @Override
    public void run(TS_ThreadSyncTrigger servletKillTrigger, HttpServletRequest rq, TGS_SGWTFuncBase funcBase, Object vldRtn) {
//        var loginCard = (TGS_LibLoginCard) vldRtn;
        var f = (AppSGFEcho) funcBase;
        f.setOutput_msg(f.getInput_msg());
    }
}
