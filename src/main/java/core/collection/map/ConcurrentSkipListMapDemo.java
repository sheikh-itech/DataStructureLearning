package core.collection.map;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**	No Null Keys
 *	
 *	Maintains a sorted order of keys, making it suitable for applications requiring range queries or ordered views
 *
 * 	A skip list is a probabilistic data structure that organizes elements in multiple levels 
 * 	for fast access, insertion, and deletion
 *	Higher levels act as express lanes for quicker traversal
 *	
 *	Designed for high scalability in environments with frequent concurrent access
 *	
 *Get, Put, Remove O(log n)
 */
public class ConcurrentSkipListMapDemo {

	public static void main(String[] args) {

		// Create a ConcurrentSkipListMap for storing time-series data
        ConcurrentSkipListMap<LocalDateTime, Double> temperatureData = new ConcurrentSkipListMap<>();

        // Add temperature readings
        temperatureData.put(LocalDateTime.parse("2025-01-01T08:00"), 15.5);
        temperatureData.put(LocalDateTime.parse("2025-01-01T09:00"), 16.0);
        temperatureData.put(LocalDateTime.parse("2025-01-01T10:00"), 16.8);
        temperatureData.put(LocalDateTime.parse("2025-01-01T11:00"), 17.3);
        temperatureData.put(LocalDateTime.parse("2025-01-01T12:00"), 18.1);

        // Display all entries
        System.out.println("All temperature readings:");
        temperatureData.forEach((time, temp) -> {
            System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " -> " + temp + " Celcius");
        });

        // Query: Temperatures between 09:00 and 11:00
        LocalDateTime start = LocalDateTime.parse("2025-01-01T09:00");
        LocalDateTime end = LocalDateTime.parse("2025-01-01T11:00");
        NavigableMap<LocalDateTime, Double> subMap = temperatureData.subMap(start, true, end, true);

        System.out.println("\nTemperature readings between 09:00 and 11:00:");
        subMap.forEach((time, temp) -> {
            System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " -> " + temp + " Celcius");
        });

        // Retrieve the closest reading to 10:30
        LocalDateTime queryTime = LocalDateTime.parse("2025-01-01T10:30");
        LocalDateTime closestTime = temperatureData.floorKey(queryTime);
        System.out.println("\nClosest reading to 10:30:");
        System.out.println(closestTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " -> " + temperatureData.get(closestTime) + " Celcius");
	}
}
