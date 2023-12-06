package java8lambda.oreilly;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ds.beans.DataProvider;

/**
 * @author Hapheej
 *
 */
public class BasicStreamExample {

	
	public static void main(String[] args) {
		
		List<Album> albums = Arrays.asList(new Album("solo", "India", "bands"),
				new Album("solo", "India", "mythological"),
				new Album("hudband", "USA", "bands"),
				new Album("Hookups", "Canada", "bands"),
				new Album("solo", "Canada", "instrumental"));
		
		// By default streams are lazy initialized, so below statement will not print
		DataProvider.getIntList().stream().filter(e ->{System.out.println(e); if(e%2==0) return true;
		return false;});
		
		// To make streams eager, terminal/initializer method call needed
		Arrays.asList(1,2,3,4,5,6,7,8,9,10).stream().filter(e ->{System.out.println(e); if(e%2==0) return true;
		return false;}).count();
		
		//Collect toList()
		List<Integer> intList = DataProvider.getIntList().stream().collect(Collectors.toList());
		
		intList = Stream.of(1,2,3,4,5).collect(Collectors.toList());
		
		//Map
		List<String> collected = Stream.of("a", "b", "hello")
				 .map(string -> string.toUpperCase())
				 .collect(Collectors.toList());
		
		//MAP
		collected = DataProvider.getStringList().stream().map(val -> 
			val.toUpperCase()).collect(Collectors.toList());

		//Filter
		collected = Stream.of("A", "b", "Hello", "bye").filter(value -> 
			Character.isUpperCase(value.charAt(0))).collect(Collectors.toList());
		
		//FlatMap
		List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				 .flatMap(numbers -> numbers.stream())
				 .collect(Collectors.toList());
		
		List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
				 new Track("Violets for Your Furs", 378),
				 new Track("Time Was", 451));
		
		// Steam inside stream 
		List<String> albumDetail = albums.stream().flatMap(album -> Stream.of(album.getName(), album.getOrigin(), album.getAlbumType())).collect(Collectors.toList());
		
		//Min, Max and Sort
		Track minTrack = 
				tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
		System.out.println(minTrack);
		
		List<Track> sortedTracks = 
				tracks.stream().sorted(Comparator.comparing(track -> track.getLength())).collect(Collectors.toList());
		System.out.println(sortedTracks);
		
		System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().min(Comparator.comparing(val -> val)).get());
		
		Track maxTrack = 
				tracks.stream().max(Comparator.comparing(track -> track.getLength())).get();
		System.out.println(maxTrack);
		
		//Reduce
		int count = Stream.of(1, 2, 3) .reduce(0, (acc, element) -> acc + element);
		
		
		/**
		 * Below two statements shows difference between fundamentals of MAP vs Filter
		 * Map is used to convert/regenerate values from one type to another
		 * But Filter is useful to filter and return same type elements
		 */
		List<String> origins = albums.stream().filter(type -> type.getAlbumType().equalsIgnoreCase("bands")).map(album -> album.getOrigin()).collect(Collectors.toList());
		
		List<Album> origin = albums.stream().filter(type -> type.getAlbumType().equalsIgnoreCase("bands")).filter(album -> !album.getOrigin().isBlank()).collect(Collectors.toList());
		
		
		System.out.println(origin);
	}

}

class Track {
	
	private String name;
	private int length;
	
	Track(String name, int length){
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public String toString() {
		
		return this.name+", "+this.length;
	}
}

class Album {
	
	private String name;
	private String origin;
	private String albumType;
	
	Album(String name, String origin, String albumType){
		this.name = name;
		this.origin = origin;
		this.albumType = albumType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getAlbumType() {
		return albumType;
	}
	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}
}