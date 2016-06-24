package eu.nexwell.fox.api.test;

import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;

public class FoxApiTestTasks implements FoxApiTest {

	@Override
	public void run(Fox fox) throws FoxException {
		
		System.out.println("TEST: TASKS");
		
		for (int i = 1; i <= 3; i++) {
			fox.doTask(i);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				;
			}
		}
	}

}
