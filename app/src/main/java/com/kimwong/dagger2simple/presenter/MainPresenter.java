package com.kimwong.dagger2simple.presenter;

import com.kimwong.dagger2simple.ui.MainActivity;
import com.kimwong.dagger2simple.model.MainModel;
import com.kimwong.dagger2simple.model.MainModelBean;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Huangjx on 2016/7/1.
 */
public class MainPresenter {
	private MainActivity mMainActivity;
	public MainModel mMainModel = new MainModel(this);

	@Inject
	@Singleton
	public MainPresenter(MainActivity mainActivity) {
		this.mMainActivity = mainActivity;
	}

	public void getData() {
		mMainActivity.showProgressBar();
		mMainModel.getData();
	}

	public void loadDataSuccess(List<MainModelBean> beans) {
		mMainActivity.showData(beans.get(0));
	}

	public void loadDataFailure() {
		mMainActivity.showData(null);
	}
}
