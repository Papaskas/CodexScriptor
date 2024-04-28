package com.papaska.codexscriptor;

import android.os.Bundle;
import android.view.Menu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.papaska.codexscriptor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static ActivityMainBinding Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Binding = ActivityMainBinding.inflate(getLayoutInflater());

        beforeSetContentView();

        setContentView(Binding.getRoot());

        new AfterSetContentView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void beforeSetContentView() {
        EdgeToEdge.enable(this);
    }

    private static class AfterSetContentView {
        {
            setEdgeToEdge();
        }

        private void setEdgeToEdge() {
            ViewCompat.setOnApplyWindowInsetsListener(Binding.getRoot(), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
}