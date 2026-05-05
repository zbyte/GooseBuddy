package com.yftech.settings.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import ru.gs8club.goosebuddy.R;

public class ImageViewExt extends AppCompatImageView {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ScaleTypeMatrixExt {
    }

    public static final int SCALE_TYPE_MATRIX_CENTER_CROP = 3;
    public static final int SCALE_TYPE_MATRIX_LEFT_CROP = 1;
    public static final int SCALE_TYPE_MATRIX_RIGHT_CROP = 2;
    private int mScaleTypeMatrixExt;

    public ImageViewExt(Context context0) {
        this(context0, null);
    }

    public ImageViewExt(Context context0, @Nullable AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ImageViewExt(Context context0, @Nullable AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.init(context0, attributeSet0);
    }

    private void handScaleTypeMatrixExt() {
        float f1;
        float f;
        if(this.getScaleType() == ImageView.ScaleType.MATRIX && this.mScaleTypeMatrixExt != -1) {
            int v = this.getDrawable().getIntrinsicWidth();
            int v1 = this.getDrawable().getIntrinsicHeight();
            int v2 = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();
            int v3 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            if(v * v3 > v2 * v1) {
                f = ((float)v3) / ((float)v1);
                switch(this.mScaleTypeMatrixExt) {
                    case 2: {
                        f1 = ((float)v2) - ((float)v) * f;
                        break;
                    }
                    case 3: {
                        f1 = 0.5f * (((float)v2) - ((float)v) * f);
                        break;
                    }
                    default: {
                        f1 = 0.0f;
                    }
                }
            }
            else {
                f = ((float)v2) / ((float)v);
                f1 = 0.0f;
            }
            Matrix matrix0 = new Matrix();
            matrix0.setScale(f, f);
            matrix0.postTranslate(((float)Math.round(f1)), 0.0f);
            this.setImageMatrix(matrix0);
        }
    }

    protected void init(Context context0, @Nullable AttributeSet attributeSet0) {
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, R.styleable.ImageViewExt);
        this.mScaleTypeMatrixExt = typedArray0.getInt(R.styleable.ImageViewExt_ive_scale_type_matrix_ext, -1);
        typedArray0.recycle();
    }

    @Override  // android.view.View
    protected void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.handScaleTypeMatrixExt();
    }

    @Override  // android.view.View
    public void requestLayout() {
        super.requestLayout();
        this.handScaleTypeMatrixExt();
    }

    public void setScaleTypeMatrixExt(@ScaleTypeMatrixExt int v) {
        this.mScaleTypeMatrixExt = v;
        this.requestLayout();
    }
}

