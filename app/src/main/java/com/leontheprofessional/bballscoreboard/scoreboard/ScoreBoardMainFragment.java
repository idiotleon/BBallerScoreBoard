package com.leontheprofessional.bballscoreboard.scoreboard;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;
import com.leontheprofessional.bballscoreboard.helpers.CommonConstants;
import com.leontheprofessional.bballscoreboard.R;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ScoreBoardMainFragment extends Fragment {

    private static final String LOG_TAG = ScoreBoardMainFragment.class.getSimpleName();

    private TextView scoreboardTitle;
    private Button btnPtr3Bucket;
    private Button btnPtr3Miss;
    private Button btnPtr2Bucket;
    private Button btnPtr2Miss;
    private Button btnPtr1Bucket;
    private Button btnPtr1Miss;
    private Button btnDefReb;
    private Button btnOffReb;
    private Button btnFaul;
    private Button btnTurnover;
    private Button btnBlock;
    private Button btnSteal;

    private TextView ptr3ScoreBoard;
    private TextView ptr2ScoreBoard;
    private TextView ptr1ScoreBoard;
    private TextView rebBoard;
    // todo: I might need to separate d&o rebs
//    private TextView offRebBoard;
    private TextView blockBoard;
    private TextView stealBoard;
    private TextView turnoverBoard;
    private TextView faulBoard;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scoreboard_main, container, false);

        final int jerseyNumber = getArguments().getInt(CommonConstants.JERSEY_NUMBER_IDENTIFIER);
        Log.v(LOG_TAG, "JerseyNumber, ScoreBoardMainFragment: " + jerseyNumber);

        btnPtr3Bucket = (Button) view.findViewById(R.id.btn_ptr_3_bucket);
        btnPtr3Miss = (Button) view.findViewById(R.id.btn_ptr_3_miss);
        btnPtr2Bucket = (Button) view.findViewById(R.id.btn_ptr_2_bucket);
        btnPtr2Miss = (Button) view.findViewById(R.id.btn_ptr_2_miss);
        btnPtr1Bucket = (Button) view.findViewById(R.id.btn_ptr_1_bucket);
        btnPtr1Miss = (Button) view.findViewById(R.id.btn_ptr_1_miss);
        btnDefReb = (Button) view.findViewById(R.id.btn_def_reb);
        btnOffReb = (Button) view.findViewById(R.id.btn_off_reb);
        btnFaul = (Button) view.findViewById(R.id.btn_faul);
        btnTurnover = (Button) view.findViewById(R.id.btn_turnover);
        btnBlock = (Button) view.findViewById(R.id.btn_block);
        btnSteal = (Button) view.findViewById(R.id.btn_steal);

        ptr3ScoreBoard = (TextView) view.findViewById(R.id.pt_3_score_board);
        ptr2ScoreBoard = (TextView) view.findViewById(R.id.pt_2_score_board);
        ptr1ScoreBoard = (TextView) view.findViewById(R.id.pt_1_score_board);
        rebBoard = (TextView) view.findViewById(R.id.rebound_board);
        faulBoard = (TextView) view.findViewById(R.id.faul_board);
        turnoverBoard = (TextView) view.findViewById(R.id.turnover_board);
        stealBoard = (TextView) view.findViewById(R.id.steal_board);
        blockBoard = (TextView) view.findViewById(R.id.block_board);

        btnPtr3Bucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 1, 0, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "3Pt made", Toast.LENGTH_SHORT).show();
            }
        });

        btnPtr3Miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, -1, 0, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "3Pt miss", Toast.LENGTH_SHORT).show();
            }
        });

        btnPtr2Bucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 1, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "2Pt made", Toast.LENGTH_SHORT).show();
            }
        });

        btnPtr2Miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, -1, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "2Pt miss", Toast.LENGTH_SHORT).show();
            }
        });

        btnPtr1Bucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 1, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "FreeThrow made", Toast.LENGTH_SHORT).show();
            }
        });

        btnPtr1Miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, -1, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "FreeThrow miss", Toast.LENGTH_SHORT).show();
            }
        });

        btnFaul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 1, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "Faul Committed", Toast.LENGTH_SHORT).show();
                // Todo: different colors for different numbers of fauls
            }
        });

        btnSteal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 1, 0, 0, 0, 0);
                Toast.makeText(getContext(), "Nice Steal", Toast.LENGTH_SHORT).show();
            }
        });


        btnTurnover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 1, 0, 0, 0);
                Toast.makeText(getContext(), "Bad Turnover", Toast.LENGTH_SHORT).show();
            }
        });


        btnOffReb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 0, 1, 0, 0);
                Toast.makeText(getContext(), "Nice Offensive Rebound", Toast.LENGTH_SHORT).show();
            }
        });

        btnDefReb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 0, 0, 1, 0);
                Toast.makeText(getContext(), "Nice Defensive Rebound", Toast.LENGTH_SHORT).show();
            }
        });

        btnBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 0, 0, 0, 1);
                Toast.makeText(getContext(), "Nice Block", Toast.LENGTH_SHORT).show();
            }
        });

        // todo: go to database with jerseyNumber as the identifier to fetch players' data

/*        if(!getArguments().equals(null)) {
            final int jerseyNumber = getArguments().getInt(CommonConstants.JERSEY_NUMBER_IDENTIFIER);

            // todo: go to database with jerseyNumber as the identifier to fetch players' data

        }else{

        }*/

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void insertValues(int jerseyNumber, int pt3, int pt2, int pt1, int faul, int steal, int turnover, int offReb, int defReb, int block) {

        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER, jerseyNumber);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_PT_3, pt3);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_PT_2, pt2);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_PT_1, pt1);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_FAUL, faul);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_STEAL, steal);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_TURNOVER, turnover);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_OFF_REB, offReb);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_Def_REB, defReb);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_BLOCK, block);
        String dateTimeStamp = (DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString());
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_TIMESTAMP, dateTimeStamp);


        Uri uri = getContext().getContentResolver().insert(DatabaseContract.CONTENT_URI_PERFORMANCES, contentValue);
        Log.v(LOG_TAG, "Inserted URI: " + uri);
    }
}
