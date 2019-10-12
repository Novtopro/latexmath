# Latexmath

A dead simple web service to render LaTex math expression as SVG.

1. `./gradlew build`
2. `docker build . -t latexmath`
3. `docker run -d --name latexmath -p 8080:8080 latexmath`
4. Open browser and navigate to `http://localhost:8080?exp=a^2`