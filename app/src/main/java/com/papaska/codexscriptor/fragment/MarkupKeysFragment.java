package com.papaska.codexscriptor.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.papaska.codexscriptor.R;

public class MarkupKeysFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_markup_keys, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.navigation_home).setOnClickListener(this::onHome);
        view.findViewById(R.id.navigation_dashboard).setOnClickListener(this::onDashboard);
        view.findViewById(R.id.navigation_notifications).setOnClickListener(this::onNotification);
    }

    private void onHome(View view) {
        Toast.makeText(this.getContext(), "onHome!",Toast.LENGTH_LONG).show();
    }

    private void onNotification(View view) {
        Toast.makeText(this.getContext(), "onNotification!",Toast.LENGTH_LONG).show();
    }

    private void onDashboard(View view) {
        Toast.makeText(this.getContext(), "onDashboard!",Toast.LENGTH_LONG).show();
    }
}