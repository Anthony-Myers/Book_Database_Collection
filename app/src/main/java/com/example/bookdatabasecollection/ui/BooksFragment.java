package com.example.bookdatabasecollection.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookdatabasecollection.databinding.BooksFragmentBinding;
import com.example.bookdatabasecollection.ui.adapter.BooksAdapter;

public class BooksFragment extends Fragment {

    private BooksFragmentBinding binding;
    private BookViewModel mViewModel;

    public static BooksFragment newInstance(){return new BooksFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BooksFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(BookViewModel.class);

        SharedPreferences sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(!sharedPreferences.getBoolean("isPopulated", false)){
            editor.putBoolean("isPopulated", true);
            mViewModel.populateDataBase();
        }

        mViewModel.getListOfBooks().observe(this, bookData -> {
            RecyclerView booksRv = binding.booksRv;
            BooksAdapter booksAdapter = new BooksAdapter(bookData);
            booksAdapter.setOnItemClickListener((position) -> {
                Uri uri = Uri.parse(booksAdapter.getItem(position).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            });
            booksRv.setAdapter(booksAdapter);
            booksRv.setLayoutManager(new LinearLayoutManager(requireContext()));

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(booksRv.getContext(), DividerItemDecoration.VERTICAL);
            booksRv.addItemDecoration(dividerItemDecoration);
        });
    }
}
