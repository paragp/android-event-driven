package com.gamefriq.ottoexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView weatherText;
    private TextView cityText;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        weatherText = (TextView) findViewById(R.id.temp_text);
        cityText = (TextView) findViewById(R.id.city_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable Button
                button.setEnabled(false);

                index = index > 4 ? 0 : index;
                //start weather service
                DummyWeatherService.getWeatherService(getApplicationContext(), index++);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Register the Subscribing class on the Bus
        MainApplication.getBusInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Always unregister when a class should no longer be on the bus
        MainApplication.getBusInstance().unregister(this);
    }

    @Subscribe
    public void weatherAvailable(WeatherModel weatherModel) {
        // React to the event somehow!
        weatherText.setText(String.valueOf(weatherModel.getTemperature()));
        cityText.setText(weatherModel.getLocation());
        button.setEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
