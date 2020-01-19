plugins {
	id("kotlin-platform-jvm")
}

dependencies {
	
	implementation(kotlin("stdlib-jdk8"))
	expectedBy(project(":src.common"))
	
	testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.0")
	testCompile("org.assertj:assertj-core:3.11.1")
	testImplementation("io.mockk:mockk:1.9.3")
	
}

tasks {
	test {
		useJUnitPlatform()
	}
	compileKotlin {
		kotlinOptions.jvmTarget = "1.8"
	}
	compileTestKotlin {
		kotlinOptions.jvmTarget = "1.8"
	}
}