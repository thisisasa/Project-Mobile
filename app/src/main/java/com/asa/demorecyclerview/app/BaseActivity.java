package com.asa.demorecyclerview.app;

import androidx.appcompat.app.AppCompatActivity;

import com.asa.demorecyclerview.R;
import com.asa.demorecyclerview.model.Product;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    protected List<Product> getAllProductList() {
        List<Product> productList = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (i % 2 == 0) {
                productList.add(new Product(
                        i,
                        "Coca Cola " + i,
                        "",
                        R.drawable.coca,
                        12 + i
                ));
            } else {
                productList.add(new Product(
                        i,
                        "Sprite " + i,
                        "",
                        R.drawable.sprite,
                        12 + i
                ));
            }
        }
        return productList;
    }
}
