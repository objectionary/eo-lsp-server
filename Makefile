# SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
# SPDX-License-Identifier: MIT

.PHONY: all build test lint clean
.SHELLFLAGS := -ex -o pipefail -c
.ONESHELL:
SHELL := bash

VERSION := 0.56.9
GRAMMAR_URL := https://raw.githubusercontent.com/objectionary/eo/refs/tags/$(VERSION)/eo-parser/src/main/antlr4/org/eolang/parser/Eo.g4

TSS := $(shell find src -name '*.ts')

all: build test lint

build: src/parser compiled Makefile
	npx ncc build compiled/server.js
	sed -i "1i\#!/usr/bin/env node\n" dist/index.js

compiled: src/parser tsc-compiled Makefile
	mkdir -p $@
	cp -R tsc-compiled/src/* $@
	cp -R src/parser/Eo.tokens $@/parser
	cp -R src/parser/EoLexer.tokens $@/parser
	sed -i "s/0\.0\.0/$(VERSION)/" src/eo-version.ts

tsc-compiled: $(TSS) Makefile
	npx tsc -b

Eo.g4: Makefile
	mkdir -p "$$(dirname $@)"
	curl --silent $(GRAMMAR_URL) > $@

src/parser: Eo.g4 Makefile
	npx antlr4ts -visitor $< -o src/parser

test: build
	npx jest

lint:
	npx eslint src --ext .ts

clean:
	rm -rf Eo.g4 dist coverage tsc-compiled src/parser
