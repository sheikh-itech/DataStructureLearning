package hari_krishna.basic;

/**		Thread.sleep()	<br/>
 * 
 *	Wait for few milliseconds to start Garbage Collector thread		<br/>
 *	It takes time because it is daemon thread	<br/> 
 *	(Low priority thread, cnn't guarantee of execution surety)
 */
public class GarbageCollectionTrick {

	public static void main(String[] args) throws InterruptedException {

		StopGarbageDemo sgd = new StopGarbageDemo();
		sgd = null;
		System.out.println("sgd: "+ sgd);
		
		System.gc();
		
		StopGarbageDemo demo = StopGarbageDemo.getInstance();
		System.out.println("StopGarbageDemo-1: "+ demo);
		
		/**	Sleep for few Seconds Otherwise finalize() method may remained untouched [not call]
		 *	Because this is daemon/background thread based */
		Thread.sleep(10);
		
		demo = StopGarbageDemo.getInstance();
		System.out.println("StopGarbageDemo-2: "+ demo);
	}
}

class StopGarbageDemo {
	
	static StopGarbageDemo demo;
	
	//This method stop to be Garbage collected
	@Override
	public void finalize() {
		System.out.println("Running finalize() method");
		StopGarbageDemo.demo = this;
	}
	
	static StopGarbageDemo getInstance() {
		
		return StopGarbageDemo.demo;
	}
}