package edu.gatech.CS2340.GrandTheftPoke.files;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

public class SaveConverter implements Converter{
	XStream xstream;
	public SaveConverter(XStream xstream){
		xstream.alias("Game", SaveGame.class);
		xstream.processAnnotations(Player.class);
		//xstream.aliasPackage("", "edu.gatech.CS2340.GrandTheftPoke.backend.Items");
		xstream.registerConverter(new BackpackConverter());
		xstream.registerConverter(new MarketConverter());
		this.xstream = xstream;
	}
	@Override
	public boolean canConvert(Class c) {
		return c.equals(SaveGame.class);
	}

	@Override
	public void marshal(Object game, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		//xstream.marshal(((SaveGame)game).getPlayer(), writer);
		//xstream.marshal(((SaveGame)game).getMap(), writer);
		writer.startNode("Player");
		context.convertAnother(((SaveGame)game).getPlayer());
		writer.endNode();
		writer.startNode("Map");
		context.convertAnother(((SaveGame)game).getMap());
		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		SaveGame save = new SaveGame();
		reader.moveDown();
		Player player = (Player) context.convertAnother(save, Player.class);
		reader.moveUp();
		reader.moveDown();
		GameMap map = (GameMap) context.convertAnother(save, Player.class);
		reader.moveUp();
		return new SaveGame(player, map);
	}
	
	
	/*class BackpackMapConverter<K,V> extends MapConverter {
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
	}*/
}
