package tw.com.flag.imooc_luckypan;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //這邊加入一個確認click flag
    public boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        View v = findViewById(R.id.back);
        v.getBackground().setAlpha(100);

        ImageView img1 = (ImageView)findViewById(R.id.imageview);
        ImageView img2 = (ImageView)findViewById(R.id.nife);
        ImageView img3 = (ImageView)findViewById(R.id.stop);

        img1.setImageResource(R.drawable.ppp);
        img2.setImageResource(R.drawable.nife);
        img3.setImageResource(R.drawable.stopbtn);


            // 動畫設定 (指定旋轉動畫) (startAngle, endAngle, rotateX, rotateY)
            Animation am = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            // 動畫開始到結束的執行時間 (1000 = 1 秒)
            am.setDuration( 200 );
            // 動畫重複次數 (-1 表示一直重複)
            am.setRepeatCount( -1 );
            // 圖片配置動畫
            img1.setAnimation(am);
            // 動畫開始
            am.startNow();



        //這邊以下設定title_bar的顯示內容
        TextView titlebar = (TextView)findViewById(R.id.title_bar);
        titlebar.setText("<注意!>這次遊戲更新 可以獲得的道具如下" +
                "  999999999999999999999999999999  " +
                "888888888888888888888888888888" +
                "77777777777777777777777777777777 Good luck~!" );
    }


    float i2;
    public void stopper(View view) {
        /**
         * 這邊實作 取random停止
         * 並且加入 時間序列來讓他找不同的ran value
         */
        ImageView img1 = (ImageView) findViewById(R.id.imageview);
        Random ran = new Random();
        long seed = System.currentTimeMillis();
        ran.setSeed(seed);
        i2 = (float) (ran.nextInt(360) + 1);

        if (!check) {
            // 動畫設定 (指定旋轉動畫) (startAngle, endAngle, rotateX, rotateY)
            Animation am = new RotateAnimation(0, i2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            // 動畫開始到結束的執行時間 (1000 = 1 秒)
            am.setDuration(500);
            // 動畫重複次數 (-1 表示一直重複)
            am.setRepeatCount(0);
            //設置圖片不會回去原點
            am.setFillAfter(true);
            // 圖片配置動畫
            img1.setAnimation(am);
            // 動畫開始
            am.startNow();
            if ((180 > (23 + i2) && 180 < (68 + i2)) || (540 > (23 + i2) && 540 < (68 + i2)))
                Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
            else if ((180 > (68 + i2) && 180 < (113 + i2)) || (540 > (68 + i2) && 540 < (113 + i2)))
                Toast.makeText(this, "恭喜獲得披薩", Toast.LENGTH_LONG).show();
            else if ((180 > (113 + i2) && 180 < (158 + i2)) || (540 > (113 + i2) && 540 < (158 + i2)))
                Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
            else if ((180 > (158 + i2) && 180 < (203 + i2)) || (540 > (158 + i2) && 540 < (203 + i2))) {
                Toast.makeText(this, "恭喜獲得素材系列", Toast.LENGTH_LONG).show();
//        Intent next = new Intent(this,weapon.class);
//        startActivity(next);
//        finish();
            }
//        Intent tou = new Intent(this,weapon.class);
//        startActivity(tou);
//        finish();
            else if ((180 > (i2 + 203) && 180 < (i2 + 248)) || (540 > (i2 + 203) && 540 < (i2 + 248)))
                Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
            else if ((180 > (i2 + 248) && 180 < (i2 + 293)) || (540 > (i2 + 248) && 540 < (i2 + 293)))
                Toast.makeText(this, "恭喜獲得寶玉", Toast.LENGTH_LONG).show();
            else if ((180 > (i2 + 293) && 180 < (i2 + 338)) || (540 > (i2 + 293) && 540 < (i2 + 338)))
                Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "恭喜獲得撈麵", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"請先點箭頭重新開始歐~",Toast.LENGTH_LONG).show();

            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.lem_resized);

            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("尼拿到")
                    .setMessage("肥宅的女友")
                    .setView(img)
                    .setPositiveButton("確定",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int id){
                            Log.d("Main","click");
                            go();
                        }
                    }).create();
            dialog.show();
        }

        check = true;
    }

    public void showGo(View view){
        go();
    }

        private void go(){
        check = false;
        Intent now_page = getIntent();
        finish();
        startActivity(now_page);
        Toast.makeText(this,"從新啟動露~!!",Toast.LENGTH_LONG).show();
        }



    }



