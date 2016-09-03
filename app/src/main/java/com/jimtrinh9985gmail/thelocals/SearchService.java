package com.jimtrinh9985gmail.thelocals;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Kimo on 9/2/2016.
 */
public class SearchService extends IntentService {

    public final String LOG_TAG = SearchService.class.getSimpleName();

    public SearchService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
