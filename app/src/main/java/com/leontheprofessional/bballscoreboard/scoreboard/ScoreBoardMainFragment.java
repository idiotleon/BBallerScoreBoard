package com.leontheprofessional.bballscoreboard.scoreboard;

import android.annotation.TargetApi;
import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leontheprofessional.bballscoreboard.Helper.CommonConstants;
import com.leontheprofessional.bballscoreboard.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ScoreBoardMainFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // todo: inflate the fragment with the data stored in the database
        if(!getArguments().equals(null)) {
            final int jerseyNumber = getArguments().getInt(CommonConstants.JERSEY_NUMBER_IDENTIFIER);

            // todo: go to database with jerseyNumber as the identifier to fetch players' data

        }else{

        }


        return inflater.inflate(R.layout.fragment_scoreboard_main, container, false);
    }
}
