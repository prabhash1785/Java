package com.prabhash.java.exercises;

/**
 * Enum class
 * 
 * @author prrathore
 *
 */
public enum EuroZoneCountry {
	
	Austria(8404252, 384908),
	Belgium(10918405,	468522),
	Cyprus(838896, 24910),
    Estonia(1340194, 19120),
    Finland(5375276, 237512),
    France(65075373, 2649390),
    Germany(81751602, 3330032),
    Greece(11325897, 329924),
    Ireland(4480858, 227193),
    Italy(60626442, 2112780),
    Luxembourg(511840, 52449),
    Malta(417617, 7449),
    Netherlands(16655799,	792128),
    Portugal(10636979, 227676),
    Slovakia(5435273, 87642),
    Slovenia(2050189, 48477),
    Spain(47190493, 1460250);
	
    int population;
	int GDP;
	
	private EuroZoneCountry(int population, int GDP) {
		this.population = population;
		this.GDP = GDP;
	}
	
	public long	getPopulation(){
		return population;
	}
	
	public 	long getGDPInMillions(){
		return GDP;
	}
	
	public long	getGDPPerCapita(){
		return GDP;
	}
	
	public static long getEurozonePopulation() {
		
		EuroZoneCountry[] country =  EuroZoneCountry.values();
		
		long totalPopulation = 0;
		
		for (int i = 0; i < country.length; i++) {
			totalPopulation += country[i].getPopulation();
		}
		
		return totalPopulation;

	}
	
	public static long getEurozoneGDPInMillions() {

		EuroZoneCountry[] country =  EuroZoneCountry.values();

		long totalGDP = 0;

		for (int i = 0; i < country.length; i++) {
			totalGDP += country[i].getGDPInMillions();
		}

		return totalGDP;

	}
	
	public static void main(String[] args) {
		
		EuroZoneCountry[] countries = EuroZoneCountry.values();
		
		for(int i = 0; i < countries.length; i++) {
			System.out.println(countries[i].name() + " :: " + countries[i].getPopulation() + " :: " + countries[i].getGDPInMillions());
		}
		
	}

}
