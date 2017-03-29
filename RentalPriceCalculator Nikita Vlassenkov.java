package rental;

public class RentalPriceCalculator {
	
	// age - age of driver
	// yearsofexperience - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// season - if it is high season or not
	//rentalprice - cant be more than 1000
	
	public double price(int age, int yearsofexperience, int clazz, boolean acc, boolean season) {
		//Alla 18 aastane ei saa autot rentida 
		if (age < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		//Alla 18 aastane ei saa autot rentida 18-21-aastane saab rentida ainult klassi 1 kuuluvaid autosid
		if (age <= 21 && clazz > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalprice = age;
		
		//Klassides 4 ja 5 on hind 50% kallim kui juht on 25-aastane või noorem (välja arvatud madalhooaja)
		if (clazz >=4 && age <= 25 && season != false) {
			rentalprice = rentalprice * 2;
		}
		
		if (yearsofexperience < 1) {
			throw new IllegalArgumentException("yearsofexperience must be at least for one year. Can not rent a car, if less than 1 year!");
		}
		
		//Rentida ei saa isikud, kellel on juhiluba olnud alla aasta. Kui juhiluba on olnud alla kolme aasta, siis on rendi hind 30% suurem.
		if (yearsofexperience < 3) {
			rentalprice = rentalprice * 1.3;
		}
		
		//Kui isik on põhjustanud viimase aasta jooksul liiklusõnnestusi ja isik on alla 30 aasta vana, siis lisandub rendi ööpäevahinnale 15 eurot.
		if (acc == true && age < 30) {
			rentalprice += 15;
		}

		//Maksimaalne rendi hind on 1000 eurot päevas.
		if (rentalprice > 1000) {
			return 1000.00;
		}
		return rentalprice;
	}
}