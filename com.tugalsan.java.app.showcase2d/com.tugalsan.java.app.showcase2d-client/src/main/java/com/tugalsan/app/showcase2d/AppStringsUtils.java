package com.tugalsan.java.app.showcase2d;

import com.tugalsan.java.core.charset.client.*;

public class AppStringsUtils {

    private AppStringsUtils() {

    }

    public static String TITLE_AppModuleDefault() {
        return TGS_CharSetCast.current().localType.equals(TGS_CharSetLocaleTypes.TURKISH) ? "Vitrin2d" : "Showcase2d";
    }
}
