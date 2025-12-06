FROM ubuntu:latest
LABEL authors="snape"

ENTRYPOINT ["top", "-b"]