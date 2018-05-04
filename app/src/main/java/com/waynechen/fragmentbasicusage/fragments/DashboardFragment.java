package com.waynechen.fragmentbasicusage.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waynechen.fragmentbasicusage.MainActivity;
import com.waynechen.fragmentbasicusage.R;

/**
 * Created by Wayne Chen on 2018/5/4.
 */
public class DashboardFragment extends Fragment {

    private TextView mTextTitle;

    public DashboardFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mTextTitle = (TextView) root.findViewById(R.id.text_title_dashboard);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextTitle.setText("Taeyeon I love you!");
        mTextTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onOpenDetail("Open from Dashboard!");
            }
        });
    }
}
