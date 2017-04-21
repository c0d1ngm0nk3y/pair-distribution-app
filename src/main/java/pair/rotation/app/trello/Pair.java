package pair.rotation.app.trello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pair {

	private List<Developer> devs;

    public Pair() {
    	devs = new ArrayList<Developer>(2);
    }

    public Pair(List<Developer> devs) {
    	this();
		this.setDevs(devs);
    }

	public List<Developer> getDevs() {
		return Arrays.asList(devs.toArray(new Developer[0]));
	}

	public Developer getFirstDev() {
		return devs.get(0);
	}
	
	public Developer getSecondDev() {
		if ( devs.size() == 2){
			return devs.get(1);
		}
		return null;
	}
	
	public void setDevs(List<Developer> devs) {
		this.devs.addAll(devs);
		Collections.sort(this.devs);
	}

	public void addDev(Developer dev) {
		if (dev != null){
			devs.add(dev);
			Collections.sort(devs);	
		}
	}

	public boolean hasDev(Developer dev) {
		return devs.contains(dev);
	}
	
	public Developer getOtherDev(Developer dev) {
		if(devs.contains(dev)){
			for (Developer pairDev : devs) {
				if(!pairDev.equals(dev)){
					return pairDev;
				}
			}
		}
		return null;
	}
	
	public boolean isComplete(){
		return devs.size() == 2;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devs == null) ? 0 : devs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (devs == null) {
			if (other.devs != null)
				return false;
		} else if (!devs.equals(other.devs))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Pair [devs=" + devs + "]";
	}

	public boolean isSolo() {
		return devs.size() == 1;
	}

	public Developer getDevFromCompany(String company) {
		for (Developer developer : devs) {
			if(developer.getCompany().equals(company)){
				return developer;
			}
		}
		return null;
	}

	public boolean isPairFromSameCompany() {
		if(isComplete()){
			return devs.get(0).getCompany().equals(devs.get(1).getCompany());
		}
		return true;
	}
}
