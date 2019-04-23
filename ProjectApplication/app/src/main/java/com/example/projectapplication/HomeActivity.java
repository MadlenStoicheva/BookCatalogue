package com.example.projectapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    ImageView book1,book2,book3,book4;
    String username;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username = getIntent().getStringExtra("email");

        //BOOK 1

        this.book1 = (ImageView) findViewById(R.id.imageVBook1);
        this.book1.setImageResource(R.drawable.games);


        //BOOK 2

        this.book2 = (ImageView) findViewById(R.id.imageVBook2);
        this.book2.setImageResource(R.drawable.fault_in_our_stars);


        //BOOK 3

        this.book3 = (ImageView) findViewById(R.id.imageVBook3);
        this.book3.setImageResource(R.drawable.secret);


        //BOOK 4
        this.book4 = (ImageView) findViewById(R.id.imageVBook4);
        this.book4.setImageResource(R.drawable.kiosaki);

    }

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
                startActivity(new Intent(HomeActivity.this, HomeActivity.class));

                return true;

            case R.id.books:
                startActivity(new Intent(this, BooksInGenreActivity.class));

                return true;

            case R.id.user:

                Intent i = new Intent(this, UserActivity.class);
                i.putExtra("username",username);
                startActivity(i);

                return true;


            case R.id.categoriesBooks:

                startActivity(new Intent (this, GenresBooksActivity.class));

                return true;

            case R.id.logout:

                startActivity(new Intent(this, LoginActivity.class));

                return true;


            default:

                return super.onOptionsItemSelected(item);

        }
    }
}
