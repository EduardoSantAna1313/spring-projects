echo "Removing previous version..."

rm -r ../target/

echo "Building the project..."

cd ../

mvn compile

echo "Packing the project..."

mvn clean install