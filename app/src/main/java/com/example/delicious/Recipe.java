package com.example.delicious;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Recipe extends AppCompatActivity {

    TextView foodDescription,RecipeName, RecipeIngriedents,RecipeTime;
    ImageView foodImage;
   // String key="";
    String imageUrl="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        RecipeName = (TextView) findViewById(R.id.txtRecipeName);
        RecipeIngriedents = (TextView) findViewById(R.id.txtIngriedents);
        foodDescription = (TextView)findViewById(R.id.txtDescription);
        RecipeTime = (TextView)findViewById(R.id.txtTime);
        foodImage = (ImageView)findViewById(R.id.ivImage2);

        Bundle mBundle = getIntent().getExtras();

        if(mBundle!=null){

            foodDescription.setText(mBundle.getString("Description"));
            //key = mBundle.getString("keyValue");
            imageUrl = mBundle.getString("Image");
            RecipeName.setText(mBundle.getString("RecipeName"));
            RecipeIngriedents.setText(mBundle.getString("Ingriedents"));
            RecipeTime.setText(mBundle.getString("Time"));  // get time item from firebae
            foodImage.setImageResource(mBundle.getInt("Image"));
        }


    }

}
