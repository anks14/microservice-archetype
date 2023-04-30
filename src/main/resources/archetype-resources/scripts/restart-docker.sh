#!/bin/bash

CLUSTER_NAME=$1
SERVICE_NAME=$2

ecrCred="$(aws ecr get-login --no-include-email --region eu-north-1)"
eval $ecrCred

#Need to change xyz to aws correct value
aws ecs update-service --cluster arn:aws:ecs:eu-north-1:xyz:cluster/$CLUSTER_NAME --service $SERVICE_NAME --force-new-deployment