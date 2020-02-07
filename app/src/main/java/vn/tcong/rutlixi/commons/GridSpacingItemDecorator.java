package vn.tcong.rutlixi.commons;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class GridSpacingItemDecorator extends RecyclerView.ItemDecoration {
    private int mSpanCount;
    private int mSpacing;

    public GridSpacingItemDecorator(int mSpanCount, int mSpacing) {
        this.mSpanCount = mSpanCount;
        this.mSpacing = mSpacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//        Log.d("OK", "posotion: " + position);
        final int position = parent.getChildLayoutPosition(view);
        final int column = position % mSpanCount;
        final int parentWidth = parent.getWidth();
        outRect.left = mSpacing - column * mSpacing / mSpanCount;
        outRect.right = (column + 1) * mSpacing / mSpanCount;

        if (position < mSpanCount) {
            outRect.top = mSpacing;
        }
        outRect.bottom = mSpacing;
        super.getItemOffsets(outRect, view, parent, state);
    }
}
