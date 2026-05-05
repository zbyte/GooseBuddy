package com.yftech.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;


import ru.gs8club.goosebuddy.R;

public class ItemTextDescribeButtonView extends LinearLayout {
    private final String TAG;
    private Button button;
    private String buttonString;
    private String contentString;
    private boolean contentVisible;
    private Drawable drawable;
    private ImageView ivIcon;
    private float mPaddingText;
    private float mTextSize;
    private String titleString;
    private TextView tvContent;
    private TextView tvTitle;

    public ItemTextDescribeButtonView(Context context0) {
        this(context0, null);
    }

    public ItemTextDescribeButtonView(Context context0, @Nullable AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.TAG = this.getClass().getSimpleName();
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.ItemTextDescribeButtonView);
            this.buttonString = typedArray0.getString(R.styleable.ItemTextDescribeButtonView_buttonString);
            this.contentVisible = typedArray0.getBoolean(R.styleable.ItemTextDescribeButtonView_contentVisible, true);
            this.contentString = "";  //typedArray0.getString(2);
            this.drawable = typedArray0.getDrawable(R.styleable.ItemTextDescribeButtonView_imgIcon);
            this.mPaddingText = typedArray0.getDimension(R.styleable.ItemTextDescribeButtonView_paddingText, 0.0f);
            this.mTextSize = typedArray0.getDimension(R.styleable.ItemTextDescribeButtonView_textSize, -1.0f);
            this.titleString = typedArray0.getString(R.styleable.ItemTextDescribeButtonView_titleString);
            typedArray0.recycle();
        }
        this.init();
    }

    public void addContentClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.tvContent != null) {
            this.tvContent.setOnClickListener(view$OnClickListener0);
        }
    }

    public void addIconClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.ivIcon != null) {
            this.ivIcon.setOnClickListener(view$OnClickListener0);
        }
    }

    public void addOnButtonClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.button != null) {
            this.button.setOnClickListener(view$OnClickListener0);
        }
    }

    public void addTitleClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.tvTitle != null) {
            this.tvTitle.setOnClickListener(view$OnClickListener0);
        }
    }

    public TextView getTvTitle() {
        return this.tvTitle;
    }

    private void init() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.item_text, this, true);  // layout:item_text
        this.tvTitle = (TextView)this.findViewById(R.id.tvTitle);  // id:tvTitle
        this.tvTitle.setText(this.titleString);
        this.tvTitle.setPadding(((int)this.mPaddingText), 0, 0, 0);
        this.tvContent = (TextView)this.findViewById(R.id.tvContent);  // id:tvContent
        this.tvContent.setVisibility((this.contentVisible ? View.VISIBLE : View.GONE));
        if(!TextUtils.isEmpty(this.contentString)) {
            this.tvContent.setText(this.contentString);
        }
        this.button = (Button)this.findViewById(R.id.button);  // id:button
        if(TextUtils.isEmpty(this.buttonString)) {
            this.button.setVisibility(View.GONE);
        }
        else {
            this.button.setText(this.buttonString);
            this.button.setVisibility(View.VISIBLE);
        }
        this.ivIcon = (ImageView)this.findViewById(R.id.ivIcon);  // id:ivIcon
        if(this.drawable == null) {
            this.ivIcon.setVisibility(View.GONE);
            return;
        }
        this.ivIcon.setVisibility(View.VISIBLE);
        this.ivIcon.setImageDrawable(this.drawable);
    }

    public void setButtonVisible(boolean z) {
        if(!TextUtils.isEmpty(this.buttonString) && z) {
            this.button.setVisibility(View.VISIBLE);
            return;
        }
        this.button.setVisibility(View.GONE);
    }

    public void setContentString(String s) {
        Log.i(this.TAG, this.getTag() + " >>> setContentString:" + s);
        this.contentString = s;
        if(this.tvContent != null) {
            if(TextUtils.isEmpty(s)) {
                this.tvContent.setVisibility(View.GONE);
                return;
            }
            this.tvContent.setVisibility(View.VISIBLE);
            this.tvContent.setText(s);
        }
    }

    public void setImageResource(@DrawableRes int v) {
        if(this.ivIcon != null && v != -1) {
            this.ivIcon.setImageResource(v);
            this.ivIcon.setVisibility(View.VISIBLE);
            return;
        }
        this.ivIcon.setVisibility(View.GONE);
    }

    public void setTitleSoundEffectsEnabled(boolean z) {
        if(this.tvTitle != null) {
            this.tvTitle.setSoundEffectsEnabled(z);
        }
    }

    public void setTitleString(String s) {
        Log.i(this.TAG, this.getTag() + " >>> setTitleString:" + s);
        this.titleString = s;
        if(this.tvTitle != null) {
            this.tvTitle.setText(s);
        }
    }
}

