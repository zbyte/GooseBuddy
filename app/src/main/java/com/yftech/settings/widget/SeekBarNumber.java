package com.yftech.settings.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Message;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.yftech.settings.base.BaseHandler;

import ru.gs8club.goosebuddy.R;

public class SeekBarNumber extends AppCompatSeekBar implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    public interface OnSeekChangeListener {
        void onProgressChanged(SeekBarNumber arg1, int arg2);

        void onStartTrackingTouch(SeekBarNumber arg1);

        void onStopTrackingTouch(SeekBarNumber arg1);
    }

    static class SeekBarNumberHandler extends BaseHandler {
        public SeekBarNumberHandler(SeekBarNumber seekBarNumber0) {
            super(seekBarNumber0);
        }

        public void handleMessageProcess(Message message0, SeekBarNumber seekBarNumber0) {
            seekBarNumber0.handleMessage(message0);
        }

        @Override  // com.yftech.settings.base.BaseHandler
        public void handleMessageProcess(Message message0, Object object0) {
            this.handleMessageProcess(message0, ((SeekBarNumber)object0));
        }
    }

    private static final int MSG_RESET_TYPE = 1001;
    private static final int PLAY_SOUND_MOVE_COUNT = 15;
    private static final int TYPE_NORMAL = 2;
    private static final int TYPE_WARNING = 1;
    private int mCurrType;
    private SeekBarNumberHandler mHandler;
    private boolean mIsMoveOutside;
    private boolean mIsPaintProgress;
    private int mLayoutDirection;
    private OnSeekChangeListener mListener;
    private int mMoveCount;
    private int mMoveOutsideProgress;
    private boolean mMoving;
    private int mNumberMin;
    private Paint mProgressPaint;
    private int mStartSeek;
    private Drawable mThumbNormal;
    private Drawable mThumbPress;
    private int mThumbWidthSub;
    private int mWarnMax;

    public SeekBarNumber(Context context0) {
        super(context0);
        this.mCurrType = 2;
        this.mMoveCount = 0;
        this.mNumberMin = 0;
        this.mIsPaintProgress = false;
        this.mIsMoveOutside = false;
        this.mMoveOutsideProgress = 0;
        this.mLayoutDirection = 0;
        this.initView();
    }

    public SeekBarNumber(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.mCurrType = 2;
        this.mMoveCount = 0;
        this.mNumberMin = 0;
        this.mIsPaintProgress = false;
        this.mIsMoveOutside = false;
        this.mMoveOutsideProgress = 0;
        this.mLayoutDirection = 0;
        this.initView();
    }

    public SeekBarNumber(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.mCurrType = 2;
        this.mMoveCount = 0;
        this.mNumberMin = 0;
        this.mIsPaintProgress = false;
        this.mIsMoveOutside = false;
        this.mMoveOutsideProgress = 0;
        this.mLayoutDirection = 0;
        this.initView();
    }

    private void drawProgressPaint(int v, Rect rect0, Canvas canvas0) {
        int v6;
        int v1 = 0;
        int v2 = this.getWidth() / 2;
        int v3 = this.getHeight() / 2;
        int v4 = this.getHeight() / 2;
        if(v == 0) {
            v6 = v2;
        }
        else if(v >= 0) {
            if(this.mLayoutDirection == 1) {
                int v8 = rect0.right;
                if(!this.mMoving) {
                    v1 = this.mThumbWidthSub;
                }
                v6 = v8 + v1 - 2;
                if(v6 > v2) {
                    v6 = v2;
                }
            }
            else {
                int v9 = rect0.left;
                if(!this.mMoving) {
                    v1 = this.mThumbWidthSub;
                }
                v6 = v9 + v1 + 2;
                if(v6 < v2) {
                    v6 = v2;
                }
            }
        }
        else if(this.mLayoutDirection == 1) {
            int v5 = rect0.left;
            if(!this.mMoving) {
                v1 = this.mThumbWidthSub;
            }
            v6 = v5 + v1 + 2;
            if(v6 < v2) {
                v6 = v2;
            }
        }
        else {
            int v7 = rect0.right;
            if(!this.mMoving) {
                v1 = this.mThumbWidthSub;
            }
            v6 = v7 + v1 - 2;
            if(v6 > v2) {
                v6 = v2;
            }
        }
        canvas0.drawLine(((float)v2), ((float)v3), ((float)v6), ((float)v4), this.mProgressPaint);
    }

    public int getMoveOutsideProgress() {
        return this.mMoveOutsideProgress;
    }

    private void handleMessage(Message message0) {
        if(message0.what == 1001) {
            this.mCurrType = 1;
        }
    }

    private void initProgressPaint() {
        this.mProgressPaint = new Paint();
        LinearGradient linearGradient0 = new LinearGradient(0.0f, 0.0f, 472.0f, 12.0f, new int[]{0xFFFFB05C, 0xFFFF7611, 0xFFFFB05C}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.mProgressPaint.setShader(linearGradient0);
        this.mProgressPaint.setStrokeWidth(12.0f);
    }

    private void initView() {
        this.mHandler = new SeekBarNumberHandler(this);
        this.mWarnMax = this.getMax();
        this.setOnSeekBarChangeListener(this);
        this.setOnTouchListener(this);
        this.initProgressPaint();
        this.mThumbNormal = this.getContext().getDrawable(R.mipmap.slider_nor2);  // mipmap:slider_nor2
        this.mThumbPress = this.getContext().getDrawable(R.mipmap.slider_nor1);  // mipmap:slider_nor1
        this.mThumbWidthSub = Math.abs(this.mThumbNormal.getIntrinsicWidth() - this.mThumbPress.getIntrinsicWidth()) / 2;
        this.setThumb(this.mThumbNormal);
        this.mLayoutDirection = this.getResources().getConfiguration().getLayoutDirection();
    }

    public boolean isMoveOutside() {
        return this.mIsMoveOutside;
    }

    @Override  // androidx.appcompat.widget.AppCompatSeekBar
    protected void onDraw(Canvas canvas0) {
        synchronized(this) {
            super.onDraw(canvas0);
            if(this.mIsPaintProgress) {
                canvas0.save();
                this.drawProgressPaint(this.getProgress() + this.mNumberMin, this.getThumb().getBounds(), canvas0);
                canvas0.restore();
            }
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        if(!z) {
            return;
        }
        if(this.mCurrType == 1 && this.mStartSeek <= this.mWarnMax && v > this.mWarnMax) {
            if(this.mListener != null) {
                this.mListener.onProgressChanged(this, this.mWarnMax);
            }
            return;
        }
        if(this.mListener != null) {
            this.mListener.onProgressChanged(this, v);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
        this.mMoving = true;
        this.mStartSeek = seekBar0.getProgress();
        this.setThumb(this.mThumbPress);
        if(this.mListener != null) {
            this.mListener.onStartTrackingTouch(this);
        }
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
        this.mMoving = false;
        int v = seekBar0.getProgress();
        this.setThumb(this.mThumbNormal);
        boolean z = true;
        if(this.mCurrType == 1 && this.mStartSeek <= this.mWarnMax && v > this.mWarnMax) {
            this.setProgress(this.mWarnMax);
            this.mCurrType = 2;
            this.mHandler.removeMessages(1001);
            this.mHandler.sendEmptyMessageDelayed(1001, 5000L);
        }
        Log.i("SeekBarNumber", "moveCount:" + this.mMoveCount);
        if(this.mMoveCount <= 15) {
            AudioManager audioManager0 = (AudioManager)this.getContext().getSystemService(Context.AUDIO_SERVICE);
            if(Settings.System.getInt(this.getContext().getContentResolver(), "sound_effects_enabled", 0) != 1) {
                z = false;
            }
            if(z) {
                audioManager0.playSoundEffect(AudioManager.FX_KEY_CLICK);
            }
        }
        this.mMoveCount = 0;
        if(this.mListener != null) {
            this.mListener.onStopTrackingTouch(this);
        }
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 0: {
                this.mMoveCount = 0;
                return false;
            }
            case 2: {
                ++this.mMoveCount;
                return false;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // android.widget.AbsSeekBar
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if((Float.compare(motionEvent0.getX(), -150.0f) < 0 || motionEvent0.getX() > ((float)(this.getWidth() + 150)) || motionEvent0.getY() < -30.0f) || (motionEvent0.getY() > ((float)(this.getHeight() + 30)))) {
            this.mIsMoveOutside = true;
            this.mMoveOutsideProgress = this.getProgress();
        }
        boolean z = super.onTouchEvent(motionEvent0);
        if(motionEvent0.getAction() == 1) {
            this.mIsMoveOutside = false;
        }
        return z;
    }

    public void setNumberMin(int v) {
        this.mNumberMin = v;
    }

    public void setOnSeekChangeListener(OnSeekChangeListener seekBarNumber$OnSeekChangeListener0) {
        this.mListener = seekBarNumber$OnSeekChangeListener0;
    }

    public void setPaintProgress(boolean z) {
        this.mIsPaintProgress = z;
    }

    public void setShowWarn(boolean z) {
        this.mCurrType = z ? 1 : 2;
    }

    public void setWarnMax(int v) {
        this.mWarnMax = v;
    }
}

