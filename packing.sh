#!/usr/bin/env bash


mvn clean package -Dhttp.proxyHost=10.209.22.141 -Dhttp.proxyPort=10486 -Dhttps.proxyHost=10.209.22.141 -Dhttps.proxyPort=10486
