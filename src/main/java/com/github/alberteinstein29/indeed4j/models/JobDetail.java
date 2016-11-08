/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2016 Rui Gong
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.alberteinstein29.indeed4j.models;

public class JobDetail {
	
	private String jobtitle;
	private String company;
	private String city;
	private String state;
	private String country;
	private String formattedLocation;
	private String source;
	private String date;
	private String snippet;
	private String url;
	private String onmousedown;
	private String jobkey;
	private boolean sponsored;
	private boolean expired;
	private boolean indeedApply;
	private String formattedLocationFull;
	private String formattedRelativeTime;
	private String stations;

	public String getJobtitle() {
		return jobtitle;
	}

	public String getCompany() {
		return company;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getFormattedLocation() {
		return formattedLocation;
	}

	public String getSource() {
		return source;
	}

	public String getDate() {
		return date;
	}

	public String getSnippet() {
		return snippet;
	}

	public String getUrl() {
		return url;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public String getJobkey() {
		return jobkey;
	}

	public boolean isSponsored() {
		return sponsored;
	}

	public boolean isExpired() {
		return expired;
	}

	public boolean isIndeedApply() {
		return indeedApply;
	}

	public String getFormattedLocationFull() {
		return formattedLocationFull;
	}

	public String getFormattedRelativeTime() {
		return formattedRelativeTime;
	}

	public String getStations() {
		return stations;
	}
	
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFormattedLocation(String formattedLocation) {
		this.formattedLocation = formattedLocation;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public void setJobkey(String jobkey) {
		this.jobkey = jobkey;
	}

	public void setSponsored(boolean sponsored) {
		this.sponsored = sponsored;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public void setIndeedApply(boolean indeedApply) {
		this.indeedApply = indeedApply;
	}

	public void setFormattedLocationFull(String formattedLocationFull) {
		this.formattedLocationFull = formattedLocationFull;
	}

	public void setFormattedRelativeTime(String formattedRelativeTime) {
		this.formattedRelativeTime = formattedRelativeTime;
	}

	public void setStations(String stations) {
		this.stations = stations;
	}
	
	@Override
	public String toString() {
		return "JobDetail [formattedLocationFull = " + formattedLocationFull
				+ ", formattedLocation = " + formattedLocation + ", expired = "
				+ expired + ", stations = " + stations + ", indeedApply = "
				+ indeedApply + ", state = " + state + ", snippet = " + snippet
				+ ", date = " + date + ", url = " + url + ", city = " + city
				+ ", country = " + country + ", jobtitle = " + jobtitle
				+ ", source = " + source + ", jobkey = " + jobkey
				+ ", company = " + company + ", onmousedown = " + onmousedown
				+ ", sponsored = " + sponsored + ", formattedRelativeTime = "
				+ formattedRelativeTime + "]";
	}
}
