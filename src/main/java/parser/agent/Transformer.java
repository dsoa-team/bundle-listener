package parser.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

import parser.Property;
import parser.event.Event;

@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transformer {

	public static final String[] TYPES = {"mapping", "class"};
	
	@XmlAttribute(name = "type")
	private String type;
	
	@XmlElementWrapper(name = "input-events")
	@XmlElement(name = "event")
	private List<Event> inputEvents;
	
	@XmlElementWrapper(name = "output-events")
	@XmlElement(name = "event")
	private List<Event> outputEvents;
	
	@XmlElementWrapper(name = "mapping")
	@XmlElement(name = "property")
	private List<Property> mapping;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public List<Event> getOutputEvents() {
		return outputEvents;
	}

	public void setOutputEvents(List<Event> outputEvents) {
		this.outputEvents = outputEvents;
	}

	public List<Event> getInputEvents() {
		return inputEvents;
	}

	public void setInputEvents(List<Event> inputEvents) {
		this.inputEvents = inputEvents;
	}

	public Map<String, String> getMapping() {
		Map<String, String> props  = new HashMap<String, String>();
		for(Property p : mapping){
			props.put(p.getId(), p.getType());
		}
		
		return props;
	}

	public void setMapping(List<Property> mapping) {
		this.mapping = mapping;
	}

}
