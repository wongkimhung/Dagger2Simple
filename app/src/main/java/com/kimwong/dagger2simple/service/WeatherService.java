package com.kimwong.dagger2simple.service;

import com.kimwong.dagger2simple.model.MainModelBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Huangjx on 2016/7/1.
 */
public interface WeatherService {
	@GET("{cityId}" + ".html")
	Observable<MainModelBean> getModelBean(@Path("cityId") String cityId);
}
