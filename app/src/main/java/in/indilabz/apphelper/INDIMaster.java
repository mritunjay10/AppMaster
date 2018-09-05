package in.indilabz.apphelper;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

public class INDIMaster extends Application implements Constants{

    public static Context applicationContext = null;
    private static INDIMaster indiMaster;

    @Override
    public void onCreate() {
        super.onCreate();
        indiMaster = this;

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        applicationContext = getApplicationContext();


    }

    public static synchronized INDIMaster getInstance() {
        return indiMaster;
    }

}
