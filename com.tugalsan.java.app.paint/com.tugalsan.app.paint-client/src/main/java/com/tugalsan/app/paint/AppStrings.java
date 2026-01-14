package com.tugalsan.java.app.paint;

import com.tugalsan.java.api.charset.client.TGS_CharSetCast;
import com.tugalsan.java.api.charset.client.TGS_CharSetLocaleTypes;

public class AppStrings {

    private AppStrings() {

    }

    public static String TITLE_AppModuleDefault() {
        return TGS_CharSetCast.current().localType.equals(TGS_CharSetLocaleTypes.TURKISH) ? "Resim" : "Paint";
    }

    public static String TITLE_AppModuleEcho() {
        return TGS_CharSetCast.current().localType.equals(TGS_CharSetLocaleTypes.TURKISH) ? "Tuval" : "Canvas";
    }
}
