val gradlePropertiesProp: String by project // This comes from the gradle.properties file
val commandLineValue: String by project // -PcommandLineValue="Value" in command line
val testProp: String by project // -Dorg.gradle.project.testProp="Value" in command line
val foo: String by project // systemProp.org.gradle.project.foo=Value in gradle.properties file
val bar: String by project // export ORG_GRADLE_PROJECT_bar=value in bash

tasks.register("printProps") {
	doLast {
		println(bar)
		println(foo)
		println(testProp)
		println(gradlePropertiesProp)
		println("Command line: $commandLineValue")
	}
}
