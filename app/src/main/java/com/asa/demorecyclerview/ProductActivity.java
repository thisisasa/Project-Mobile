package com.asa.demorecyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asa.demorecyclerview.adapter.ProductAdapter;
import com.asa.demorecyclerview.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProduct;
    private ProductAdapter productAdapter;
    private ImageView ivBack, ivChangeCard;
    private int columnCount=1;
    private String cardType = "LIST";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }
    private void initView(){
        recyclerViewProduct = findViewById(R.id.recycleViewProduct);
        ivBack = findViewById(R.id.ivBack);
        ivChangeCard = findViewById(R.id.ivAction);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setData();
        ivChangeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardType.equals("LIST")){
                    columnCount = 2;
                    cardType = "GRID";
                    ivChangeCard.setImageDrawable(getResources().getDrawable(R.drawable.gird));
                }
                else{
                    columnCount = 1;
                    cardType = "LIST";
                    ivChangeCard.setImageDrawable(getResources().getDrawable(R.drawable.list));
                }
                setData();
            }
        });
    }
    private void setData(){
        List<Product> productList = new ArrayList<>();
        for(int i = 1; i<=30; i++){
            if(i%2 == 0){
                productList.add(new Product(
                        i,
                        "Coca Cola "+i,
                        "",
                        R.drawable.coca,
                        12+i
                ));
            }else {
                productList.add(new Product(
                        i,
                        "Sprite "+i,
                        "",
                        R.drawable.sprite,
                        12+i
                ));
            }
        }
        productAdapter = new ProductAdapter(this,productList,cardType);
        recyclerViewProduct.setAdapter(productAdapter);
        //layout
        recyclerViewProduct.setLayoutManager(new GridLayoutManager(this,columnCount));
    }
}