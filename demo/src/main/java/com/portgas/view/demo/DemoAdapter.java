package com.portgas.view.demo;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DemoAdapter extends Adapter {


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_holder, null);
    return new DemoViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    DemoViewHolder demoViewHolder = (DemoViewHolder) holder;
    demoViewHolder.imageView.setImageResource(R.drawable.girl);
  }

  @Override
  public int getItemCount() {
    return 100;
  }

  private class DemoViewHolder extends ViewHolder {

    public ImageView imageView;

    public DemoViewHolder(View itemView) {
      super(itemView);
      imageView = itemView.findViewById(R.id.holder_iv);
    }
  }
}