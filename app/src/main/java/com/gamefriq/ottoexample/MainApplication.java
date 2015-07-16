package com.gamefriq.ottoexample;

import android.app.Application;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Custom Application class
 * Created by oyewale on 7/15/15.
 */
public class MainApplication extends Application {
    private static Bus bus;

    public static Bus getBusInstance(){
        if (bus == null){
            bus = new MainThreadBus();
        }
        return bus;
    }


}
