package com.bwie.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity{
    private RadioGroup rg;
    private ViewPager vp;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private  RadioButton radioButton3;
    private RadioButton radioButton4;
    private List<Fragment>list;
    private RadioButton[]radioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg= (RadioGroup) findViewById(R.id.rg);
        vp= (ViewPager) findViewById(R.id.vp);
        radioButton= (RadioButton) findViewById(R.id.radio);
        radioButton2= (RadioButton) findViewById(R.id.radio1);
        radioButton3= (RadioButton) findViewById(R.id.radio2);
        radioButton4= (RadioButton) findViewById(R.id.radio3);
        radioButtons=new RadioButton[]{radioButton,radioButton2,radioButton3,radioButton4};
        init();
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        setcolor(0);
        vp.setCurrentItem(0);
     /*   rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case  R.id.radio:
                        setcolor(0);
                        vp.setCurrentItem(0);
                    case  R.id.radio1:
                        setcolor(1);
                        vp.setCurrentItem(1);
                    case  R.id.radio2:
                        setcolor(2);
                        vp.setCurrentItem(2);
                    case  R.id.radio3:
                        setcolor(3);
                        vp.setCurrentItem(3);

                }
            }
        });*/


    }

    private void init() {
        list=new ArrayList<Fragment>();
        list.add(new A());
        list.add(new B());
        list.add(new C());
        list.add(new D());
    }
    private void setcolor(int index) {
        for (int i=0;i<radioButtons.length;i++){
            if(i==index){
                radioButtons[i].setTextColor(Color.YELLOW);
            }
            else {
                radioButtons[i].setTextColor(Color.BLACK);
            }
        }
    }
}





