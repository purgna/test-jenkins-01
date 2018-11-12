#!/usr/bin/env bash

ssh -T chetan@l502x <<'EOF'
pkill -u chetan java
#rm /home/chetan/devel/sw/thin-client-work/*.jar
cd /home/chetan/devel/sw/thin-client-work
/home/chetan/devel/installs/jdk-11/bin/java -jar thin-jar-01-0.0.1-SNAPSHOT.jar
EOF