FROM adoptopenjdk/openjdk8 as builder

WORKDIR /app
COPY .  /app

RUN ./sbt stage

FROM adoptopenjdk/openjdk8

COPY --from=builder /app/target/universal/stage /app

CMD ["/app/bin/hello-embedded-play"]
