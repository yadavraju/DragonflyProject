package com.raju.dragonflyproject.Utils;

import android.support.annotation.Nullable;

import java.util.Collection;

public class CollectionUtils {

    public static boolean isCollectionEmpty(@Nullable Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
