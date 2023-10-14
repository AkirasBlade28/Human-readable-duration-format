public class TimeFormatter {
    
	public static String formatDuration(int seconds) {
		
    	final int min_sec = 60;
    	final int hour_sec = 3600;
    	final int day_sec = 86400;
    	final int year_sec = 31536000;
		
    	int[] box = {year_sec, day_sec, hour_sec, min_sec, 1};
    	// year, day, hour, minute, seconds 
    	int[] result = {0,0,0,0,0};
    	
    	int value = seconds;
    	if(seconds == 0) return "now";
    	if(seconds>0 && seconds<=60 ) return (seconds>1)?seconds+" seconds":seconds+" second";
    	for(int i=0; i<box.length; ++i) {
    		if(value >= box[i]) {
    			result[i] = value/box[i];
    			value = (result[i]>0) ? value - (result[i] * box[i]) : value;
    		}
    	}
    	return printDuration(result);
    }
	private static String printDuration(int[] result) {
		StringBuilder printResult = new StringBuilder();
		String[] labels = {"year", "day", "hour", "minute", "second"};
	    int lastNonZeroIndex = -1;
	    
	    for(int i = 0; i < result.length; i++) {
	        if(result[i] > 0) {
	            lastNonZeroIndex = i;
	        }
	    }
	    
	    for(int i = 0; i < result.length; i++) {
	        if(result[i] > 0) {
	            if(i == lastNonZeroIndex) {
	                printResult.append(result[i] + " " + labels[i]);
	                if(result[i] > 1) {
	                	printResult.append("s");
	                }
	            }
	            else{
	            	printResult.append(result[i] + " " + labels[i]);
	                if(result[i] > 1) {
	                	printResult.append("s");
	                }
	                if(i == lastNonZeroIndex - 1) {
	                    printResult.append(" and ");
	                }else{
	                	printResult.append(", ");
	                }
	            }
	        }
	    }
	    return printResult.toString();
	}
}