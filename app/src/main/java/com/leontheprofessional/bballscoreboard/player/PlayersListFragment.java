package com.leontheprofessional.bballscoreboard.player;

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
 * This fragment lists all players registered/mentioned on this device
 * todo: it will also be used for quick selection of players who later will be added to some team
 * todo: it is different between PlayerMainActivity and TeamMainActivity calling this fragment
 */
public class PlayersListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String LOG_TAG = PlayersListFragment.class.getSimpleName();
    private static final int PLAYER_LIST_FRAGMENT_URL_LOADER = 0;

    private ListAllPlayersLVAdapter listAllPlayersLVAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(LOG_TAG, "onCreate() executed");
        getLoaderManager().initLoader(PLAYER_LIST_FRAGMENT_URL_LOADER, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();
        View emptyView = LayoutInflater.from(getContext()).inflate(R.layout.empty_view_list_all_players, null);
        getListView().setEmptyView(emptyView);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.v(LOG_TAG, "Item on position: " + position + " has been clicked");
        Cursor playerSelected = (Cursor) listAllPlayersLVAdapter.getItem(position);
        String playerUUID = playerSelected.getString(playerSelected.getColumnIndexOrThrow(DatabaseContract.PlayerTable.COLUMN_PLAYER_UUID));
        Log.v(LOG_TAG, "playerUUID from PlayerListFragment: " + playerUUID);
        Intent playerDetailsIntent = new Intent(getActivity(), PlayerDetailsActivity.class);
        playerDetailsIntent.putExtra(CommonConstants.PLAYER_UUID_IDENTIFIER, playerUUID);
        startActivity(playerDetailsIntent);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case PLAYER_LIST_FRAGMENT_URL_LOADER:
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
        listAllPlayersLVAdapter = new ListAllPlayersLVAdapter(getContext(), data, 0);
        setListAdapter(listAllPlayersLVAdapter);
        listAllPlayersLVAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        listAllPlayersLVAdapter.swapCursor(null);
    }

    public static PlayersListFragment newInstance(Bundle bundle) {
        Log.v(LOG_TAG, "newInstance() executed");
        PlayersListFragment playersListFragment = new PlayersListFragment();
        playersListFragment.setArguments(bundle);
        return playersListFragment;
    }
}
