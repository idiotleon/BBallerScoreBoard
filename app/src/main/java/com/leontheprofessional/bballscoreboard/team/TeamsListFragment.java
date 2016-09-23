package com.leontheprofessional.bballscoreboard.team;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.leontheprofessional.bballscoreboard.R;
import com.leontheprofessional.bballscoreboard.database.DatabaseContract;
import com.leontheprofessional.bballscoreboard.helpers.CommonConstants;

/**
 * This Fragment lists all teams
 */

public class TeamsListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String LOG_TAG = TeamsListFragment.class.getSimpleName();
    private static final int TEAM_LIST_FRAGMENT_URL_LOADER = 1;

    private ListAllTeamsLVAdapter listAllTeamsLVAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(LOG_TAG, "onCreate() executed");
        getLoaderManager().initLoader(TEAM_LIST_FRAGMENT_URL_LOADER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();
        View emptyView = LayoutInflater.from(getContext()).inflate(R.layout.empty_view_list_all_teams, null);
        getListView().setEmptyView(emptyView);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Cursor teamSelected = (Cursor) listAllTeamsLVAdapter.getItem(position);
        String teamUUID = teamSelected.getString(teamSelected.getColumnIndexOrThrow(DatabaseContract.TeamTable.COLUMN_TEAM_UUID));
        Log.v(LOG_TAG, "teamUUID: " + teamUUID);
        Intent teamDetailIntent = new Intent(getActivity(), TeamDetailsActivity.class);
        teamDetailIntent.putExtra(CommonConstants.TEAM_UUID_IDENTIFIER, teamUUID);
        startActivity(teamDetailIntent);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case TEAM_LIST_FRAGMENT_URL_LOADER:
                return new CursorLoader(
                        getContext(),
                        DatabaseContract.TeamTable.CONTENT_URI_TEAMS,
                        DatabaseContract.TeamTable.projectionForAll,
                        null,
                        null,
                        null
                );
            default:
                // An invalid ID was passed in
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        listAllTeamsLVAdapter = new ListAllTeamsLVAdapter(getContext(), data, 0);
        setListAdapter(listAllTeamsLVAdapter);
        listAllTeamsLVAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        listAllTeamsLVAdapter.swapCursor(null);
    }

    public static TeamsListFragment newInstance(Bundle bundle) {
        Log.v(LOG_TAG, "newInstance() executed");
        Bundle args = new Bundle();
        TeamsListFragment fragment = new TeamsListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
