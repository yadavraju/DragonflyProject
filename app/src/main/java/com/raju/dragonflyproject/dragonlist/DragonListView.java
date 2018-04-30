package com.raju.dragonflyproject.dragonlist;

import com.raju.dragonflyproject.datamanager.model.DragonFly;

import java.util.ArrayList;

public interface DragonListView {

    void initializeView();
    void loadLoadList(ArrayList<DragonFly> dragonFlies);
    void showProgress();
    void hideProgress();
    void showMessage(String message);
}
