package com.tugalsan.java.app.showcase3d;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.user.client.ui.*;
import com.shc.webgl4j.client.TimeUtil;
import com.shc.webgl4j.client.WebGL10;
import com.tugalsan.java.core.file.html.client.*;
import com.tugalsan.java.core.function.client.maythrowexceptions.unchecked.TGS_FuncMTU;
import com.tugalsan.java.core.gui.gl.client.webgl.TGC_GLWeb;
import com.tugalsan.java.core.gui.gl.client.webgl.TGC_GLWebRender;
import com.tugalsan.java.core.log.client.TGC_Log;
import com.tugalsan.java.core.gui.client.dom.TGC_DOMUtils;
import com.tugalsan.java.core.gui.gl.client.three4g.TGC_GLProgramAbstract;
import com.tugalsan.java.core.shape.client.TGS_ShapeRectangle;
import com.tugalsan.java.lib.boot.client.*;
import com.tugalsan.java.lib.resource.client.TGS_LibResourceUtils;

public class AppModuleWebGL extends TGC_LibBootModulePanel {

    final private static TGC_Log d = TGC_Log.of(AppModuleWebGL.class);

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
                        AppStrings.TITLE_AppModuleDefault(),
                        d.className(),
                        null
                )
        ).setBold(true).toString();
    }

    @Override
    public void run() {
        loadParams();
        initControllers(() -> {
            createWidgets();
            createPops();
            configInit();
            configActions();
            configFocus();
            configLayout();
        });
    }

    @Override
    public void loadParams() {
    }

    public void initControllers(TGS_FuncMTU exe) {
        if (!TGC_GLProgramAbstract.isWEBGL1Supported()) {
            d.ce("iniControllers", "WEBGL_1_NOT_SUPPORTED!");
            return;
        }
        gl = new TGC_GLWeb(10);
        var urlImage = TGS_LibResourceUtils.threejs.res.examples.textures.crate_gif().toString();
        var imageId = gl.createImageId(urlImage);

        var quality = 75;
        var width = 640 / 2;
        var height = 480 / 2;
        var heightOffset = 50;
        var xLeft = 2;
        var xMid = xLeft * 2 + width;
        var xRight = xLeft * 3 + width * 2;

        gl.createCanvasId(xLeft, heightOffset, width, height, quality, new TGC_GLWebRender() {
            @Override
            public void init() {
                initStandard();

                {
                    initTestTriangle(null);
                } //OR
                {
//                    programID = glCreateProgram();
//                    glLinkProgram(programID);
//                    glUseProgram(programID);
                }
            }
            int angle = 0;

            @Override
            public void render(double ms_cur
            ) {
                WebGL10.glClear(WebGL10.GL_COLOR_BUFFER_BIT | WebGL10.GL_DEPTH_BUFFER_BIT);

                angle++;
                var z = -4L + (float) Math.sin(TimeUtil.currentSeconds());
                camera.setPerspective(canvas);
                camera.projView.translate(0, 0, z)
                        .rotateX((float) Math.toRadians(angle))
                        .rotateY((float) Math.toRadians(angle))
                        .rotateZ((float) Math.toRadians(angle));
                camera.pushProjectView(programID);

                WebGL10.glDrawArrays(WebGL10.GL_TRIANGLES, 0, 3);
            }
        }
        );

        var wbGlInfo10 = gl.supportUtils.createInformationWidget(false);
        var wbGlInfo20 = gl.supportUtils.createInformationWidget(true);

        TGC_DOMUtils.addAbsolute(wbGlInfo10,
                TGS_ShapeRectangle.of(xMid, heightOffset, width, height));
        TGC_DOMUtils.addAbsolute(wbGlInfo20,
                TGS_ShapeRectangle.of(xRight, heightOffset, width, height));

        gl.initAll();

        AnimationScheduler.get()
                .requestAnimationFrame(AppModuleWebGL.this::animationCallback);
        exe.run();
    }
    public TGC_GLWeb gl;

    private void animationCallback(double ms_sys) {
        if (ms_init == 0) {
            ms_init = ms_sys;
        }
        ms_cur = ms_sys - ms_init;

        gl.renderAll(ms_cur, true);
        AnimationScheduler.get().requestAnimationFrame(AppModuleWebGL.this::animationCallback);
    }
    private double ms_init = 0;
    private double ms_cur = 0;

    @Override
    public void createWidgets() {
    }

    @Override
    public void createPops() {
    }

    @Override
    public void configInit() {
    }

    @Override
    public void configActions() {
    }

    @Override
    public void configFocus() {
    }

    @Override
    public void configLayout() {
        widget = new HTML("");
    }
    private Widget widget;

    @Override
    public Widget getWidget() {
        return widget;
    }
}
