package eu.nexwell.fox.api.test;

import eu.nexwell.fox.api.core.Fox;
import eu.nexwell.fox.api.core.FoxException;

interface FoxApiTest {
	void run(Fox fox) throws FoxException;
}
