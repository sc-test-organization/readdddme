FROM alpine:3.9

RUN cat /etc/resolv.conf
RUN cat /etc/hosts
RUN ifconfig

RUN apk add --no-cache --update mtu

FROM alpine

ADD . .
RUN apk add --no-cache --update curl mtu
