#!/bin/bash

ip=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' yahtzee_client)
curl --include --header "Accept: application/json" http://${ip}:80
echo
