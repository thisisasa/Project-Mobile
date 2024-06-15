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
import androidx.recyclerview.widget.RecyclerView;

import com.asa.demorecyclerview.adapter.CategoryAdapter;
import com.asa.demorecyclerview.app.BaseActivity;
import com.asa.demorecyclerview.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends BaseActivity {
    private RecyclerView rvCategory;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    private ImageView ivBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        getCategories();
    }
    private void initView(){
        rvCategory = findViewById(R.id.rvCategory);
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void getCategories(){
        categoryList = new ArrayList<>();
        Category softDrink = new Category();
        softDrink.setId(1);
        softDrink.setName("Soft Drink");
        softDrink.setProductList(getAllProductList());
        categoryList.add(softDrink);

        Category beer = new Category();
        beer.setId(2);
        beer.setName("Beer");
        beer.setProductList(getAllProductList());
        categoryList.add(beer);

        Category food = new Category();
        food.setId(3);
        food.setName("Food");
        food.setProductList(getAllProductList());
        categoryList.add(food);

        Category fastFood = new Category();
        fastFood.setId(4);
        fastFood.setName("Fast Food");
        fastFood.setProductList(getAllProductList());
        categoryList.add(fastFood);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        rvCategory.setAdapter(categoryAdapter);
        rvCategory.setLayoutManager(new GridLayoutManager(this,1));
    }
}