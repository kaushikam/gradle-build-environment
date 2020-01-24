// This comes from the gradle.properties file
val gradlePropertiesProp: String by project

// -PcommandLineValue="Value" in command line
val commandLineValue: String by project

// -Dorg.gradle.project.testProp="Value" in command line
val testProp: String by project

/*  Properties starting with "systemProp" indicate system properties
* systemProp.gradle.wrapperUser=kaushik, but the exception is given below
 */

/*
* systemProp.org.gradle.project.foo=Value in gradle.properties file. This is a project property
* In a multi project build, systemProp.” properties set in any project except the project
* root will be ignored
 */
val foo: String by project

// export ORG_GRADLE_PROJECT_bar=value in bash
val bar: String by project

tasks.register("printProps") {
	doLast {
		println(bar)
		println(foo)
		println(testProp)
		println(gradlePropertiesProp)
		println("Command line: $commandLineValue")
	}
}

/**
 * Project properties can be used to manipulate gradle functionality.
 * A common use case is build profile
 */
tasks.register("performRelease") {
	doLast {
		/**
		 * You can set isCI=any value in gradle.properties or -PisCI in command line
		 * or systemProp.org.gradle.project.isCI in gradle.properties file
		 */
		if (project.hasProperty("isCI")) {
			println("Performing release actions")
		} else {
			throw InvalidUserDataException("Cannot perform release outside of CI")
		}
	}
}
