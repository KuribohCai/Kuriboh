package com.studio.cai.mysuperdemo.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.studio.cai.mysuperdemo.R;
import com.studio.cai.mysuperdemo.widget.ZQImageViewRoundOval;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 瀑布流
 * Created by Administrator Kuriboh on 2017/5/10.
 */
public class WaterFallActivity extends FragmentActivity {
    @BindView(R.id.waterfall_recycler)
    RecyclerView mWaterfallRecycler;

    private WaterfallAdapter mAdapter;
    private ArrayList<WaterfallItemBean> mTextDataList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        ButterKnife.bind(this);

        // recyclerView 瀑布流 6行
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6);
        // 设置合并行数
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                // 根据position获取适配器中数据
                WaterfallItemBean itemBean = mAdapter.getTextDataList().get(position);
                switch (itemBean.getType()) {
                    // 2个
                    case 0:
                        return 3;
                    // 3个
                    case 1:
                        return 2;
                    // 默认
                    default:
                        return 6;
                }

            }
        });
        // 获取测试数据
        getTextData();
        // 配置recyclerview
        mWaterfallRecycler.setLayoutManager(gridLayoutManager);
        // 设置item动画
        mWaterfallRecycler.setItemAnimator(new DefaultItemAnimator());
        // 创建适配器
        mAdapter = new WaterfallAdapter(this, mTextDataList);
        // 设配适配器
        mWaterfallRecycler.setAdapter(mAdapter);
    }

    private void getTextData() {
        mTextDataList = new ArrayList<WaterfallItemBean>();
        for (int i = 0; i < 6; i++) {
            String name = "第" + i + "个";
            int type = 0;
            name += "景点";
            if (i % 6 != 1 && i % 6 != 2) {
                type = 1;
                name += "2";
            }
            if (i % 6 == 0) {
                type = -1;
                name = "国内特价";
            }
            mTextDataList.add(new WaterfallItemBean(type, name));
        }
    }

    class WaterfallAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private Context mContext;
        private ArrayList<WaterfallItemBean> mTextDataList;

        public WaterfallAdapter(WaterFallActivity waterFallActivity, ArrayList<WaterfallItemBean> textDataList) {
            this.mContext = waterFallActivity;
            this.mTextDataList = textDataList;
        }

        public ArrayList<WaterfallItemBean> getTextDataList() {
            return mTextDataList;
        }

        public void setTextDataList(ArrayList<WaterfallItemBean> textDataList) {
            mTextDataList = textDataList;
        }

        @Override
        public int getItemViewType(int position) {
            if (position % 6 == 0) {
                // 标签
                return 0;
            } else {
                // 图片
                return 1;
            }
        }
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == 0) {
                view = View.inflate(mContext,R.layout.item_waterfall_text, null);
                return new WaterfallHoloder2(view);
            } else {
                view = View.inflate(mContext, R.layout.item_waterfall, null);
                return new WaterfallHoloder(view);
            }

        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            WaterfallItemBean itemBean = mTextDataList.get(position);
            switch (getItemViewType(position)) {
                case 0:
                    ((WaterfallHoloder2) holder).mItemWaterfallText.setText(itemBean.getName());
                    break;
                case 1:
                    ((WaterfallHoloder) holder).mItemWaterfallText.setText(itemBean.getName());
                    Glide.with(mContext)
                            .load("http://img07.tooopen.com/images/20170427/tooopen_sy_207057725658.jpg")
                            .placeholder(R.drawable.ic_launcher) // can also be a drawable
                            .error(R.drawable.ic_launcher) // will be displayed if the image cannot be loaded
                            .centerCrop()
                            .into(((WaterfallHoloder) holder).mItemWaterfallImag);
                    break;
                default:
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return mTextDataList.size();
        }

        private ZQImageViewRoundOval iv_roundRect;//圆角矩形图片

        public class WaterfallHoloder extends RecyclerView.ViewHolder {

            @BindView(R.id.item_waterfall_text)
            TextView mItemWaterfallText;
            @BindView(R.id.item_waterfall_imag)
            ZQImageViewRoundOval mItemWaterfallImag;


            public WaterfallHoloder(View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
                mItemWaterfallImag.setType(ZQImageViewRoundOval.TYPE_ROUND);
                mItemWaterfallImag.setRoundRadius(15);//矩形凹行大小
            }
        }

        public class WaterfallHoloder2 extends RecyclerView.ViewHolder {
            TextView mItemWaterfallText;

            public WaterfallHoloder2(View itemView) {
                super(itemView);
                mItemWaterfallText = (TextView) itemView.findViewById(R.id.item_waterfall_text);
            }
        }
    }



    class WaterfallItemBean {
        private int type;
        private String name;

        public WaterfallItemBean(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
