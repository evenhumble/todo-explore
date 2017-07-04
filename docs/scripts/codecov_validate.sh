#!/usr/bin/env bash
cat ../docs/codecov.yml | curl --data-binary @- https://codecov.io/validate
