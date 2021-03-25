package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        setRetainInstance(true);
        TextView Numb = view.findViewById(R.id.Number);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Numb.setText(bundle.get("Number").toString());
            Numb.setTextColor(bundle.getInt("Color"));
        }
        return view;
    }
}
