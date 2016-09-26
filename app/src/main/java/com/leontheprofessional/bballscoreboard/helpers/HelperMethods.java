package com.leontheprofessional.bballscoreboard.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.leontheprofessional.bballscoreboard.database.DatabaseContract;
import com.leontheprofessional.bballscoreboard.player.model.PlayerModel;
import com.leontheprofessional.bballscoreboard.team.model.TeamModel;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 9/25/2016.
 */

public class HelperMethods {

    public static Boolean isTablet(){

        // https://developer.android.com/training/multiscreen/screensizes.html#TaskUseSWQuali
        // res/layout-sw600dp/main.xml
        return false;
    }


}
