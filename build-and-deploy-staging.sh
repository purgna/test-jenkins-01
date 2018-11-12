#!/usr/bin/env bash

mvn -DskipTests=true clean package && scp target/thin-jar-01-0.0.1-SNAPSHOT.jar chetan@l502x:/home/chetan/devel/sw/thin-client-work/