FROM alpine:latest

ADD . .
RUN cat /etc/resolv.conf
RUN apk add --no-cache --update curl
