package com.santiago.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @note: Minimum views required is 5. Since we need views older to get destroyed for reusing them
 */
public class InfiniteViewAdapter extends PagerAdapter {

    private List<? extends View> data;

    public InfiniteViewAdapter(List<? extends View> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        // warning: scrolling to very high values (1,000,000+) results in
        // strange drawing behaviour
        return Integer.MAX_VALUE;
    }

    public int getRealCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % getRealCount();

        container.addView(data.get(virtualPosition));
        container.setTag(data.get(virtualPosition));
        return data.get(virtualPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int virtualPosition = position % getRealCount();
        return (CharSequence) data.get(virtualPosition).getTag();
    }

}

