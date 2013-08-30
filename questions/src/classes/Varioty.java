package classes;

import java.util.ArrayList;
import java.util.List;

public class Varioty {
    private int pictureId;

    private String name; //название группы загадок
    private String description; //описание группы
    private List<Mystery> mysteries = new ArrayList<Mystery>();
    
    public Varioty()
    {}
    
    public Varioty(String name, String description, int pictureId, List<Mystery> mysteries)
    {
    	this.name = name;
    	this.description = description;
    	this.pictureId = pictureId;
    	this.mysteries = mysteries;
    }
    
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Mystery> getMysteries() {
		return mysteries;
	}
	public void setMysteries(List<Mystery> mysteries) {
		this.mysteries = mysteries;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

 
    
}
