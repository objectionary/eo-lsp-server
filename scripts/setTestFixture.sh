#!/usr/bin/env bash

# Uses fixed grammar for testing. If grammar is changed, the tests
# need to change as well

cp "$(pwd)/testFixture/Eo.g4" "$(pwd)/resources/Eo.g4"

npm run build-parser
npm run compile
