package com.lampumimpi.sunshine.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glkrenx on 12/11/16.
 */

public class APIResponse {
	@SerializedName("cod")
	@Expose
	private String cod;
	@SerializedName("message")
	@Expose
	private String message;
	@SerializedName("list")
	@Expose
	private List<Weather> weathers = new ArrayList<Weather>();

	public String getCod() {
		return cod;
	}

	public String getMessage() {
		return message;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}
}
