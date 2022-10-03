package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlace;

public class TestDataBuild {
public addPlace addPlacePayload(String name,String language,String address)
{
	addPlace p=new addPlace();
	p.setAccuracy(50);
	p.setName(name);
	p.setPhone_number("(+91) 983 893 3937");
	p.setAddress(address);
	p.setWebsite("http://google.com");
	p.setLanguage(language);
	List<String> mylist=new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	p.setTypes(mylist);
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng( 33.427362);
	p.setLocation(l);
	return p;
	
}
}
