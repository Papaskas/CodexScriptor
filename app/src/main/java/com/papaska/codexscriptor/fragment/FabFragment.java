package com.papaska.codexscriptor.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.papaska.codexscriptor.R;
import com.papaska.codexscriptor.activity.MainActivity;
import com.papaska.codexscriptor.activity.NoteActivity;

public class FabFragment extends Fragment {
    private boolean isOpen = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton FABSettings = view.findViewById(R.id.fab__settings);
        FloatingActionButton FABBooks = view.findViewById(R.id.fab__books);
        FloatingActionButton FABMain = view.findViewById(R.id.fab__main);

        FABMain.setOnClickListener((mainFAB) -> new OnClickMainFAB(
                (FloatingActionButton) mainFAB, FABSettings, FABBooks
        ));
        FABBooks.setOnClickListener(this::onClickBooksFAB);
        FABSettings.setOnClickListener(this::onClickSettingsFAB);
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
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        startActivity(intent);
    }

    private void onClickBooksFAB(@NonNull View view) {
        Intent intent = new Intent(this.getActivity(), NoteActivity.class);
        startActivity(intent);
    }

    @Override
    public void startActivity(@SuppressLint("UnknownNullness") Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        super.startActivity(intent);
    }
}