package Saif.Learning;

import android.app.Application;
import android.content.Context;

import io.reactivex.plugins.RxJavaPlugins;



public class BaseApps extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApps.context    = getApplicationContext();
    }

    public static Context getAppContext(){
        return BaseApps.context;
    }
}
