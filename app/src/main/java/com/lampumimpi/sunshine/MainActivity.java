package com.lampumimpi.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lampumimpi.sunshine.data.APIService;
import com.lampumimpi.sunshine.model.APIResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

	ListView listview;
	Call<APIResponse> responseCall;
	ArrayAdapter<String> adapter;
	ArrayList<String> strings = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (ListView)findViewById(R.id.listview);

		getAPI();

	}

	void getAPI(){
		responseCall = APIService.service.getWeather("Bandung", "json",
				getResources().getString(R.string.API_KEY), 5);
		responseCall.enqueue(new Callback<APIResponse>() {
			@Override
			public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
				if (response.isSuccessful()){
					APIResponse body = response.body();

					for (int i = 0; i < body.getWeathers().size(); i++){
						String temp = String.valueOf(body.getWeathers().get(i).getMainWeather().getTemp());
						strings.add(temp);
					}

					adapter = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1, strings);
					listview.setAdapter(adapter);
				}
			}

			@Override
			public void onFailure(Call<APIResponse> call, Throwable t) {

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
}