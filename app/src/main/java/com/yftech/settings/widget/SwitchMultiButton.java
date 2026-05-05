package com.yftech.settings.widget;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ru.gs8club.goosebuddy.R;

public class SwitchMultiButton extends View {
    public interface OnSwitchListener {
        void onSwitch(SwitchMultiButton arg1, int arg2, String arg3, boolean arg4);
    }

    private static final int DEFAULT_BG_COLOR = 0xFF4F535A;
    private static final int DEFAULT_DISABLE_COLOR = 0xFFCCCCCC;
    private static final int DEFAULT_QUICK_CLICK_INTERVAL = 300;
    private static final int DEFAULT_SELECTED_COLOR = 0xFF5F6574;
    private static final int DEFAULT_SELECTED_TEXT_COLOR = -1;
    private static final float DEFAULT_STROKE_RADIUS = 20.0f;
    private static final int DEFAULT_UNSELECTED_TEXT_COLOR = 0xB3FFFFFF;
    private static final String TAG = "SwitchMultiButton";
    float currentTabAvaWidth;
    private int mBgColor;
    private Drawable mBgResource;
    private int mDisableColor;
    private boolean mEnable;
    private final Paint mFillPaint;
    private Paint.FontMetrics mFontMetrics;
    private boolean mIsFixWidth;
    private long mLastClickTime;
    private float mMaxTabWidth;
    private OnSwitchListener mOnSwitchListener;
    private float mPaddingText;
    private boolean mPlaySoundEffect;
    private Bitmap mSelectedBgBitmap;
    private NinePatch mSelectedBgNinePatch;
    private int mSelectedColor;
    private int mSelectedTab;
    private int mSelectedTextColor;
    private final TextPaint mSelectedTextPaint;
    private Typeface mSelectedTypeface;
    private ValueAnimator mSelectionAnimator;
    private final Paint mStrokePaint;
    private float mStrokeRadius;
    private RectF[] mTabAreas;
    private final List mTabTexts;
    private final SparseArray mTextLayoutCache;
    private float mTextSize;
    private Typeface mUnSelectedTypeface;
    private int mUnselectedTextColor;
    private final TextPaint mUnselectedTextPaint;
    private final SparseArray totalTabWidthList;

    public SwitchMultiButton(Context context0) {
        this(context0, null);
    }

    public SwitchMultiButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        mStrokePaint = new Paint(1);
        mFillPaint = new Paint(1);
        mSelectedTextPaint = new TextPaint(1);
        mUnselectedTextPaint = new TextPaint(1);
        mTextLayoutCache = new SparseArray();
        mTabTexts = new ArrayList();
        mSelectedTab = -1;
        mEnable = true;
        mPlaySoundEffect = true;
        totalTabWidthList = new SparseArray();
        initAttributes(context0, attributeSet0);
        initPaints();
    }

    private void animateSelection(int v) {
        if(mSelectionAnimator != null) {
            mSelectionAnimator.cancel();
        }
        mSelectionAnimator = ValueAnimator.ofFloat(new float[]{((float)mSelectedTab), ((float)v)});
        mSelectionAnimator.setDuration(200L);
        mSelectionAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator0) {
                invalidate();
            }
        });
        mSelectionAnimator.start();
        mSelectedTab = v;
    }

    private int calculateDefaultHeight() {
        return ((int)(mFontMetrics.bottom - mFontMetrics.top)) + getPaddingTop() + getPaddingBottom();
    }

    private int calculateDefaultWidth() {
        currentTabAvaWidth = mMaxTabWidth / ((float)mTabTexts.size());
        int v = 0;
        float f = 0.0f;
        for(int v1 = 0; v1 < mTabTexts.size(); ++v1) {
            String s = (String)mTabTexts.get(v1);
            float f1 = mSelectedTextPaint.measureText(s);
            totalTabWidthList.put(v1, Float.valueOf(f1));
            f += f1;
        }
        float f2 = mPaddingText * ((float)mTabTexts.size()) * 2.0f;
        float f3 = f + f2;
        float f4 = ((float)mTabTexts.size()) * 12.0f * 2.0f + f;
        if((f4 < mMaxTabWidth) && (mMaxTabWidth < f3)) {
            f3 = mMaxTabWidth;
            mPaddingText = Math.min(f2, mMaxTabWidth - f) / ((float)(mTabTexts.size() * 2));
            mIsFixWidth = false;
            while(v < mTabTexts.size()) {
                String s1 = (String)mTabTexts.get(v);
                float f5 = mSelectedTextPaint.measureText(s1);
                totalTabWidthList.put(v, Float.valueOf(f5 + mPaddingText * 2.0f));
                ++v;
            }
            return (int)f3;
        }
        if((mMaxTabWidth < f4)) {
            float f6 = 0.666667f;
            boolean z = true;
            while(z) {
                f3 = mMaxTabWidth;
                mIsFixWidth = true;
                float f7 = 0.0f;
                for(int v2 = 0; v2 < mTabTexts.size(); ++v2) {
                    float f8 = (float)(((Float)totalTabWidthList.get(v2)));
                    if((f8 > currentTabAvaWidth)) {
                        f8 *= f6;
                    }
                    totalTabWidthList.put(v2, Float.valueOf(f8));
                    f7 += f8;
                }
                if((f7 < mMaxTabWidth)) {
                    mPaddingText = (mMaxTabWidth - f7) / ((float)(mTabTexts.size() * 2));
                    for(int v3 = 0; v3 < mTabTexts.size(); ++v3) {
                        float f9 = (float)(((Float)totalTabWidthList.get(v3)));
                        totalTabWidthList.put(v3, Float.valueOf(f9 + mPaddingText * 2.0f));
                    }
                }
                else if(f6 == 0.5f) {
                    Log.i("SwitchMultiButton", "still Exceeding the mMaxTabWidth :" + Arrays.toString(mTabTexts.toArray()));
                }
                else {
                    f6 = 0.5f;
                    continue;
                }
                z = false;
            }
            return (int)f3;
        }
        mIsFixWidth = false;
        while(v < mTabTexts.size()) {
            float f10 = (float)(((Float)totalTabWidthList.get(v)));
            totalTabWidthList.put(v, Float.valueOf(f10 + mPaddingText * 2.0f));
            ++v;
        }
        return (int)f3;
    }

    private void calculateTabAreas() {
        int v = mTabTexts.size();
        mTabAreas = new RectF[v];
        int v1 = 0;
        float f1;
        for(float f = 0.0f; v1 < v; f = f1) {
            f1 = ((float)(((Float)totalTabWidthList.get(v1)))) + f;
            RectF[] arr_rectF = mTabAreas;
            arr_rectF[v1] = new RectF(f, 0.0f, f1, ((float)getHeight()));
            ++v1;
        }
    }

    public void clearSelection() {
        mSelectedTab = -1;
        invalidate();
    }

    private void configureTextPaint(TextPaint textPaint0, int v, Typeface typeface0) {
        textPaint0.setColor(v);
        textPaint0.setTextSize(mTextSize);
        textPaint0.setTypeface(typeface0);
    }

    private void drawBackground(Canvas canvas0) {
        if(mBgResource != null) {
            setBackground(mBgResource);
            return;
        }
        canvas0.drawRoundRect(new RectF(0.0f, 0.0f, ((float)getWidth()), ((float)getHeight())), mStrokeRadius, mStrokeRadius, mStrokePaint);
    }

    private void drawMultilineText(Canvas canvas0, String s, RectF rectF0, boolean z) {
        StaticLayout staticLayout0 = getCachedTextLayout(s, (z ? mSelectedTextPaint : mUnselectedTextPaint), ((int)rectF0.width()));
        canvas0.save();
        try {
            float f = (rectF0.height() - ((float)staticLayout0.getHeight())) / 2.0f;
            canvas0.translate(rectF0.left, rectF0.top + f);
            staticLayout0.draw(canvas0);
        }
        finally {
            canvas0.restore();
        }
    }

    private void drawSingleLineText(Canvas canvas0, String s, RectF rectF0, boolean z) {
        TextPaint textPaint0 = z ? mSelectedTextPaint : mUnselectedTextPaint;
        float f = textPaint0.measureText(s);
        canvas0.drawText(s, rectF0.left + (rectF0.width() - f) / 2.0f, rectF0.centerY() - (textPaint0.descent() + textPaint0.ascent()) / 2.0f, textPaint0);
    }

    private void drawTabBackground(Canvas canvas0, int v) {
        if(v != mSelectedTab) {
            return;
        }
        RectF rectF0 = mTabAreas[v];
        if(mSelectedBgNinePatch != null) {
            mSelectedBgNinePatch.draw(canvas0, rectF0);
            return;
        }
        canvas0.drawRoundRect(rectF0, mStrokeRadius, mStrokeRadius, mFillPaint);
    }

    private void drawTabText(Canvas canvas0, int v) {
        RectF rectF0 = mTabAreas[v];
        String s = (String)mTabTexts.get(v);
        boolean z = v == mSelectedTab && mSelectedTab != -1;
        if(mIsFixWidth) {
            drawMultilineText(canvas0, s, rectF0, z);
            return;
        }
        drawSingleLineText(canvas0, s, rectF0, z);
    }

    private void drawTabs(Canvas canvas0) {
        if(mTabAreas != null && !mTabTexts.isEmpty()) {
            for(int v = 0; v < mTabTexts.size(); ++v) {
                drawTabBackground(canvas0, v);
                drawTabText(canvas0, v);
            }
        }
    }

    private StaticLayout getCachedTextLayout(String s, TextPaint textPaint0, int v) {
        int v1 = s.hashCode() + textPaint0.hashCode() + v;
        StaticLayout staticLayout0 = (StaticLayout)mTextLayoutCache.get(v1);
        if(staticLayout0 == null) {
            staticLayout0 = new StaticLayout(s, textPaint0, v, Layout.Alignment.ALIGN_CENTER, 0.7f, 0.0f, true);
            mTextLayoutCache.put(v1, staticLayout0);
        }
        return staticLayout0;
    }

    public int getTabNum() {
        return mTabTexts == null ? 0 : mTabTexts.size();
    }

    private void handleTouchEvent(float f) {
        if(mPlaySoundEffect) {
            playKeySoundEffect();
        }
        float f1 = 0.0f;
        for(int v = 0; v < mTabTexts.size(); ++v) {
            float f2 = (float)(((Float)totalTabWidthList.get(v)));
            if((f > f1) && (f < f1 + f2)) {
                if(mSelectedTab == v) {
                    if(!mPlaySoundEffect) {
                        playKeySoundEffect();
                    }
                    return;
                }
                mSelectedTab = v;
                if(mOnSwitchListener != null) {
                    Log.i("SwitchMultiButton", getTag() + " click :" + ((String)mTabTexts.get(v)) + " , index = " + mSelectedTab);
                    mOnSwitchListener.onSwitch(this, v, ((String)mTabTexts.get(v)), true);
                }
            }
            f1 += f2;
        }
        invalidate();
    }

    private void initAttributes(Context context0, AttributeSet attributeSet0) {
        if(attributeSet0 == null) {
            return;
        }
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.SwitchMultiButton);
        try {
            mBgResource = typedArray0.getDrawable(R.styleable.SwitchMultiButton_background);
            mBgColor = typedArray0.getColor(R.styleable.SwitchMultiButton_backgroundColor, 0xFF4F535A);
            mDisableColor = typedArray0.getColor(R.styleable.SwitchMultiButton_disableColor, 0xFFCCCCCC);
            mMaxTabWidth = typedArray0.getDimension(R.styleable.SwitchMultiButton_maxTabWidth, getResources().getDimension(R.dimen.multi_button_max_width));  // dimen:multi_button_max_width
            mPaddingText = typedArray0.getDimension(R.styleable.SwitchMultiButton_paddingText, getResources().getDimension(R.dimen.multi_button_max_padding_text));  // dimen:multi_button_max_padding_text
            initNinePatch(typedArray0.getResourceId(R.styleable.SwitchMultiButton_selectedBg, 0));
            mSelectedColor = typedArray0.getColor(R.styleable.SwitchMultiButton_selectedColor, 0xFF5F6574);
            mSelectedTextColor = typedArray0.getColor(R.styleable.SwitchMultiButton_selectedTextColor, -1);
            mStrokeRadius = typedArray0.getDimension(R.styleable.SwitchMultiButton_strokeRadius, 20.0f);
            int v1 = typedArray0.getResourceId(R.styleable.SwitchMultiButton_switchTabs, 0);
            mTextSize = typedArray0.getDimension(R.styleable.SwitchMultiButton_textSize, getResources().getDimension(R.dimen.multi_button_text_size));  // dimen:multi_button_text_size
            mUnselectedTextColor = typedArray0.getColor(R.styleable.SwitchMultiButton_unselectedTextColor, 0xB3FFFFFF);
            if(v1 == 0) {
                mTabTexts.add("???");
                mTabTexts.add("???");
            }
            else {
                String[] arr_s = getResources().getStringArray(v1);
                Collections.addAll(mTabTexts, arr_s);
            }
            initTypefaces(typedArray0);
        }
        finally {
            typedArray0.recycle();
        }
    }

    private void initNinePatch(int v) {
        if(v != 0) {
            mSelectedBgBitmap = BitmapFactory.decodeResource(getResources(), v);
            mSelectedBgNinePatch = new NinePatch(mSelectedBgBitmap, mSelectedBgBitmap.getNinePatchChunk(), null);
        }
    }

    private void initPaints() {
        mStrokePaint.setColor(mBgColor);
        mStrokePaint.setStyle(Paint.Style.FILL);
        mFillPaint.setColor(mSelectedColor);
        mFillPaint.setStyle(Paint.Style.FILL);
        configureTextPaint(mSelectedTextPaint, mSelectedTextColor, mSelectedTypeface);
        configureTextPaint(mUnselectedTextPaint, mUnselectedTextColor, mUnSelectedTypeface);
        mFontMetrics = mSelectedTextPaint.getFontMetrics();
    }

    private void initTypefaces(TypedArray typedArray0) {
        String s = typedArray0.getString(R.styleable.SwitchMultiButton_selectedTypeface);
        String s1 = typedArray0.getString(R.styleable.SwitchMultiButton_unselectedTypeface);
        if(!TextUtils.isEmpty(s)) {
            mSelectedTypeface = Typeface.create(s, Typeface.NORMAL);
        }
        if(!TextUtils.isEmpty(s1)) {
            mUnSelectedTypeface = Typeface.create(s1, Typeface.NORMAL);
        }
    }

    @Override  // android.view.View
    public boolean isEnabled() {
        return mEnable;
    }

    private boolean isQuickClick() {
        long v = SystemClock.elapsedRealtime();
        if(v - mLastClickTime < 300L) {
            return true;
        }
        mLastClickTime = v;
        return false;
    }

    @Override  // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if(mSelectedBgBitmap != null) {
            mSelectedBgBitmap.recycle();
        }
        mTextLayoutCache.clear();
    }

    @Override  // android.view.View
    protected void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        updateViewState();
        drawBackground(canvas0);
        drawTabs(canvas0);
    }

    @Override  // android.view.View
    protected void onMeasure(int v, int v1) {
        int v2 = calculateDefaultWidth();
        int v3 = calculateDefaultHeight();
        mStrokeRadius = ((float)v3) / 2.0f;
        setMeasuredDimension(SwitchMultiButton.resolveSize(v2, v), SwitchMultiButton.resolveSize(v3, v1));
    }

    @Override  // android.view.View
    protected void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        calculateTabAreas();
        mTextLayoutCache.clear();
    }

    @Override  // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(!mEnable || motionEvent0.getAction() != 1 || isQuickClick()) {
            return true;
        }
        handleTouchEvent(motionEvent0.getX());
        return true;
    }

    private void playKeySoundEffect() {
        if(Settings.System.getInt(getContext().getContentResolver(), "sound_effects_enabled", 0) == 1) {
            ((AudioManager)getContext().getSystemService(Context.AUDIO_SERVICE)).playSoundEffect(AudioManager.FX_KEY_CLICK);
        }
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        if(z == isEnabled()) {
            return;
        }
        mEnable = z;
        invalidate();
    }

    public void setOnSwitchListener(OnSwitchListener switchMultiButton$OnSwitchListener0) {
        mOnSwitchListener = switchMultiButton$OnSwitchListener0;
    }

    public void setPaddingText(int v) {
        mPaddingText = (float)v;
        invalidate();
    }

    public void setPaddingText(int v, float f) {
        mPaddingText = (float)v;
        mTextSize = f;
        if(mSelectedTextPaint != null) {
            mSelectedTextPaint.setTextSize(mTextSize);
        }
        if(mUnselectedTextPaint != null) {
            mUnselectedTextPaint.setTextSize(mTextSize);
        }
        invalidate();
    }

    public void setPlaySoundEffect(boolean z) {
        mPlaySoundEffect = z;
    }

    public void setSelectedTab(int v) {
        if(v < 0) {
            clearSelection();
            return;
        }
        setSelectedTab(v, false);
    }

    public void setSelectedTab(int v, boolean z) {
        if(v >= 0 && v < mTabTexts.size()) {
            if(z) {
                animateSelection(v);
            }
            else {
                mSelectedTab = v;
                invalidate();
            }
            Log.i("SwitchMultiButton", getTag() + "setSelectedTab : " + ((String)mTabTexts.get(v)) + " , index = " + mSelectedTab);
            if(mOnSwitchListener != null) {
                mOnSwitchListener.onSwitch(this, v, ((String)mTabTexts.get(v)), false);
            }
        }
    }

    public SwitchMultiButton setText(String[] arr_s) {
        mTextLayoutCache.clear();
        mTabTexts.clear();
        Collections.addAll(mTabTexts, arr_s);
        requestLayout();
        return this;
    }

    private void updateViewState() {
        int v = mEnable ? mSelectedColor : mDisableColor;
        mStrokePaint.setColor((mEnable ? mBgColor : mDisableColor));
        mFillPaint.setColor(v);
        mSelectedTextPaint.setColor((mEnable ? mSelectedTextColor : mDisableColor));
        mUnselectedTextPaint.setColor((mEnable ? mUnselectedTextColor : mDisableColor));
    }
}

