#!/bin/sh

# -----------------------------------------------------
# Start bot
# -----------------------------------------------------

cd /data

# make surce database migrate to latest config
lein run -- migrate

echo ""
echo ""
echo "------------------------------------------------------------"
echo "    Start Esunconsulting Bot"
echo "------------------------------------------------------------"
echo ""

# start the bot
lein run
