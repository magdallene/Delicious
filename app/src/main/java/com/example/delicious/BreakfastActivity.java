package com.example.delicious;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BreakfastActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<FoodData> myFoodList;
    FoodData mFoodData;
    ProgressDialog progressDialog;
    MyAdapter myAdapter;
    EditText txt_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView)findViewById(R.id.rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        mRecyclerView.setLayoutManager(gridLayoutManager);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Items ....");


        myFoodList = new ArrayList<>();

        myAdapter  = new MyAdapter(this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Recipe");

        progressDialog.show();
        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                myFoodList.clear();

                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    FoodData foodData = itemSnapshot.getValue(FoodData.class);
                    myFoodList.add(foodData);

                }
                myAdapter.notifyDataSetChanged();
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });

        txt_Search = (EditText) findViewById(R.id.txt_searchtext);

        txt_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }
    private void filter(String text) {

        ArrayList<FoodData> filterList = new ArrayList<>();
        for(FoodData item:myFoodList){
            if(item.getItemName().toLowerCase().contains(text.toLowerCase())){
                filterList.add(item);
            }
        }
        myAdapter.filteredList(filterList);
    }

}
