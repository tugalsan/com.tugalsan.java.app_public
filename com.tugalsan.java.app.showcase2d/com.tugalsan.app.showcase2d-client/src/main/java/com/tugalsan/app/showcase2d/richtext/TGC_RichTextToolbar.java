package com.tugalsan.java.app.showcase2d.richtext;

import com.google.gwt.core.client.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.resources.client.*;
import com.google.gwt.user.client.*;
import com.google.gwt.user.client.ui.*;

public class TGC_RichTextToolbar extends Composite {

    private static RichTextArea.FontSize[] fontSizesConstants() {
        return new RichTextArea.FontSize[]{
            RichTextArea.FontSize.XX_SMALL, RichTextArea.FontSize.X_SMALL,
            RichTextArea.FontSize.SMALL, RichTextArea.FontSize.MEDIUM,
            RichTextArea.FontSize.LARGE, RichTextArea.FontSize.X_LARGE,
            RichTextArea.FontSize.XX_LARGE
        };
    }

    /**
     * This {@link ClientBundle} is used for all the button icons. Using a
     * bundle allows all of these images to be packed into a single image, which
     * saves a lot of HTTP requests, drastically improving startup time.
     */
    public interface Images extends ClientBundle {

        ImageResource bold();

        ImageResource createLink();

        ImageResource hr();

        ImageResource indent();

        ImageResource insertImage();

        ImageResource italic();

        ImageResource justifyCenter();

        ImageResource justifyLeft();

        ImageResource justifyRight();

        ImageResource ol();

        ImageResource outdent();

        ImageResource removeFormat();

        ImageResource removeLink();

        ImageResource strikeThrough();

        ImageResource subscript();

        ImageResource superscript();

        ImageResource ul();

        ImageResource underline();
    }

    public interface Strings extends Constants {

        String black();

        String blue();

        String bold();

        String color();

        String createLink();

        String font();

        String green();

        String hr();

        String indent();

        String insertImage();

        String italic();

        String justifyCenter();

        String justifyLeft();

        String justifyRight();

        String large();

        String medium();

        String normal();

        String ol();

        String outdent();

        String red();

        String removeFormat();

        String removeLink();

        String size();

        String small();

        String strikeThrough();

        String subscript();

        String superscript();

        String ul();

        String underline();

        String white();

        String xlarge();

        String xsmall();

        String xxlarge();

        String xxsmall();

        String yellow();
    }

    private class EventHandler implements ClickHandler, ChangeHandler, KeyUpHandler {

        @Override
        public void onChange(ChangeEvent event) {
            var eventSource = (Widget) event.getSource();
            if (eventSource == cw_backColors) {
                richTextAreaFormatter.setBackColor(cw_backColors.getValue(cw_backColors.getSelectedIndex()));
                cw_backColors.setSelectedIndex(0);
            } else if (eventSource == cw_foreColors) {
                richTextAreaFormatter.setForeColor(cw_foreColors.getValue(cw_foreColors.getSelectedIndex()));
                cw_foreColors.setSelectedIndex(0);
            } else if (eventSource == cw_fonts) {
                richTextAreaFormatter.setFontName(cw_fonts.getValue(cw_fonts.getSelectedIndex()));
                cw_fonts.setSelectedIndex(0);
            } else if (eventSource == cw_fontSizes) {
                richTextAreaFormatter.setFontSize(fontSizesConstants()[cw_fontSizes.getSelectedIndex() - 1]);
                cw_fontSizes.setSelectedIndex(0);
            }
        }

        @Override
        public void onClick(ClickEvent event) {
            var eventSource = (Widget) event.getSource();
            if (eventSource == cw_bold) {
                richTextAreaFormatter.toggleBold();
            } else if (eventSource == cw_italic) {
                richTextAreaFormatter.toggleItalic();
            } else if (eventSource == cw_underline) {
                richTextAreaFormatter.toggleUnderline();
            } else if (eventSource == cw_subscript) {
                richTextAreaFormatter.toggleSubscript();
            } else if (eventSource == cw_superscript) {
                richTextAreaFormatter.toggleSuperscript();
            } else if (eventSource == cw_strikethrough) {
                richTextAreaFormatter.toggleStrikethrough();
            } else if (eventSource == cw_indent) {
                richTextAreaFormatter.rightIndent();
            } else if (eventSource == cw_outdent) {
                richTextAreaFormatter.leftIndent();
            } else if (eventSource == cw_justifyLeft) {
                richTextAreaFormatter.setJustification(RichTextArea.Justification.LEFT);
            } else if (eventSource == cw_justifyCenter) {
                richTextAreaFormatter.setJustification(RichTextArea.Justification.CENTER);
            } else if (eventSource == cw_justifyRight) {
                richTextAreaFormatter.setJustification(RichTextArea.Justification.RIGHT);
            } else if (eventSource == cw_insertImage) {
                var url = Window.prompt("Enter an image URL:", "http://");
                if (url != null) {
                    richTextAreaFormatter.insertImage(url);
                }
            } else if (eventSource == cw_createLink) {
                var url = Window.prompt("Enter a link URL:", "http://");
                if (url != null) {
                    richTextAreaFormatter.createLink(url);
                }
            } else if (eventSource == cw_removeLink) {
                richTextAreaFormatter.removeLink();
            } else if (eventSource == cw_hr) {
                richTextAreaFormatter.insertHorizontalRule();
            } else if (eventSource == cw_ol) {
                richTextAreaFormatter.insertOrderedList();
            } else if (eventSource == cw_ul) {
                richTextAreaFormatter.insertUnorderedList();
            } else if (eventSource == cw_removeFormat) {
                richTextAreaFormatter.removeFormat();
            } else if (eventSource == richTextArea) {
                // We use the RichTextArea's onKeyUp event to update the toolbar status.
                // This will catch any cases where the user moves the cursur using the
                // keyboard, or uses one of the browser's built-in keyboard shortcuts.
                update_cw();
            }
        }

        @Override
        public void onKeyUp(KeyUpEvent event) {
            var eventSource = (Widget) event.getSource();
            if (eventSource == richTextArea) {
                // We use the RichTextArea's onKeyUp event to update the toolbar status.
                // This will catch any cases where the user moves the cursur using the
                // keyboard, or uses one of the browser's built-in keyboard shortcuts.
                update_cw();
            }
        }
    }
    private Images images = (Images) GWT.create(Images.class);
    private Strings strings = (Strings) GWT.create(Strings.class);
    private EventHandler eventHandler = new EventHandler();
    final public RichTextArea richTextArea;
    private RichTextArea.Formatter richTextAreaFormatter;
    private VerticalPanel outer = new VerticalPanel();
    private HorizontalPanel topPanel = new HorizontalPanel();
    private HorizontalPanel bottomPanel = new HorizontalPanel();
    private ToggleButton cw_bold;
    private ToggleButton cw_italic;
    private ToggleButton cw_underline;
    private ToggleButton cw_subscript;
    private ToggleButton cw_superscript;
    private ToggleButton cw_strikethrough;
    private PushButton cw_indent;
    private PushButton cw_outdent;
    private PushButton cw_justifyLeft;
    private PushButton cw_justifyCenter;
    private PushButton cw_justifyRight;
    private PushButton cw_hr;
    private PushButton cw_ol;
    private PushButton cw_ul;
    private PushButton cw_insertImage;
    private PushButton cw_createLink;
    private PushButton cw_removeLink;
    private PushButton cw_removeFormat;
    private ListBox cw_backColors;
    private ListBox cw_foreColors;
    private ListBox cw_fonts;
    private ListBox cw_fontSizes;

    public TGC_RichTextToolbar() {
        this(new RichTextArea());
    }
    
    public TGC_RichTextToolbar(RichTextArea richText) {
        this.richTextArea = richText;
        this.richTextAreaFormatter = richText.getFormatter();
        if (richTextAreaFormatter == null) {
            return;
        }
        outer.add(topPanel);
        outer.add(bottomPanel);
        topPanel.setWidth("100%");
        bottomPanel.setWidth("100%");
        initWidget(outer);
        setStyleName("gwt-RichTextToolbar");
        cw_bold = createToggleButton(images.bold(), strings.bold());
        cw_italic = createToggleButton(images.italic(), strings.italic());
        cw_underline = createToggleButton(images.underline(), strings.underline());
        cw_subscript = createToggleButton(images.subscript(), strings.subscript());
        cw_superscript = createToggleButton(images.superscript(), strings.superscript());
        cw_justifyLeft = createPushButton(images.justifyLeft(), strings.justifyLeft());
        cw_justifyCenter = createPushButton(images.justifyCenter(), strings.justifyCenter());
        cw_justifyRight = createPushButton(images.justifyRight(), strings.justifyRight());
        cw_strikethrough = createToggleButton(images.strikeThrough(), strings.strikeThrough());
        cw_indent = createPushButton(images.indent(), strings.indent());
        cw_outdent = createPushButton(images.outdent(), strings.outdent());
        cw_hr = createPushButton(images.hr(), strings.hr());
        cw_ol = createPushButton(images.ol(), strings.ol());
        cw_ul = createPushButton(images.ul(), strings.ul());
        cw_insertImage = createPushButton(images.insertImage(), strings.insertImage());
        cw_createLink = createPushButton(images.createLink(), strings.createLink());
        cw_removeLink = createPushButton(images.removeLink(), strings.removeLink());
        cw_removeFormat = createPushButton(images.removeFormat(), strings.removeFormat());
        cw_backColors = createColorList("Background");
        cw_foreColors = createColorList("Foreground");
        cw_fonts = createFontList();
        cw_fontSizes = createFontSizes();
        topPanel.add(cw_bold);
        topPanel.add(cw_italic);
        topPanel.add(cw_underline);
        topPanel.add(cw_subscript);
        topPanel.add(cw_superscript);
        topPanel.add(cw_justifyLeft);
        topPanel.add(cw_justifyCenter);
        topPanel.add(cw_justifyRight);
        topPanel.add(cw_strikethrough);
        topPanel.add(cw_indent);
        topPanel.add(cw_outdent);
        topPanel.add(cw_hr);
        topPanel.add(cw_ol);
        topPanel.add(cw_ul);
        topPanel.add(cw_insertImage);
        topPanel.add(cw_createLink);
        topPanel.add(cw_removeLink);
        topPanel.add(cw_removeFormat);
        bottomPanel.add(cw_backColors);
        bottomPanel.add(cw_foreColors);
        bottomPanel.add(cw_fonts);
        bottomPanel.add(cw_fontSizes);
        richText.addKeyUpHandler(eventHandler);
        richText.addClickHandler(eventHandler);
    }

    private ListBox createColorList(String caption) {
        var lb = new ListBox();
        lb.addChangeHandler(eventHandler);
        lb.setVisibleItemCount(1);
        lb.addItem(caption);
        lb.addItem(strings.white(), "white");
        lb.addItem(strings.black(), "black");
        lb.addItem(strings.red(), "red");
        lb.addItem(strings.green(), "green");
        lb.addItem(strings.yellow(), "yellow");
        lb.addItem(strings.blue(), "blue");
        return lb;
    }

    private ListBox createFontList() {
        var lb = new ListBox();
        lb.addChangeHandler(eventHandler);
        lb.setVisibleItemCount(1);
        lb.addItem(strings.font(), "");
        lb.addItem(strings.normal(), "");
        lb.addItem("Times New Roman", "Times New Roman");
        lb.addItem("Arial", "Arial");
        lb.addItem("Courier New", "Courier New");
        lb.addItem("Georgia", "Georgia");
        lb.addItem("Trebuchet", "Trebuchet");
        lb.addItem("Verdana", "Verdana");
        return lb;
    }

    private ListBox createFontSizes() {
        var lb = new ListBox();
        lb.addChangeHandler(eventHandler);
        lb.setVisibleItemCount(1);
        lb.addItem(strings.size());
        lb.addItem(strings.xxsmall());
        lb.addItem(strings.xsmall());
        lb.addItem(strings.small());
        lb.addItem(strings.medium());
        lb.addItem(strings.large());
        lb.addItem(strings.xlarge());
        lb.addItem(strings.xxlarge());
        return lb;
    }

    private PushButton createPushButton(ImageResource img, String tip) {
        var pb = new PushButton(new Image(img));
        pb.addClickHandler(eventHandler);
        pb.setTitle(tip);
        return pb;
    }

    private ToggleButton createToggleButton(ImageResource img, String tip) {
        var tb = new ToggleButton(new Image(img));
        tb.addClickHandler(eventHandler);
        tb.setTitle(tip);
        return tb;
    }

    private void update_cw() {
        if (richTextAreaFormatter != null) {
            cw_bold.setDown(richTextAreaFormatter.isBold());
            cw_italic.setDown(richTextAreaFormatter.isItalic());
            cw_underline.setDown(richTextAreaFormatter.isUnderlined());
            cw_subscript.setDown(richTextAreaFormatter.isSubscript());
            cw_superscript.setDown(richTextAreaFormatter.isSuperscript());
        }
        if (richTextAreaFormatter != null) {
            cw_strikethrough.setDown(richTextAreaFormatter.isStrikethrough());
        }
    }
}
