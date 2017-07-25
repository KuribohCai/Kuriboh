package com.studio.cai.mysuperdemo.rxjava_retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.studio.cai.mysuperdemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator Kuriboh on 2017/7/24.
 */

public class ZhuangBiAdapter extends RecyclerView.Adapter<ZhuangBiAdapter.MyViewHolder>{
    List<ZhuangbiImage> images;
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 带parent item外布局有效 但是 不能绑定外布局
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_elementary,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            ZhuangbiImage image = images.get(position);
            Glide.with(holder.itemView.getContext())
                    .load(image.image_url)
                    .into(myViewHolder.mImageViewIv);
            holder.mDescriptionTv.setText(image.description);
        }

        @Override
        public int getItemCount() {
            return images == null ? 0 : images.size();
        }

    public void setImages(List<ZhuangbiImage> images) {
        this.images = images;
        notifyDataSetChanged();
    }

class MyViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.imageIv)
            ImageView mImageViewIv;
            @BindView(R.id.descriptionTv)
            TextView mDescriptionTv;
            public MyViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

}

