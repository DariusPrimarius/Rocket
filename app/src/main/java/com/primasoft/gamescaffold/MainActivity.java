package com.primasoft.gamescaffold;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.os.Bundle;

/**
 * MainActivity is the entry point to our application.
 */

//default extends appcompatactivity
public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity.java", "onCreate()");
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onStart() {
        // Set content view to game, so that objects in the Game class can be rendered to the screen
        game = new Game(this);
        setContentView(game);
        Log.d("MainActivity.java", "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("MainActivity.java", "onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity.java", "onPause()");
        game.pause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity.java", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity.java", "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        // Comment out "super.onBackPressed()" to disable button
        //super.onBackPressed();
    }
}