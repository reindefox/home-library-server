FROM ubuntu:latest
LABEL authors="reindefox"

ENTRYPOINT ["top", "-b"]