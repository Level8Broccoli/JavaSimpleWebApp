# JavaSimpleWebApp

## Description

This is a basic Java web application using Jakarta EE HttpServlet directly.

## Motivation

Good starting point to learn Java in a web environment.

## Development

The project can locally be built and run using Docker:

```shell
docker run --rm -p 8080:8080 $(docker build -q .)
```

## Deployment

This repo has been successfully deployed using [render.com](https://render.com) via [GitHub](https://github.com). At the
time of this writing this is the proposed way to deploy this project. (free tier, no credit card needed)