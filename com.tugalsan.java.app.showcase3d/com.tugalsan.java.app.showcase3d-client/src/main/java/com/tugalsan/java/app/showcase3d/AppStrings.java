package com.tugalsan.java.app.showcase3d;

import com.tugalsan.java.core.charset.client.TGS_CharSet;
import com.tugalsan.java.core.charset.client.TGS_CharSetCast;
import com.tugalsan.java.core.charset.client.TGS_CharSetLocaleTypes;

public class AppStrings {

    public static String TITLE_AppModuleDefault() {
        return TGS_CharSetCast.current().localType.equals(TGS_CharSetLocaleTypes.TURKISH) ? "Vitrin3d" : "Showcase3d";
    }
}
