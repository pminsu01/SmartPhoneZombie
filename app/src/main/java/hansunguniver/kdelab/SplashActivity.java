package hansunguniver.kdelab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by pmins on 2016-09-12.
 */
public class SplashActivity extends Activity{

    Handler mhandler;
    boolean isClick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        isClick = true;

        mhandler = new Handler();

        mhandler.postDelayed(new splashHandler(), 3000);
    }


    private class splashHandler implements Runnable {

        public void run() {

            startActivity(new Intent(getApplication(), MainActivity.class));
            SplashActivity.this.finish();
        }




    }

}
