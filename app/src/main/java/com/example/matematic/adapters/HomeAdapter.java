package com.example.matematic.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.matematic.R;
import com.example.matematic.fragments.AreaCircleFragment;
import com.example.matematic.fragments.HomeFragment;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends BaseAdapter {

    private List<String> listThemesTitles = new ArrayList<>();
    private LayoutInflater themesInf;
    private Context context;
    private FragmentActivity activity;

    public HomeAdapter(Context c, List<String>l, FragmentActivity a) {
        this.listThemesTitles = l;
        this.context = c;
        this.activity = a;
        this.themesInf=LayoutInflater.from( c );
    }

    @Override
    public int getCount() {
        return this.listThemesTitles.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") LinearLayout themesLay = (LinearLayout) this.themesInf.inflate
                (R.layout.line_adapter_home, viewGroup, false);

        MaterialButton btn = themesLay.findViewById(R.id.btnTitle);
        String title = this.listThemesTitles.get(i);
        btn.setText(title);
        themesLay.setTag(i);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = btn.getText().toString();
                Toast.makeText(btn.getContext(), title, Toast.LENGTH_SHORT).show();

                if(title.equals("aire d'un cercle")) {
                    activity.getSupportFragmentManager().beginTransaction().
                            remove(activity.getSupportFragmentManager().findFragmentById(R.id.frame)).commit();
                    AreaCircleFragment frag = new AreaCircleFragment();
                    activity.getSupportFragmentManager().beginTransaction().add(R.id.frame, frag).commit();
                }
            }
        });

        return themesLay;
    }

}
