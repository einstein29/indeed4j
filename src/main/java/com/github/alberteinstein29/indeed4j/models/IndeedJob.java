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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name="response")
public class IndeedJob {

	private Integer version;
	private String query;
	private String location;
	private String paginationPayload;
	private boolean dupefilter;
	private boolean highlight;
	private Integer totalResults;
	private Integer start;
	private Integer end;
	private Integer pageNumber;
	private List<JobDetail> jobList;
	
	public Integer getVersion() {
		return version;
	}

	public String getQuery() {
		return query;
	}

	public String getLocation() {
		return location;
	}

	public String getPaginationPayload() {
		return paginationPayload;
	}

	public boolean isDupefilter() {
		return dupefilter;
	}

	public boolean isHighlight() {
		return highlight;
	}

	public Integer getTotalResults() {
		return totalResults;
	}

	public Integer getStart() {
		return start;
	}

	public Integer getEnd() {
		return end;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPaginationPayload(String paginationPayload) {
		this.paginationPayload = paginationPayload;
	}

	public void setDupefilter(boolean dupefilter) {
		this.dupefilter = dupefilter;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	@JsonProperty("results")
	@XmlElementWrapper(name="results")
	@XmlElement(name="result")
	public List<JobDetail> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobDetail> jobList) {
		this.jobList = jobList;
	}

	@Override
	public String toString() {
		return "IndeedJonb [dupefilter = " + dupefilter + ", results = "
				+ ", start = " + start + ", totalResults = "
				+ totalResults + ", location = " + location
				+ ", paginationPayload = " + paginationPayload + ", query = "
				+ query + ", pageNumber = " + pageNumber + ", highlight = "
				+ highlight + ", end = " + end + ", version = " + version + "]";
	}
}