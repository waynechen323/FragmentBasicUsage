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
public class NotificationsFragment extends Fragment {

    private TextView mTextTitle;

    public NotificationsFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        mTextTitle = (TextView) root.findViewById(R.id.text_title_notifications);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextTitle.setText("Now I see u!");
        mTextTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).onOpenDetail("Open from Notifications!");
            }
        });
    }
}
