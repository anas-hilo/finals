package com.example.roomexample;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

public class Repository {
    ProductDAO productDAO;
    public Repository(Application application) {
        productDAO = MyDataBase.getDatabase(application).productDAO();
    }

    void insertProduct(Product product){
        MyDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                productDAO.insertProduct(product);
            }
        });
    }
    LiveData<List<Product>> getAllProduct(){
        return productDAO.getAllProduct();
    }
}
