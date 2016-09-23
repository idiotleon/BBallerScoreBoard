/*
package com.leontheprofessional.bballscoreboard.team.selectplayers;

import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;

*
 * Created by LeonthePro7 on 9/22/2016.



public class SelectPlayersListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String LOG_TAG = SelectPlayersListFragment.class.getSimpleName();
    private static final int SELECT_PLAYERS_URL_LAODER = 0;

    private SelectPlayersLVAdapter selectPlayersLVAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(LOG_TAG, "onCreate() executed");
        getLoaderManager().initLoader(SELECT_PLAYERS_URL_LAODER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case SELECT_PLAYERS_URL_LAODER:
                return new CursorLoader(
                        getContext(),
                        DatabaseContract.PlayerTable.CONTENT_URI_PLAYERS,
                        DatabaseContract.PlayerTable.projectionForAll,
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
        selectPlayersLVAdapter = new SelectPlayersLVAdapter(getContext(), data, 0);
        setListAdapter(selectPlayersLVAdapter);
        selectPlayersLVAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        selectPlayersLVAdapter.swapCursor(null);
    }

    public static SelectPlayersListFragment newInstance(Bundle bundle) {

        SelectPlayersListFragment fragment = new SelectPlayersListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}
*/
