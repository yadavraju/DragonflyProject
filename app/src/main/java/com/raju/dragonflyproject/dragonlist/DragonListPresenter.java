package com.raju.dragonflyproject.dragonlist;

import android.util.Log;

import com.raju.dragonflyproject.datamanager.model.DragonFly;
import com.raju.dragonflyproject.datamanager.service.ApiService;
import com.raju.dragonflyproject.datamanager.service.DragonService;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>
 * Todo Used Null Object pattern for SchoolListView ,
 * A null object replaces check of NULL object instance.
 * Instead of putting if check for a null value,
 * Null Object reflects a do nothing relationship.
 * Such Null object can also be used to provide default behaviour
 * in case data is not available.
 * Todo https://en.wikipedia.org/wiki/Null_object_pattern
 * </p>
 * Created by Raju Yadav
 */

public class DragonListPresenter {

    private static final String TAG = DragonListPresenter.class.getSimpleName();
    /**
     * This ful fill null object pattern
     */
    private DragonListView nullDragonListView = new DragonListView() {
        @Override
        public void initializeView() { /*Ignore*/ }

        @Override
        public void loadLoadList(ArrayList<DragonFly> schools) { /*Ignore*/ }

        @Override
        public void showProgress() { /*Ignore*/ }

        @Override
        public void hideProgress() { /*Ignore*/ }

        @Override
        public void showMessage(String message) { /*Ignore*/ }
    };
    private DragonListView dragonListView = nullDragonListView;
    private DragonService dragonService;
    private Disposable dragonListDisposable;

    public DragonListPresenter(DragonListView dragonListView) {
        this.dragonListView = dragonListView != null ? dragonListView : nullDragonListView;
        dragonService = ApiService.INSTANCE.getDragonFlyService();
        initializeView();
    }

    private void initializeView() {
        dragonListView.initializeView();
        loadDragonData();
    }

    private void loadDragonData() {
        dragonListView.showProgress();
        if (dragonService != null) {
            dragonListDisposable = dragonService.getDragonList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(dragonList -> {
                        dragonListView.loadLoadList(dragonList);
                        dragonListView.hideProgress();
                    }, error -> {
                        Log.e(TAG, "Failed to download list of dragon events");
                        dragonListView.hideProgress();
                        dragonListView.showMessage("Connection Error");
                    });
        }
    }

    public void tearDown() {
        dragonListView = null;
        if (dragonListDisposable != null) {
            dragonListDisposable.dispose();
        }
    }

}
