package com.asa.demorecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asa.demorecyclerview.R;
import com.asa.demorecyclerview.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<Category> categories;
     public CategoryAdapter(Context context, List<Category> categories){
         this.context = context;
         this.categories = categories;
     }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_card_list,null,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        if (category.getName() != null){
            holder.title.setText(category.getName());
        }
        if(!category.getProductList().isEmpty()){
            ProductAdapter productAdapter = new ProductAdapter(context, category.getProductList(),"V");
            holder.recyclerViewProduct.setAdapter(productAdapter);
            holder.recyclerViewProduct.setLayoutManager(
                    new GridLayoutManager(context,1,RecyclerView.HORIZONTAL,false)
            );
        }
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        RecyclerView recyclerViewProduct;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvCategoryName);
            recyclerViewProduct = itemView.findViewById(R.id.rcProduct);
        }
    }
}
