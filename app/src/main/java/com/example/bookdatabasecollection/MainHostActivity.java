package com.example.bookdatabasecollection;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.bookdatabasecollection.ui.BooksFragment;

public class MainHostActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, BooksFragment.newInstance())
                .addToBackStack(null).commit();

    }
}
