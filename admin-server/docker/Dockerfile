FROM gitlab:5505/ifobs-cloud/third-party-services/alpine-base-jdk17-liberica-lite:user-7777

# Create dir for logs
RUN mkdir -p "$HOME_DIR"/logs/log/
RUN chown -R $UID:$GID "$HOME_DIR"/logs/

WORKDIR "$HOME_DIR"

# Add  files
COPY --chown="$UID":"$GID" ./target/admin-server.jar $HOME_DIR/
COPY --chown="$UID":"$GID" ./docker/*.xml $HOME_DIR/properties/

USER "$USER"

ENV APP_PORT=9990
ENV LOGPATH="/deployments/logs"
ENV LOGLEVELROOT="INFO"
ENV APP_DISCOVERY_HOST=192.168.88.133
ENV APP_DISCOVERY_PORT=8500

ARG JAVA_OPTS_APP="-Dapp.server.port=$APP_PORT -Dapp.discovery.host=$APP_DISCOVERY_HOST -Dapp.discovery.port=${APP_DISCOVERY_PORT}"

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS_APP -Dlogging.config=file:///deployments/properties/logback-spring.xml -Dlogpath=${LOGPATH} -Dloglevelroot=${LOGLEVELROOT} -jar /deployments/*.jar" ]