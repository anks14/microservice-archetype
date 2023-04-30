#!/bin/bash

ARTIFACT_ID=$1
FROM_ENV=$2
ENV=$3
ECR_URL=$4

ecrCred="$(aws ecr get-login --no-include-email --region eu-north-1)"
eval $ecrCred

docker pull $ECR_URL:$ENV
docker tag $ECR_URL:$ENV $ECR_URL:$ENV-previous
docker push $ECR_URL:$ENV-previous

if [$ENV == "dev"]; then
  docker tag $ARTIFACT_ID:latest $ECR_URL:$ENV
  docker push $ECR_URL:$ENV
else
  docker pull $ECR_URL:$FROM_ENV
  docker tag $ECR_URL:$FROM_ENV $ECR_URL:$ENV
  docker push $ECR_URL$ENV
fi
