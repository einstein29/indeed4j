# indeed4j #
 A java API for [nz.indeed.com](http://nz.indeed.com/). This is an implementation for the basic APIs. The default country is set to New Zealand. Developed by using Java 1.8.

## Example ##

To find out how many Java related jobs are in Wellington:

	JIndeed ji = new JIndeed(publisherID);
	String result = ji.Query("Java").Location("wellington").FormatType(Format.JSON).Limit("0").build();
	System.out.println(result);

There are two response types are supported by indeed.com, and you can convert the returned JSON and XML strings to POJOs:

	IndeedJob indeedJson = ji.jsonToPOJO(result);
	IndeedJob indeedXML  = ji.xmlToPOJO(result);

## TODO ##

- Includes advanced search.
- Includes API for jobkeys.
- URL depends on the selected country.

## License ##

[The MIT License](https://opensource.org/licenses/MIT).