!#/bin/bash

GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

printf "${RED}Stopig the application...\n${NC}"

fuser -k 8080/tcp

sleep 5

printf "\n\n\n${GREEN}installing the app!\n${NC}"

mv ../target/start-0.0.1-SNAPSHOT.jar /tmp/

rm -r ../target/
echo "Starting the server..."

./start.sh &

sleep 5

until $(curl --output /dev/null --silent --head --fail http://localhost:8080/client); do
    printf '.'
    sleep 1
done


printf "Starting postman tests..."

./postman_tests.sh

printf "\n\n\n${GREEN}OK Server Started!\n"
