package com.waynechen.fragmentbasicusage.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waynechen.fragmentbasicusage.R;

import static com.waynechen.fragmentbasicusage.MainActivity.DETAIL_MESSAGE;

/**
 * Created by Wayne Chen on 2018/5/4.
 */
public class DetailFragment extends Fragment {

    private TextView mTextTitle;

    public DetailFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        mTextTitle = (TextView) root.findViewById(R.id.text_title_detail);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            mTextTitle.setText(getArguments().getString(DETAIL_MESSAGE));
        }
    }
}
