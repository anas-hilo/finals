package com.example.roomexample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Repository repository ;
    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }
    void insertProduct(Product product){
        repository.insertProduct(product);
    }
    LiveData<List<Product>> getAllProduct(){
        return repository.getAllProduct();
    }
}
