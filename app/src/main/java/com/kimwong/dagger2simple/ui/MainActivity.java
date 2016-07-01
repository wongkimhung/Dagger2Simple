package com.kimwong.dagger2simple.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.kimwong.dagger2simple.R;
import com.kimwong.dagger2simple.model.MainModelBean;
import com.kimwong.dagger2simple.model.component.DaggerMainComponent;
import com.kimwong.dagger2simple.model.modules.MainPresenterModule;
import com.kimwong.dagger2simple.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

	@Inject
	MainPresenter mMainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		DaggerMainComponent.builder()
				.mainPresenterModule(new MainPresenterModule(this))
				.build()
				.inject(this);
		mMainPresenter.getData();

	}

	public void showData(MainModelBean mainModelBean) {
		Toast.makeText(MainActivity.this, "mainModelBean = [" + mainModelBean + "]", Toast.LENGTH_SHORT).show();
	}

	public void showProgressBar() {
		Toast.makeText(MainActivity.this, "MainActivity.showProgressBar", Toast.LENGTH_SHORT).show();
	}
}
