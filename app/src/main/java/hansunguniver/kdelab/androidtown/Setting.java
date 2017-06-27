package hansunguniver.kdelab.androidtown;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hansunguniver.kdelab.MainActivity;
import hansunguniver.kdelab.R;

/**
 * Created by pmins on 2016-09-12.
 */
public class Setting extends Fragment {

    View vi;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
            Log.d(MainActivity.TAG, "(화면 2) Start");
            vi = inflater.inflate(R.layout.setting, container, false);

            return vi;

        }
}
