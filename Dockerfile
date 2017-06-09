FROM builder-base:latest

ADD target/IgniteService-1.jar /service.jar
ADD config.yml /config.yml

HEALTHCHECK CMD curl --fail http://localhost:4567/ping || exit 1

ENV EXTRA_OPTS="server config.yml"

CMD [ "/run.sh" ]