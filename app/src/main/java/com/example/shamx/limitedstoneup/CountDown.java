//package com.example.shamx.limitedstoneup;
//
//import android.content.res.Resources;
//import android.os.CountDownTimer;
//import android.widget.TextView;
//
//import static android.app.PendingIntent.getActivity;
//import static com.example.shamx.limitedstoneup.R.id.timer;
//
///**
// * Created by shamx on 2017/10/07.
// */
//
//public class CountDown extends CountDownTimer {
//
//    public CountDown(long millisInFuture, long countDownInterval) {
//        super(millisInFuture, countDownInterval);
//    }
//    @Override
//    public void onTick(long millisUntilFinished) {
//
//            int time = (int)millisUntilFinished /1000;
//            ((TextView) new MainActivity().findViewById(timer)).setText("あと" + time + "秒");
//    }
//
//
//    @Override
//    public void onFinish() {
//
//    }
//}
