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
    // todo: I might need to separate d/o_rebs
//    private TextView offRebBoard;
    private TextView blockBoard;
    private TextView stealBoard;
    private TextView turnoverBoard;
    private TextView faulBoard;

    private int jerseyNumber;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scoreboard_main, container, false);

        jerseyNumber = getArguments().getInt(CommonConstants.JERSEY_NUMBER_IDENTIFIER);
        Log.v(LOG_TAG, "JerseyNumber: " + jerseyNumber);

        btnPtr2Bucket = (Button) view.findViewById(R.id.btn_ptr_2_bucket);
        btnPtr2Miss = (Button) view.findViewById(R.id.btn_ptr_2_miss);
        btnPtr3Bucket = (Button) view.findViewById(R.id.btn_ptr_3_bucket);
        btnPtr3Miss = (Button) view.findViewById(R.id.btn_ptr_3_miss);
        btnPtr1Bucket = (Button) view.findViewById(R.id.btn_ptr_1_bucket);
        btnPtr1Miss = (Button) view.findViewById(R.id.btn_ptr_1_miss);
        btnDefReb = (Button) view.findViewById(R.id.btn_def_reb);
        btnOffReb = (Button) view.findViewById(R.id.btn_off_reb);
        btnFaul = (Button) view.findViewById(R.id.btn_faul);
        btnTurnover = (Button) view.findViewById(R.id.btn_turnover);
        btnBlock = (Button) view.findViewById(R.id.btn_block);
        btnSteal = (Button) view.findViewById(R.id.btn_steal);

        ptr2ScoreBoard = (TextView) view.findViewById(R.id.pt_2_score_board);
        ptr3ScoreBoard = (TextView) view.findViewById(R.id.pt_3_score_board);
        ptr1ScoreBoard = (TextView) view.findViewById(R.id.pt_1_score_board);
        rebBoard = (TextView) view.findViewById(R.id.rebound_board);
        faulBoard = (TextView) view.findViewById(R.id.faul_board);
        turnoverBoard = (TextView) view.findViewById(R.id.turnover_board);
        stealBoard = (TextView) view.findViewById(R.id.steal_board);
        blockBoard = (TextView) view.findViewById(R.id.block_board);

        btnPtr2Bucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, DatabaseContract.PerformanceTable.SHOT_MADE, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "2Pt shot made", Toast.LENGTH_SHORT).show();
                refreshPt2Panel();
            }
        });

        btnPtr2Miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, DatabaseContract.PerformanceTable.SHOT_MISS, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "2Pt shot missed", Toast.LENGTH_SHORT).show();
                refreshPt2Panel();
            }
        });

        btnPtr3Bucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, DatabaseContract.PerformanceTable.SHOT_MADE, 0, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "3Pt shot made", Toast.LENGTH_SHORT).show();
                refreshPt3Panel();
            }
        });

        btnPtr3Miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, DatabaseContract.PerformanceTable.SHOT_MISS, 0, 0, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "3Pt shot missed", Toast.LENGTH_SHORT).show();
                refreshPt3Panel();
            }
        });

        btnPtr1Bucket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, DatabaseContract.PerformanceTable.SHOT_MADE, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "FreeThrow made", Toast.LENGTH_SHORT).show();
                refreshPt1Panel();
            }
        });

        btnPtr1Miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, DatabaseContract.PerformanceTable.SHOT_MISS, 0, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "FreeThrow miss", Toast.LENGTH_SHORT).show();
                refreshPt1Panel();
            }
        });

        btnFaul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, DatabaseContract.PerformanceTable.FAUL_COMMITTED, 0, 0, 0, 0, 0);
                Toast.makeText(getContext(), "Faul committed", Toast.LENGTH_SHORT).show();
                refreshFaulPanel();
            }
        });

        btnSteal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, DatabaseContract.PerformanceTable.STEAL_MADE, 0, 0, 0, 0);
                Toast.makeText(getContext(), "Nice steal", Toast.LENGTH_SHORT).show();
                refreshStealPanel();
            }
        });


        btnTurnover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, DatabaseContract.PerformanceTable.TURNOVER_MADE, 0, 0, 0);
                Toast.makeText(getContext(), "Bad Turnover", Toast.LENGTH_SHORT).show();
                refreshTurnoverPanel();
            }
        });

        btnOffReb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 0, DatabaseContract.PerformanceTable.REB_GOT, 0, 0);
                Toast.makeText(getContext(), "Nice Offensive Rebound", Toast.LENGTH_SHORT).show();
                refreshRebPanel();
            }
        });

        btnDefReb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 0, 0, DatabaseContract.PerformanceTable.REB_GOT, 0);
                Toast.makeText(getContext(), "Nice Defensive Rebound", Toast.LENGTH_SHORT).show();
                refreshRebPanel();
            }
        });

        btnBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertValues(jerseyNumber, 0, 0, 0, 0, 0, 0, 0, 0, DatabaseContract.PerformanceTable.BLOCK_MADE);
                Toast.makeText(getContext(), "Nice Block", Toast.LENGTH_SHORT).show();
                refreshBlockPanel();
            }
        });

        refreshPage();
        return view;
    }

    private void refreshPage() {
        refreshPt2Panel();
        refreshPt3Panel();
        refreshPt1Panel();
        refreshRebPanel();
        refreshStealPanel();
        refreshFaulPanel();
        refreshTurnoverPanel();
        refreshBlockPanel();
    }

    private void insertValues(int jerseyNumber, int pt3, int pt2, int pt1, int faul, int steal, int turnover, int offReb, int defReb, int block) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_JERSEY_NUMBER, jerseyNumber);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_PT_2, pt2);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_PT_3, pt3);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_PT_1, pt1);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_FAUL, faul);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_STEAL, steal);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_TURNOVER, turnover);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_OFF_REB, offReb);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_DEF_REB, defReb);
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_BLOCK, block);
        String dateTimeStamp = (DateFormat.format("yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString());
        contentValue.put(DatabaseContract.PerformanceTable.COLUMN_TIMESTAMP, dateTimeStamp);

        Uri uri = getContext().getContentResolver().insert(DatabaseContract.CONTENT_URI_PERFORMANCES, contentValue);
        Log.v(LOG_TAG, "Inserted URI: " + uri);
    }

    private void refreshPt2Panel() {
        String UrlPerformancePt2Made = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_PT2_MADE + jerseyNumber;
        String UrlPerformancePt2Missed = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_PT2_MISSED + jerseyNumber;
        Uri UriPerformancePt2Made = Uri.parse(UrlPerformancePt2Made);
        Uri UriPerformancePt2Missed = Uri.parse(UrlPerformancePt2Missed);
        int pt2Made = getContext().getContentResolver()
                .query(UriPerformancePt2Made, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        int pt2Missed = getContext().getContentResolver()
                .query(UriPerformancePt2Missed, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        int pt2Attempted = pt2Made + pt2Missed;
        Log.v(LOG_TAG, "pt2Attempted: " + pt2Attempted);

        ptr2ScoreBoard.setText(pt2Made + "/" + pt2Attempted);
    }

    private void refreshPt3Panel() {
        String UrlPerformancePt3Made = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_PT3_MADE + jerseyNumber;
        String UrlPerformancePt3Missed = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_PT3_MISSED + jerseyNumber;
        Uri UriPerformancePt3Made = Uri.parse(UrlPerformancePt3Made);
        Uri UriPerformancePt3Missed = Uri.parse(UrlPerformancePt3Missed);

        int pt3Made = getContext().getContentResolver()
                .query(UriPerformancePt3Made, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        int pt3Missed = getContext().getContentResolver()
                .query(UriPerformancePt3Missed, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        int pt3Attempted = pt3Made + pt3Missed;
        Log.v(LOG_TAG, "pt3Attempted: " + pt3Attempted);

        ptr3ScoreBoard.setText(pt3Made + "/" + pt3Attempted);
    }

    private void refreshPt1Panel() {
        String UrlPerformancePt1Made = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_PT1_MADE + jerseyNumber;
        String UrlPerformancePt1Missed = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_PT1_MISSED + jerseyNumber;
        Uri UriPerformancePt1Made = Uri.parse(UrlPerformancePt1Made);
        Uri UriPerformancePt1Missed = Uri.parse(UrlPerformancePt1Missed);

        int pt1Made = getContext().getContentResolver()
                .query(UriPerformancePt1Made, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        int pt1Missed = getContext().getContentResolver()
                .query(UriPerformancePt1Missed, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        int pt1Attempted = pt1Made + pt1Missed;
        Log.v(LOG_TAG, "pt1Attempted: " + pt1Attempted);

        ptr1ScoreBoard.setText(pt1Made + "/" + pt1Attempted);
    }

    private void refreshStealPanel() {
        String UrlPerformanceStealMade = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_STEAL + jerseyNumber;
        Uri UriPerformanceStealMade = Uri.parse(UrlPerformanceStealMade);

        int stealsMade = getContext().getContentResolver()
                .query(UriPerformanceStealMade, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        Log.v(LOG_TAG, "Steals made: " + stealsMade);

        stealBoard.setText(Integer.toString(stealsMade));
    }

    private void refreshRebPanel() {
        String UrlPerformanceOffRebMade = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_OFF_REB + jerseyNumber;
        String UrlPerformanceDefRebMade = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_DEF_REB + jerseyNumber;
        Uri UriPerformanceOffRebMade = Uri.parse(UrlPerformanceOffRebMade);
        Uri UriPerformanceDefRebMade = Uri.parse(UrlPerformanceDefRebMade);

        int offRebMade = getContext().getContentResolver()
                .query(UriPerformanceOffRebMade, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        Log.v(LOG_TAG, "OffReb made: " + offRebMade);
        int defRebMade = getContext().getContentResolver()
                .query(UriPerformanceDefRebMade, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        Log.v(LOG_TAG, "defReb made: " + defRebMade);

        rebBoard.setText(defRebMade + "|" + offRebMade);
    }

    private void refreshFaulPanel() {
        String UrlPerformanceFaulCommitted = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_FAUL + jerseyNumber;
        Uri UriPerformanceFaulCommitted = Uri.parse(UrlPerformanceFaulCommitted);

        int faulsCommitted = getContext().getContentResolver()
                .query(UriPerformanceFaulCommitted, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        Log.v(LOG_TAG, "Fauls committed: " + faulsCommitted);
        faulBoard.setText(Integer.toString(faulsCommitted));
        switch (faulsCommitted) {
            case 0:
                faulBoard.setBackgroundResource(R.color.faul0);
                break;
            case 1:
                faulBoard.setBackgroundResource(R.color.faul1);
                break;
            case 2:
                faulBoard.setBackgroundResource(R.color.faul2);
                break;
            case 3:
                faulBoard.setBackgroundResource(R.color.faul3);
                break;
            case 4:
                faulBoard.setBackgroundResource(R.color.faul4);
                break;
            default:
                // Todo: make 5 or 6 as the max (or maybe not)
                faulBoard.setBackgroundResource(R.color.faul5);
                faulBoard.setText(R.string.faul_out);
                break;
        }
    }

    private void refreshTurnoverPanel() {
        String UrlPerformanceTurnoverMade = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_TURNOVER + jerseyNumber;
        Uri UriPerformanceTurnoverMade = Uri.parse(UrlPerformanceTurnoverMade);

        int turnoversMade = getContext().getContentResolver()
                .query(UriPerformanceTurnoverMade, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        Log.v(LOG_TAG, "Turnovers made: " + turnoversMade);

        turnoverBoard.setText(Integer.toString(turnoversMade));
    }

    private void refreshBlockPanel() {
        String UrlPerformanceBlockMade = DatabaseContract.PerformanceTable.URL_PERFORMANCE + DatabaseContract.PerformanceTable.URL_PERFORMANCE_BLOCK + jerseyNumber;
        Uri UriPerformanceBlockMade = Uri.parse(UrlPerformanceBlockMade);

        int blocksMade = getContext().getContentResolver()
                .query(UriPerformanceBlockMade, DatabaseContract.projectionForAll, null, null, null)
                .getCount();
        Log.v(LOG_TAG, "Blocks made: " + blocksMade);

        blockBoard.setText(Integer.toString(blocksMade));
    }
}
