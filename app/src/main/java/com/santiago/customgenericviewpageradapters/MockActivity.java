package com.santiago.customgenericviewpageradapters;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.santiago.adapter.InfiniteViewAdapter;
import com.santiago.viewpager.InfiniteViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santiago on 24/03/16.
 */
public class MockActivity extends Activity {

    private InfiniteViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mock);

        viewPager = (InfiniteViewPager) findViewById(R.id.activity_mock_view_pager);

        List<View> views = new ArrayList<>();

        View viewZero = new View(this);
        viewZero.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        View viewOne = new View(this);
        viewOne.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        View viewTwo =  new View(this);
        viewTwo.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        View viewThree =  new View(this);
        viewThree.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));

        View viewFour = new View(this);
        viewFour.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        views.add(viewZero);
        views.add(viewOne);
        views.add(viewTwo);
        views.add(viewThree);
        views.add(viewFour);

        InfiniteViewAdapter adapter = new InfiniteViewAdapter(views);

        viewPager.setAdapter(adapter);
    }

}
