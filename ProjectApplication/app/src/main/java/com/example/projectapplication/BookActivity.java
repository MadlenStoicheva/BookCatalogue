package com.example.projectapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class BookActivity extends AppCompatActivity {

    String username;
    WebView webview;
    TextView textView;
    TextView textViewName;
    long startTime, timeInMilliseconds = 0;
    Handler customHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        username = getIntent().getStringExtra("email");

        webview = (WebView) findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setSupportZoom(true);
        webview.getSettings().setJavaScriptEnabled(true);
        String url = "http://4motivi.com/books/hill/grow.pdf";
        webview.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url);

        textView = (TextView) findViewById(R.id.textViewTimer);
        start();

        textViewName = (TextView) findViewById(R.id.textViewBookTitle);
    }

    public static String getDateFromMillis(long d) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(d);
    }

    public void start() {
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);
    }

    public void stop(View v) {
        customHandler.removeCallbacks(updateTimerThread);
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            textView.setText(getDateFromMillis(timeInMilliseconds));
            customHandler.postDelayed(this, 1000);
        }
    };


    //ot tuk zapochva za menuto
    // @Override
    public void onCreateOptionsMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.my_options_menu, menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.my_options_menu, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //respond to menu item selection

        switch (item.getItemId()) {

            case R.id.home:
                startActivity(new Intent(BookActivity.this, HomeActivity.class));

                return true;

            case R.id.books:
                startActivity(new Intent(BookActivity.this, AllBooksActivity.class));

                return true;

            case R.id.user:

                startActivity(new Intent(BookActivity.this, UserActivity.class));


                return true;


            case R.id.categoriesBooks:

                startActivity(new Intent (BookActivity.this, GenresBooksActivity.class));

                return true;

            case R.id.logout:

                startActivity(new Intent(BookActivity.this, LoginActivity.class));

                return true;


            default:

                return super.onOptionsItemSelected(item);

        }
    }
}