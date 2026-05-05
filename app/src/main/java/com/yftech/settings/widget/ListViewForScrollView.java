package com.yftech.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListView;

public class ListViewForScrollView extends ListView {
    public ListViewForScrollView(Context context0) {
        super(context0);
    }

    public ListViewForScrollView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public ListViewForScrollView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // android.widget.ListView
    protected void onMeasure(int v, int v1) {
        super.onMeasure(v, View.MeasureSpec.makeMeasureSpec(0x1FFFFFFF, MeasureSpec.AT_MOST));
    }
}

