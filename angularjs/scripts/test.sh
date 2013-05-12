#!/bin/bash

BASE_DIR=`dirname $0`

echo ""
echo "Starting karma Server (http://vojtajina.github.com/testacular)"
echo "-------------------------------------------------------------------"

karma start $BASE_DIR/../test/javascripts/karma.conf.js $*
