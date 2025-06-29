# SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
# SPDX-License-Identifier: MIT

NODE := node
NPM := npm
TSC := npx tsc
ANTLR4TS := npx antlr4ts
ESLINT := npx eslint
JEST := npx jest
NCC := npx ncc
PKG := npx pkg
CURL := curl

GRAMMAR_URL := https://raw.githubusercontent.com/objectionary/eo/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4
GRAMMAR_FILE := resources/Eo.g4

SRC_DIR := src
DIST_DIR := dist
OUT_DIR := out
BIN_DIR := bin
PARSER_DIR := $(SRC_DIR)/parser
RESOURCES_DIR := resources

TS_FILES := $(shell find $(SRC_DIR) -name '*.ts' -o -name '*.tsx' 2>/dev/null || true)

.PHONY: all
all: build test package

.PHONY: build
build: get-grammar build-parser compile

.PHONY: compile
compile: get-grammar build-parser
	$(TSC) -b

.PHONY: get-grammar
get-grammar:
	@mkdir -p $(RESOURCES_DIR)
	$(CURL) -s $(GRAMMAR_URL) > $(GRAMMAR_FILE)

.PHONY: build-parser
build-parser: $(GRAMMAR_FILE)
	$(ANTLR4TS) -visitor $(GRAMMAR_FILE)
	@mkdir -p $(PARSER_DIR)
	mv $(RESOURCES_DIR)/*.ts $(PARSER_DIR)/

.PHONY: fetch-and-build-grammar
fetch-and-build-grammar: get-grammar build-parser

.PHONY: test
test: get-grammar build-parser
	$(JEST)

.PHONY: lint
lint:
	$(ESLINT) ./$(SRC_DIR) --ext .ts,.tsx

.PHONY: package
package: compile
	@if [ ! -f ./$(OUT_DIR)/server.js ]; then \
		echo "Build failed: server.js not found. Run 'make build' first"; \
		exit 1; \
	fi
	$(NCC) build ./$(OUT_DIR)/server.js
	$(PKG) package.json

.PHONY: clean
clean:
	rm -rf $(DIST_DIR) $(OUT_DIR) $(BIN_DIR) src/parser

.PHONY: ci
ci: install lint test build
