#!/bin/bash

ip=$(docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' yahtzee_client)
echo $ip
curl --include --header "Accept: application/json" http://${ip}:80
echo
