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

package com.github.alberteinstein29.indeed4j.fragments;

public enum Country {

	ANTARCTICA("&co=aq"),
	ARGENTINA("&co=ar"),
	AUSTRALIA("&co=au"),
	AUSTRIA("&co=at"),
	BAHRAIN("&co=bh"),
	BELGIUM("&co=be"),
	BRAZIL("&co=br"),
	CANADA("&co=ca"),
	CHILE("&co=cl"),
	CHINA("&co=cn"),
	COLOMBIA("&co=co"),
	COSTA_RICA("&co=cr"),
	CZECH_REPUBLIC("&co=cz"),
	DENMARK("&co=dk"),
	ECUADOR("&co=ec"),
	EGYPT("&co=eg"),
	FINLAND("&co=fi"),
	FRANCE("&co=fr"),
	GERMANY("&co=de"),
	GREECE("&co=gr"),
	HONG_KONG("&co=hk"),
	HUNGARY("&co=hu"),
	INDIA("&co=in"),
	INDONESIA("&co=id"),
	IRELAND("&co=ie"),
	ISRAEL("&co=il"),
	ITALY("&co=it"),
	JAPAN("&co=jp"),
	KUWAIT("&co=kw"),
	LUXEMBOURG("&co=lu"),
	MALAYSIA("&co=my"),
	MEXICO("&co=mx"),
	MOROCCO("&co=ma"),
	NETHERLANDS("&co=nl"),
	NEW_ZEALAND("&co=nz"),
	NIGERIA("&co=ng"),
	NORWAY("&co=no"),
	OMAN("&co=om"),
	PAKISTAN("&co=pk"),
	PANAMA("&co=pa"),
	PERU("&co=pe"),
	PHILIPPINES("&co=ph"),
	POLAND("&co=pl"),
	PORTUGAL("&co=pt"),
	QATAR("&co=qa"),
	ROMANIA("&co=ro"),
	RUSSIA("&co=ru"),
	SAUDI_ARABIA("&co=sa"),
	SINGAPORE("&co=sg"),
	SOUTH_AFRICA("&co=za"),
	SOUTH_KOREA("&co=kr"),
	SPAIN("&co=es"),
	SWEDEN("&co=se"),
	SWITZERLAND("&co=ch"),
	TAIWAN("&co=tw"),
	THAILAND("&co=th"),
	TURKEY("&co=tr"),
	UKRAINE("&co=ua"),
	UNITED_ARAB_EMIRATES("&co=ae"),
	UNITED_KINGDOM("&co=gb"),
	UNITED_STATES("&co=us"),
	URUGUAY("&co=uy"),
	VENEZUELA("&co=ve"),
	VIETNAM("&co=vn");
	
	private String country;

	Country(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
}
