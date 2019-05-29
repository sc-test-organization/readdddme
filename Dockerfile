FROM scratch

ADD . .
RUN apk add --no-cache --update curl mtu
