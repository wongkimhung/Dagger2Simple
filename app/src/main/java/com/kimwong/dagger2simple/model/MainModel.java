package com.kimwong.dagger2simple.model;

import com.kimwong.dagger2simple.presenter.MainPresenter;
import com.kimwong.dagger2simple.service.WeatherService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Huangjx on 2016/7/1.
 */
public class MainModel {
	MainPresenter mMainPresenter;

	public MainModel(MainPresenter mainPresenter) {
		mMainPresenter = mainPresenter;
	}

	String baseUrl = "http://www.weather.com.cn/adat/sk/";
	private List<MainModelBean> list = new ArrayList<>();

	public void getData() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();

		WeatherService weatherService = retrofit.create(WeatherService.class);
		weatherService.getModelBean("101010100")
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<MainModelBean>() {
					@Override
					public void onCompleted() {
						mMainPresenter.loadDataSuccess(list);
					}

					@Override
					public void onError(Throwable e) {
						mMainPresenter.loadDataFailure();
					}

					@Override
					public void onNext(MainModelBean mainModelBean) {
						list.add(mainModelBean);
					}
				});
	}
}
