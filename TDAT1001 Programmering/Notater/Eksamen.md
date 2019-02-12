##### Lesing og skriving av objekter fra fil

````java
class Bilprodusent implements java.io.serializable {}

// Hvis andre objekter brukes må også den klassen implementere serializable
class Bil implements java.io.Serializeable {
    String bilmerke = bilprodusent.getModell();
}
````



Hvordan implementere lesingen fra fil*

````java
try {
    FileInputStream fis = new FilInputStream(filnavn);
    ObjectInputStream ois = new ObjectInputStream(fis);
    
    ios.readObject() // Leser objekt
    // Ikke glem å caste objektet som man får! 
        
    ois.close() // Husk å lukke filstrømmen
}

catcher exceptions...
````





##### Komposisjon vs aggregering

````java
// ord er et parameter i en metode 
// Dyp kopering, ingen fare for at noen tuller med det senere
ordbok[antReg] = new Ord(ord.getOrd(), ord.getDef());

// Grunn kopering, man får flere referanser til samme objekt
ordbok[antReg] = ord
````



##### Sorteringsmetode

Unngå å bruke java.Arrays.sort(), lag metoden selv!

````java
public Ord[] sorter() {
		Ord[] arr = new Ord[ordbok.length];
		// Dyp kopering av tabell
		for (int i = 0; i < ordbok.length; i++) {
			arr[i] = ordbok[i];
		}

		//Sjekker om størrelsen er 1 eller mindre
		if (arr.length <= 1) return arr;

		for (int i = 0; i < ordbok.length-1; i++) {
			int index = i+1;

			// Finner den minste i forhold 
			for (int j = i+1; j < ordbok.length; j++) {
				if (arr[index].compareTo(arr[j]) > 0) index = j; 
			}

			// Bytter plass
			Ord temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		return arr;
	}
````



##### Exceptions

*Exceptions som brukes ved lesing av objekter fra fil*

FileNotFoundException
ClassNotFoundException
IOException

````java
catch(FileNotFoundException | ClassNotFoundExcepion | IOException e) {
	e.printStackTrace() //ALLTID BRUK DENNE!
}
````

