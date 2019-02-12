class Test {
	// Selection sort
	public int[] sort(int[] array) {
		
		for (int i = 0; i < array.length-1; i++) {
			// Printing arrays
			// for (int j = 0; j < array.length; j++) {
   //  			System.out.print(array[j] + ", ");
   //  		}
    		// System.out.println("");

			// Find min number after current 
			int minNum = i+1;
			for (int x = i+1; x < array.length; x++) {
				if (array[minNum] > array[x]) {minNum = x;}
			}

			// Temporary to save current
			int temp = array[i];

			// Switch places if current is higher than minNum
			if (array[minNum] < array[i]) {
				array[i] = array[minNum];
				array[minNum] = temp;
			}	
		}
		return array;
	}

	 public int lengthOfLongestSubstring(String s) {
        int total = 0;
        String currentLetters = "";
        for (int i = 0; i < array.length-1; i++) {
        	for (int j = 0; j < currentLetters.length(); j++) {
        		if (s.substring(i,1) != currentLetters.substring(i,1)) {
	            	total++;
	            	currentLetters += s.substring(i,1);
           		 }
        	}
            
            else {
            	total = 0;
            	currentLetters = "";
            }
        }
        return total;
    }

    public static void main(String[] args) {
    	Test test = new Test();
    	// Desired output 7
    	/*
    		Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        	Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
		*/
    	String text = "abcabcbb";
    	System.out.println(test.lengthOfLongestSubstring(text));
    }
}