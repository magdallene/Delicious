package com.example.delicious;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder> {


    private Context mContext;
    private List<FoodData> myFoodList;

    public MyAdapter(Context mContext, List<FoodData> myFoodList){
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }



    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_row,viewGroup,false);

        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final FoodViewHolder foodViewHolder, int i) {
        //foodViewHolder.imageView.setImageResource(myFoodList.get(i).getItemImage());
        foodViewHolder.mTitle.setText(myFoodList.get(i).getItemName());
        foodViewHolder.mDescription.setText(myFoodList.get(i).getItemDescription());
        foodViewHolder.mTime.setText(myFoodList.get(i).getItemTime());
        foodViewHolder.mIngriedents.setText(myFoodList.get(i).getItemIngriedents());

        foodViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,Recipe.class);
                intent.putExtra("Image",myFoodList.get(foodViewHolder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",myFoodList.get(foodViewHolder.getAdapterPosition()).getItemDescription());
                intent.putExtra("RecipeName",myFoodList.get(foodViewHolder.getAdapterPosition()).getItemName());
                intent.putExtra("Time",myFoodList.get(foodViewHolder.getAdapterPosition()).getItemTime());
                intent.putExtra("Ingriedents",myFoodList.get(foodViewHolder.getAdapterPosition()).getItemIngriedents());

                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return myFoodList.size();
    }

    public void filteredList(ArrayList<FoodData> filterList) {

        myFoodList = filterList;
        notifyDataSetChanged();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView mTitle,mDescription,mTime,mIngriedents;
    CardView mCardView;

    // Pass in the contact array into the constructor
    public FoodViewHolder(View itemView ) {
        super(itemView);
        imageView = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mDescription = itemView.findViewById(R.id.tvDescription);
        mTime = itemView.findViewById(R.id.tvTime);
        mIngriedents = itemView.findViewById(R.id.tvIngriedents);
        mCardView = itemView.findViewById(R.id.myCardView);
    }
}
