package com.example.projectapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class GenresBooksActivity extends AppCompatActivity {

    ImageView book1,book2,book3,book4,book5,book6,book7,book8,book9,book10,book11;
    ImageView arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow7,arrow8,arrow9,arrow10,arrow11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genres_books);

        //BOOK 1

        this.book1 = (ImageView) findViewById(R.id.imageViewB1);
        this.book1.setImageResource(R.drawable.art);

        this.arrow1 = (ImageView) findViewById(R.id.imageViewIcon);
        this.arrow1.setImageResource(R.drawable.right_arrow);


        //BOOK 2

        this.book2 = (ImageView) findViewById(R.id.imageViewB2);
        this.book2.setImageResource(R.drawable.bussines_icon);

        this.arrow2 = (ImageView) findViewById(R.id.imageViewIcon1);
        this.arrow2.setImageResource(R.drawable.right_arrow);

        this.arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GenresBooksActivity.this, BooksInGenreActivity.class);
                startActivity(i);
            }
        });


        //BOOK 3

        this.book3 = (ImageView) findViewById(R.id.imageViewB3);
        this.book3.setImageResource(R.drawable.coding_icon);

        this.arrow3 = (ImageView) findViewById(R.id.imageViewIcon2);
        this.arrow3.setImageResource(R.drawable.right_arrow);


        //BOOK 4

        this.book4 = (ImageView) findViewById(R.id.imageViewB4);
        this.book4.setImageResource(R.drawable.puzzle_icon);

        this.arrow4 = (ImageView) findViewById(R.id.imageViewIcon3);
        this.arrow4.setImageResource(R.drawable.right_arrow);


        //BOOK 5

        this.book5 = (ImageView) findViewById(R.id.imageViewB5);
        this.book5.setImageResource(R.drawable.icon_health);

        this.arrow5 = (ImageView) findViewById(R.id.imageViewIcon4);
        this.arrow5.setImageResource(R.drawable.right_arrow);


        //BOOK 6

        this.book6 = (ImageView) findViewById(R.id.imageViewB6);
        this.book6.setImageResource(R.drawable.book_romance_icon);

        this.arrow6 = (ImageView) findViewById(R.id.imageViewIcon5);
        this.arrow6.setImageResource(R.drawable.right_arrow);

        //BOOK 7

        this.book7 = (ImageView) findViewById(R.id.imageViewB7);
        this.book7.setImageResource(R.drawable.cook_icon);

        this.arrow7 = (ImageView) findViewById(R.id.imageViewIcon6);
        this.arrow7.setImageResource(R.drawable.right_arrow);

        //BOOK 8

        this.book8 = (ImageView) findViewById(R.id.imageViewB8);
        this.book8.setImageResource(R.drawable.education);

        this.arrow8 = (ImageView) findViewById(R.id.imageViewIcon8);
        this.arrow8.setImageResource(R.drawable.right_arrow);

        //BOOK 9

        this.book9 = (ImageView) findViewById(R.id.imageViewB9);
        this.book9.setImageResource(R.drawable.travel);

        this.arrow9 = (ImageView) findViewById(R.id.imageViewIcon9);
        this.arrow9.setImageResource(R.drawable.right_arrow);

        //BOOK 10

        this.book10 = (ImageView) findViewById(R.id.imageViewB10);
        this.book10.setImageResource(R.drawable.selfhelp);

        this.arrow10 = (ImageView) findViewById(R.id.imageViewIcon10);
        this.arrow10.setImageResource(R.drawable.right_arrow);

        //BOOK 11

        this.book11 = (ImageView) findViewById(R.id.imageViewB11);
        this.book11.setImageResource(R.drawable.fantasy);

        this.arrow11 = (ImageView) findViewById(R.id.imageViewIcon11);
        this.arrow11.setImageResource(R.drawable.right_arrow);

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
                startActivity(new Intent(GenresBooksActivity.this, HomeActivity.class));

                return true;

            case R.id.books:
                startActivity(new Intent(this, AllBooksActivity.class));

                return true;

            case R.id.user:

                startActivity(new Intent(this, UserActivity.class));

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