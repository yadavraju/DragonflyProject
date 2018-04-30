package com.raju.dragonflyproject.datamanager.service;

import com.raju.dragonflyproject.datamanager.model.DragonFly;
import com.raju.dragonflyproject.datamanager.model.EventStatus;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DragonService {

    String BASE_URL = "http://dev.dragonflyathletics.com:1337/";

    @GET("api/dfkey/events")
    Observable<ArrayList<DragonFly>> getDragonList();

    @GET("api/dfkey/events/{eventId}/status/{username}")
    Observable<EventStatus> getEventStatus(@Path("eventId") String eventId, @Path("username") String username);

    @PUT("api/dfkey/events/{eventId}/status/{username}")
    Observable<Response<EventStatus>> updateEventStatus(@Path("eventId") String eventId, @Path("username") String username, @Body EventStatus eventStatus);
}
