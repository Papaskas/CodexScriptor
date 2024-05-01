package com.papaska.codexscriptor.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.papaska.codexscriptor.R;

public class EditMarkupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_markup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editMarkup = view.findViewById(R.id.edit_markup);

        editMarkup.addTextChangedListener(new EditMarkupListener(editMarkup));
        editMarkup.setOnKeyListener(new KeyListener());
    }
}

class EditMarkupListener implements TextWatcher {
    private final EditText editMarkup;

    EditMarkupListener(EditText editMarkup) {this.editMarkup = editMarkup;}

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(editMarkup.getText().toString().equals("#")){
            editMarkup.setText(editMarkup.getText().subSequence(0, editMarkup.getText().length()-1));
        }
    }
}

class KeyListener implements View.OnKeyListener {
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}