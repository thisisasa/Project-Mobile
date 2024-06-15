package com.asa.demorecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asa.demorecyclerview.R;
import com.asa.demorecyclerview.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    //Data Member
    private Context context;
    private List<Product> list;
    private String cardType;
    //Constructor
    public ProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    public ProductAdapter(Context context, List<Product> list, String cardType) {
        this.context = context;
        this.list = list;
        this.cardType = cardType;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if("GRID".equals(cardType)){
            View view = LayoutInflater.from(context).inflate(R.layout.product_item_card_gird,null,false);
            return new ProductViewHolder(view);
        }
        if("V".equals(cardType)){
            View view = LayoutInflater.from(context).inflate(R.layout.product_item_card_gird_v1,null,false);
            return new ProductViewHolder(view);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_card_list,null,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = list.get(position);
        if (product.getName() != null){
            holder.name.setText((product.getName()));
        }
        if(product.getIcon() != 0){
            holder.image.setImageDrawable(context.getResources().getDrawable(product.getIcon()));
        }
        holder.price.setText("$ "+ product.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //View Holder
    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView image, edit,delete;
        TextView name,price;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivProductImage);
            edit = itemView.findViewById(R.id.ivEdit);
            delete = itemView.findViewById(R.id.ivDelete);
            name = itemView.findViewById(R.id.tvProductName);
            price = itemView.findViewById(R.id.tvProductPrice);
        }
    }
}
