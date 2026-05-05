package com.yftech.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.provider.Settings.System;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View;

import ru.gs8club.goosebuddy.R;

public class SwitchMultiButtonOld extends View {
    public interface OnSwitchListener {
        void onSwitch(SwitchMultiButtonOld arg1, int arg2, String arg3, boolean arg4);
    }

    private static final int BG_COLOR = 0xFF4F535A;
    private static final int DISABLE_COLOR = 0xFFCCCCCC;
    private static final int ENABLE_COLOR = -1;
    private static final String FONTS_DIR = "fonts/";
    private static final int SELECTED_COLOR = 0xFF5F6574;
    private static final int SELECTED_TAB = -1;
    private static final int SELECTED_TEXT_COLOR = -1;
    private static final float STROKE_RADIUS = 0.0f;
    private static final String TAG = "SwitchMultiButtonNew";
    private static final float TEXT_SIZE = 14.0f;
    private static final int UNSELECTED_TEXT_COLOR = 0xB3FFFFFF;
    private boolean isFixWidth;
    private boolean isQuickClick;
    private long lastClickTime;
    private int mBgColor;
    private Drawable mBgResource;
    private int mDisableColor;
    private boolean mEnable;
    private Paint mFillPaint;
    private Paint.FontMetrics mFontMetrics;
    private int mHeight;
    private float mPaddingText;
    private NinePatch mSelectedBgNinePatch;
    private int mSelectedBgResource;
    private int mSelectedColor;
    private int mSelectedTab;
    private int mSelectedTextColor;
    private TextPaint mSelectedTextPaint;
    private Typeface mSelectedTypeface;
    private Paint mStrokePaint;
    private float mStrokeRadius;
    private int mTabNum;
    private String[] mTabTexts;
    private float mTextHeightOffset;
    private float mTextSize;
    private int mUnSelectedTextColor;
    private Typeface mUnSelectedTypeface;
    private TextPaint mUnselectedTextPaint;
    private int mWidth;
    private float maxTabWidth;
    private OnSwitchListener onSwitchListener;
    private boolean playSoundEffect;
    private int quickClickTime;
    private Bitmap selectedBgBitmap;

    public SwitchMultiButtonOld(Context context0) {
        this(context0, null);
    }

    public SwitchMultiButtonOld(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mTabTexts = new String[]{"L", "R"};
        this.mTabNum = this.mTabTexts.length;
        this.mEnable = true;
        this.playSoundEffect = true;
        this.quickClickTime = 0;
        this.lastClickTime = 0L;
        this.isQuickClick = false;
        this.initAttrs(context0, attributeSet0);
        this.initPaint();
    }

    private void checkAttrs() {
        if((this.mStrokeRadius > ((float)this.mHeight) * 0.5f)) {
            this.mStrokeRadius = ((float)this.mHeight) * 0.5f;
        }
    }

    public void clearSelection() {
        this.mSelectedTab = -1;
        this.invalidate();
    }

    private int getDefaultHeight() {
        return ((int)(this.mFontMetrics.bottom - this.mFontMetrics.top)) + this.getPaddingTop() + this.getPaddingBottom();
    }

    private int getDefaultWidth() {
        float f = 0.0f;
        for(int v = 0; v < this.mTabTexts.length; ++v) {
            f += this.mSelectedTextPaint.measureText(this.mTabTexts[v]);
        }
        float f1 = f + this.mPaddingText * ((float)this.mTabTexts.length) * 2.0f;
        if((f1 > this.maxTabWidth)) {
            this.isFixWidth = true;
            return (int)this.maxTabWidth;
        }
        this.isFixWidth = false;
        return (int)f1;
    }

    private int getExpectSize(int v, int v1) {
        int v2 = View.MeasureSpec.getMode(v1);
        int v3 = View.MeasureSpec.getSize(v1);
        switch(v2) {
            case MeasureSpec.AT_MOST: {
                return Math.min(v, v3);
            }
            case MeasureSpec.EXACTLY: {
                return v3;
            }
            default: {
                return v;
            }
        }
    }

    public int getSelectedTab() {
        return this.mSelectedTab;
    }

    public int getTabNum() {
        return this.mTabNum;
    }

    private String getTabText(int v) {
        return v < 0 || v >= this.mTabTexts.length ? "" : this.mTabTexts[v];
    }

    private void initAttrs(Context context0, AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.SwitchMultiButtonOld);
            this.mStrokeRadius = typedArray0.getDimension(R.styleable.SwitchMultiButtonOld_strokeRadius, 0.0f);
            this.mTextSize = typedArray0.getDimension(R.styleable.SwitchMultiButtonOld_textSize, this.getResources().getDimension(R.dimen.multi_button_text_size));  // dimen:multi_button_text_size
            this.mSelectedColor = typedArray0.getColor(R.styleable.SwitchMultiButtonOld_selectedColor, 0xFF5F6574);
            this.mBgColor = typedArray0.getColor(R.styleable.SwitchMultiButtonOld_backgroundColor, 0xFF4F535A);
            this.mSelectedTextColor = typedArray0.getColor(R.styleable.SwitchMultiButtonOld_selectedTextColor, -1);
            this.mUnSelectedTextColor = typedArray0.getColor(R.styleable.SwitchMultiButtonOld_unselectedTextColor, 0xB3FFFFFF);
            this.mDisableColor = typedArray0.getColor(R.styleable.SwitchMultiButtonOld_disableColor, 0xFFCCCCCC);
            this.mSelectedTab = typedArray0.getInteger(R.styleable.SwitchMultiButtonOld_selectedTab, -1);
            this.mBgResource = typedArray0.getDrawable(R.styleable.SwitchMultiButtonOld_background);
            this.mPaddingText = typedArray0.getDimension(R.styleable.SwitchMultiButtonOld_paddingText, this.getResources().getDimension(R.dimen.multi_button_max_padding_text));  // dimen:multi_button_max_padding_text
            this.maxTabWidth = typedArray0.getDimension(R.styleable.SwitchMultiButtonOld_maxTabWidth, this.getResources().getDimension(R.dimen.multi_button_max_width));  // dimen:multi_button_max_width
            this.mSelectedBgResource = 0;//typedArray0.getResourceId(5, 0);
            int v = typedArray0.getResourceId(R.styleable.SwitchMultiButtonOld_switchTabs, 0);
            if(v != 0) {
                this.mTabTexts = this.getResources().getStringArray(v);
                this.mTabNum = this.mTabTexts.length;
            }
            String s = typedArray0.getString(R.styleable.SwitchMultiButtonOld_selectedTypeface);
            if(!TextUtils.isEmpty(s)) {
                this.mSelectedTypeface = Typeface.create(s, Typeface.NORMAL);
            }
            String s1 = typedArray0.getString(R.styleable.SwitchMultiButtonOld_unselectedTypeface);
            if(!TextUtils.isEmpty(s1)) {
                this.mUnSelectedTypeface = Typeface.create(s1, Typeface.NORMAL);
            }
            if(this.mSelectedBgResource != 0) {
                this.selectedBgBitmap = BitmapFactory.decodeResource(this.getResources(), this.mSelectedBgResource);
                this.mSelectedBgNinePatch = new NinePatch(this.selectedBgBitmap, this.selectedBgBitmap.getNinePatchChunk(), null);
            }
            typedArray0.recycle();
        }
    }

    private void initPaint() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setColor(this.mBgColor);
        this.mStrokePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mStrokePaint.setAntiAlias(true);
        this.mFillPaint = new Paint();
        this.mFillPaint.setColor(this.mSelectedColor);
        this.mFillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mFillPaint.setAntiAlias(true);
        this.mSelectedTextPaint = new TextPaint(1);
        this.mSelectedTextPaint.setTextSize(this.mTextSize);
        this.mSelectedTextPaint.setColor(this.mSelectedTextColor);
        if(this.mSelectedTypeface != null) {
            this.mSelectedTextPaint.setTypeface(this.mSelectedTypeface);
        }
        this.mSelectedTextPaint.setAntiAlias(true);
        this.mUnselectedTextPaint = new TextPaint(1);
        this.mUnselectedTextPaint.setTextSize(this.mTextSize);
        this.mUnselectedTextPaint.setColor(this.mUnSelectedTextColor);
        if(this.mUnSelectedTypeface != null) {
            this.mUnselectedTextPaint.setTypeface(this.mUnSelectedTypeface);
        }
        this.mUnselectedTextPaint.setAntiAlias(true);
        this.mTextHeightOffset = -(this.mSelectedTextPaint.ascent() + this.mSelectedTextPaint.descent()) * 0.5f;
        this.mFontMetrics = this.mSelectedTextPaint.getFontMetrics();
    }

    @Override  // android.view.View
    public boolean isEnabled() {
        return this.mEnable;
    }

    @Override  // android.view.View
    protected void onDraw(Canvas canvas0) {
        float f4;
        super.onDraw(canvas0);
        if(!this.mEnable) {
            this.mStrokePaint.setColor(this.mDisableColor);
            this.mFillPaint.setColor(this.mDisableColor);
            this.mSelectedTextPaint.setColor(-1);
            this.mUnselectedTextPaint.setColor(this.mDisableColor);
        }
        float f = (float)this.mWidth;
        float f1 = (float)this.mHeight;
        if(this.mBgResource == null) {
            canvas0.drawRoundRect(new RectF(0.0f, 0.0f, f, f1), this.mStrokeRadius, this.mStrokeRadius, this.mStrokePaint);
        }
        else {
            this.setBackground(this.mBgResource);
        }
        int v = (int)(((float)this.mWidth) / (((float)this.mTabNum) * 1.0f));
        int v1 = 0;
        float f2 = 0.0f;
        while(v1 < this.mTabNum) {
            String s = this.mTabTexts[v1];
            float f3 = this.mSelectedTextPaint.measureText(s) + f2 + this.mPaddingText * 2.0f;
            if(v1 == this.mSelectedTab) {
                if(this.isFixWidth) {
                    StaticLayout staticLayout0 = new StaticLayout(s, this.mSelectedTextPaint, v, Layout.Alignment.ALIGN_CENTER, 0.7f, 0.0f, true);
                    int v2 = staticLayout0.getHeight();
                    f4 = ((float)v) + f2;
                    float f5 = ((float)(this.mHeight - v2)) / 2.0f;
                    if(this.mSelectedBgNinePatch == null) {
                        canvas0.drawRoundRect(new RectF(f2, 0.0f, f4, f1), this.mStrokeRadius, this.mStrokeRadius, this.mFillPaint);
                    }
                    else {
                        this.mSelectedBgNinePatch.draw(canvas0, new RectF(f2, 0.0f, f4, f1));
                    }
                    canvas0.save();
                    canvas0.translate(f2, f5);
                    staticLayout0.draw(canvas0);
                    canvas0.restore();
//                    goto label_51;
                }
                else {
                    if(this.mSelectedBgNinePatch == null) {
                        canvas0.drawRoundRect(new RectF(f2, 0.0f, f3, f1), this.mStrokeRadius, this.mStrokeRadius, this.mFillPaint);
                    }
                    else {
                        this.mSelectedBgNinePatch.draw(canvas0, new RectF(f2, 0.0f, f3, f1));
                    }
                    canvas0.drawText(s, this.mPaddingText + f2, ((float)this.mHeight) * 0.5f + this.mTextHeightOffset - 1.0f, this.mSelectedTextPaint);
                    f4 = f3; // label_50
                }
//                goto label_39;
            }
            else {
//            label_39:
                if(this.isFixWidth) {
                    StaticLayout staticLayout1 = new StaticLayout(s, this.mUnselectedTextPaint, v, Layout.Alignment.ALIGN_CENTER, 0.7f, 0.0f, true);
                    int v3 = staticLayout1.getHeight();
                    f4 = ((float)v) + f2;
                    float f6 = ((float)(this.mHeight - v3)) / 2.0f;
                    canvas0.save();
                    canvas0.translate(f2, f6);
                    staticLayout1.draw(canvas0);
                    canvas0.restore();
//                    goto label_51;
                }
                else {
                    canvas0.drawText(s, this.mPaddingText + f2, ((float)this.mHeight) * 0.5f + this.mTextHeightOffset - 1.0f, this.mUnselectedTextPaint);
                    f4 = f3; // label_50
                }
            }
//        label_50:
//            f4 = f3;
        label_51:
            f2 += f4 - f2;
            ++v1;
        }
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        int v2 = this.getDefaultWidth();
        int v3 = this.getDefaultHeight();
        this.setMeasuredDimension(this.getExpectSize(v2, v), this.getExpectSize(v3, v1));
    }

    @Override  // android.view.View
    protected void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.mWidth = this.getMeasuredWidth();
        this.mHeight = this.getMeasuredHeight();
        this.checkAttrs();
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(!this.mEnable) {
            return true;
        }
        if(motionEvent0.getAction() == 1) {
            if(this.quickClickTime > 0) {
                long v1 = SystemClock.elapsedRealtime();
                this.isQuickClick = v1 - this.lastClickTime < ((long)this.quickClickTime);
                Log.i("SwitchMultiButtonNew", "onTouchEvent isQuickClick " + this.isQuickClick);
                if(this.isQuickClick) {
                    return true;
                }
                this.lastClickTime = v1;
            }
            if(this.playSoundEffect) {
                this.playKeySoundEffect();
            }
            float f = motionEvent0.getX();
            float f1 = 0.0f;
            for(int v = 0; v < this.mTabNum; ++v) {
                float f2 = this.mSelectedTextPaint.measureText(this.mTabTexts[v]) + this.mPaddingText * 2.0f;
                if(this.isFixWidth) {
                    f2 = ((float)this.mWidth) / (((float)this.mTabNum) * 1.0f);
                }
                if((f > f1) && (f < f1 + f2)) {
                    if(this.mSelectedTab == v) {
                        if(!this.playSoundEffect) {
                            this.playKeySoundEffect();
                        }
                        return true;
                    }
                    this.mSelectedTab = v;
                    if(this.onSwitchListener != null) {
                        Log.i("SwitchMultiButtonNew", this.getTag() + " click :" + this.mTabTexts[v] + " , index = " + this.mSelectedTab);
                        this.onSwitchListener.onSwitch(this, v, this.mTabTexts[v], true);
                    }
                }
                f1 += f2;
            }
            this.invalidate();
        }
        return true;
    }

    private void playKeySoundEffect() {
        if(Settings.System.getInt(this.getContext().getContentResolver(), "sound_effects_enabled", 0) == 1) {
            ((AudioManager)this.getContext().getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(AudioManager.FX_KEY_CLICK);
        }
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        if(z == this.isEnabled()) {
            return;
        }
        this.mEnable = z;
        this.invalidate();
    }

    public SwitchMultiButtonOld setOnSwitchListener(OnSwitchListener switchMultiButtonOld$OnSwitchListener0) {
        this.onSwitchListener = switchMultiButtonOld$OnSwitchListener0;
        return this;
    }

    public void setPaddingText(int v) {
        this.mPaddingText = (float)v;
        this.invalidate();
    }

    public void setPaddingText(int v, float f) {
        this.mPaddingText = (float)v;
        this.mTextSize = f;
        if(this.mSelectedTextPaint != null) {
            this.mSelectedTextPaint.setTextSize(this.mTextSize);
        }
        if(this.mUnselectedTextPaint != null) {
            this.mUnselectedTextPaint.setTextSize(this.mTextSize);
        }
        this.invalidate();
    }

    public void setPlaySoundEffect(boolean z) {
        this.playSoundEffect = z;
    }

    public SwitchMultiButtonOld setSelectedTab(int v) {
        if(this.getSelectedTab() != v && v < this.getTabNum()) {
            Log.i("SwitchMultiButtonNew", this.getTag() + " >>> setSelectedTab " + v + " >> " + this.getTabText(v));
            this.mSelectedTab = v;
            this.invalidate();
            if(this.onSwitchListener != null) {
                String s = this.getTabText(v);
                this.onSwitchListener.onSwitch(this, v, s, false);
            }
            return this;
        }
        return this;
    }

    public SwitchMultiButtonOld setText(String[] arr_s) {
        this.mTabTexts = arr_s;
        this.mTabNum = arr_s.length;
        this.requestLayout();
        return this;
    }

    public void setTextSize(float f) {
        this.mTextSize = f;
        this.initPaint();
        this.postInvalidate();
    }
}

