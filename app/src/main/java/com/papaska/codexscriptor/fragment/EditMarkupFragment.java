package com.papaska.codexscriptor.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.papaska.codexscriptor.R;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class EditMarkupFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_markup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editMarkup = view.findViewById(R.id.edit_markup);
        keys = view.findViewById(R.id.markup_keys_fragment);

        editMarkup.addTextChangedListener(new EditMarkupListener(editMarkup));

        KeyboardVisibilityEvent.setEventListener(this.getActivity(), this::onVisibilityChanged);
    }

    View keys;
    private void onVisibilityChanged(boolean isOpen) {
        if (isOpen) keys.setVisibility(View.VISIBLE);
        else keys.setVisibility(View.GONE);
    }
}

class EditMarkupListener implements TextWatcher {
    private final EditText editMarkup;

    protected EditMarkupListener(EditText editMarkup) {this.editMarkup = editMarkup;}

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
