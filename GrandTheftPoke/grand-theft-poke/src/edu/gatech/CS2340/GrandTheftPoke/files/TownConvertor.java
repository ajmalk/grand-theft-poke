package edu.gatech.CS2340.GrandTheftPoke.files;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

public class TownConvertor implements Converter {
	XStream xstream;
	public TownConvertor(XStream xstream){
		xstream.alias("Game", GTPoke.class);
		this.xstream = xstream;
	}
	@Override
	public boolean canConvert(Class c) {
		return c.equals(Town.class);
	}

	@Override
	public void marshal(Object town, HierarchicalStreamWriter writer,
			MarshallingContext arg2) {
		writer.startNode(((Town)town).toString());
		//xstream.marshal(((Town)town).toString(), writer);
		xstream.marshal(((Town)town).getMarket(), writer);
		writer.close();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0,
			UnmarshallingContext arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
