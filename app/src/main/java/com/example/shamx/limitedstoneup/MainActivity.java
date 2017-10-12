package com.example.shamx.limitedstoneup;


import android.content.Intent;
import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {
    //ARRAY_TOP 配列中身有の始まり, ARRAY_BOTTOM 配列中身有の終わり, ARRAY_SIDE 石の左右, ARRAY_UPDOWN 石の上下,
    //ARRAY_START 配列の始まり, ARRAY_END 配列の終わり, ARRAY_FULL 中身有の個数;
    private static final int ARRAY_TOP = 5, ARRAY_BOTTOM = 30, ARRAY_SIDE = 1, ARRAY_UPDOWN = 5,
            ARRAY_START = 0, ARRAY_END = 35, ARRAY_FULL = ARRAY_BOTTOM - ARRAY_TOP;
    private ImageButton imagebutton[] = new ImageButton[ARRAY_END];
    private TextView textView;
    public int allcount = 0;
    public int partcount = 0;
    private Button passbutton, startButton, returnButton;
    private int passcount, beforestn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setScreenStart();
        setContentView(R.layout.activity_main);
//        CountDown countDown = new CountDown(10000,100);
//        countDown.start();
        // idがgridLayoutのGridLayoutを取得
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        // TextViewの設定
        textView = new TextView(this);

        //空データ生成
        //OutofArrayException対策
        for(int i = ARRAY_START; i < ARRAY_TOP; i++) {
            // ボタンを1つ生成

            imagebutton[i] = new ImageButton(this);
        }
        for(int i = ARRAY_BOTTOM; i < ARRAY_END; i++) {
            // ボタンを1つ生成

            imagebutton[i] = new ImageButton(this);
        }

        // データ生成
        for(int i = ARRAY_TOP; i < ARRAY_BOTTOM; i++) {
            // ボタンを1つ生成

            imagebutton[i] = new ImageButton(this);
            imagebutton[i].setImageResource(R.drawable.stone);
            imagebutton[i].setPadding(15,15,15,15);
            imagebutton[i].setBackgroundColor(Color.rgb(255, 255, 255));
            // Tag を設定する
            imagebutton[i].setTag(i);
            imagebutton[i].setId(i);
            imagebutton[i].setEnabled(true);


            // GridLayoutにボタンを追加
            gridLayout.addView(imagebutton[i]);

            imagebutton[i].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                   // Log.d("test","text is " + ((ImageButton)view).getId());

                    view.setVisibility(View.INVISIBLE);
                    onClick_stone((ImageButton)view);
                }
            });




        }
        passbutton = (Button)findViewById(R.id.passButton);
        passbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                beforestn = 0;
                for (int i = ARRAY_TOP;i<ARRAY_BOTTOM;i++){
                    imagebutton[i].setEnabled(true);

                }
                passcount++;
                partcount = 0;
//                CountDown countDown = new CountDown(10000,100);
//                countDown.start();
                passbutton.setVisibility(View.INVISIBLE);
                TextView textView = (TextView) findViewById(R.id.textview1);

                textView.setText("0");
                if(1 == passcount % 2){
                    findViewById(R.id.after).setVisibility(View.VISIBLE);
                    findViewById(R.id.before).setVisibility(View.GONE);
                }
                else {
                    findViewById(R.id.after).setVisibility(View.GONE);
                    findViewById(R.id.before).setVisibility(View.VISIBLE);
                }


            }


        });




    }

    public void onClick_stone(View view){



        Log.d("stntest", "onClick_beforestn: " + beforestn);
        int stnNo = view.getId();

        Log.d("stntest", "onClick_stone: " + stnNo);
        Log.d("stntest", "onClick_partcount: " + partcount);


        findViewById(R.id.before).setVisibility(View.VISIBLE);
        findViewById(R.id.return_button).setVisibility(View.GONE);

        //1石目の有効石設定
        //+-5は縦,+-1は横
        if (partcount == 0){
            for (int i = ARRAY_TOP;i<ARRAY_BOTTOM;i++){
                imagebutton[i].setEnabled(false);

            }
            switch (stnNo){
                case ARRAY_TOP:
                    Log.d(" test Limitter Removal", String.valueOf(stnNo+ARRAY_UPDOWN) +" : " + String.valueOf(stnNo+ARRAY_SIDE));
                    imagebutton[stnNo + ARRAY_UPDOWN].setEnabled(true);
                    imagebutton[stnNo + ARRAY_SIDE].setEnabled(true);
                    break;
                case 6:
                case 7:
                case 8:
                case 9:
                    Log.d(" test Limitter Removal", String.valueOf(stnNo+ARRAY_UPDOWN) +" : " + String.valueOf(stnNo+ARRAY_SIDE)+" : " + String.valueOf(stnNo-ARRAY_SIDE));
                    imagebutton[stnNo+ARRAY_UPDOWN].setEnabled(true);
                    imagebutton[stnNo+ARRAY_SIDE].setEnabled(true);
                    imagebutton[stnNo-ARRAY_SIDE].setEnabled(true);
                    break;
                case 25:
                case 26:
                case 27:
                case 28:
                    Log.d(" test Limitter Removal", String.valueOf(stnNo-ARRAY_UPDOWN) +" : " + String.valueOf(stnNo+ARRAY_SIDE)+" : " + String.valueOf(stnNo-ARRAY_SIDE));
                    imagebutton[stnNo+ARRAY_SIDE].setEnabled(true);
                    imagebutton[stnNo-ARRAY_UPDOWN].setEnabled(true);
                    imagebutton[stnNo-ARRAY_SIDE].setEnabled(true);
                    break;
                case 29:
                    Log.d(" test Limitter Removal", String.valueOf(stnNo-ARRAY_UPDOWN) + String.valueOf(stnNo-ARRAY_SIDE));
                    imagebutton[stnNo-ARRAY_UPDOWN].setEnabled(true);
                    imagebutton[stnNo-ARRAY_SIDE].setEnabled(true);
                    break;
                default:
                    Log.d(" test Limitter Removal", String.valueOf(stnNo-ARRAY_UPDOWN) +" : " + String.valueOf(stnNo+ARRAY_SIDE)+" : " + String.valueOf(stnNo-ARRAY_SIDE)+" : " + String.valueOf(stnNo+ARRAY_UPDOWN));
                    imagebutton[stnNo+ARRAY_UPDOWN].setEnabled(true);
                    imagebutton[stnNo+ARRAY_SIDE].setEnabled(true);
                    imagebutton[stnNo-ARRAY_UPDOWN].setEnabled(true);
                    imagebutton[stnNo-ARRAY_SIDE].setEnabled(true);
                    break;
            }
        }

        else{

            //縦に制限
            if (stnNo == (beforestn+ARRAY_UPDOWN)){
                Log.d(" test Limitter Change","OK " + String.valueOf(stnNo+ARRAY_UPDOWN) +" NG " + String.valueOf(beforestn+ARRAY_SIDE)+" : " + String.valueOf(beforestn-ARRAY_SIDE));
                imagebutton[beforestn+ARRAY_SIDE].setEnabled(false);
                imagebutton[stnNo+ARRAY_UPDOWN].setEnabled(true);
                imagebutton[beforestn-ARRAY_SIDE].setEnabled(false);
            }
            else if (stnNo == (beforestn-ARRAY_UPDOWN)){
                Log.d(" test Limitter Change","OK " + String.valueOf(stnNo-ARRAY_UPDOWN) +" NG " + String.valueOf(beforestn+ARRAY_SIDE)+" : " + String.valueOf(beforestn-ARRAY_SIDE));
                imagebutton[beforestn+ARRAY_SIDE].setEnabled(false);
                imagebutton[stnNo-ARRAY_UPDOWN].setEnabled(true);
                imagebutton[beforestn-ARRAY_SIDE].setEnabled(false);
            }

            //横に制限
            else if (stnNo == (beforestn+ARRAY_SIDE)) {
                Log.d(" test Limitter Change","OK " + String.valueOf(stnNo+ARRAY_SIDE) +" NG " + String.valueOf(beforestn-ARRAY_UPDOWN)+" : " + String.valueOf(beforestn+ARRAY_UPDOWN));
                imagebutton[beforestn + ARRAY_UPDOWN].setEnabled(false);
                imagebutton[stnNo + ARRAY_SIDE].setEnabled(true);
                imagebutton[beforestn - ARRAY_UPDOWN].setEnabled(false);
            }
            else if (stnNo == (beforestn-ARRAY_SIDE) ) {
                Log.d(" test Limitter Change","OK " + String.valueOf(stnNo-ARRAY_SIDE) +" NG " + String.valueOf(beforestn-ARRAY_UPDOWN)+" : " + String.valueOf(beforestn+ARRAY_UPDOWN));
                imagebutton[beforestn + ARRAY_UPDOWN].setEnabled(false);
                imagebutton[stnNo - ARRAY_SIDE].setEnabled(true);
                imagebutton[beforestn - ARRAY_UPDOWN].setEnabled(false);
            }

        }
        partcount++;
        allcount++;
        beforestn = stnNo;
        passbutton = (Button)findViewById(R.id.passButton);

        //最後の石を取ったとき
        if (allcount == ARRAY_FULL) {
            TextView textWinner = (TextView)findViewById(R.id.textWinner) ;
            textWinner.setVisibility(View.VISIBLE);

            Button again_button = (Button)findViewById(R.id.again);
            again_button.setVisibility(View.VISIBLE);
            again_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    reload();
                }
            });
            findViewById(R.id.return_button).setVisibility(View.VISIBLE);
            if(1 == passcount % 2){
                textWinner.setBackgroundColor(0xffff0000);
                textWinner.setText("先手勝利");

            }
            else {

                textWinner.setText("後手勝利");
                textWinner.setBackgroundColor(0xff0000ff);

            }
        }
        else {
            TextView textView = (TextView) findViewById(R.id.textview1);


            if (partcount == 1) {
                textView.setText("1");

                passbutton.setVisibility(View.VISIBLE);

            }
            else if (partcount == 2){
                textView.setText("2");

            }
            else{

                passbutton.performClick();
            }




            }
        }

    private void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();

        overridePendingTransition(0, 0);
        startActivity(intent);
    }


//    private void setScreenStart(){
//        setContentView(R.layout.activity_start);
//        startButton = (Button) findViewById(R.id.send_button);
//
//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setScreenMain();
//            }
//        });
//    }
//    private void setScreenMain(){
//        setContentView(R.layout.activity_main);
//        returnButton = (Button) findViewById(R.id.return_button);
//        returnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setScreenStart();
//            }
//        });
//    }
//    private void setScreenExplain(){
//        setContentView(R.layout.activity_explain);
//        returnButton = (Button) findViewById(R.id.return_button);
//        returnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setScreenMain();
//            }
//        });
//    }
    }






