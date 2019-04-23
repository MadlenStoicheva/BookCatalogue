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
import android.widget.TextView;

public class AllBooksActivity extends AppCompatActivity {

    ImageView book1, book2, book3, book4, book5, book6;
    TextView titleBook1, titleBook2, titleBook3, titleBook4, titleBook5, titleBook6;
    TextView categoryB1, categoryB2, categoryB3, categoryB4, categoryB5, categoryB6;
    Button btnReadBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_all);



        //BOOK 1

        this.book1 = (ImageView) findViewById(R.id.allBooksI1);
        this.book1.setImageResource(R.drawable.book_cook_1);

        this.titleBook1 = (TextView) findViewById(R.id.allBooksT1);
        this.titleBook1.setText("The Joy of Cooking");

        this.categoryB1 = (TextView) findViewById(R.id.allBooksC1);
        this.categoryB1.setText("Category: Cook");

        //BOOK 2

        this.book2 = (ImageView) findViewById(R.id.allBooksI2);
        this.book2.setImageResource(R.drawable.book_photo_2);

        this.titleBook2 = (TextView) findViewById(R.id.allBooksT2);
        this.titleBook2.setText("The Digital Photography");

        this.categoryB2 = (TextView) findViewById(R.id.allBooksC2);
        this.categoryB2.setText("Category: Photography");

        //BOOK 3

        this.book3 = (ImageView) findViewById(R.id.allBooksI3);
        this.book3.setImageResource(R.drawable.book_bussines_3);

        this.titleBook3 = (TextView) findViewById(R.id.allBooksT3);
        this.titleBook3.setText("Think and Grow Rich");

        this.categoryB3 = (TextView) findViewById(R.id.allBooksC3);
        this.categoryB3.setText("Category: Bussines");

        //BOOK 4

        this.book4 = (ImageView) findViewById(R.id.allBooksI4);
        this.book4.setImageResource(R.drawable.book_music_4);

        this.titleBook4 = (TextView) findViewById(R.id.allBooksT4);
        this.titleBook4.setText("All You Need to Know about the Music Business");

        this.categoryB4 = (TextView) findViewById(R.id.allBooksC4);
        this.categoryB4.setText("Category: Music");

        //BOOK 5

        this.book5 = (ImageView) findViewById(R.id.allBooksI5);
        this.book5.setImageResource(R.drawable.book_img_5);

        this.titleBook5 = (TextView) findViewById(R.id.allBooksT5);
        this.titleBook5.setText("Next : The Future Just Happened");

        this.categoryB5 = (TextView) findViewById(R.id.allBooksC5);
        this.categoryB5.setText("Category:  E-Commerce");

        //BOOK 6

        this.book6 = (ImageView) findViewById(R.id.allBooksI6);
        this.book6.setImageResource(R.drawable.book_img_8);

        this.titleBook6 = (TextView) findViewById(R.id.allBooksT6);
        this.titleBook6.setText("Everything is Obvious: Why Common Sense is Nonsense");

        this.categoryB6 = (TextView) findViewById(R.id.allBooksC6);
        this.categoryB6.setText("Category: Self-Help");

        this.btnReadBook = (Button) findViewById(R.id.readThink);
        this.btnReadBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AllBooksActivity.this, BookActivity.class);
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
                startActivity(new Intent(this, HomeActivity.class));

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

