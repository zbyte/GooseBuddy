package com.yftech.settings.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.TextView;

public class CommonCheckboxDialog extends BaseDialog {
    public interface OnBtnClickListener {
        void onCancelClick();

        void onSureClick();
    }

    private Button btn_cancel;
    private Button btn_sure;
    private CheckBox checkBox;
    private View divider_vertical;
    private boolean mIsCustomDismiss;
    private OnBtnClickListener mOnBtnClickListener;
    private TextView tv_content;
    private TextView tv_title;

    public CommonCheckboxDialog(Context context0) {
        super(context0, 0x7F1002CF);  // style:dialog_normal
    }

    @Override  // com.yftech.settings.widget.dialog.BaseDialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(0x7F0C0033);  // layout:dialog_common_checkbox
        this.getWindow().setType(0x808);
        this.setCanceledOnTouchOutside(false);
        this.setCancelable(false);
        this.btn_sure = (Button)this.findViewById(0x7F0900AB);  // id:btn_sure
        this.btn_cancel = (Button)this.findViewById(0x7F09009C);  // id:btn_cancel
        this.divider_vertical = this.findViewById(0x7F09011C);  // id:divider_vertical
        this.tv_title = (TextView)this.findViewById(0x7F0902E1);  // id:tv_title
        this.tv_content = (TextView)this.findViewById(0x7F0902D4);  // id:tv_content
        this.checkBox = (CheckBox)this.findViewById(0x7F0900DE);  // id:checkbox
        this.btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CommonCheckboxDialog.this.mOnBtnClickListener != null) {
                    CommonCheckboxDialog.this.mOnBtnClickListener.onSureClick();
                }
                if(!CommonCheckboxDialog.this.mIsCustomDismiss) {
                    CommonCheckboxDialog.this.dismiss();
                }
            }
        });
        this.btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CommonCheckboxDialog.this.mOnBtnClickListener != null) {
                    CommonCheckboxDialog.this.mOnBtnClickListener.onCancelClick();
                }
                if(!CommonCheckboxDialog.this.mIsCustomDismiss) {
                    CommonCheckboxDialog.this.dismiss();
                }
            }
        });
        this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override  // android.widget.CompoundButton$OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
                CommonCheckboxDialog.this.btn_sure.setEnabled(z);
                CommonCheckboxDialog.this.btn_sure.setSelected(z);
            }
        });
    }

    public CommonCheckboxDialog setButtonText(String[] arr_s) {
        if(arr_s != null) {
            if(arr_s.length == 1) {
                this.btn_sure.setBackgroundResource(0x7F08009C);  // drawable:selector_dialog_one_btn_bg
                this.btn_sure.setText(arr_s[0]);
                this.btn_sure.setVisibility(View.VISIBLE);
                this.divider_vertical.setVisibility(View.GONE);
                this.btn_cancel.setVisibility(View.GONE);
                return this;
            }
            if(arr_s.length > 1) {
                this.btn_sure.setBackgroundResource(0x7F08009B);  // drawable:selector_dialog_left_btn_bg
                this.btn_sure.setText(arr_s[0]);
                this.btn_sure.setVisibility(View.VISIBLE);
                this.divider_vertical.setVisibility(View.VISIBLE);
                this.btn_cancel.setBackgroundResource(0x7F08009D);  // drawable:selector_dialog_right_btn_bg
                this.btn_cancel.setText(arr_s[1]);
                this.btn_cancel.setVisibility(View.VISIBLE);
            }
        }
        return this;
    }

    public CommonCheckboxDialog setCancelEnabled(boolean z) {
        this.btn_cancel.setEnabled(z);
        return this;
    }

    public CommonCheckboxDialog setCancelSelected(boolean z) {
        this.btn_cancel.setSelected(z);
        return this;
    }

    public CommonCheckboxDialog setCheckBox(String s, boolean z) {
        this.checkBox.setText(s);
        this.checkBox.setChecked(z);
        this.btn_sure.setEnabled(z);
        this.btn_sure.setSelected(z);
        return this;
    }

    public CommonCheckboxDialog setContent(String s) {
        this.tv_content.setText(s);
        this.tv_content.setVisibility((TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE));
        return this;
    }

    public void setCustomDismiss(boolean z) {
        this.mIsCustomDismiss = z;
    }

    public CommonCheckboxDialog setOnBtnClickListener(OnBtnClickListener commonCheckboxDialog$OnBtnClickListener0) {
        this.mOnBtnClickListener = commonCheckboxDialog$OnBtnClickListener0;
        return this;
    }

    public CommonCheckboxDialog setSureEnabled(boolean z) {
        this.btn_sure.setEnabled(z);
        return this;
    }

    public CommonCheckboxDialog setSureSelected(boolean z) {
        this.btn_sure.setSelected(z);
        return this;
    }

    public CommonCheckboxDialog setTitle(String s) {
        this.tv_title.setText(s);
        this.tv_title.setVisibility((TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE));
        return this;
    }
}

