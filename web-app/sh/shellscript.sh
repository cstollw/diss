#!/bin/bash

time_stamp=$(date +%Y-%m-%d-%T)
file=$1$time_stamp
echo "$file"
mkdir -p "$file"