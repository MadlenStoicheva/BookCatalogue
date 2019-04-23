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

public class BooksInGenreActivity extends AppCompatActivity {

    ImageView book1, book2, book3, book4, book5;
    Button buttonReadNapoleone, buttonSeeAllGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_in_category);

        //BOOK 1

        this.book1 = (ImageView) findViewById(R.id.imageVB1);
        this.book1.setImageResource(R.drawable.kiosaki);

       //BOOK 2

        this.book2 = (ImageView) findViewById(R.id.imageVB2);
        this.book2.setImageResource(R.drawable.napoleone);

        //BOOK 3

        this.book3 = (ImageView) findViewById(R.id.imageVB3);
        this.book3.setImageResource(R.drawable.selling_tracy);

        //BOOK 4

        this.book4 = (ImageView) findViewById(R.id.imageVB4);
        this.book4.setImageResource(R.drawable.talent);

        //BOOK 5

        this.book5 = (ImageView) findViewById(R.id.imageVB5);
        this.book5.setImageResource(R.drawable.habbits);

        //Read book
        this.buttonReadNapoleone = (Button) findViewById(R.id.buttonReadB);
        this.buttonReadNapoleone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BooksInGenreActivity.this, BookActivity.class);
                startActivity(i);
            }
        });

        //See all genres
        this.buttonSeeAllGenres = (Button) findViewById(R.id.buttonAllGenres);
        this.buttonSeeAllGenres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BooksInGenreActivity.this, GenresBooksActivity.class);
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
