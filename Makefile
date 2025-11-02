# SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
# SPDX-License-Identifier: MIT

.PHONY: all build test lint clean
.SHELLFLAGS := -e -o pipefail -c
.ONESHELL:
SHELL := bash

VERSION := 0.59.0
GRAMMAR_URL := https://raw.githubusercontent.com/objectionary/eo/refs/tags/$(VERSION)/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4
ANTLR4_VERSION := 4.13.2

# a few URLs for download antlr4 tools
# ANTLR4_URL := https://github.com/antlr/website-antlr4/blob/gh-pages/download/antlr-${ANTLR4_VERSION}-complete.jar
# ANTLR4_URL := https://repo1.maven.org/maven2/org/antlr/antlr4/${ANTLR4_VERSION}/antlr4-${ANTLR4_VERSION}-complete.jar
ANTLR4_URL := https://www.antlr.org/download/antlr-${ANTLR4_VERSION}-complete.jar

TSS := $(shell find src -name '*.ts')

all: build test lint

build: src/parser compiled Makefile
	npx ncc build compiled/server.js
	sed -i "1i\#!/usr/bin/env node\n" dist/index.js

compiled: src/parser src/eo-version.ts tsc-compiled Makefile
	mkdir -p $@
	cp -R tsc-compiled/src/* $@
	cp -R src/parser/Eo.tokens $@/parser
	cp -R src/parser/EoLexer.tokens $@/parser

src/eo-version.ts:
	echo "export const EoVersion = \"$(VERSION)\";" > $@

tsc-compiled: $(TSS) Makefile
	npx tsc -b

Eo.g4: Makefile
	curl --silent $(GRAMMAR_URL) > $@

antlr4: Makefile
	mkdir -p $@
	curl --silent $(ANTLR4_URL) > $@/antlr4-$(ANTLR4_VERSION)-complete.jar

src/parser: Eo.g4 antlr4 Makefile
	env DYLD_BIND_AT_LAUNCH=1 java -jar antlr4/antlr4-$(ANTLR4_VERSION)-complete.jar -o src/parser -visitor -Dlanguage=TypeScript Eo.g4

test: build
	npx jest --coverage

lint:
	npx eslint src --ext .ts

clean:
	rm -rf Eo.g4 dist coverage tsc-compiled src/parser src/eo-version.ts
