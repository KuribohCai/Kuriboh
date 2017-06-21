package com.studio.cai.mysuperdemo.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.studio.cai.mysuperdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator Kuriboh on 2017/5/15.
 */

public class BannerSimpleActivity extends Activity {
    @BindView(R.id.roll_view_pager)
    RollPagerView mRollViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannersimple);
        ButterKnife.bind(this);
        // banner

        mRollViewPager.setAnimationDurtion(500);    //设置切换时间
        mRollViewPager.setAdapter(new BannerAdapter(mRollViewPager, this)); //设置适配器
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.BLUE, Color.GRAY));// 设置圆点指示器颜色
        // mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
    }


    public class BannerAdapter extends LoopPagerAdapter {
        private String[] imgs = {
                "http://img.t.388g.com/allimg/160606/3-160606113929-50.png",
                "http://img.t.388g.com/allimg/160606/3-160606114106.png",
                "http://img.t.388g.com/allimg/160606/3-160606114153.png"};  // 本地图片
        private int count = imgs.length;  // banner上图片的数量
        private Context mContext;

        public BannerAdapter(RollPagerView viewPager, Context context) {
            super(viewPager);
            mContext = context;
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(mContext);
            // glide
            Glide.with(mContext)
                    .load(imgs[position])
                    .placeholder(R.drawable.ic_launcher) // can also be a drawable
                    .centerCrop()
                    .error(R.drawable.ic_launcher) // will be displayed if the image cannot be loaded
                    .into(view);
            final int picNo = position + 1;
            view.setOnClickListener(new View.OnClickListener()      // 点击事件
            {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了第" + picNo + "张图片", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BannerSimpleActivity.this,BannerSimpleActivity2.class));
                }

            });

            return view;
        }

        @Override
        public int getRealCount() {
            return count;
        }
    }
}
