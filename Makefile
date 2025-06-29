# SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
# SPDX-License-Identifier: MIT

.PHONY: all build compile test lint package clean
.SHELLFLAGS := -e -o pipefail -c
.ONESHELL:
SHELL := bash

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

all: build test package lint

build: $(SRC_DIR)/parser compile
	$(NCC) build $(OUT_DIR)/server.js
	sed -i "1i\#!/usr/bin/env node\n" $(DIST_DIR)/index.js

compile: $(SRC_DIR)/parser
	$(TSC) -b

resources/Eo.g4:
	@mkdir -p $(RESOURCES_DIR)
	$(CURL) -s $(GRAMMAR_URL) > $@

$(SRC_DIR)/parser: resources/Eo.g4
	$(ANTLR4TS) -visitor $<
	@mkdir -p $(PARSER_DIR)
	mv $(RESOURCES_DIR)/*.ts $(PARSER_DIR)/

test: build
	$(JEST)

lint:
	$(ESLINT) $(SRC_DIR) --ext .ts,.tsx

clean:
	rm -rf $(DIST_DIR) $(OUT_DIR) src/parser bin coverage
