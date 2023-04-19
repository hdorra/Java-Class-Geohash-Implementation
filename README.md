# Java Geohash Implementation
This is a class which provides an implementation of Geohashes, completed as part of graduate coursework.

## GeoHash Code
This Java code defines a class named GeoHash that implements the GeoHash algorithm. The algorithm is used to encode a latitude and longitude pair into a binary hash value. This implementation provides methods to encode a single latitude or longitude, as well as a method to encode a latitude-longitude pair.

### The class provides the following methods:

**geohash1D(double valueToHash, double[] valueRange, int bitsOfPrecision):** </br> 
This method generates a 1D GeoHash for a single value within a given range. It takes in the value to be hashed, the range of values that the hash should be generated for, and the number of bits of precision to be used in the hash. It returns a boolean array containing the hash.

**geohash2D(double v1, double[] v1range, double v2, double[] v2range, int bitsOfPrecision):** </br> 
This method generates a 2D GeoHash for a latitude-longitude pair. It uses the geohash1D() method to generate a GeoHash for each of the latitude and longitude values separately, and then interleaves the two hashes together to create a final GeoHash. It takes in the latitude and longitude values to be hashed, the ranges for these values, and the number of bits of precision to be used in the hash. It returns a boolean array containing the hash.

**geohash(double lat, double lon, int bitsOfPrecision):** </br> 
This method is a convenience method that simply calls geohash2D() with the latitude-longitude ranges and the specified number of bits of precision.

**toHashString(boolean[] geohash):** </br> 
This method takes in a boolean array containing a GeoHash and converts it to a string of 1s and 0s.

**geohashString(double valueToHash, double[] valueRange, int bitsOfPrecision):** </br> 
This method is a convenience method that simply calls toHashString() on the output of geohash1D().

**main(String[] args):** </br> 
This method contains an example of how to generate a GeoHash using the geohash1D() method. It generates a 3-bit GeoHash for a longitude value.

### Public Constants
The class also provides two public constants LATITUDE_RANGE and LONGITUDE_RANGE that contain the valid ranges for latitude and longitude values.

### How to use
To use this code, simply import the GeoHash class into your project and call one of the provided methods to generate a GeoHash.




