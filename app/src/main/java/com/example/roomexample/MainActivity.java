package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.roomexample.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MyViewModel model;
    LifecycleOwner owner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(MyViewModel.class);
        owner = this;

        binding.Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.insertProduct(new Product("Anas",100));
                model.insertProduct(new Product("Hassan",101));
                model.insertProduct(new Product("Mahmoud",102));
                model.insertProduct(new Product("Ahmed",103));
            }
        });


        binding.View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.getAllProduct().observe(owner, new Observer<List<Product>>() {
                    @Override
                    public void onChanged(List<Product> products) {
                        Log.e("Anasss", "onChanged: "+products.get(0).getName()+' '+products.get(0).getPrice() );
                    }
                });
            }
        });

    }
}