package com.zhaoss.newqqslidemenu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private MainRelativeLayout mainLayout;
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    private String[] datas = {"中文", "英语", "韩语", "日语", "法语", "德语", "俄语", "西班牙", "阿拉伯"};
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initData();
    }

    private void initData() {

        viewPager.setAdapter(new ViewPagerAdapter(this));
        recyclerView.setAdapter(new MyAdapter(this, datas));

        mainLayout.setOnMenuChangeStateListener(new MainRelativeLayout.OnMenuChangeStateListener() {
            @Override
            public void onOpen() {
                System.out.print("leftMenu被打开");
                myHandler.removeMessages(0);
            }

            @Override
            public void onClose() {
                System.out.print("leftMenu被关闭");
                if (!myHandler.hasMessages(0)) {
                    myHandler.sendEmptyMessageDelayed(0, 1000);
                }
            }

            @Override
            public void onStartSlide() {
                System.out.print("leftMenu开始滑动");
                myHandler.removeMessages(0);
            }

            @Override
            public void onSlide(float pctSlide) {
                System.out.print("leftMenu滑动距离: " + pctSlide);
            }
        });

        myHandler = new MyHandler(viewPager);
        //myHandler.sendEmptyMessageDelayed(0, 1000);
    }

    static class MyHandler extends Handler{

        private ViewPager viewPager;
        MyHandler(ViewPager viewPager){
            this.viewPager = viewPager;
        }
        @Override
        public void handleMessage(Message msg) {
            if(viewPager.getCurrentItem() >= viewPager.getChildCount()-1){
                viewPager.setCurrentItem(0);
            }else{
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
            sendEmptyMessageDelayed(0, 1000);
        }
    }

    private void initUI() {

        mainLayout = (MainRelativeLayout) findViewById(R.id.mainLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        RelativeLayout rl_menu = (RelativeLayout) findViewById(R.id.rl_menu);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        rl_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.slideMenu();
            }
        });
    }
}












