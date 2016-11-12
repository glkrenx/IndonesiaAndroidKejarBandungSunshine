package com.lampumimpi.sunshine.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by glkrenx on 12/11/16.
 */

public class Weather {
	@SerializedName("dt")
	@Expose
	private String dt;
	@SerializedName("dt_txt")
	@Expose
	private String dt_txt;
	@SerializedName("main")
	@Expose
	private MainWeather mainWeather;

	public String getDt() {
		return dt;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public MainWeather getMainWeather() {
		return mainWeather;
	}
}
