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

import java.util.List;

import com.github.alberteinstein29.indeed4j.fragments.Format;
import com.github.alberteinstein29.indeed4j.models.IndeedJob;
import com.github.alberteinstein29.indeed4j.models.JobDetail;

public class Example {

	private final static String publisherID = "YOUR_PUBLISHER_ID";

	public static void main(String[] args) {

		JIndeed ji = new JIndeed(publisherID);
		String result = ji.Query("Java").Location("auckland")
				.FormatType(Format.JSON).Limit("10").build();
		System.out.println(result);

		IndeedJob ij = ji.jsonToPOJO(result);
		List<JobDetail> jd = ij.getJobList();
		System.out.println("Company: " + jd.get(1).getCompany()
				+ ", job title: " + jd.get(1).getJobtitle());

	}

}
