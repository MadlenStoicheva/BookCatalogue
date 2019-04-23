package com.example.projectapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    TextView textViewUsername;
    Button buttonRead , buttonBooks;
    ImageView imageViewUser, imageViewBook1, imageViewBook2, imageViewBook3;
    String username;
    ImageView likeImage,likeImage2,likeImage3;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        username = getIntent().getStringExtra("username");

        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        this.textViewUsername.setText(username.toUpperCase());

        imageViewUser = (ImageView) findViewById(R.id.imageViewUser);
        this.imageViewUser.setImageResource(R.drawable.user_image);
        this.imageViewUser.setClipToOutline(true);

        imageViewBook1 = (ImageView) findViewById(R.id.imageViewB1);
        this.imageViewBook1.setImageResource(R.drawable.napoleone);

        imageViewBook2 = (ImageView) findViewById(R.id.imageViewB2);
        this.imageViewBook2.setImageResource(R.drawable.lord_of_the_rings);

        imageViewBook3 = (ImageView) findViewById(R.id.imageViewB3);
        this.imageViewBook3.setImageResource(R.drawable.lost_symbol);

        this.likeImage = (ImageView) findViewById(R.id.imageViewLike);
        this.likeImage.setImageResource(R.drawable.like_full);

        this.likeImage2 = (ImageView) findViewById(R.id.imageViewLike1);
        this.likeImage2.setImageResource(R.drawable.like_full);

        this.likeImage3 = (ImageView) findViewById(R.id.imageViewLike2);
        this.likeImage3.setImageResource(R.drawable.like_favorite);


        buttonRead = (Button) findViewById(R.id.buttonRead);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, BookActivity.class);
                startActivity(i);
            }
        });

        buttonBooks = (Button) findViewById(R.id.buttonBooks);
        buttonBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserActivity.this, AllBooksActivity.class);
                startActivity(i);
            }
        });

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
                startActivity(new Intent(UserActivity.this, HomeActivity.class));

                return true;

            case R.id.books:
                startActivity(new Intent(UserActivity.this, AllBooksActivity.class));

                return true;

            case R.id.user:

                Intent i = new Intent(this, UserActivity.class);
                i.putExtra("username",username);
                startActivity(i);

                return true;


            case R.id.categoriesBooks:

                startActivity(new Intent (UserActivity.this, GenresBooksActivity.class));

                return true;

            case R.id.logout:

                startActivity(new Intent(UserActivity.this, LoginActivity.class));

                return true;


            default:

                return super.onOptionsItemSelected(item);

        }
    }
}