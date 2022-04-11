echo "Removing previous version..."

rm /target/start-0.0.1-SNAPSHOT.jar

echo "Building the project..."

cd ../

mvn compile

echo "Packing the project..."

mvn clean install