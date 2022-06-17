FROM node:16 
#WORKDIR /web-front/web-frontend
COPY package.json package-lock.json ./
RUN npm install
EXPOSE 4200
COPY . .
CMD ["npm", "start"]

#STAGE 2
#FROM nginx:1.17.1-alpine
#COPY nginx.conf /etc/nginx/nginx.conf
#COPY --from=build /web-frontend/src/app /usr/share/nginx/html

#docker build -t frontend -f Dockerfile web-frontend

#docker run --rm -it -p 4201:4200 frontend 