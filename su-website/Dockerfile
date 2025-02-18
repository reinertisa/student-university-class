# Stage 1: Build the application
FROM node:lts-alpine as builder

RUN corepack enable

RUN mkdir -p /app
WORKDIR /app

COPY package.json yarn.lock .yarnrc.yml ./
RUN yarn install

COPY . .
RUN yarn build

# Stage 2: Serve the applicatioon with Nginx
FROM nginx:latest
COPY --from=builder /app/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]