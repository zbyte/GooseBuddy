package com.yftech.settings.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CommonDialog extends BaseDialog {
    public interface OnBtnClickListener {
        void onCancelClick();

        void onIconClick();

        void onSureClick();
    }

    private Button btn_cancel;
    private Button btn_sure;
    private View divider_vertical;
    private ImageView iv_title_icon;
    private RelativeLayout layout_title_icon;
    private boolean mIsCustomDismiss;
    private OnBtnClickListener mOnBtnClickListener;
    private TextView tv_content;
    private TextView tv_title;
    private TextView tv_title_icon;

    public CommonDialog(Context context0) {
        super(context0, 0x7F1002CF);  // style:dialog_normal
    }

    @Override  // com.yftech.settings.widget.dialog.BaseDialog
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(0x7F0C0032);  // layout:dialog_common
        this.getWindow().setType(0x808);
        this.setCanceledOnTouchOutside(false);
        this.setCancelable(false);
        this.btn_sure = (Button)this.findViewById(0x7F0900AB);  // id:btn_sure
        this.btn_cancel = (Button)this.findViewById(0x7F09009C);  // id:btn_cancel
        this.divider_vertical = this.findViewById(0x7F09011C);  // id:divider_vertical
        this.tv_title = (TextView)this.findViewById(0x7F0902E1);  // id:tv_title
        this.layout_title_icon = (RelativeLayout)this.findViewById(0x7F09019C);  // id:layout_title_icon
        this.tv_title_icon = (TextView)this.findViewById(0x7F0902E3);  // id:tv_title_icon
        this.iv_title_icon = (ImageView)this.findViewById(0x7F09017E);  // id:iv_title_icon
        this.tv_content = (TextView)this.findViewById(0x7F0902D4);  // id:tv_content
        this.btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CommonDialog.this.mOnBtnClickListener != null) {
                    CommonDialog.this.mOnBtnClickListener.onSureClick();
                }
                if(!CommonDialog.this.mIsCustomDismiss) {
                    CommonDialog.this.dismiss();
                }
            }
        });
        this.btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CommonDialog.this.mOnBtnClickListener != null) {
                    CommonDialog.this.mOnBtnClickListener.onCancelClick();
                }
                if(!CommonDialog.this.mIsCustomDismiss) {
                    CommonDialog.this.dismiss();
                }
            }
        });
        this.iv_title_icon.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                if(CommonDialog.this.mOnBtnClickListener != null) {
                    CommonDialog.this.mOnBtnClickListener.onIconClick();
                }
                if(!CommonDialog.this.mIsCustomDismiss) {
                    CommonDialog.this.dismiss();
                }
            }
        });
    }

    public CommonDialog setButtonText(String[] arr_s) {
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

    public CommonDialog setCancelEnabled(boolean z) {
        this.btn_cancel.setEnabled(z);
        return this;
    }

    public CommonDialog setCancelSelected(boolean z) {
        this.btn_cancel.setSelected(z);
        return this;
    }

    public CommonDialog setContent(String s) {
        this.tv_content.setText(s);
        this.tv_content.setVisibility((TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE));
        return this;
    }

    public void setContentGravity(int v) {
        if(this.tv_content != null) {
            this.tv_content.setGravity(v);
        }
    }

    public void setCustomDismiss(boolean z) {
        this.mIsCustomDismiss = z;
    }

    public CommonDialog setOnBtnClickListener(OnBtnClickListener commonDialog$OnBtnClickListener0) {
        this.mOnBtnClickListener = commonDialog$OnBtnClickListener0;
        return this;
    }

    public CommonDialog setSureEnabled(boolean z) {
        this.btn_sure.setEnabled(z);
        return this;
    }

    public CommonDialog setSureSelected(boolean z) {
        this.btn_sure.setSelected(z);
        return this;
    }

    public CommonDialog setTitle(String s) {
        int v = View.GONE;
        this.layout_title_icon.setVisibility(View.GONE);
        this.tv_title.setText(s);
        TextView textView0 = this.tv_title;
        if(!TextUtils.isEmpty(s)) {
            v = View.VISIBLE;
        }
        textView0.setVisibility(v);
        return this;
    }

    public CommonDialog setTitleAndIcon(String s, int v) {
        this.tv_title.setVisibility(View.GONE);
        this.tv_title_icon.setText(s);
        this.iv_title_icon.setImageResource(v);
        this.layout_title_icon.setVisibility(View.VISIBLE);
        return this;
    }
}

