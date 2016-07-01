package com.kimwong.dagger2simple.model.component;

import com.kimwong.dagger2simple.model.modules.MainPresenterModule;
import com.kimwong.dagger2simple.ui.MainActivity;

import dagger.Component;

/**
 * Created by Huangjx on 2016/7/1.
 */
@Component(modules = {MainPresenterModule.class})
public interface MainComponent {
	void inject(MainActivity mainActivity);
}
