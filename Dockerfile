FROM andreptb/oracle-java:8
ADD ./build/libs/latexmath-1.0-SNAPSHOT-all.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]