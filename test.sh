#!/bin/bash

# Color codes
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m' # No Color

echo "Starting Integration Tests..."

# Function to perform a request and check the result
test_route() {
    local target=$1
    local name=$2
    local expected=$3

    echo -n "Testing routing to $target... "
    
    # Updated JSON payload to match the RouteRequest record: {"targetService": "...", "name": "..."}
    response=$(curl -s -X POST http://localhost:8080/RouterService/route \
        -H 'Content-Type: application/json' \
        -d "{\"targetService\": \"$target\", \"name\": \"$name\"}")

    if [[ "$response" == "\"$expected\"" ]]; then
        echo -e "  Received: $response"
        echo -e "${GREEN}PASS${NC}"
    else
        echo -e "${RED}FAIL${NC}"
        echo "  Expected: \"$expected\""
        echo "  Received: $response"
        return 1
    fi
}

# Wait for Restate and Services to be ready
echo "Waiting for services to be ready..."
MAX_RETRIES=30
COUNT=0
until curl -s http://localhost:9070/health > /dev/null; do
    sleep 2
    COUNT=$((COUNT+1))
    if [ $COUNT -ge $MAX_RETRIES ]; then
        echo -e "${RED}Restate server did not start in time${NC}"
        exit 1
    fi
done

echo "Running tests..."
test_route "ServiceA" "Bob" "Hello from ServiceA, Bob" || exit 1
test_route "ServiceB" "Alice" "Hello from ServiceB, Alice" || exit 1

echo -e "\n${GREEN}All integration tests passed!${NC}"
