package edu.gatech.CS2340.GrandTheftPoke.files;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;

public class TownConverter implements Converter {

    public void marshal(Object town, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        writer.addAttribute("town", ((Town) town).toString());
    }

    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
        return null;
    }

    public boolean canConvert(Class type) {
        return type.equals(Town.class);
    }
}