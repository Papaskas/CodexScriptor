package com.papaska.codexscriptor.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.papaska.codexscriptor.R;
import com.papaska.codexscriptor.databinding.FragmentFabBinding;

public class FabFragment extends Fragment {

    public FabFragment() {
        super(R.layout.fragment_fab);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentFabBinding binding = FragmentFabBinding.inflate(inflater, container, false);

        binding.getRoot().setOnClickListener(view ->
                Toast
                        .makeText(view.getContext(), "Hello Android!",Toast.LENGTH_LONG)
                        .show());

        return binding.getRoot();
    }

}