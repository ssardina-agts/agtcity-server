package massim.protocol.scenario.city.data;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Vector;

/**
 * Holds complete info of an item for serialization.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ItemData {

    @XmlAttribute
    public String name;

    @XmlAttribute
    public int volume;

    @XmlElement(name="item")
    public List<NameData> parts;

    @XmlElement(name="role")
    public List<NameData> roles;

    /**
     * For JAXB
     */
    private ItemData(){}

    /**
     * Constructor.
     * @param name name of the item
     * @param volume volume of the item
     * @param requiredParts items required to assemble the item (may be null or empty)
     * @param roles roles required to assemble the item (may be null or empty)
     */
    public ItemData(String name, int volume, List<NameData> requiredParts, List<NameData> roles){
        this.name = name;
        this.volume = volume;
        if(requiredParts.size() > 0) parts = requiredParts;
        if(roles.size() > 0) this.roles = roles;
    }

    /**
     * @return the item's name
     */
    public String getName() {
        return name == null? "" : name;
    }

    /**
     * @return the item's volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * @return a list of the required items to craft this item or null if no items are required
     */
    public List<NameData> getParts() {
        return parts == null? new Vector<>() : parts;
    }

    /**
     * @return a list of all roles necessary to craft this item or null if no roles required
     */
    public List<NameData> getRoles() {
        return roles == null? new Vector<>() : roles;
    }
}