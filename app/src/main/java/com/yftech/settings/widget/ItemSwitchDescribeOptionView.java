package com.yftech.settings.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

import ru.gs8club.goosebuddy.R;

public class ItemSwitchDescribeOptionView extends LinearLayout {
    private final String TAG;
    private String descString;
    private float mPaddingText;
    private String[] mTabTexts;
    private float mTextSize;
    private SwitchCompatButton switchCompatButton;
    private SwitchMultiButton switchMultiButton;
    private String titleString;
    private String titleStringCN;
    private TextView tvDescribe;
    private TextView tvTitle;

    public ItemSwitchDescribeOptionView(Context context0) {
        this(context0, null);
    }

    public ItemSwitchDescribeOptionView(Context context0, @Nullable AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.TAG = this.getClass().getSimpleName();
        this.mTabTexts = new String[]{"L", "R"};
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.ItemSwitchDescribeOptionView);
            this.descString = typedArray0.getString(R.styleable.ItemSwitchDescribeOptionView_descString);
            this.mPaddingText = typedArray0.getDimension(R.styleable.ItemSwitchDescribeOptionView_paddingText, this.getResources().getDimension(R.dimen.multi_button_max_padding_text));  // dimen:multi_button_max_padding_text
            this.mTextSize = typedArray0.getDimension(R.styleable.ItemSwitchDescribeOptionView_textSize, this.getResources().getDimension(R.dimen.multi_button_text_size));  // dimen:multi_button_text_size
            this.titleString = typedArray0.getString(R.styleable.ItemSwitchDescribeOptionView_titleString);
            int v = typedArray0.getResourceId(R.styleable.ItemSwitchDescribeOptionView_switchTabs, 0);
            if(v != 0) {
                this.mTabTexts = this.getResources().getStringArray(v);
            }
            typedArray0.recycle();
            this.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
        }
        this.init();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void addOnTouchListener(View.OnTouchListener view$OnTouchListener0) {
        if(this.switchCompatButton != null) {
            this.switchCompatButton.setOnTouchListener(view$OnTouchListener0);
        }
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setOnTouchListener(view$OnTouchListener0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void init() {
        LayoutInflater.from(this.getContext()).inflate(R.layout.item_switch_describe_option_view, this, true);  // layout:item_switch_describe_option_view
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
        this.switchCompatButton = (SwitchCompatButton)this.findViewById(R.id.switcher);  // id:switcher
        this.switchCompatButton.setTag(this.titleString);
        this.switchMultiButton = (SwitchMultiButton)this.findViewById(R.id.switchMultiButton);  // id:switchMultiButton
        this.switchMultiButton.setText(this.mTabTexts).setPaddingText(((int)this.mPaddingText), this.mTextSize);
        if(TextUtils.isEmpty(this.titleString)) {
            this.tvTitle.setVisibility(View.INVISIBLE);
            return;
        }
        this.tvTitle.setVisibility(View.VISIBLE);
        this.tvTitle.setText(this.titleString);
        this.switchMultiButton.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
        this.setTag((TextUtils.isEmpty(this.titleStringCN) ? this.titleString : this.titleStringCN));
    }

    public void setChecked(boolean z) {
        if(this.switchCompatButton.isChecked() == z) {
            return;
        }
        Log.i(this.TAG, this.getTag() + " >>> setChecked:" + z);
        this.switchCompatButton.setChecked(z);
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

    public void setOnSwitchCompatButtonListener(SwitchCompatButton.OnSwitchCompatChangeFromUserListener switchCompatButton$OnSwitchCompatChangeFromUserListener0) {
        if(this.switchCompatButton != null) {
            this.switchCompatButton.setOnSwitchCompatChangeFromUserListener(switchCompatButton$OnSwitchCompatChangeFromUserListener0);
        }
    }

    public void setOnSwitchMultiButtonListener(SwitchMultiButton.OnSwitchListener switchMultiButton$OnSwitchListener0) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setOnSwitchListener(switchMultiButton$OnSwitchListener0);
        }
    }

    public void setSelectedTab(int v) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setSelectedTab(v);
        }
    }

    public void setSwitchMultiButtonVisible(boolean z) {
        if(this.switchMultiButton != null) {
            this.switchMultiButton.setVisibility((z ? View.VISIBLE : View.GONE));
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

