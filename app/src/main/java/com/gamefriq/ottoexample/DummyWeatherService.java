package com.gamefriq.ottoexample;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

/**
 * An dummy {@link IntentService} to load
 */
public class DummyWeatherService extends IntentService {

    private static final String EXTRA_PARAM1 = "com.gamefriq.ottoexample.extra.id";

    /**
     * Start the  weather service with location id
     *
     * @see IntentService
     */
    public static void getWeatherService(Context context, int id) {
        Intent intent = new Intent(context, DummyWeatherService.class);
        intent.putExtra(EXTRA_PARAM1, id);
        context.startService(intent);
    }


    public DummyWeatherService() {
        super("DummyWeatherService");
        MainApplication.getBusInstance().register(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            int id = intent.getIntExtra(EXTRA_PARAM1, 0);
            WeatherModel weather = WeatherModel.getDummyCityWeather(id);

            // Publish Weather Event
            MainApplication.getBusInstance().post(weather);
        }
    }

}
