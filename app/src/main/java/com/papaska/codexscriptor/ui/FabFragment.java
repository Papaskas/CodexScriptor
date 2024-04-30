package com.papaska.codexscriptor.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.papaska.codexscriptor.R;
import com.papaska.codexscriptor.databinding.FragmentFabBinding;

public class FabFragment extends Fragment {
    private boolean isOpen = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton FABSettings = view.findViewById(R.id.fab__settings);
        FloatingActionButton FABBooks = view.findViewById(R.id.fab__books);

        view.findViewById(R.id.fab__main).setOnClickListener((v) ->
                new OnClickMainFAB((FloatingActionButton) v, FABSettings, FABBooks));

        FABBooks.setOnClickListener(this::onClickBooksFAB);
        FABSettings.setOnClickListener(this::onClickSettingsFAB);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        FragmentFabBinding binding = FragmentFabBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    private class OnClickMainFAB {
        private final FloatingActionButton FABMain;
        private final FloatingActionButton[] secondaryFABs;

        OnClickMainFAB(@NonNull FloatingActionButton FABMain, @NonNull FloatingActionButton ...secondaryFABs) {
            this.FABMain = FABMain;
            this.secondaryFABs = secondaryFABs;
            isOpen = !isOpen;

            toggleMainIcon();
            toggleVisible();
        }

        private void toggleMainIcon() {
            FABMain.setSelected(isOpen);
        }

        private void toggleVisible() {
            for (FloatingActionButton FAB : secondaryFABs) {
                if(FAB.getVisibility() == View.GONE)
                    FAB.show();

                else if(FAB.getVisibility() == View.VISIBLE)
                    FAB.hide();
            }
        }
    }

    private void onClickSettingsFAB(@NonNull View view) {
        Toast.makeText(view.getContext(), "Settings", Toast.LENGTH_SHORT).show();
    }

    private void onClickBooksFAB(@NonNull View view) {
        Toast.makeText(view.getContext(), "Books", Toast.LENGTH_SHORT).show();
    }
}