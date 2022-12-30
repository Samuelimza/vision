project_name := vision

build:
	mvn clean package

build_skip_tests:
	mvn clean package -Dmaven.test.skip

exec:
	mvn exec:java -Dexec.mainClass="com.simul.vision.MainApp"

run: build_skip_tests exec