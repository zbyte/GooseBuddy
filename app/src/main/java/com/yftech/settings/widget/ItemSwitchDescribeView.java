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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;


import ru.gs8club.goosebuddy.R;

public class ItemSwitchDescribeView extends LinearLayout {
    private final String TAG;
    private Button button;
    private String buttonString;
    private String descString;
    private SwitchCompatButton switchCompatButton;
    private String titleString;
    private String titleStringCN;
    private TextView tvDescribe;
    private TextView tvTitle;

    public ItemSwitchDescribeView(Context context0) {
        this(context0, null);
    }

    public ItemSwitchDescribeView(Context context0, @Nullable AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.TAG = this.getClass().getSimpleName();
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.ItemSwitchDescribeView);
            this.buttonString = typedArray0.getString(R.styleable.ItemSwitchDescribeView_buttonString);
            this.descString = typedArray0.getString(R.styleable.ItemSwitchDescribeView_descString);
            this.titleString = typedArray0.getString(R.styleable.ItemSwitchDescribeView_titleString);
            typedArray0.recycle();
            this.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
        }
        this.init();
    }

    public void addOnClickListener(View.OnClickListener view$OnClickListener0) {
        if(this.button != null) {
            this.button.setOnClickListener(view$OnClickListener0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addOnTouchListener(View.OnTouchListener view$OnTouchListener0) {
        if(this.switchCompatButton != null) {
            this.switchCompatButton.setOnTouchListener(view$OnTouchListener0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.item_switch_describe_view, this, true);  // layout:item_switch_describe_view
        this.tvTitle = (TextView)this.findViewById(R.id.tvTitle);  // id:tvTitle
        this.tvTitle.setText(this.titleString);
        this.tvDescribe = (TextView)this.findViewById(R.id.tvDescribe);  // id:tvDescribe
        if(TextUtils.isEmpty(this.descString)) {
            this.tvDescribe.setVisibility(View.GONE);
        }
        else {
            this.tvDescribe.setText(this.descString);
            this.tvDescribe.setVisibility(View.VISIBLE);
        }
        this.button = (Button)this.findViewById(R.id.button);  // id:button
        if(TextUtils.isEmpty(this.buttonString)) {
            this.button.setVisibility(View.GONE);
        }
        else {
            this.button.setText(this.buttonString);
            this.button.setVisibility(View.VISIBLE);
        }
        this.switchCompatButton = (SwitchCompatButton)this.findViewById(R.id.switcher);  // id:switcher
        this.switchCompatButton.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
    }

    public void setButtonVisible(boolean z) {
        if(!TextUtils.isEmpty(this.buttonString) && z) {
            this.button.setVisibility(View.VISIBLE);
            return;
        }
        this.button.setVisibility(View.GONE);
    }

    public void setChecked(boolean z) {
        this.setButtonVisible(z);
        if(this.switchCompatButton.isChecked() == z) {
            return;
        }
        Log.i(this.TAG, this.getTag() + " >>> setChecked:" + z);
        this.switchCompatButton.setChecked(z);
    }

    public void setCompoundDrawables(@Nullable Drawable drawable0, @Nullable Drawable drawable1, @Nullable Drawable drawable2, @Nullable Drawable drawable3) {
        if(this.tvTitle != null) {
            this.tvTitle.setCompoundDrawablesWithIntrinsicBounds(drawable0, drawable1, drawable2, drawable3);
        }
    }

    public void setDescString(String s) {
        Log.i(this.TAG, this.getTag() + " >>> setDescString:" + s);
        this.descString = s;
        if(this.tvDescribe != null) {
            if(TextUtils.isEmpty(s)) {
                this.tvDescribe.setVisibility(View.GONE);
                return;
            }
            this.tvDescribe.setVisibility(View.VISIBLE);
            this.tvDescribe.setText(s);
        }
    }

    public void setDrawableStart(Drawable drawable0) {
        this.setCompoundDrawables(drawable0, null, null, null);
    }

    @Override  // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if(this.switchCompatButton != null) {
            this.switchCompatButton.setEnabled(z);
        }
        if(this.button != null) {
            this.button.setEnabled(z);
        }
    }

    public void setOnSwitchListener(SwitchCompatButton.OnSwitchCompatChangeFromUserListener switchCompatButton$OnSwitchCompatChangeFromUserListener0) {
        if(this.switchCompatButton != null) {
            this.switchCompatButton.setOnSwitchCompatChangeFromUserListener(switchCompatButton$OnSwitchCompatChangeFromUserListener0);
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

