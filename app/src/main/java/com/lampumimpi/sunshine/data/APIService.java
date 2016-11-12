package com.lampumimpi.sunshine.data;

import com.lampumimpi.sunshine.model.APIResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by glkrenx on 12/11/16.
 */

public interface APIService {

	public static final String API_URL = "http://api.openweathermap.org/data/2.5/";

	@GET("forecast")
	Call<APIResponse> getWeather(@Query("q") String kota, @Query("mode") String mode,
								 @Query("appid") String KEY, @Query("cnt") int LIMIT);

	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(API_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build();

	APIService service = retrofit.create(APIService.class);
}
