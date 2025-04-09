package com.sap.cc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import com.sap.cc.handsoff.CodeCreator;
import com.sap.cc.handsoff.DeveloperEvent;

//██╗  ██╗ █████╗ ███╗   ██╗██████╗ ███████╗     ██████╗ ███████╗███████╗██╗██╗██╗
//██║  ██║██╔══██╗████╗  ██║██╔══██╗██╔════╝    ██╔═══██╗██╔════╝██╔════╝██║██║██║
//███████║███████║██╔██╗ ██║██║  ██║███████╗    ██║   ██║█████╗  █████╗  ██║██║██║
//██╔══██║██╔══██║██║╚██╗██║██║  ██║╚════██║    ██║   ██║██╔══╝  ██╔══╝  ╚═╝╚═╝╚═╝
//██║  ██║██║  ██║██║ ╚████║██████╔╝███████║    ╚██████╔╝██║     ██║     ██╗██╗██╗
//╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝ ╚══════╝     ╚═════╝ ╚═╝     ╚═╝     ╚═╝╚═╝╚═╝

class HackathonTest {

	private static final String SEPARATOR = "\n";
	private static Reflections reflections = new Reflections("com.sap.cc");
	private static Constructor<? extends DeveloperEvent> hackathonConstructor;
	private static Constructor<? extends CodeCreator> developerConstructor;

	@BeforeAll
	public static void beforeClass() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Set<Class<? extends DeveloperEvent>> developerEventclasses = reflections.getSubTypesOf(DeveloperEvent.class);
		Assumptions.assumeTrue(developerEventclasses.size() == 1, "Not executing since Hackathon class missing");
		Class<? extends DeveloperEvent> hackathonClass = developerEventclasses.iterator().next();
		Assumptions.assumeTrue(hackathonClass.getSimpleName().equals("Hackathon"),
				"Not executing since Hackathon class missing");
		hackathonConstructor = hackathonClass.getConstructor();

		Set<Class<? extends CodeCreator>> codeCreatorclasses = reflections.getSubTypesOf(CodeCreator.class);
		Assumptions.assumeTrue(codeCreatorclasses.size() == 1, "Not executing since Developer class missing");
		Class<? extends CodeCreator> developerClass = codeCreatorclasses.iterator().next();
		Assumptions.assumeTrue(developerClass.getSimpleName().equals("Developer"),
				"Not executing since Developer class missing");
		developerConstructor = developerClass.getConstructor(String.class, String.class);
	}

	@Test
	void testCodeTogetherMethodEmptyList()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DeveloperEvent instance;
		try {

			instance = hackathonConstructor.newInstance();
			assertThat(instance.codeTogether(Collections.emptyList())).isEqualTo("");

		} catch (Exception e) {
			fail("The code in your Hackathon class threw an unexpected Exception",e);
		}

	}

	@Test
	void testCodeTogetherMethodListOneDeveloper()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DeveloperEvent hackathonInstance;
		try {

			hackathonInstance = hackathonConstructor.newInstance();
			List<CodeCreator> list = new ArrayList<>();
			list.add(createDeveloper(DeveloperTest.GO_NAME, DeveloperTest.GO_LANGUAGE));
			assertThat(hackathonInstance.codeTogether(list)).isEqualTo(DeveloperTest.GO_STRING + SEPARATOR);

		} catch (Exception e) {
			fail("The code in your Hackathon class threw an unexpected Exception",e);
		}

	}

	@Test
	void testCodeTogetherMethodListThreeDevelopers()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DeveloperEvent hackathonInstance;
		try {

			hackathonInstance = hackathonConstructor.newInstance();
			List<CodeCreator> list = new ArrayList<>();
			list.add(createDeveloper(DeveloperTest.GO_NAME, DeveloperTest.GO_LANGUAGE));
			list.add(createDeveloper(DeveloperTest.NODE_NAME, DeveloperTest.NODE_LANGUAGE));
			list.add(createDeveloper(DeveloperTest.PYTHON_NAME, DeveloperTest.PYTHON_LANGUAGE));
			assertThat(hackathonInstance.codeTogether(list)).isEqualTo(DeveloperTest.GO_STRING + SEPARATOR
					+ DeveloperTest.NODE_STRING + SEPARATOR + DeveloperTest.PYTHON_STRING + SEPARATOR);

		} catch (Exception e) {
			fail("The code in your Hackathon class threw an unexpected Exception",e);
		}

	}

	@Test
	void testCodeTogetherMethodListThreeDevelopersOneUnsupportedLanguage()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DeveloperEvent hackathonInstance;
		try {

			hackathonInstance = hackathonConstructor.newInstance();
			List<CodeCreator> list = new ArrayList<>();
			list.add(createDeveloper(DeveloperTest.GO_NAME, DeveloperTest.GO_LANGUAGE));
			list.add(createDeveloper(DeveloperTest.NODE_NAME, DeveloperTest.NODE_LANGUAGE));
			list.add(createDeveloper("Ada", DeveloperTest.ABAP_LANGUAGE));
			assertThat(hackathonInstance.codeTogether(list)).isEqualTo(DeveloperTest.GO_STRING + SEPARATOR
					+ DeveloperTest.NODE_STRING + SEPARATOR + DeveloperTest.ABAP_STRING + SEPARATOR);

		} catch (Exception e) {
			fail("The code in your Hackathon class threw an unexpected Exception",e);
		}

	}

	private CodeCreator createDeveloper(String name, String language)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		return developerConstructor.newInstance(name, language);

	}

}