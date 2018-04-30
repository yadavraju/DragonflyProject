package com.raju.dragonflyproject.dragondetail;

import android.util.Log;

import com.raju.dragonflyproject.datamanager.model.EventStatus;
import com.raju.dragonflyproject.datamanager.service.ApiService;
import com.raju.dragonflyproject.datamanager.service.DragonService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * <p>
 * Todo Used Null Object pattern for DetailView ,
 * A null object replaces check of NULL object instance.
 * Instead of putting if check for a null value,
 * Null Object reflects a do nothing relationship.
 * Such Null object can also be used to provide default behaviour
 * in case data is not available.
 * Todo https://en.wikipedia.org/wiki/Null_object_pattern
 * </p>
 * Created by Raju Yadav
 */



public class DetailPresenter {

    private static final String TAG = DetailPresenter.class.getSimpleName();
    private final DragonService dragonService;
    private DetailView nullDetailView = new DetailView() {
        @Override
        public void loadDetailData(boolean status) {/*ignore*/}
    };

    private DetailView detailView = nullDetailView;
    private Disposable dragonStatusDisposable, dragonUpdateStatusDisposable;

    public DetailPresenter(DetailView detailView, String eventID) {
        this.detailView = detailView != null ? detailView : nullDetailView;
        dragonService = ApiService.INSTANCE.getDragonFlyService();
        loadStatus(eventID);
    }

    private void loadStatus(String eventID) {
        if (dragonService != null) {
            dragonStatusDisposable = dragonService.getEventStatus(eventID, ApiService.INSTANCE.getUSER_NAME())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(status -> detailView.loadDetailData(status.getComing()),
                            error -> Log.e(TAG, "Failed to get status of events" + error));
        }
    }

    public void updateStatus(String eventID, boolean userClickedStatus) {
        if (dragonService != null) {
            Log.e(TAG, "value " + eventID + " status " + userClickedStatus);
            dragonUpdateStatusDisposable = dragonService.updateEventStatus(eventID, ApiService.INSTANCE.getUSER_NAME(), new EventStatus(userClickedStatus))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(status -> Log.e(TAG, "Sucessfully to post status of events" + status.code()),
                            error -> Log.e(TAG, "Failed to post status of events" + error));
        }
    }

    public void tearDown(){
        detailView = null;
        if (dragonStatusDisposable != null){
            dragonStatusDisposable.dispose();
        }
        if (dragonUpdateStatusDisposable != null){
            dragonUpdateStatusDisposable.dispose();
        }
    }
}
