package com.portgas.view.demo;


import static android.support.v7.widget.LinearLayoutManager.HORIZONTAL;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.portgas.view.ZoomRecyclerView;

public class MainActivity extends AppCompatActivity {

  private ZoomRecyclerView mRecyclerView;
  private DemoAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
    initData();
  }

  private void initView() {
    //recyclerView
    mRecyclerView = findViewById(R.id.zoomRv);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setEnableScale(true);
    mAdapter = new DemoAdapter();
    mRecyclerView.setAdapter(mAdapter);

    //button
    findViewById(R.id.scale).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        boolean old = mRecyclerView.isEnableScale();
        mRecyclerView.setEnableScale(!old);
        if (!old) {
          Toast.makeText(MainActivity.this, "打开缩放", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(MainActivity.this, "禁用缩放", Toast.LENGTH_SHORT).show();
        }
      }
    });

    findViewById(R.id.orientation).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
        int o = layoutManager.getOrientation();
        if (o == VERTICAL) {
          layoutManager.setOrientation(HORIZONTAL);
          Toast.makeText(MainActivity.this, "横向", Toast.LENGTH_LONG).show();
        } else {
          layoutManager.setOrientation(VERTICAL);
          Toast.makeText(MainActivity.this, "竖向", Toast.LENGTH_LONG).show();
        }
      }
    });
  }

  private void initData() {

  }
}
