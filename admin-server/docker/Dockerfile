FROM gitlab:5505/ifobs-cloud/third-party-services/alpine-base-jdk17-liberica-lite:user-7777

# Create dir for logs
RUN mkdir -p "$HOME_DIR"/logs/log/

WORKDIR "$HOME_DIR"

# Add  files
COPY --chown="$UID":"$GID" *.jar $HOME_DIR/

USER "$USER"

ENTRYPOINT [ "sh", "-c", "java -jar /deployments/*.jar" ]

