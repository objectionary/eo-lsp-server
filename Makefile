# SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
# SPDX-License-Identifier: MIT

NODE := node
NPM := npm
TSC := npx tsc
ANTLR4TS := npx antlr4ts
ESLINT := npx eslint
JEST := npx jest
NCC := npx ncc
CURL := curl

GRAMMAR_URL := https://raw.githubusercontent.com/objectionary/eo/master/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4
GRAMMAR_FILE := resources/Eo.g4

SRC_DIR := src
DIST_DIR := dist
OUT_DIR := out
PARSER_DIR := $(SRC_DIR)/parser
RESOURCES_DIR := resources

TS_FILES := $(shell find $(SRC_DIR) -name '*.ts' -o -name '*.tsx' 2>/dev/null || true)

.PHONY: all
all: build test package

.PHONY: build
build: get-grammar build-parser compile

.PHONY: compile
compile: $(SRC_DIR)/parser
	$(TSC) -b

.PHONY: get-grammar
resources/Eo.g4:
	@mkdir -p $(RESOURCES_DIR)
	$(CURL) -s $(GRAMMAR_URL) > $@

.PHONY: build-parser
$(SRC_DIR)/parser: resources/Eo.g4
	$(ANTLR4TS) -visitor $<
	@mkdir -p $(PARSER_DIR)
	mv $(RESOURCES_DIR)/*.ts $(PARSER_DIR)/

.PHONY: test
test: $(SRC_DIR)/parser
	$(JEST)

.PHONY: lint
lint:
	$(ESLINT) $(SRC_DIR) --ext .ts,.tsx

.PHONY: package
package: $(SRC_DIR)/parser
	$(NCC) build $(OUT_DIR)/server.js
	sed -i "1i\#!/usr/bin/env node\n" $(DIST_DIR)/index.js

.PHONY: clean
clean:
	rm -rf $(DIST_DIR) $(OUT_DIR) src/parser

.PHONY: ci
ci: install lint test build
