package core.thread.executor;

import java.util.concurrent.Callable;

/**		Runnable			Callable
 * 		--------			--------
 * 		void return			Parameterized return
 * 		no exception		throws Exception
 * 		run()				call()
 */
public class RunnableVsCallable {

	public static void main(String[] args) {

		R r = new R();
		r.run();

		C c = new C();
		
		try {
			
			System.out.println(c.call());
			
		} catch (Exception e) {	}		
	}
}

class C implements Callable<String> {

	@Override
	public String call() throws Exception {

		return "Callable::call";
	}
}

class R implements Runnable {

	@Override
	public void run() {

		System.out.println("Runnable::run");
	}
}