package edu.gatech.CS2340.GrandTheftPoke.files;

import java.util.HashMap;
import java.util.Map;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

import edu.gatech.CS2340.GrandTheftPoke.backend.Backpack;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

public class SaveConverter implements Converter{
	XStream xstream;
	public SaveConverter(XStream xstream){
		xstream.alias("Game", SaveGame.class);
		xstream.processAnnotations(Player.class);
		xstream.aliasPackage("", "edu.gatech.CS2340.GrandTheftPoke.backend.Items");
		xstream.registerConverter(new BackpackConverter());
		xstream.registerConverter(new MarketConverter());
		xstream.registerConverter(new TownConverter());
		this.xstream = xstream;
	}
	@Override
	public boolean canConvert(Class c) {
		return c.equals(SaveGame.class);
	}

	@Override
	public void marshal(Object game, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		xstream.marshal(((SaveGame)game).getPlayer(), writer);
		xstream.marshal(((SaveGame)game).getMap(), writer);
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext arg1) {
		Player player = new Player();
		GameMap map = new GameMap();
		reader.moveDown();
		xstream.unmarshal(reader, player);
		xstream.unmarshal(reader, map);
		reader.moveUp();
		return new SaveGame(player, map);
	}
	
	private class BackpackConverter implements Converter {
		public BackpackConverter(){
			xstream.registerConverter(new BackpackMapConverter<Item, Integer>(xstream.getMapper(), "type"));
		}
		@Override
		public boolean canConvert(Class c) {
			return c.equals(Backpack.class);
		}
		@Override
		public void marshal(Object backpack, HierarchicalStreamWriter writer,
				MarshallingContext context) {
			writer.addAttribute("capacity", ((Backpack)backpack).getCapacity().toString());
			writer.addAttribute("range", ((Backpack)backpack).getMaxRange().toString());
			context.convertAnother(((Backpack)backpack).getContents());
		}
		@Override
		public Object unmarshal(HierarchicalStreamReader reader,
				UnmarshallingContext arg1) {
			int capacity = Integer.parseInt(reader.getAttribute("capacity"));
			int range = Integer.parseInt(reader.getAttribute("range"));
			return null;
		}
	}
	private class MarketConverter implements Converter {
		@Override
		public boolean canConvert(Class c) {
			return c.equals(MarketPlace.class);
		}

		@Override
		public void marshal(Object market, HierarchicalStreamWriter writer,
				MarshallingContext context) {
			xstream.registerConverter(new MarketMapConverter(xstream.getMapper(), "type"));
			context.convertAnother(((MarketPlace)market).getStock());
		}
		@Override
		public Object unmarshal(HierarchicalStreamReader arg0,
				UnmarshallingContext arg1) {
			// TODO Auto-generated method stub
			return null;
		}
	}
	private class TownConverter implements Converter {
		@Override
		public boolean canConvert(Class c) {
			return c.equals(Town.class);
		}
		@Override
		public void marshal(Object town, HierarchicalStreamWriter writer,
				MarshallingContext arg2) {
			writer.addAttribute("town", ((Town)town).toString());
			xstream.registerConverter(new ItemConverter());
			xstream.marshal(((Town)town).getMarket(), writer);
		}
		@Override
		public Object unmarshal(HierarchicalStreamReader arg0,
				UnmarshallingContext arg1) {
			return null;
		}
	}
	private class ItemConverter implements SingleValueConverter {
		@Override
		public boolean canConvert(Class c) {
			return c.getPackage().equals(Package.getPackage("edu.gatech.CS2340.GrandTheftPoke.backend.Items"));
		}
		@Override
		public Object fromString(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String toString(Object item) {
			return "";
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
				writer.startNode(entry.getKey().toString());
				writer.addAttribute("stock", entry.getValue().toString());
				writer.endNode();
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
	class MarketMapConverter<K> extends MapConverter {
		private final String attributename;
		public MarketMapConverter(Mapper mapper, String attributename) {
			super(mapper);
			this.attributename = attributename;
		}

		public boolean canConvert(Class type) {
			return type.equals(HashMap.class);
		}

		public void marshal(Object source, HierarchicalStreamWriter writer,
				MarshallingContext context) {
			Map<K, MarketPlaceItem> map = (Map<K, MarketPlaceItem>) source;
			for (Map.Entry<K, MarketPlaceItem> entry : map.entrySet()) {
				K value = (K) entry.getValue();
				writer.startNode(entry.getKey().toString());
				writer.addAttribute("price", entry.getValue().getPrice().toString());
				writer.addAttribute("stock", entry.getValue().getStock().toString());
				writer.endNode();
			}
		}

		public Object unmarshal(HierarchicalStreamReader reader,
				UnmarshallingContext context) {
			Map<K, MarketPlaceItem> map = new HashMap<K, MarketPlaceItem>();
			populateStringMap(reader, context, map);
			return map;
		}

		protected void populateStringMap(HierarchicalStreamReader reader,
				UnmarshallingContext context,
				Map<K, MarketPlaceItem> map) {
			while (reader.hasMoreChildren()) {
				reader.moveDown();
				String key = reader.getAttribute(attributename);
				MarketPlaceItem value = (MarketPlaceItem) readItem(reader, context, map);
				reader.moveUp();
				map.put((K) key, value);
			}
		}
	}
}