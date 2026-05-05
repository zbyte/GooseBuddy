package com.yftech.settings.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import ru.gs8club.goosebuddy.R;

public class ItemSeekBarNumIconView extends LinearLayout {
    private final String TAG;
    private boolean contentVisible;
    private AppCompatImageView imgIcon;
    private boolean imgVisible;
    private SeekBarNumber seekBarNumber;
    private String titleString;
    private String titleStringCN;
    private TextView tvContent;
    private TextView tvTitle;

    public ItemSeekBarNumIconView(@NonNull Context context0) {
        this(context0, null);
    }

    public ItemSeekBarNumIconView(@NonNull Context context0, @Nullable AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.TAG = this.getClass().getSimpleName();
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.ItemSeekBarNumIconView);
            this.contentVisible = typedArray0.getBoolean(R.styleable.ItemSeekBarNumIconView_contentVisible, false);
            this.imgVisible = typedArray0.getBoolean(R.styleable.ItemSeekBarNumIconView_imgVisible, false);
            this.titleString = typedArray0.getString(R.styleable.ItemSeekBarNumIconView_titleString);
            typedArray0.recycle();
            this.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
        }
        this.init();
    }

    public void addOnClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.imgIcon != null) {
            this.imgIcon.setOnClickListener(view$OnClickListener0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addOnTouchListener(View.OnTouchListener view$OnTouchListener0) {
        if(this.seekBarNumber != null) {
            this.seekBarNumber.setOnTouchListener(view$OnTouchListener0);
        }
    }

    public int getProgress() {
        return this.seekBarNumber.getProgress();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.item_seekbar_num_icon_view, this, true);  // layout:item_seekbar_num_icon_view
        this.imgIcon = (AppCompatImageView)this.findViewById(R.id.ivIcon);  // id:ivIcon
        int v = GONE;
        this.imgIcon.setVisibility((this.imgVisible ? VISIBLE : GONE));
        this.tvContent = (TextView)this.findViewById(R.id.tvContent);  // id:tvContent
        if(this.contentVisible) {
            v = VISIBLE;
        }
        tvContent.setVisibility(v);
        this.seekBarNumber = (SeekBarNumber)this.findViewById(R.id.seekBarNumber);  // id:seekBarNumber
        this.tvTitle = (TextView)this.findViewById(R.id.tvTitle);  // id:tvTitle
        if(TextUtils.isEmpty(this.titleString)) {
            this.tvTitle.setVisibility(View.INVISIBLE);
            return;
        }
        this.tvTitle.setVisibility(VISIBLE);
        this.tvTitle.setText(this.titleString);
        this.seekBarNumber.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
    }

    public void setContentString(String s) {
        if(this.tvContent != null) {
            this.tvContent.setText(s);
        }
    }

    public void setImageResource(@DrawableRes int v) {
        if(this.imgIcon != null && v != -1) {
            this.imgIcon.setImageResource(v);
        }
    }

    public void setOnSeekBarChangeListener(SeekBarNumber.OnSeekChangeListener seekBarNumber$OnSeekChangeListener0) {
        if(this.seekBarNumber != null) {
            this.seekBarNumber.setOnSeekChangeListener(seekBarNumber$OnSeekChangeListener0);
        }
    }

    public void setPaintProgress(boolean z) {
        this.seekBarNumber.setPaintProgress(z);
    }

    public void setProgress(int v) {
        if(this.seekBarNumber.getProgress() == v) {
            return;
        }
        Log.i(this.TAG, this.getTag() + " setProgress : " + v);
        this.seekBarNumber.setProgress(v);
    }

    public void setProgressDrawable(Drawable drawable0) {
        if(this.seekBarNumber != null) {
            this.seekBarNumber.setProgressDrawable(drawable0);
        }
    }

    public void setSeekBarEnable(boolean z) {
        this.seekBarNumber.setEnabled(z);
        this.seekBarNumber.setAlpha((z ? 1.0f : 0.2f));
    }

    public void setSeekBarMax(int v) {
        this.seekBarNumber.setMax(v);
    }

    public void setSeekBarMin(int v) {
        this.seekBarNumber.setMin(v);
    }

    public void setSeekBarNumberMin(int v) {
        this.seekBarNumber.setNumberMin(v);
    }

    public void setShowWarn(boolean z) {
        this.seekBarNumber.setShowWarn(z);
    }

    public void setTitleString(String s) {
        Log.i(this.TAG, this.getTag() + " >>> setTitleString:" + s);
        this.titleString = s;
        if(this.tvTitle != null) {
            this.tvTitle.setText(s);
        }
    }

    public void setWarnMax(int v) {
        this.seekBarNumber.setWarnMax(v);
    }
}

