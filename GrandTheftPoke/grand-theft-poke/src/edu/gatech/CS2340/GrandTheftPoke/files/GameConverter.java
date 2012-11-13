package edu.gatech.CS2340.GrandTheftPoke.files;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

import edu.gatech.CS2340.GrandTheftPoke.GTPoke;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

public class GameConverter implements Converter{
	XStream xstream;
	public GameConverter(XStream xstream){
		xstream.alias("Game", GTPoke.class);
		xstream.processAnnotations(Player.class);
		xstream.aliasPackage("", "edu.gatech.CS2340.GrandTheftPoke.backend.Items");
		
		this.xstream = xstream;
	}
	@Override
	public boolean canConvert(Class c) {
		return c.equals(GTPoke.class);
	}

	@Override
	public void marshal(Object game, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		//xstream.autodetectAnnotations(true);
		//xstream.registerConverter(new PersonConverter());
		//xstream.registerConverter(new BackpackMapConverter<Item, Integer>(xstream.getMapper(),"type"));
		//context.convertAnother(((GTPoke)game).getPlayer());
		xstream.marshal(((GTPoke)game).getPlayer(), writer);
		xstream.registerConverter(new TownConvertor());
		xstream.marshal(((GTPoke)game).getMap(), writer);
		//xstream.marshal(((GTPoke)game).getMap().getTownSet().toArray()[0], writer);
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader arg0,
			UnmarshallingContext arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class PersonConverter implements Converter {
		@Override
		public boolean canConvert(Class c) {
			return c.getGenericSuperclass().equals(Person.class);
		}

		@Override
		public void marshal(Object person, HierarchicalStreamWriter writer,
				MarshallingContext arg2) {
			writer.addAttribute("name", ((Person)person).getName());
			writer.startNode("Skills");
			//writer.addAttribute("agility", arg1)
		}

		@Override
		public Object unmarshal(HierarchicalStreamReader arg0,
				UnmarshallingContext arg1) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	private class TownConvertor implements Converter {
		@Override
		public boolean canConvert(Class c) {
			return c.equals(Town.class);
		}

		@Override
		public void marshal(Object town, HierarchicalStreamWriter writer,
				MarshallingContext arg2) {
			//writer.startNode(((Town)town).toString());
			writer.addAttribute("town", ((Town)town).toString());
			//xstream.marshal(((Town)town).toString(), writer);
			xstream.registerConverter(new ItemConvertor());
			xstream.marshal(((Town)town).getMarket(), writer);
			//writer.close();
		}

		@Override
		public Object unmarshal(HierarchicalStreamReader arg0,
				UnmarshallingContext arg1) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	private class ItemConvertor implements SingleValueConverter {
		@Override
		public boolean canConvert(Class c) {
			//return c.getGenericSuperclass().equals(Item.class);
			return c.getPackage().equals(Package.getPackage("edu.gatech.CS2340.GrandTheftPoke.backend.Items"));
		}

		@Override
		public Object fromString(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toString(Object item) {
			return ((Item)item).toString();
		}

	}
	
	private class BackPackEntry implements SingleValueConverter {
		@Override
		public boolean canConvert(Class c) {
			//return c.getGenericSuperclass().equals(Item.class);
			return c.equals(new Entry<Item, Integer>() {
				@Override
				public Item getKey() {	return null;	}
				@Override
				public Integer getValue() {		return null;	}
				@Override
				public Integer setValue(Integer value) {	return null;	}
			}.getClass());
		}

		@Override
		public Object fromString(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String toString(Object entry) {
			return ((Entry)entry).getValue().toString();
		}

	}
	
	class BackpackMapConverter<K,V> extends MapConverter {
		private final String attributename;

		public BackpackMapConverter(Mapper mapper, String attributename) {
			super(mapper);
			this.attributename = attributename;
		}

		public boolean canConvert(Class type) {
			return type.equals(HashMap.class);
		}

		public void marshal(Object source, HierarchicalStreamWriter writer,
				MarshallingContext context) {
			Map<K, V> map = (Map<K, V>) source;
			for (Map.Entry<K, V> entry : map.entrySet()) {
				K value = (K) entry.getValue();
				//writer.startNode(mapper().serializedClass(value.getClass()));
				//writer.addAttribute(attributename, entry.getKey().toString());
				//context.convertAnother(value);
				//writer.endNode();
			}
		}

		public Object unmarshal(HierarchicalStreamReader reader,
				UnmarshallingContext context) {
			Map<K, V> map = new HashMap<K, V>();
			populateStringMap(reader, context, map);
			return map;
		}

		protected void populateStringMap(HierarchicalStreamReader reader,
				UnmarshallingContext context,
				Map<K, V> map) {
			while (reader.hasMoreChildren()) {
				reader.moveDown();
				String key = reader.getAttribute(attributename);
				V value = (V) readItem(reader, context, map);
				reader.moveUp();
				map.put((K) key, value);
			}
		}
	}
}
