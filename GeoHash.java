public class GeoHash {

	public static final double[] LATITUDE_RANGE = { -90, 90 };
	public static final double[] LONGITUDE_RANGE = { -180, 180 };

	public static boolean[] geohash1D(double valueToHash, double[] valueRange, int bitsOfPrecision) {
		
		System.out.println("hash " + valueToHash +" [" + valueRange[0] +"," +
		valueRange[1] + "]");

		// Implement GeoHashing here for a single value.

		boolean hashArray[] = new boolean[bitsOfPrecision];
	
		for(int i=0; i <=bitsOfPrecision-1; i++) {
			double midpoint = (valueRange[0] + valueRange[1]) / 2;
			if (valueToHash >= midpoint){
			   hashArray[i]=true;
			   valueRange = new double[]{midpoint, valueRange[1]};
			   
			}
			else {
			   hashArray[i]=false;
			   valueRange = new double[]{valueRange[0], midpoint};
			}
		}
	
		
		// This method only "geohashes" either latitude or longitude separately - passing a valueToHash and a valueRange (e.g., the range of
		// longitudes or latitudes).
		//
		// The bits of precision is the number of bits that should be in the output hash
		
		// Approximating "bits" with a boolean array to make things simpler.

		return hashArray;
	}

	public static boolean[] geohash2D(double v1, double[] v1range, double v2, double[] v2range, int bitsOfPrecision) {

		//compute for v1
		boolean[] hashArrayv2 = geohash1D(v2, v2range, bitsOfPrecision/2);
		boolean[] hashArrayv1 = geohash1D(v1, v1range, bitsOfPrecision - hashArrayv2.length);

		//Need to combine them both.
		
		boolean hashConcat[] = new boolean[bitsOfPrecision];
		int index = 0;
		int minArray = hashArrayv2.length;
		for (int z = 0; z <minArray; z++) {
			hashConcat[index++]=hashArrayv1[z];
			hashConcat[index++]=hashArrayv2[z];
		}
		
		if (hashArrayv2.length != hashArrayv1.length){
			   hashConcat[index++] = hashArrayv1[hashArrayv1.length - 1];
			}
	
		System.out.println(hashConcat.toString());
		
		// Separately compute indvidual 1D geohashes for v1 and v2 and then interleave them together into a final combined geohash.

		return hashConcat;
	}

	public static boolean[] geohash(double lat, double lon, int bitsOfPrecision) {
		return geohash2D(lat, LATITUDE_RANGE, lon, LONGITUDE_RANGE, bitsOfPrecision);
	}

	// This is a helper method that will make printing out geohashes easier
	public static String toHashString(boolean[] geohash) {
		String hashString = "";
		for (boolean b : geohash) {
			hashString += (b ? "1" : "0");
		}
		return hashString;
	}

	// This is a convenience method to make it easy to get a string of 1s and 0s for a geohash
	public static String geohashString(double valueToHash, double[] valueRange, int bitsOfPrecision) {
		return toHashString(geohash1D(valueToHash,valueRange,bitsOfPrecision));
	}

	public static void main(String[] args) {

		// Example of hand-coding a 3-bit geohash

		// 1st bit of the geohash
		double longitude = 0.0;
		double[] bounds = {LONGITUDE_RANGE[0], LONGITUDE_RANGE[1]};
		double midpoint = (bounds[0] + bounds[1]) / 2;
		boolean bit = false;

		if (longitude >= midpoint) {
			bit = true;
			bounds[0] = midpoint;
		}
		else {
			bit = false;
			bounds[1] = midpoint;
		}

		// 2nd bit of the geohash
		boolean bit2 = false;
		midpoint = (bounds[0] + bounds[1]) / 2;
		if (longitude >= midpoint) {
			bit2 = true;
			bounds[0] = midpoint;
		}
		else {
			bit2 = false;
			bounds[1] = midpoint;
		}

		// 3rd bit of the geohash
		boolean bit3 = false;
		midpoint = (bounds[0] + bounds[1]) / 2;
		if (longitude >= midpoint) {
			bit3 = true;
			bounds[0] = midpoint;
		}
		else {
			bit3 = false;
			bounds[1] = midpoint;
		}
		// Continue this process for however many bits of precision needed.

	}
}
