String filNavn = "filnavn.txt";

//Lese fra fil
FileReader leser = new FileReader(filNavn);
String enLinje = leser.readLine() 
leser.close() //Lukke strømmen

BufferedReader bufferLeser = BufferedReader(leser); //Med buffring

// Skrive til fil
FileWriter skriver = new FileWriter(filNavn, false); //False for å overskrive
PrintWriter printSkriver = new PrintWriter(new BufferedWriter(skriver)); //Print versjon med buffring

printSkriver.print("hello world!"); //Skrive til fil
printSkriver.close() //Viktig! Buffret må tømmes til disk 

