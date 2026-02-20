FROM eclipse-temurin:21-jre-jammy AS base
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

FROM base
ARG SUBPROJECT
WORKDIR /app
COPY $SUBPROJECT/build/install/$SUBPROJECT .

# Expose the internal container port
EXPOSE 9080

# Run the app
# Use a script to handle the execution and ensure correct path
RUN echo "#!/bin/sh\nexec /app/bin/${SUBPROJECT}" > /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh /app/bin/${SUBPROJECT}

ENTRYPOINT ["/app/entrypoint.sh"]
