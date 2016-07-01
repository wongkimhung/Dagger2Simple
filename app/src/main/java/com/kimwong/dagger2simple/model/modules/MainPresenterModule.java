package com.kimwong.dagger2simple.model.modules;

import com.kimwong.dagger2simple.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Huangjx on 2016/7/1.
 */
@Module
public class MainPresenterModule {
	private MainActivity mMainActivity;

	public MainPresenterModule(MainActivity mainActivity) {
		mMainActivity = mainActivity;
	}

	@Provides
	public MainActivity provideMainActivity() {
		return mMainActivity;
	}
}
