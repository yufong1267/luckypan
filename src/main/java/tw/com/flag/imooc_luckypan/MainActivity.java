package tw.com.flag.imooc_luckypan;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ImageView img1 = (ImageView)findViewById(R.id.imageview);
        ImageView img2 = (ImageView)findViewById(R.id.head);
        img1.setImageResource(R.drawable.ppp);
        img2.setImageResource(R.drawable.ppw);

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
    }


    float i2;
    public void stopper(View view)
    {
        /**
         * 這邊實作 取random停止
         * 並且加入 時間序列來讓他找不同的ran value
         */
        ImageView img1 = (ImageView)findViewById(R.id.imageview);
        Random ran = new Random();
        long seed = System.currentTimeMillis();
        ran.setSeed(seed);
        i2 = (float)(ran.nextInt(360) + 1);



        // 動畫設定 (指定旋轉動畫) (startAngle, endAngle, rotateX, rotateY)
        Animation am = new RotateAnimation(0, i2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // 動畫開始到結束的執行時間 (1000 = 1 秒)
        am.setDuration( 500 );
        // 動畫重複次數 (-1 表示一直重複)
        am.setRepeatCount( 1 );
        //設置圖片不會回去原點
        am.setFillAfter(true);
        // 圖片配置動畫
        img1.setAnimation(am);
        // 動畫開始
        am.startNow();
        if(i2>23 && i2<68)
        Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
        else if(i2>68 && i2<113)
            Toast.makeText(this, "恭喜獲得披薩", Toast.LENGTH_LONG).show();
        else if(i2>113 && i2<158)
            Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
        else if(i2>158 && i2<203)
            Toast.makeText(this, "恭喜獲得素材", Toast.LENGTH_LONG).show();
        else if(i2>203 && i2<248)
            Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
        else if(i2>248 && i2<293)
            Toast.makeText(this, "恭喜獲得寶玉", Toast.LENGTH_LONG).show();
        else if(i2>293 && i2<338)
            Toast.makeText(this, "恭喜獲得黃金", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "恭喜獲得撈麵", Toast.LENGTH_LONG).show();
    }


}
