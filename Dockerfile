FROM alpine   

ADD . .
RUN apk add --no-cache --update curl
