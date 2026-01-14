package com.tugalsan.java.app.showcase2d.upload;

import com.google.gwt.user.client.ui.*;
import com.tugalsan.java.api.function.client.maythrowexceptions.unchecked.*;
import com.tugalsan.java.api.log.client.*;
import com.tugalsan.java.app.showcase2d.layout.*;
import com.tugalsan.java.app.showcase2d.widget.*;

public class AppTest_PanelFileUploadUtils {

    private AppTest_PanelFileUploadUtils() {

    }

    final private static TGC_Log d = TGC_Log.of(AppTest_PanelFileUploadUtils.class);

    private static FileUpload createFileUpload(String formVariableName) {
        var w = new FileUpload();
        if (formVariableName != null) {
            w.setName(formVariableName);
        }
        return w;
    }

    public static FormPanel create(String labelText, String buttonText, TGS_FuncMTU_In1<String> exe_submit) {
        var wLabel = AppTest_WidgetUtils.createHTML(labelText);
        var wFileUpload = createFileUpload("TGS_ASWSHUtils.SE_Upload");
        var wButton = AppTest_WidgetUtils.createButton(buttonText);

        var pv = AppTest_PanelVerticalUtils.create();
        AppTest_PanelVerticalUtils.add(pv, wLabel);
        AppTest_PanelVerticalUtils.add(pv, wFileUpload);
        AppTest_PanelVerticalUtils.add(pv, wButton);

        var pf = AppTest_PanelFormUtils.create("TGS_ASWSHUtils.SE_Upload", true, true, pv);
        AppTest_WidgetUtils.addAction(wButton, () -> AppTest_PanelFormUtils.submit(pf, exe_submit));

        return pf;
    }
}
