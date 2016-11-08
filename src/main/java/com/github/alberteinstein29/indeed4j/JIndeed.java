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

package com.github.alberteinstein29.indeed4j;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.ExecutionException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alberteinstein29.indeed4j.fragments.*;
import com.github.alberteinstein29.indeed4j.models.IndeedJob;
import com.github.alberteinstein29.indeed4j.utils.HttpClient;

public class JIndeed {

	private String callback = "&callback=";
	private String channelName = "&chnl=";
	private String filter = "&filter=1";
	private String fromage = "&fromage=";
	private String highlight = "&highlight=0";
	private String jobKeys = "&jobkeys=";
	private String latlong = "&latlong=0";
	private String limit = "&limit=10";
	private String location = "&l=";
	private String publisherID;
	private String query = "&q=";
	private String radius = "&radius=25";
	private String start = "&start=0";
	private String siteType = "&st=";
	private String userIP = "&userip=";

	private Country country = Country.NEW_ZEALAND;
	private Format formatType = Format.XML;
	private JobType jobType = JobType.ALL;
	private Sort sortType = Sort.RELEVANCE;
	private UserAgent userAgent = UserAgent.MOZILLA5;

	private final String VERSION = "&v=2";
	private String url = "http://api.indeed.com/ads/apisearch?";

	/**
	 * Sets the Publisher ID.
	 * 
	 * @param publisherID
	 * @return The instance of this class
	 */
	public JIndeed(String publisherID) {
		this.publisherID = publisherID;
	}

	/**
	 * Sets the callback method. The name of a javascript function to use as a
	 * callback to which the results of the search are passed
	 * 
	 * @param callback
	 *            The callback fucntion's name.
	 * @return The instance of this class
	 */
	public JIndeed Callback(String callback) {
		this.callback += callback;
		return this;
	}

	/**
	 * Sets the channel name. Group API requests to a specific channel.
	 * 
	 * @param channelName
	 * @return The instance of this class
	 */
	public JIndeed ChannelName(String channelName) {
		this.channelName += channelName;
		return this;
	}

	/**
	 * Sets this value to 0 will turn off duplicate job filtering. Default is 1.
	 * 
	 * @param _switch
	 * @return The instance of this class
	 */
	public JIndeed Filter(Switch _switch) {
		this.filter = "&filter=" + _switch.getStatus();
		return this;
	}

	/**
	 * Sets the number of days back to search.
	 * 
	 * @param fromage
	 * @return The instance of this class
	 */
	public JIndeed Fromage(String fromage) {
		this.fromage += fromage;
		return this;
	}

	/**
	 * Sets this value to 1 will bold terms in the snippet that are also present
	 * in q. Default is 0.
	 * 
	 * @param _switch
	 * @return The instance of this class
	 */
	public JIndeed Highlight(Switch _switch) {
		this.highlight = "&highlight=" + _switch.getStatus();
		return this;
	}

	/**
	 * There is now an additional API available for looking up individual jobs
	 * using the jobkey. Sets the job's key. A comma separated list of job keys
	 * specifying the jobs to look up.
	 * 
	 * @param jobKeys
	 * @return The instance of this class
	 */
	public JIndeed JobKeys(String jobKeys) {
		this.jobKeys = jobKeys;
		return this;
	}

	/**
	 * Sets this value to 1 will return latitude and longitude information for
	 * each job result. Default is 0.
	 * 
	 * @param _switch
	 * @return The instance of this class
	 */
	public JIndeed LatLong(Switch _switch) {
		this.latlong = "&latlong=" + _switch.getStatus();
		return this;
	}

	/**
	 * Sets the maximum number of results returned per query. Default is 10.
	 * 
	 * @param limit
	 * @return The instance of this class
	 */
	public JIndeed Limit(String limit) {
		this.limit = "&limit=" + limit;
		return this;
	}

	/**
	 * Sets the location. Use a postal code or a "city, state/province/region"
	 * combination. For a better precision, it is recommended to set both names
	 * for city and country.
	 * 
	 * @param location
	 * @return The instance of this class
	 */
	public JIndeed Location(String location) {
		this.location += location.replaceAll("\\s+", "+");
		return this;
	}

	/**
	 * Sets the query value. For instance, "java" or "c#".
	 * 
	 * @param query
	 * @return The instance of this class
	 */
	public JIndeed Query(String query) {
		this.query += query;
		return this;
	}

	/**
	 * Sets the distance from search location ("as the crow flies"). Default is
	 * 25.
	 * 
	 * @param radius
	 * @return The instance of this class
	 */
	public JIndeed Radius(String radius) {
		this.radius = "&radius=" + radius;
		return this;
	}

	/**
	 * Starts results at this result number, beginning with 0. Default is 0.
	 * 
	 * @param pos
	 * @return The instance of this class
	 */
	public JIndeed Start(String pos) {
		this.start = "&start=" + pos;
		return this;
	}

	/**
	 * Sets the site's type. To show only jobs from job boards use "jobsite".
	 * For jobs from direct employer websites use "employer". .
	 * 
	 * @param siteType
	 * @return The instance of this class
	 */
	public JIndeed SiteType(String siteType) {
		this.siteType += siteType;
		return this;
	}

	/**
	 * Sets the user IP.
	 * 
	 * @param userIP
	 * @return The instance of this class
	 */
	public JIndeed UserIP(String userIP) {
		this.userIP += userIP;
		return this;
	}

	/**
	 * Sets the country. Default is New Zealand.
	 * 
	 * @param country
	 * @return The instance of this class
	 */
	public JIndeed Country(Country country) {
		this.country = country;
		return this;
	}

	/**
	 * Sets the response type of the API you wish to use. The options are "xml"
	 * and "json". If omitted or invalid, the XML format is used.
	 * 
	 * @param formatType
	 * @return The instance of this class
	 */
	public JIndeed FormatType(Format formatType) {
		this.formatType = formatType;
		return this;
	}

	/**
	 * Sets the job type. Allowed values: "fulltime", "parttime", "contract",
	 * "internship", "temporary".
	 * 
	 * @param jobType
	 * @return The instance of this class
	 */
	public JIndeed withJobType(JobType jobType) {
		this.jobType = jobType;
		return this;
	}

	/**
	 * Sorts by relevance or date. Default is relevance.
	 * 
	 * @param sortType
	 * @return The instance of this class
	 */
	public JIndeed Sort(Sort sortType) {
		this.sortType = sortType;
		return this;
	}

	/**
	 * Sets the User-Agent. Default is Mozilla/5.0.
	 * 
	 * @param userAgent
	 * @return The instance of this class
	 */
	public JIndeed UserAgent(UserAgent userAgent) {
		this.userAgent = userAgent;
		return this;
	}

	/**
	 * @return the response from calling APIs.
	 */
	public String build() {
		String result = "";
		try {
			HttpClient hc = new HttpClient(url(), userAgent);
			result = hc.getResponse();
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @return url.
	 */
	private String completeURL() {
		return "publisher=" + publisherID + VERSION + callback
				+ formatType.getFormat() + query + location + jobKeys
				+ sortType.getSort() + radius + siteType + jobType.getJobType()
				+ start + limit + fromage + highlight + filter + latlong
				+ country.getCountry() + channelName + userIP + "&useragent="
				+ userAgent.getUserAgent();
	}

	/**
	 * @return the completed url.
	 */
	public String url() {
		return url + completeURL();
	}

	/**
	 * Converts the returned Json string to a POJO.
	 * 
	 * @param input
	 * @return an instance of IndeedJob
	 */
	public IndeedJob jsonToPOJO(String input) {
		ObjectMapper mapper = new ObjectMapper();
		IndeedJob indeedJob = null;
		try {
			indeedJob = mapper.readValue(input, IndeedJob.class);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return indeedJob;
	}

	/**
	 * Converts the returned XML string to a POJO.
	 * 
	 * @param input
	 * @return an instance of IndeedJob
	 */
	public IndeedJob xmlToPOJO(String input) {
		IndeedJob indeedJob = null;
		try {
			StringReader stringReader = new StringReader(input);
			JAXBContext jaxbContext = JAXBContext.newInstance(IndeedJob.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			indeedJob = (IndeedJob) jaxbUnmarshaller.unmarshal(stringReader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return indeedJob;
	}
}
